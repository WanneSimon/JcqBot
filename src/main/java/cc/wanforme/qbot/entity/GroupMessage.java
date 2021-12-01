package cc.wanforme.qbot.entity;

import cc.wanforme.qbot.entity.message.MessageEntity;

/**
 * @author wanne
 * 2021年8月7日
 */
public class GroupMessage extends MessageEntity {
	// 群号
	private String group_id;
	// 要发送的内容
	private String message;
	// 消息内容是否作为纯文本发送 ( 即不解析 CQ 码) , 只在 message 字段是字符串时有效
	private boolean auto_escape;
	
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isAuto_escape() {
		return auto_escape;
	}
	public void setAuto_escape(boolean auto_escape) {
		this.auto_escape = auto_escape;
	}
	
}
