package cc.wanforme.qbot.cqextra;

/** 图片组件（包括自定义表情）。
 * @author wanne
 * @since 2021-08-06
 */
public class ExtraImage extends BaseExtraCQComponent{
	// TODO 
	
	// 被 at 的qq
	private String at;
	
	public ExtraImage(String mathcedString) {
		super(mathcedString);
		
	}


	@Override
	public String toCQCode() {
		return "[CQ:at,qq=" + at + "]";
	}

}
