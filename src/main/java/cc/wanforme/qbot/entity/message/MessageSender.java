package cc.wanforme.qbot.entity.message;

/** 消息发送者
 * @author wanne
 * 2021年8月6日
 */
public class MessageSender {
	// ==== 私聊和群聊共有 ====
	// 年龄，好像没用，一直都是 0
	private Integer age = 0;
	// 昵称
	private String nickname;
	// 性别，默认
	private String sex = "unknown";
	// 发送者 qq号
	private Long user_id;
	// ==== 私聊和群聊共有 - 结束 ====
	
	// ==== 仅群聊 ====
	// 地区，难道是开了群位置共享后的位置？
	private String area = "";
	// 群名片？
	private String card = "";
	// 群等级？
	private String level = "";
	// 角色 member - 群员
	private String role;
	// 标题？
	private String title = "";
	// ==== 仅群聊 - 结束====
	
	public MessageSender() {}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	
	
}
