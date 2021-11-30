package cc.wanforme.qbot.cqextra;

import java.util.regex.Pattern;

/** 名片组件，包括QQ用户名片和群名片。
 * @author wanne
 * @since 2021-08-06
 */
public class ExtraDice extends BaseExtraCQComponent{
	// TODO 
	
	// 被 at 的qq
	private String at;
	
	public ExtraDice(String mathcedString) {
		super(mathcedString);
		
	}

	@Override
	public String toCQCode() {
		return "[CQ:at,qq=" + at + "]";
	}

}
