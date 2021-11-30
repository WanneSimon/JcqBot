package cc.wanforme.qbot.entity.message;

import cc.wanforme.qbot.entity.EventEntity;

/** 收到的消息实体
 * @author wanne
 * 2021年8月6日
 */
public class MessageEntity extends EventEntity{
	public static final String POST_TYPE = "message";
	
	// ==== 私聊和群聊和频道共有 ====
	// 字体？
	private String font;
	// 消息 [CQ:image,file=b5f8dea67f277e1e74a3029dc60ffd21.image,url=https://gchat.qpic.cn/gchatpic_new/2854196310/521584745-2254694554-B5F8DEA67F277E1E74A3029DC60FFD21/0?term=3]
	private String message;
	// 消息 id, 注：字符串
	private String message_id;
	// 消息类型  group-群消息  private-私聊
	private String message_type; 
	// 原生消息 [CQ:image,file=b5f8dea67f277e1e74a3029dc60ffd21.image]
	private String raw_message;
	// 消息类型，子类型， normal-群、?， friend-好友, channel-频道
	private String sub_type; 
	// 发送者 qq 号
	private String user_id;
	// 消息发送者中也只有部分
	private MessageSender sender;
	// ==== 私聊和群聊共有 - 结束 ====

	// ==== 仅私聊 ====
	// 消息接收人 qq，也就是机器人的qq
	private Long target_id;
	// ==== 仅私聊  - 结束 ====

	
	// ==== 仅群聊 ====
	// 群号
	private String group_id;
	// 未知，不清楚是什么
	private String anonymous;
	// 消息序列号？
	private Long message_seq;
	// ==== 仅群聊  - 结束====
	
	// ==== 仅频道 ====
	// 频道
	private String guild_id;
	// 子频道
	private String channel_id;
	// ==== 仅频道 - 结束 ====
	
	public MessageEntity() {}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage_id() {
		return message_id;
	}

	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	public String getMessage_type() {
		return message_type;
	}

	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}

	public String getRaw_message() {
		return raw_message;
	}

	public void setRaw_message(String raw_message) {
		this.raw_message = raw_message;
	}

	public String getSub_type() {
		return sub_type;
	}

	public void setSub_type(String sub_type) {
		this.sub_type = sub_type;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public MessageSender getSender() {
		return sender;
	}

	public void setSender(MessageSender sender) {
		this.sender = sender;
	}

	public Long getTarget_id() {
		return target_id;
	}

	public void setTarget_id(Long target_id) {
		this.target_id = target_id;
	}

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

	public String getGuild_id() {
		return guild_id;
	}

	public void setGuild_id(String guild_id) {
		this.guild_id = guild_id;
	}

	public String getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}
	
	
}
