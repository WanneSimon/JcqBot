package cc.wanforme.qbot.extra.turing.entity;

/**
 * @author wanne
 * 2021年12月6日
 */
public class TurUserInfo {
	
	private String apiKey;
	private String userId;
	
	public TurUserInfo() {}
	
	public TurUserInfo(String apiKey, String userId) {
		super();
		this.apiKey = apiKey;
		this.userId = userId;
	}

	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
