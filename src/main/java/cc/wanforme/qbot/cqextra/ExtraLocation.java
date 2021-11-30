package cc.wanforme.qbot.cqextra;

import java.util.regex.Pattern;

/**
 * 位置组件。
 *
 * @author Taskeren
 */
public class ExtraLocation extends BaseExtraCQComponent {
	// TODO 
	
	public ExtraLocation(String mathcedString) {
		super(mathcedString);
	}

	/**
	 * 经度
	 */
	String lat;

	/**
	 * 纬度
	 */
	String lon;

	/**
	 * 粗略地名
	 */
	String title;

	/**
	 * 详细地址
	 */
	String content;

	/**
	 * 样式代码（未知）
	 */
	int style;

	@Override
	public String toCQCode() {
		// TODO Auto-generated method stub
		return null;
	}
}
