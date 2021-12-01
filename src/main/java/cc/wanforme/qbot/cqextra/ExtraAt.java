package cc.wanforme.qbot.cqextra;

/** 群内AT
 * @author wanne
 * @since 2021-08-06
 */
public class ExtraAt extends BaseExtraCQComponent{

	// 被 at 的qq
	private String at;
	
	public ExtraAt(String mathcedString) {
		super(mathcedString);
		
	}

	@Override
	public String toCQCode() {
		return "[CQ:at,qq=" + at + "]";
	}

}
