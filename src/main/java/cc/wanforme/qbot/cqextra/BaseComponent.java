package cc.wanforme.qbot.cqextra;

/**
 * @author wanne
 * 2021年8月6日
 */
public abstract class BaseComponent {
	/** 是否是当前组件 */
    protected boolean match = true;
    
    public BaseComponent (String mathcedString) { }
    
    
    /** 匹配消息中的扩展组件字符串。匹配过程 {@link #findComponents(String)}
     * @return
     */
//    public abstract Pattern getPattern();
    
	/** 对象创建，经过初始化处理后，如果是当前拓展组件，那么设置为 true，不是设为 false。<br>
	 * 主要用于如下特殊情况： {@link #getPattern()} 返回 大范围匹配{@link #CQPattern}，内部重新分析后，不是当前组件要处理的类型！
	 * @return default true
	 * @see #findComponents(String)  */
	public boolean isMatched() {
		return match;
	}
}
