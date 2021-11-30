package cc.wanforme.qbot.cqextra;

import java.util.regex.Pattern;

/** 自带表情组件。
 * @author wanne
 * @since 2021-08-06
 */
public class ExtraFace extends BaseExtraCQComponent{
	// TODO 
	
	// 被 at 的qq
	private String at;
	
	public ExtraFace(String mathcedString) {
		super(mathcedString);
		
	}

	@Override
	public String toCQCode() {
		return "[CQ:at,qq=" + at + "]";
	}

}
