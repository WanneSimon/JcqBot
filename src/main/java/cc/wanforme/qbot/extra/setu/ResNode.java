package cc.wanforme.qbot.extra.setu;

/**
 * @author wanne
 * 2021年8月6日
 */
public class ResNode {
	// 作品 pid
	private Integer pid;
	// 作品所在页
	private Integer p;
	// 作者 uid
	private Integer uid;
	// 作品标题
	private String title;
	// 作者名（入库时，并过滤掉 @ 及其后内容）
	private String author;
	// 是否 R18（在库中的分类，不等同于作品本身的 R18 标识）
	private boolean r18	;
	//原图宽度 px 
	private Integer width;
	// 原图高度 px
	private Integer height;
	// 作品标签，包含标签的中文翻译（有的话）
	private String[] tags;
	// 图片扩展名
	private String ext;
	// 作品上传日期；时间戳，单位为毫秒
	private Long uploadDate;
	// 包含了所有指定size的图片地址
	private ImageUrlNode urls;
	
	public ResNode() {}
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getP() {
		return p;
	}
	public void setP(Integer p) {
		this.p = p;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isR18() {
		return r18;
	}
	public void setR18(boolean r18) {
		this.r18 = r18;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public Long getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Long uploadDate) {
		this.uploadDate = uploadDate;
	}
	public ImageUrlNode getUrls() {
		return urls;
	}
	public void setUrls(ImageUrlNode urls) {
		this.urls = urls;
	}
}
