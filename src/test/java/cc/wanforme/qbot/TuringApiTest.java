package cc.wanforme.qbot;

import java.io.IOException;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.fasterxml.jackson.core.JsonProcessingException;

import cc.wanforme.qbot.util.SimpleJackson;
import cc.wanforme.qbot.util.SimpleOkHttp;
import okhttp3.Response;

/**
 * @author wanne <br>
 * <a href="http://biz.turingos.cn/home">图灵机器人</a> 
 * <a href="http://www.tuling123.com/">图灵机器人</a> 
 * 2021年12月6日
 */
public class TuringApiTest {

	public static void main(String[] args) {
		
		String message = "{\"reqType\":0,\"perception\":{\"inputText\":{\"text\":\"你好, Turing\"},\"inputImage\":{\"url\":\"imageUrl\"},\"selfInfo\":{\"location\":{\"city\":\"北京\",\"province\":\"北京\",\"street\":\"信息路\"}}},\"userInfo\":{\"apiKey\":\"175009\",\"userId\":\"0daed99e58aa400e93313a98dd7e894a\"}}";
		
		String url = "http://openapi.turingapi.com/openapi/api/v2";
		
		
		SimpleOkHttp okHttp = new SimpleOkHttp();
		okHttp.getAsnc(url, TuringApiTest::successTest, TuringApiTest::failTest);
	}
	
	public static Boolean successTest (Response res) {
		try {
			System.out.println(SimpleJackson.toJson(res));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return true;
	}
	public static Boolean failTest (IOException exp) {
		exp.printStackTrace();
		return true;
	}
	
}
