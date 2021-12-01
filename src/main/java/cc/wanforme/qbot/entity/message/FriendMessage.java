package cc.wanforme.qbot.entity.message;

/**
 * @author wanne
 * 2021年12月1日
 */
public class FriendMessage extends MessageEntity {

	// ==== 仅私聊 ====
	// 消息接收人 qq，也就是机器人的qq
	private Long target_id;
	// ==== 仅私聊  - 结束 ====

	public Long getTarget_id() {
		return target_id;
	}

	public void setTarget_id(Long target_id) {
		this.target_id = target_id;
	}
	
	
}
