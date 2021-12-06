package cc.wanforme.qbot.handler;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import cc.wanforme.qbot.entity.message.ChannelMessage;
import cc.wanforme.qbot.entity.message.MessageEntity;
import cc.wanforme.qbot.entity.type.MessageTypeEnum;

/**
 * 白名单处理器, 仅处理名单内的消息
 * @since 2021-12-06
 */
public abstract class WhiteListMessageHandler extends MessageHandler {
	// 好友
	private List<String> friends;
	// 群
	private List<String> groups;
	// 频道
//	private List<String> channels;
	private Map<String, List<String>> channels;
	
	public WhiteListMessageHandler (List<String> friendIds, List<String> groupIds, Map<String, List<String>> channelIds) {
		this.friends = friendIds;
		this.groups = groupIds;
		this.channels = channelIds;
	}
	
	/**
	 * 进行白名单验证，如果通过，调用 {@link #handleMessage1(MessageEntity)} 处理消息
	 */
	@Override
	public void handleMessage(MessageEntity entity) {
		if(Objects.equals(entity.getSub_type(), MessageTypeEnum.FRIEND.getValue())) {
			if(friends!=null && friends.contains(entity.getUser_id())) {
				handleMessage1(entity);
			}
		} else if (Objects.equals(entity.getSub_type(), MessageTypeEnum.NORMAL.getValue())) {
			if(groups!=null && groups.contains(entity.getUser_id())) {
				handleMessage1(entity);
			}
		} else if (Objects.equals(entity.getSub_type(), MessageTypeEnum.CHANNEL.getValue())) {
			ChannelMessage cm = (ChannelMessage) entity;
			if(channels!=null && channels.containsKey(cm.getGuild_id())) {
				List<String> list = channels.get(cm.getGuild_id());
				if(list!=null && list.contains(cm.getChannel_id())) {
					handleMessage1(entity);
				}
			}
		}
	}

	/** 通过白名单验证后，处理消息的地方
	 * @param entity
	 */
	public abstract void handleMessage1(MessageEntity entity) ;
}
