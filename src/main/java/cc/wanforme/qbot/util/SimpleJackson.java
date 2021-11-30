package cc.wanforme.qbot.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author wanne
 * @since 2021年7月13日
 */
public class SimpleJackson {

	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	public static String toJson(Object ob) throws JsonProcessingException {
		return MAPPER.writeValueAsString(ob);
	}
	
	public static <T> T toObject(String json, Class<T> clazz) 
			throws JsonMappingException, JsonProcessingException {
		return MAPPER.readValue(json, clazz);
	}
	
	public static JsonNode toJsonNode(String json)
			throws JsonMappingException, JsonProcessingException {
		return MAPPER.readTree(json);
	}
	
}
