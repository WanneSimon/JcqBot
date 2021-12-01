package cc.wanforme.qbot.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author wanne
 * @since 2021年7月13日
 */
public class SimpleJackson {

	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static final ObjectMapper MAPPER_SAFE = new ObjectMapper();
	
	static {
		// 忽略多余字段
		MAPPER_SAFE.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	public static String toJson(Object ob) throws JsonProcessingException {
		return MAPPER.writeValueAsString(ob);
	}
	
	public static <T> T toObject(String json, Class<T> clazz) 
			throws JsonMappingException, JsonProcessingException {
		return MAPPER.readValue(json, clazz);
	}
	public static <T> T toSafeObject(String json, Class<T> clazz) 
			throws JsonMappingException, JsonProcessingException {
		return MAPPER_SAFE.readValue(json, clazz);
	}
	
	public static JsonNode toJsonNode(String json)
			throws JsonMappingException, JsonProcessingException {
		return MAPPER.readTree(json);
	}
	
}
