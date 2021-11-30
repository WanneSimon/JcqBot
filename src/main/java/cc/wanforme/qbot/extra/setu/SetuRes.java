package cc.wanforme.qbot.extra.setu;

import java.util.List;

/**
 * @author wanne
 * 2021年8月6日
 */
public class SetuRes {

	// 错误信息
	private String error;
	// 图片数组
	private List<ResNode> data;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<ResNode> getData() {
		return data;
	}
	public void setData(List<ResNode> data) {
		this.data = data;
	}
	
}
