package cc.wanforme.qbot.cqextra.builder;

import cc.wanforme.qbot.entity.type.ImageEffectId;
import cc.wanforme.qbot.entity.type.ImageType;

/**
 * @author wanne
 * 2021年8月7日
 */
public class ImageSendBuilder {
	
	private String url;
	private String type;
	private String id;
	
	private final String cqData = "[CQ:image,file=%s,type=%s,id=%s]";
	
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
	
	public String create() {
		return String.format(cqData, url, type == null ? "":type, id);
	}
}
