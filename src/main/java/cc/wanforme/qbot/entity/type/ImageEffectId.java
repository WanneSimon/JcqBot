package cc.wanforme.qbot.entity.type;

/**
 * @author wanne
 * 2021年8月7日
 */
public enum ImageEffectId implements CqType{
	NORMAL("40000", "普通"),
	BACKGROUND("40001", "幻影"),
	SHAKE("40002", "抖动"),
	BIRTHDAY("40003", "生日"),
	LOVE("40004", "爱你"),
	FRIEND("40005", "征友"),
	;
	
	private String value;
	private String desc;
	
	private ImageEffectId(String id, String desc) {
		this.value = id;
		this.desc = desc;
	}
	
	public String getValue() {
		return value;
	}
	public String getDesc() {
		return desc;
	}
}
