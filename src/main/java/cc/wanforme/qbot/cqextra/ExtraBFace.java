package cc.wanforme.qbot.cqextra;

/**  原创表情
 * @author wanne
 * @since 2021-08-06
 */
public class ExtraBFace extends BaseExtraCQComponent{

	// 未知
//	private String p;
	// 表情id
	private String id;
	
	public ExtraBFace(String mathcedString) {
		super(mathcedString);
	}

//	@Override
//	public Pattern getPattern() {
//		return Pattern.compile("\\[CQ:bface\\,id=.+\\]");
//	}

	@Override
	public String toCQCode() {
		return "[CQ:bface,id=" + id + "]";
	}

}
