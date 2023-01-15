package cc.wanforme.qbot.extra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import cc.wanforme.qbot.cqextra.BaseComponent;
import cc.wanforme.qbot.cqextra.ExtraAt;
import cc.wanforme.qbot.entity.message.MessageEntity;
import cc.wanforme.qbot.handler.MessageHandler;

/**
 * @author wanne
 * 2021年12月17日
 */
public class SayHandler extends MessageHandler {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Class<? extends BaseComponent> getHandleComponentType() {
		return ExtraAt.class;
	}

	@Override
	public void handleMessage(MessageEntity entity) {
		String message = entity.getMessage();
		System.out.println(message);
		
		
	}

	
	
}
