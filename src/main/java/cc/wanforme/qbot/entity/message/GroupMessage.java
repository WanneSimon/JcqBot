package cc.wanforme.qbot.entity.message;

/**
 * @author wanne
 * 2021年12月1日
 */
public class GroupMessage extends MessageEntity {

	// ==== 仅群聊 ====
	// 群号
	private String group_id;
	// 未知，不清楚是什么
	private String anonymous;
	// 消息序列号？
	private Long message_seq;
	// ==== 仅群聊  - 结束====
	
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getAnonymous() {
		return anonymous;
	}
	public void setAnonymous(String anonymous) {
		this.anonymous = anonymous;
	}
	public Long getMessage_seq() {
		return message_seq;
	}
	public void setMessage_seq(Long message_seq) {
		this.message_seq = message_seq;
	}
	
	
}
