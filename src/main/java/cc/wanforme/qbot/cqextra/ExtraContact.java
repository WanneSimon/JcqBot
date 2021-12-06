package cc.wanforme.qbot.cqextra;

/**
 * 名片组件，包括QQ用户名片和群名片。
 * 
 * @author wanne
 * @since 2021-08-06
 */
public class ExtraContact extends BaseExtraCQComponent {
	// TODO
	/**
	 * 名片指向的QQ号或群号
	 */
	private Long id;

	/**
	 * 名片类型（QQ用户或QQ群）
	 *
	 * @see ContactTo
	 */
	private ContactTo to;

	public enum ContactTo {
		USER, GROUP;

		public static ContactTo parse(String str) {
			switch (str) {
			case "qq":
				return USER;
			case "group":
				return GROUP;
			default:
				return null;
			}
		}
	}

	public ExtraContact(String mathcedString) {
		super(mathcedString);
	}

	public ContactTo getTo() {
		return to;
	}

	@Override
	public String toCQCode() {
		return "[CQ:at,qq=" + id + "]";
	}

}
