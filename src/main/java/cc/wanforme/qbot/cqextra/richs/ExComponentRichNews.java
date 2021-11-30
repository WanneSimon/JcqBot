package cc.wanforme.qbot.cqextra.richs;

import java.util.regex.Pattern;

import cc.wanforme.qbot.cqextra.BaseExtraCQComponent;

/**
 * 网页分享富文本组件。
 *
 * @author Taskeren
 */
public class ExComponentRichNews extends BaseExtraCQComponent
{
    public ExComponentRichNews(String mathcedString) {
		super(mathcedString);
	}

	/**
     * 页面名称
     */
     String title;

    /**
     * 页面描述
     */
     String desc;

    /**
     * 页面预览
     */
     String preview;

    /**
     * APP标签
     */
     String tag;

    /**
     * 页面地址
     */
     String url;

	@Override
	public String toCQCode() {
		// TODO Auto-generated method stub
		return null;
	}
}
