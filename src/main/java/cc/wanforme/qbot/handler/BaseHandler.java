package cc.wanforme.qbot.handler;

import cc.wanforme.qbot.entity.EventEntity;

/** 基础处理器
 * @author wanne
 * @param <T>
 * @since 2021-08-05
 */
public interface BaseHandler {

	/** 处理的类型 */
	Class<?> getHandleComponentType();
	
	/** 处理*/
	void handle(EventEntity entity);

}