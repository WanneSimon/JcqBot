package cc.wanforme.qbot.extra.setu;

/**
 * @author wanne
 * 2021年8月6日
 */
public class SetuReq {

	// 0为非 R18，1为 R18，2为混合（在库中的分类，不等同于作品本身的 R18 标识）
	private int r18 = 0;
	// 一次返回的结果数量，范围为1到100；在指定关键字或标签的情况下，结果数量可能会不足指定的数量
	private int num = 1;
	// 返回指定uid作者的作品，最多20个
	private int[] uid;
	// 	返回从标题、作者、标签中按指定关键字模糊匹配的结果，大小写不敏感，性能和准度较差且功能单一，建议使用tag代替
	private String keyword;
	// 返回匹配指定标签的作品
	private String[] tag;
	// 	["original"]
	private String[] size;
	// i.pixiv.cat	设置图片地址所使用的在线反代服务
	private String proxy;
	
	// 返回在这个时间及以后上传的作品；时间戳，单位为毫秒
	private long dateAfter;
	// 返回在这个时间及以前上传的作品；时间戳，单位为毫秒
	private long dateBefore;
	// 设置为任意真值以禁用对某些缩写keyword和tag的自动转换
	private boolean dsc;
	
	public SetuReq() {}
	
	public int getR18() {
		return r18;
	}
	public void setR18(int r18) {
		this.r18 = r18;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int[] getUid() {
		return uid;
	}
	public void setUid(int[] uid) {
		this.uid = uid;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String[] getTag() {
		return tag;
	}
	public void setTag(String[] tag) {
		this.tag = tag;
	}
	public String[] getSize() {
		return size;
	}
	public void setSize(String[] size) {
		this.size = size;
	}
	public String getProxy() {
		return proxy;
	}
	public void setProxy(String proxy) {
		this.proxy = proxy;
	}
	public long getDateAfter() {
		return dateAfter;
	}
	public void setDateAfter(long dateAfter) {
		this.dateAfter = dateAfter;
	}
	public long getDateBefore() {
		return dateBefore;
	}
	public void setDateBefore(long dateBefore) {
		this.dateBefore = dateBefore;
	}
	public boolean isDsc() {
		return dsc;
	}
	public void setDsc(boolean dsc) {
		this.dsc = dsc;
	}
	
}
