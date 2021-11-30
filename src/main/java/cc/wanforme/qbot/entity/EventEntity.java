package cc.wanforme.qbot.entity;

/**
 * @author wanne
 * 2021年8月6日
 */
public class EventEntity {
	// 
	private String post_type;
	// 时间
	private Long time;

	// 机器人的 qq 号
	private String self_id;
	
	public String getPost_type() {
		return post_type;
	}
	
	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}
	
	public Long getTime() {
		return time;
	}
	
	public void setTime(Long time) {
		this.time = time;
	}
	
	public String getSelf_id() {
		return self_id;
	}
	
	public void setSelf_id(String self_id) {
		this.self_id = self_id;
	}
	
}
