package cc.wanforme.qbot.entity.heartbeat;

/** 数据包的各项指标，不知道什么用
 * @author wanne
 * 2021年8月6日
 */
public class HeartBeatStat {
	private Long packet_received;
	private Long packet_sent;
	private Long packet_lost;
	private Long message_received;
	private Long message_sent;
	private Long disconnect_times;
	private Long lost_times;
	private Long last_message_time;
	
	public HeartBeatStat() {}
	
	public Long getPacket_received() {
		return packet_received;
	}
	public void setPacket_received(Long packet_received) {
		this.packet_received = packet_received;
	}
	public Long getPacket_sent() {
		return packet_sent;
	}
	public void setPacket_sent(Long packet_sent) {
		this.packet_sent = packet_sent;
	}
	public Long getPacket_lost() {
		return packet_lost;
	}
	public void setPacket_lost(Long packet_lost) {
		this.packet_lost = packet_lost;
	}
	public Long getMessage_received() {
		return message_received;
	}
	public void setMessage_received(Long message_received) {
		this.message_received = message_received;
	}
	public Long getMessage_sent() {
		return message_sent;
	}
	public void setMessage_sent(Long message_sent) {
		this.message_sent = message_sent;
	}
	public Long getDisconnect_times() {
		return disconnect_times;
	}
	public void setDisconnect_times(Long disconnect_times) {
		this.disconnect_times = disconnect_times;
	}
	public Long getLost_times() {
		return lost_times;
	}
	public void setLost_times(Long lost_times) {
		this.lost_times = lost_times;
	}
	public Long getLast_message_time() {
		return last_message_time;
	}
	public void setLast_message_time(Long last_message_time) {
		this.last_message_time = last_message_time;
	}
	
}
