package cc.wanforme.qbot.cqextra;

import java.util.regex.Pattern;

/**
 * 签到组件。
 *
 * @author Taskeren
 */
public class ExtraSign extends BaseExtraCQComponent {
	// TODO 
	public ExtraSign(String mathcedString) {
		super(mathcedString);
	}

	/**
	 * 签到地点
	 */
	String location;

	/**
	 * 签到内容
	 */
	String title;

	/**
	 * 签到图片
	 */
	String image;


	@Override
	public String toCQCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
