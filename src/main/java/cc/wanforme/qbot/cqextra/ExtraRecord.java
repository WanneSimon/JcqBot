package cc.wanforme.qbot.cqextra;

import java.util.regex.Pattern;

/**
 * 语音组件。
 *
 * @author Taskeren
 */
public class ExtraRecord extends BaseExtraCQComponent {
	// TODO 
	/**
	 * 语音储存在本地的位置
	 */
	String file;

	/**
	 * 是否使用变声器
	 */
	boolean magic;

	/**
	 * 构建一个内部语音组件
	 *
	 * @param file  语音本地地址
	 * @param magic 是否启用变声器
	 */
	protected ExtraRecord(String file, boolean magic) {
		super(file);
		this.file = file;
		this.magic = magic;
	}

	/**
	 * 构造一个语音组件
	 *
	 * @param fileOrUrl 语音地址
	 */
	public ExtraRecord(String fileOrUrl) {
		this(fileOrUrl, false);
	}

	@Override
	public String toCQCode() {
		return "[CQ:record,file=" + file + "]";
	}

}
