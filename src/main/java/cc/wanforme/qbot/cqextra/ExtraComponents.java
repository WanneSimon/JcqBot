package cc.wanforme.qbot.cqextra;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 扩展组件注册中心
 * @author wanne
 * @since 2021-08-06
 */
public class ExtraComponents {
	private static final Logger log = LoggerFactory.getLogger(ExtraComponents.class);
	
	/** 大范围匹配，所有的 cq代码都是这样的 */
	public static final Pattern CQPattern = Pattern.compile("(\\[CQ:.*?\\,.*?\\])");
	/** 所有cq拓展组件 和 它们正则的匹配 */
    private static final Map<Pattern, Class<? extends BaseExtraCQComponent>> components = new ConcurrentHashMap<>();
    
    /** 注册拓展组件
     * @param key
     * @param component
     * @return
     */
    public static void registerComponent(Pattern pattern, Class<? extends BaseExtraCQComponent> component) {
    	// 禁止注册纯文本组件
    	components.put(pattern, component);
    }

    /** 从消息中找出所有的扩展组件
     * @param message
     * @return 可能是 empty ，但不会是 null
     */
    public static List<BaseComponent> findComponents(String message){
    	List<BaseComponent> list = new ArrayList<>();
    	List<String> added = new ArrayList<>();
    	
    	Matcher matcher = CQPattern.matcher(message);
    	
    	if(!matcher.find()) {
    		// 纯文本
    		list.add(new TextComponent(message));
    		return list;
    	}
    	
    	do {
    		// 使用大范围的匹配，找出字符串
    		String str = matcher.group();
    		
    		for (Pattern p : components.keySet()) {
    			Matcher detailMather = p.matcher(str);
				if( detailMather.matches() ) {
					Class<? extends BaseExtraCQComponent> clazz = components.get(p);
					if(added.contains(clazz.getCanonicalName())) {
						continue;
					}
					
					try {
						Constructor<? extends BaseComponent> constructor = clazz.getConstructor(String.class);
						BaseComponent component = constructor.newInstance(str);
						
						// 组件内部会重新分析，如果不是当前组件要处理的类型，就抛弃
						if(component.isMatched()) {
							list.add(component);
							added.add(clazz.getCanonicalName());
						}
					} catch (Exception e1) {
						log.error("Can't new instance for '"+clazz.getCanonicalName()+"', "
								+ "make sure constructor with String existed, "
								+ "or it's public method!");
					} 
				}
			}
    	} while (matcher.find());
    	return list;
    }
}
