package cc.wanforme.qbot.entity.heartbeat;

/** go-cqhttp的 各项状态指标，不知道有什么用
 * @author wanne
 * 2021年8月6日
 */
public class HeartBeatStatus {
	
	private Boolean app_enabled;
	private Boolean app_good;
	private Boolean app_initialized;
	private Boolean good;
	private Boolean online;
	private Boolean plugins_good;
	private HeartBeatStat stat;

	public HeartBeatStatus() {}
	
	public Boolean getApp_enabled() {
		return app_enabled;
	}

	public void setApp_enabled(Boolean app_enabled) {
		this.app_enabled = app_enabled;
	}

	public Boolean getApp_good() {
		return app_good;
	}

	public void setApp_good(Boolean app_good) {
		this.app_good = app_good;
	}

	public Boolean getApp_initialized() {
		return app_initialized;
	}

	public void setApp_initialized(Boolean app_initialized) {
		this.app_initialized = app_initialized;
	}

	public Boolean getGood() {
		return good;
	}

	public void setGood(Boolean good) {
		this.good = good;
	}

	public Boolean getOnline() {
		return online;
	}

	public void setOnline(Boolean online) {
		this.online = online;
	}

	public Boolean getPlugins_good() {
		return plugins_good;
	}

	public void setPlugins_good(Boolean plugins_good) {
		this.plugins_good = plugins_good;
	}

	public HeartBeatStat getStat() {
		return stat;
	}

	public void setStat(HeartBeatStat stat) {
		this.stat = stat;
	}
	
}
