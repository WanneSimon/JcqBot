package cc.wanforme.qbot.cqextra.richs;

import cc.wanforme.qbot.cqextra.BaseExtraCQComponent;

/**
 * 音乐分享富文本组件。
 *
 * @author Taskeren
 */
public class ExComponentRichMusic extends BaseExtraCQComponent {
	/**
	 * 歌曲名称
	 */
	String title;

	/**
	 * 歌曲描述 （网易云音乐和QQ音乐则显示作者）
	 */
	String desc;

	/**
	 * 歌曲封面
	 */
	String preview;

	/**
	 * APP标签 （例如：“QQ音乐”、“网易云音乐”）
	 */
	String tag;

	/**
	 * 音乐文件地址
	 */
	String urlMusic;

	/**
	 * 音乐网页
	 */
	String urlPage;

	public ExComponentRichMusic(String mathcedString) {
		super(mathcedString);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCQCode() {
		// TODO Auto-generated method stub
		return null;
	}
}
