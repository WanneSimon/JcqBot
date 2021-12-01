package cc.wanforme.qbot.controller;

import java.util.List;
import java.util.Objects;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import cc.wanforme.qbot.cqextra.BaseComponent;
import cc.wanforme.qbot.cqextra.ExtraComponents;
import cc.wanforme.qbot.entity.message.MessageEntity;
import cc.wanforme.qbot.entity.type.EventPostType;
import cc.wanforme.qbot.handler.HandlerManager;
import cc.wanforme.qbot.util.MessageType;
import cc.wanforme.qbot.util.SimpleJackson;

/**
 * @author wanne
 * @since 2021-08-05
 */
@ServerEndpoint("/event")
@Component
public class QBotEventController {
	private static final Logger log = LoggerFactory.getLogger(QBotEventController.class);
	
	@OnOpen
	public void onOpen(Session session) {
		log.info("[event]服务开机！");
	}
	
	@OnClose
	public void onClose(Session session) {
		log.info("[event]关机了，下班");
	}
	
	@OnMessage
	public void onMessage(String message, Session session)
			throws JsonMappingException, JsonProcessingException {
		log.info("\n[event]:\n" + message);
		JsonNode root = null;
		try {
			root = SimpleJackson.toJsonNode(message);
		} catch (Exception e) {
			log.info("Jackson translation failed！");
			log.debug(e.getMessage(), e);
			return;
		}
		
		JsonNode postType = root.get("post_type");
		if(postType == null) {
			log.warn("No post_type: " + message);
			return;
		}
		
		if(Objects.equals( postType.asText(), 
				EventPostType.MESSAGE.getValue())) {
//			MessageEntity entity = SimpleJackson.toObject(message, MessageEntity.class);
			MessageEntity entity = MessageType.deserilizeMessage(root, message);
			String messageText = entity.getMessage();
			
			List<BaseComponent> components = ExtraComponents.findComponents(messageText);
			
			for (BaseComponent component : components) {
				try {
					HandlerManager.getInstance().launchMessage(entity, component);
				} catch (Exception e) {
					log.error("处理异常！", e);
				}
			}
			return;
		}
		// 心跳处理，不知道干嘛用，不用了
		else if(Objects.equals( postType.asText(), 
				EventPostType.META_EVENT.getValue())) {
//			SimpleJackson.toObject(message, HeartBeatStatus.class);
		}else {
			log.warn("Unkown post_type ("+postType.asText()+"): " +message);
			return;
		}
	}
	
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("[event]出错了", error);
    }
    
    
    
}
