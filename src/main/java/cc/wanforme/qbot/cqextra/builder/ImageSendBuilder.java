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
	// [CQ:image,file=http://localhost:90/img/43831380_p0.jpg,cache=0]
	// [CQ:image,file=http://localhost:90/img/ra2.gif]
	private final String cqData2 = "[CQ:image,type=%s,file=%s,cache=0]";
	private final String cqData3 = "[CQ:image,file=%s]";
	
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
		return String.format(cqData, type == null ? "":type, id, file, url);
	}
	
	public String create2() {
		return String.format(cqData2, type == null ? "":type, url);
	}
	public String createSimple() {
		return String.format(cqData3, url);
	}
}
