package cc.wanforme.qbot.cqextra;

import java.util.regex.Pattern;

/**
 * 戳一戳组件。
 *
 * @author Taskeren
 */
public class ExtraShake extends BaseExtraCQComponent {
	// TODO 

	public ExtraShake(String mathcedString) {
		super(mathcedString);
	}

	@Override
	public String toCQCode() {
		return "[CQ:shake]";
	}

}
