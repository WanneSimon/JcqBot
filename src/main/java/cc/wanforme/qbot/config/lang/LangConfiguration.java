package cc.wanforme.qbot.config.lang;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 语言文本配置
 * @author wanne
 * @since 2021-08-05
 */
@Configuration
public class LangConfiguration {

	@Value("${cq-lang:zh-CN}")
	private String lang;
	
	@Bean
	public TextContainer textContainer() {
		TextContainer container = new TextContainer(lang, "lang/"+lang + ".properties" );
		TextHolder.setContainer(container);
		return container;
	}
	
}
