package cc.wanforme.qbot.cqextra;

/** 扩展组件
 * @author wanne
 * @since 2021-08-06
 */
public abstract class BaseExtraCQComponent extends BaseComponent{

    public BaseExtraCQComponent(String mathcedString) {
		super(mathcedString);
	}

	/** 将组件转回 cq 代码，不能转回来就返回 null */
	public abstract String toCQCode();
	
}
