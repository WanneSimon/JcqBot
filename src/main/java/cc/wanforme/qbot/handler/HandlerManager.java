package cc.wanforme.qbot.handler;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import cc.wanforme.qbot.cqextra.BaseComponent;
import cc.wanforme.qbot.entity.message.MessageEntity;

/** 信息处理中心
 * @author wanne
 * 2021年8月6日
 */
public class HandlerManager {

	private static final List<BaseHandler> handlers = new CopyOnWriteArrayList<>();
	
	/** 注册
	 * @param handler
	 * @return
	 */
	public static boolean register(BaseHandler handler) {
		return handlers.add(handler);
	}
	
	/** 获取所有处理器*/
	public static Set<BaseHandler> getHandlers() {
		return new HashSet<BaseHandler>(handlers);
	}
	
	/** 消息交给所有处理器进行处理
	 * @param message
	 */
	public static void launchMessage(MessageEntity message, BaseComponent component) {
		for (BaseHandler h : handlers) {
			if( Objects.equals(h.getHandleComponentType().getCanonicalName(),
					component.getClass().getCanonicalName()) ) {
				h.handle(message);
			}
		}
	}
	
}
