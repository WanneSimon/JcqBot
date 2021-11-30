package cc.wanforme.qbot.controller;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author wanne
 * @since 2021-08-05
 */
@ServerEndpoint("/api")
@Component
public class QBotApiController {
	private static final Logger log = LoggerFactory.getLogger(QBotApiController.class);
	
	@OnOpen
	public void onOpen(Session session) {
		log.info("[api]服务开机！");
	}
	
	@OnClose
	public void onClose(Session session) {
		log.info("[api]关机了，下班");
	}
	
	@OnMessage
	public void onMessage(String message, Session session) {
		log.info("\n[api]:\n" + message);
	}
	
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("[api]出错了", error);
    }
    
    
    
}
