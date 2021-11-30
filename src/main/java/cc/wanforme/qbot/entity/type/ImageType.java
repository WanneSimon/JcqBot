package cc.wanforme.qbot.entity.type;

/**
 * @author wanne
 * 2021年8月7日
 */
public enum ImageType implements CqType {

	// 闪照
	FLASH("flash"),
	// 秀图，默认普通图片
	SHOW("show"),
	;
	
	private String value;
	
	private ImageType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	

}
