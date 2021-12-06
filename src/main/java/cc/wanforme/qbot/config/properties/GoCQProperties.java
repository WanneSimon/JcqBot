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
	@Value("${host}")
	private String host;
	@Value("${reply-group}")
	private String replyGroup;
	
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
	
}
