package cc.wanforme.qbot.extra.setu;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cc.wanforme.qbot.cqextra.BaseComponent;
import cc.wanforme.qbot.cqextra.TextComponent;
import cc.wanforme.qbot.cqextra.builder.ImageSendBuilder;
import cc.wanforme.qbot.entity.GroupMessage;
import cc.wanforme.qbot.entity.message.MessageEntity;
import cc.wanforme.qbot.entity.type.ImageEffectId;
import cc.wanforme.qbot.entity.type.ImageType;
import cc.wanforme.qbot.handler.MessageHandler;
import cc.wanforme.qbot.util.FileNameUtil;
import cc.wanforme.qbot.util.SimpleOkHttp;

/** 样例
 * @author wanne
 * 2021年8月6日
 */
@Component
public class SetuHandler extends MessageHandler{
	private static final List<String> keywords = Arrays.asList("涩图", "色图");
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${setu.groups}")
	private List<String> groups;
	
	
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
		boolean allow = true;
		if(groups != null) {
			allow = this.groups.contains(groupId);
		} 
		
		if(!allow) {
			return;
		}
		
		String text = entity.getMessage();
		
		String[] split = text.split("[ ]");
		if(split==null || split.length==0) {
			return;
		}
		
		if(!keywords.contains(split[0])) {
			return;
		}
		String tag = "";
		if(split.length > 1) {
			tag = String.join("|", Arrays.copyOfRange(split, 1, split.length));
		}
		
		// 查找
//		SetuReq request = new SetuReq();
		try {
			String url = "https://api.lolicon.app/setu/v2";
			if(!"".equals(tag)) {
				url += "?tag="+tag;
			}
			
//			ResponseEntity<SetuRes> response = restTemplate.postForEntity("https://api.lolicon.app/setu/v2", request, SetuRes.class);
			ResponseEntity<SetuRes> response = restTemplate.getForEntity(url, SetuRes.class);
			if(response.getStatusCodeValue() == 200) {
				SetuRes res = response.getBody();
				
				if( (res.getError() == null || Objects.equals(res.getError().trim(), ""))
						&& res.getData()!=null && !res.getData().isEmpty()) {
					ResNode node = res.getData().get(0);
					String msg = "Title："+node.getTitle()+"\nAuthor："+node.getAuthor()
						+"\n"+node.getUrls().getOriginal();
					
					this.replyMessage(entity, msg);
					
					// 消息回传给机器人
//					this.replyMessage(entity, msg);
//					String img = "[CQ:image,url="+node.getUrls().getOriginal()+"]"+node.getUrls().getOriginal();
					this.replyImage(entity, node);
//					this.replyImageWithTemp(entity, node);
					return;
				}
			}
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		// 失败了
		String msg = "失败了失败了失败.....";
		this.replyMessage(entity, msg);
	}
	

	private void replyImage(GroupMessage entity, ResNode node) {
		try {
			// 下载图片，手动发送
		 	String imageUrl = node.getUrls().getOriginal();
		 	
			String img = ImageSendBuilder.build()
					.setUrl(imageUrl)
					.setFile(node.getTitle())
					.setType(ImageType.SHOW)
					.setEffect(ImageEffectId.NORMAL)
					.createSimple();
			System.out.println(img);
			
			this.replyMessage(entity, img);
		} catch (Exception e) {
//			this.replyMessage(entity, msg+"\n"+img);
			log.error("图片发送失败", e);
		}
	}
	
	private void replyImageWithTemp(GroupMessage entity, ResNode node) {
		try {
			// 下载图片，手动发送
		 	String imageUrl = node.getUrls().getOriginal();
		 	String tempPath = node.getPid()+FileNameUtil.getSuffix(imageUrl);
			SimpleOkHttp soh = new SimpleOkHttp();
			soh.downloadGet(imageUrl, tempPath);
		 	
			String img = ImageSendBuilder.build()
//					.setUrl(node.getUrls().getOriginal())
					.setUrl(tempPath)
					.setFile(node.getTitle())
					.setType(ImageType.SHOW)
					.setEffect(ImageEffectId.NORMAL)
					.createSimple();
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
		restTemplate.postForObject("http://127.0.0.1:5700/send_group_msg", gm, String.class);
	}
	
}
