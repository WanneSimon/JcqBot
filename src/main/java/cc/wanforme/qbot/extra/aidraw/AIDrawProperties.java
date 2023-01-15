package cc.wanforme.qbot.extra.aidraw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "aidraw")
public class AIDrawProperties {
	
	private String aidrawDrawUrl;
	
	private List<String> keywords = Arrays.asList("ai");
	
	private List<String> groups = new ArrayList<>(0);

	public String getAidrawDrawUrl() {
		return aidrawDrawUrl;
	}

	public void setAidrawDrawUrl(String aidrawDrawUrl) {
		this.aidrawDrawUrl = aidrawDrawUrl;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}
	
}
