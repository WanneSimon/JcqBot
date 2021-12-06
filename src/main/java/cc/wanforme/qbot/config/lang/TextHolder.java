package cc.wanforme.qbot.config.lang;

/**
 * @author wanne
 * @since 2021-08-05
 */
public class TextHolder {

	private static TextContainer container;
	
	public synchronized static void setContainer(TextContainer container) {
		if(container!=null) {
			throw new RuntimeException("TextContainer can be set only once!");
		}
		TextHolder.container = container;
	}
	public static TextContainer getContainer() {
		return container;
	}
	
}
