package cc.wanforme.qbot.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import cc.wanforme.qbot.cqextra.ExtraComponents;
import cc.wanforme.qbot.excption.JQException;

/**
 * @author wanne
 * @since 2021-08-06
 */
public class ExComponentUtil {

	/** 把消息装换成 json 格式，例如：<br>
	 * [CQ:at,qq=311103]， 把后面的 qq=311103 转换成 json
	 * @param cqCode
	 */
	@Deprecated
	public static ObjectNode toJson(String cqCode) {
		Matcher matcher = ExtraComponents.CQPattern.matcher(cqCode);
		if(matcher.matches()) {
			String[] split = cqCode.split("\\,", 1);
			if(split.length < 2) {
				throw new JQException("Invalid CQ message !");
			}
			
			// 后面的信息使用类似 properties 的方式解析，第一个 = 作为分隔符
			ObjectNode json = propertiesToJson(Arrays.copyOfRange(split, 1, split.length));
			return json;
		}
		throw new JQException("CQCode Not matched !");
	}

	/** [ 'a=b', 'c=1', 'b=3' ] 封装成一个json对象
	 * @param kvs
	 * @return
	 */
	@Deprecated
	protected static ObjectNode propertiesToJson(String[] kvs) {
		ObjectNode node = JsonNodeFactory.instance.objectNode();
		for (String kv : kvs) {
			String[] split = kv.split("=", 2);
			if(split.length < 2) {
				node.set(split[0], JsonNodeFactory.instance.textNode(split[0]));
			} else {
				node.set(split[0], JsonNodeFactory.instance.textNode(split[1]));
			}
		}
		return node;
	}
	
	/** 将整个cq代码转换成 map。cq代码如下：[CQ:image,file=b5f8dea67f277e1e74a3029dc60ffd21.image]
	 * @param message
	 * @return
	 */
	public Map<String, String> messageTextToMap(String message){
		Map<String, String> map = new HashMap<>();
		message = message.substring(1, message.length()-1);
		
		String[] arr = message.split("\\,");
		for (String kvStr : arr) {
			String[] kv = kvStr.split("[:=]", 2);
			if(kv.length < 2) {
				continue;
			}
			map.put(kv[0], kv[1]);
		}
		return map;
	}
	
}
