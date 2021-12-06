package cc.wanforme.qbot.cqextra.builder;

import cc.wanforme.qbot.entity.type.ImageEffectId;
import cc.wanforme.qbot.entity.type.ImageType;

/**
 * @author wanne
 * 2021年8月7日
 */
public class ImageSendBuilder {
	
	private String file;
	private String url;
	private String type; // flash, show
	private String id;
	
	private final String cqData = "[CQ:image,type=%s,id=%s,file=%s,url=%s]";
	private final String cqDataJson = "{\"type\":\"image\",\"data\":{\"type\":\"%s\",\"id\":\"%s\",\"file\":\"%s\",\"url\":\"%s\"}}";
	
	public static ImageSendBuilder build() {
		return new ImageSendBuilder();
	}
	
	public ImageSendBuilder setUrl(String url) {
		this.url = url;
		return this;
	}
	
	public ImageSendBuilder setType(ImageType type) {
		this.type = type.getValue();
		return this;
	}
	
	public ImageSendBuilder setEffect(ImageEffectId effect) {
		this.id = effect.getValue();
		return this;
	}
	
	public ImageSendBuilder setFile(String file) {
		this.file = file;
		return this;
	}
	
	public String create() {
		return String.format(cqData, type == null ? "":type, id, url, url);
	}
	
	public String createJson() {
		return String.format(cqDataJson, type == null ? "":type, id, url, url);
	}
}
