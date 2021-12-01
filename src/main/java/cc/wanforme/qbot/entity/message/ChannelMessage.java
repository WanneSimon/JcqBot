package cc.wanforme.qbot.entity.message;

/**
 * @author wanne
 * 2021年12月1日
 */
public class ChannelMessage extends MessageEntity {

	// ==== 仅频道 ====
	// 频道
	private String guild_id;
	// 子频道
	private String channel_id;
	// ==== 仅频道 - 结束 ====
	
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
