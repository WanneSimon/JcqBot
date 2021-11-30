package cc.wanforme.qbot.config.lang;

/**
 * @author wanne
 * @since 2021-08-05
 */
public class TextHolder {

	private static TextContainer container;
	
	public static void setContainer(TextContainer container) {
		TextHolder.container = container;
	}
	public static TextContainer getContainer() {
		return container;
	}
	
}
