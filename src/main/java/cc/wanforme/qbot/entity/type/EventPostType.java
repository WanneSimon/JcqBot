package cc.wanforme.qbot.entity.type;

/**
 * @author wanne
 * 2021年8月6日
 */
public enum EventPostType implements CqType{
	META_EVENT("meta_event"),
	MESSAGE("message"),
	;
	
	private String value;
	
	private EventPostType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
