package cc.wanforme.qbot.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * go-cqhttp 的相关配置
 */
@Component
@ConfigurationProperties(prefix = "go-cqhttp")
public class GoCQProperties {
	// 基础路径 
//	@Value("${host}")
	private String host;
//	@Value("${reply-group}")
	private String replyGroup;
//	@Value("${reply-private}")
	private String replyPrivate;
//	@Value("${delete-message}")
	private String deleteMessage;
//	@Value("${get-message}")
	private String getMessage;
//	@Value("${get-image}")
	private String getImage;
//	@Value("${get-forward-message}")
	private String getForwardMessage;
//	@Value("${get-friend-list}")
	private String getFriendList;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getReplyGroup() {
		return replyGroup;
	}
	public void setReplyGroup(String replyGroup) {
		this.replyGroup = replyGroup;
	}
	public String getReplyPrivate() {
		return replyPrivate;
	}
	public void setReplyPrivate(String replyPrivate) {
		this.replyPrivate = replyPrivate;
	}
	public String getDeleteMessage() {
		return deleteMessage;
	}
	public void setDeleteMessage(String deleteMessage) {
		this.deleteMessage = deleteMessage;
	}
	public String getGetMessage() {
		return getMessage;
	}
	public void setGetMessage(String getMessage) {
		this.getMessage = getMessage;
	}
	public String getGetImage() {
		return getImage;
	}
	public void setGetImage(String getImage) {
		this.getImage = getImage;
	}
	public String getGetForwardMessage() {
		return getForwardMessage;
	}
	public void setGetForwardMessage(String getForwardMessage) {
		this.getForwardMessage = getForwardMessage;
	}
	public String getGetFriendList() {
		return getFriendList;
	}
	public void setGetFriendList(String getFriendList) {
		this.getFriendList = getFriendList;
	}
	
}
