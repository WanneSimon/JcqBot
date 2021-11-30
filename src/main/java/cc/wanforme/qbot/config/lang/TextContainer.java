package cc.wanforme.qbot.config.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

/** 提示文本信息
 * @author wanne
 * @since 2021-08-05
 */
public class TextContainer {
	private static final Logger log = LoggerFactory.getLogger(TextContainer.class);
	
	// 语言类型
	private String lang;
	// 语言文件
	private String langFile;
	// 键值对文本信息
	private Properties wrapper;
	
	public TextContainer(String lang, String langFile) {
		super();
		this.lang = lang;
		this.langFile = langFile;
		
		try {
			Properties properties = this.loadLanguageFile(langFile, true);
			if(properties!=null) {
				wrapper = properties;
			} else {
				log.error("Language file load failed!");
			}
		}  catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}
	
	/**
	 * @param langFile 对应的文件
	 * @param loadInner 读取不到时，是否尝试读取jar内的文件
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private Properties loadLanguageFile(String langFile, boolean loadInner) 
			throws FileNotFoundException, IOException {
		Properties t = new Properties();

		File file = new File(langFile);
		if(file.exists() && file.isFile()) {
			t.load(new InputStreamReader( new FileInputStream(file), StandardCharsets.UTF_8));
		} else {
			// 尝试读取外部文件
			String currentDir = System.getProperty("user.dir");
			file = new File(currentDir, langFile);
		}
		
		try {
			t.load(new InputStreamReader( new FileInputStream(file), StandardCharsets.UTF_8));
			return t;
		} catch (IOException e) {
			if(log.isDebugEnabled()) {
				log.debug("Fail to load language file '"+langFile+"'", e);
			} else {
				log.warn("Fail to load language file '"+langFile+"'");
			}
			
			// 读取内部文件
			if(loadInner) {
				ClassPathResource resource = new ClassPathResource(langFile);
				try {
					t.load(new InputStreamReader( resource.getInputStream(), StandardCharsets.UTF_8));
					// 同时保存一份样例
					return t;
				} catch (IOException e1) {
					log.error("Fail to load inner language file '"+langFile+"'", e);
				}
			}
		}
		
		return null;
	}


	public String get(String key){
		return wrapper.getProperty(key, key);
	}
	public String get(String key, String defaultValue){
		return wrapper.getProperty(key, defaultValue);
	}
	
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getLangFile() {
		return langFile;
	}

	public void setLangFile(String langFile) {
		this.langFile = langFile;
	}

	
}
