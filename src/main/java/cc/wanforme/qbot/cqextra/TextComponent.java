package cc.wanforme.qbot.cqextra;

/**
 * 纯文本消息，应该不算是组件。
 *
 * @author wanne
 */
public class TextComponent extends BaseComponent {

	private String text;

	public TextComponent(String mathcedString) {
		super(mathcedString);
	}

	public String toString() {
		return text;
	}
	
	public String getText() {
		return text;
	}
	
}
