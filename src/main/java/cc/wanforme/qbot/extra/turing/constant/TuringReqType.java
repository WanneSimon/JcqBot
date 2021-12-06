package cc.wanforme.qbot.extra.turing.constant;

/**
 * @author wanne
 * 2021年12月6日
 */
public enum TuringReqType {
	
	// 0-文本(默认)、1-图片、2-音频
	TEXT("0"),
	IMAGE("1"),
	AUDIO("2");
	
	private String value;
	
	private TuringReqType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
