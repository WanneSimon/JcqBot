package cc.wanforme.qbot.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cc.wanforme.qbot.entity.EventEntity;
import cc.wanforme.qbot.entity.message.MessageEntity;

/** 消息处理器
 * @author wanne
 * 2021年8月6日
 */
public abstract class MessageHandler implements BaseHandler{
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void handle(EventEntity entity) {
		this.handleMessage((MessageEntity) entity);
	}

	public abstract void handleMessage(MessageEntity entity);
	
}
