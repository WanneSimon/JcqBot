package cc.wanforme.qbot.entity.type;

import cc.wanforme.qbot.entity.message.MessageEntity;
import cc.wanforme.qbot.entity.GroupMessage;
import cc.wanforme.qbot.entity.message.FriendMessage;
import cc.wanforme.qbot.entity.message.ChannelMessage;

/**
 * @author wanne
 * 2021年12月1日
 */
public enum MessageTypeEnum {
	
	// normal-群、?， friend-好友, channel-频道
	NORMAL("normal", GroupMessage.class),
	FRIEND("friend", FriendMessage.class),
	CHANNEL("channel", ChannelMessage.class),
	;
	
	private String value;
	private Class<? extends MessageEntity> clazz;
	
	private MessageTypeEnum (String value, Class<? extends MessageEntity> clazz) {
		this.value = value;
		this.clazz = clazz;
	}
	
	public String getValue() {
		return value;
	}
	public Class<? extends MessageEntity> getClazz() {
		return clazz;
	}
	
}
