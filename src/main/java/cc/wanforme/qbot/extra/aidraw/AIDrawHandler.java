package cc.wanforme.qbot.extra.aidraw;

import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Base64.Decoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import cc.wanforme.qbot.JcqBotApplication;
import cc.wanforme.qbot.config.properties.GoCQProperties;
import cc.wanforme.qbot.cqextra.BaseComponent;
import cc.wanforme.qbot.cqextra.TextComponent;
import cc.wanforme.qbot.cqextra.builder.ImageSendBuilder;
import cc.wanforme.qbot.entity.GroupMessage;
import cc.wanforme.qbot.entity.message.MessageEntity;
import cc.wanforme.qbot.entity.type.ImageEffectId;
import cc.wanforme.qbot.entity.type.ImageType;
import cc.wanforme.qbot.handler.MessageHandler;
import cc.wanforme.qbot.util.FileUtil;
import cc.wanforme.qbot.util.SimpleJackson;

@Component
public class AIDrawHandler extends MessageHandler {
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
	
//	@Autowired
	private RestTemplate restTemplate;
	private Decoder decoder = Base64.getDecoder();
	@Autowired
	private GoCQProperties cqProperties;
	@Autowired
	private AIDrawProperties aiDrawProperties;
	
	@Value("${public-host}")
	private String publicHost;
	
	public AIDrawHandler() {
		this.restTemplate = this.createRestTemplate();
	}
	
	@Override
	public Class<? extends BaseComponent> getHandleComponentType() {
		return TextComponent.class;
	}


	@Override
	public void handleMessage(MessageEntity messageEntity) {
		GroupMessage entity = null;
		if(! (messageEntity instanceof GroupMessage)) {
			return;
		}

		entity = (GroupMessage) messageEntity;
		String groupId = entity.getGroup_id();
		                                    // 备用   domi  未命名  沙雕
//		List<Long> groups = Arrays.asList( 680481259L, 771829371L, 705436069L, 716971791L );
		List<String> groups = aiDrawProperties.getGroups();
		boolean allow = true;
		if(groups != null) {
			allow = groups.contains(groupId);
		} 
		
		if(!allow) {
			return;
		}
		
		String text = entity.getMessage();
		
		String[] split = text.split("[ ]");
		if(split==null || split.length==0) {
			return;
		}
		
		List<String> keywords = aiDrawProperties.getKeywords();
		if(!keywords.contains(split[0])) {
			return;
		}
		
		// 查找
//		SetuReq request = new SetuReq();
		String promt = text.substring(split[0].length()).trim();
		try {
			String url = aiDrawProperties.getAidrawDrawUrl();
//			String body = "{"
//					+ "\"prompt\": \"+promt+\""
//					+ "\"steps\": 5"
//					+ "}";
			Map<String, String> data = new HashMap<>(2);
			data.put("prompt", promt);
			data.put("steps", "5");
			
			// {"images":[ "string" ],"parameters":{},"info":"string"} 
			// {"detail":[{"loc":["string",0],"msg":"string","type":"string"}]}
			ResponseEntity<ObjectNode> response = restTemplate.postForEntity(url, data, ObjectNode.class);
			
			if(response.getStatusCodeValue() == 200) {
				ObjectNode res = response.getBody();
				ArrayNode images = res.withArray("images");
				if(images.has(0)) {
					JsonNode base64CodeNode = images.get(0);
					String base64Code = base64CodeNode.asText();
					System.out.println("base64code:\n" + base64Code);
					
					byte[] bs = decoder.decode(base64Code);
					String path = this.tempFileName() + ".png"; 
					FileUtil.saveFile(bs, path);
					
					//System.out.println("publicHost: " + publicHost);
					String tempUrl =  (publicHost + "/image/" +  URLEncoder.encode(path));
					
					this.replyImageWithTemp(entity, tempUrl);
				}
				
				//System.out.println("res: "  + SimpleJackson.toJson(res));
			}
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		// 失败了
		String msg = "失败了失败了失败.....";
		this.replyMessage(entity, msg);
	}

	private void replyImageWithTemp(GroupMessage entity,String tempPath) {
		try {
			// 下载图片，手动发送
//		 	String imageUrl = node.getUrls().getOriginal();
//		 	String tempPath = node.getPid()+FileNameUtil.getSuffix(imageUrl);
//			SimpleOkHttp soh = new SimpleOkHttp();
//			soh.downloadGet(imageUrl, tempPath);
		 	File f = new File(tempPath);
			
			String img = ImageSendBuilder.build()
//					.setUrl(node.getUrls().getOriginal())
					.setUrl(tempPath)
					.setFile(f.getName())
					.setType(ImageType.SHOW)
					.setEffect(ImageEffectId.NORMAL)
//					.createSimple();
					.create();
			System.out.println(img);
			
			this.replyMessage(entity, img);
		} catch (Exception e) {
//			this.replyMessage(entity, msg+"\n"+img);
			log.error("图片发送失败", e);
		}
	}
	
	/** 快速回复
	 * @param source
	 * @param message
	 */
	private void replyMessage(GroupMessage source, String message) {
		GroupMessage gm = new GroupMessage();
		gm.setGroup_id(source.getGroup_id());
		gm.setMessage(message);
		gm.setAuto_escape(false);
		
		String groupUrl = cqProperties.getHost() + cqProperties.getReplyGroup();
		//restTemplate.postForObject("http://127.0.0.1:5700/send_group_msg", gm, String.class);
		restTemplate.postForObject(groupUrl, gm, String.class);
	}
	
	private RestTemplate createRestTemplate() {
		RestTemplate restTemplate = new RestTemplateBuilder()
				.setConnectTimeout(Duration.ofSeconds(300))
				.setReadTimeout(Duration.ofSeconds(300))
				.build();
		return restTemplate;
	}
	
	public String tempFileName() {
		String path = "temp/" + dtf.format(LocalDate.now()) + "/" + System.currentTimeMillis();
		return path;
	}
	
}
