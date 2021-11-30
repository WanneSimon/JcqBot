  package cc.wanforme.qbot.entity.heartbeat;

import cc.wanforme.qbot.entity.EventEntity;

/** 心跳实体
 * @author wanne
 * 2021年8月6日
 */
public class HearBeat extends EventEntity {
	public static final String POST_TYPE = "meta_event";
	
	// 间隔 5000
	private int interval;
	// 固定 heartbeat
	private String meta_event_type;
	
	private HeartBeatStatus status;

	public HearBeat() {}
	
	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public String getMeta_event_type() {
		return meta_event_type;
	}

	public void setMeta_event_type(String meta_event_type) {
		this.meta_event_type = meta_event_type;
	}

	public HeartBeatStatus getStatus() {
		return status;
	}

	public void setStatus(HeartBeatStatus status) {
		this.status = status;
	}
	
}
