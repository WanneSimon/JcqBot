package cc.wanforme.qbot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import cc.wanforme.qbot.entity.message.MessageEntity;
import cc.wanforme.qbot.entity.type.MessageTypeEnum;

/**
 * @author wanne
 * 2021年12月1日
 */
public class MessageType {
	private static final Logger log = LoggerFactory.getLogger(MessageType.class);
	
	/**
	 * @see #deserilizeMessage(JsonNode, String)
	 * @param originMessage
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public static MessageEntity deserilizeMessage(String originMessage) 
			throws JsonMappingException, JsonProcessingException {
		JsonNode json = SimpleJackson.toJsonNode(originMessage);
		return deserilizeMessage(json, originMessage);
	}
	
	/**
	 * @param json 消息的json对象
	 * @param originMessage 原生消息的json字符串
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public static MessageEntity deserilizeMessage(JsonNode json, String originMessage)
			throws JsonMappingException, JsonProcessingException {
		 JsonNode type = json.get("sub_type");
		 if (type==null) {
			 return null;
		 }
		 
		 MessageTypeEnum t = null;
		 try {
			 t = MessageTypeEnum.valueOf(type.asText().toUpperCase());
			 return SimpleJackson.toObject(originMessage, t.getClazz());
		} catch (IllegalArgumentException e) {
			log.error("No such sub_type: " + type.asText(), e);
			return null;
		}
	}
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		String testStr = "{\r\n" + 
				"	\"channel_id\": 1465206,\r\n" + 
				"	\"guild_id\": 64603361637235030,\r\n" + 
				"	\"message\": \"签到水\",\r\n" + 
				"	\"message_id\": \"508-1668767930\",\r\n" + 
				"	\"message_type\": \"guild\",\r\n" + 
				"	\"post_type\": \"message\",\r\n" + 
				"	\"self_id\": 2331396908,\r\n" + 
				"	\"self_tiny_id\": 144115218678307800,\r\n" + 
				"	\"sender\": {\r\n" + 
				"		\"nickname\": \"wanne\",\r\n" + 
				"		\"user_id\": 144115218678307800\r\n" + 
				"	},\r\n" + 
				"	\"sub_type\": \"channel\",\r\n" + 
				"	\"time\": 1638182339,\r\n" + 
				"	\"user_id\": 144115218678307800\r\n" + 
				"}";
		
		JsonNode json = SimpleJackson.toJsonNode(testStr);
		System.out.println(json.get("sub_type").asText());
		System.out.println(json.get("sub_type").toString() );
		
	}
	
}
