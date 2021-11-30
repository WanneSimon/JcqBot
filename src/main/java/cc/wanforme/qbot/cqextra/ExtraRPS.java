package cc.wanforme.qbot.cqextra;

import java.util.regex.Pattern;

/**
 * 石头剪刀布组件。
 *
 * @author Taskeren
 */
public class ExtraRPS extends BaseExtraCQComponent {
	// TODO 
	/**
	 * 石头剪刀布
	 */
	RPS type;

	/**
	 * 构造一个内部石头剪刀布组件
	 *
	 * @param rps
	 */
	public ExtraRPS(String message) {
		super(message);
//        this.type = rps;
	}

	/**
	 * 构造一个石头剪刀布组件（随机）
	 */
	public ExtraRPS() {
		this(null);
	}

	@Override
	public String toCQCode() {
		return "[CQ:rps,type=1]";
	}

	public enum RPS {
		ROCK, // 石头
		PAPER, // 布
		SCISSORS; // 剪刀

		public static RPS parse(int type) {
			switch (type) {
			case 1:
				return ROCK;
			case 2:
				return SCISSORS;
			case 3:
				return PAPER;
			default:
				return null;
			}
		}
	}

}
