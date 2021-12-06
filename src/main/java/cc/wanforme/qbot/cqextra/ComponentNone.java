package cc.wanforme.qbot.cqextra;

/**
 * 用于匹配所有类型的组件
 */
public class ComponentNone extends BaseComponent {

	public ComponentNone() {}

	@Override
	public boolean isMatched(String cqMessage) {
		return true;
	}
}
