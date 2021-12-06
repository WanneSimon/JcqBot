package cc.wanforme.qbot.util;

import java.io.IOException;
import java.util.function.Function;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author wanne
 * 2021年12月6日
 */
public class SimpleOkHttp {

	private final OkHttpClient okHttpClient;
	
	public SimpleOkHttp() {
		this.okHttpClient = new OkHttpClient();
	}
	
	/** 异步get请求
	 * @param url
	 * @param success 成功处理器
	 * @param failure 失败处理器
	 */
	public void getAsnc(String url, Function<Response, Boolean> success, Function<IOException, Boolean> failure) {
		Request request = new Request.Builder()
		        .url(url)
		        .get()//默认就是GET请求，可以不写
		        .build();
		
		Call call = okHttpClient.newCall(request);
		call.enqueue(new Callback() {
		    @Override
		    public void onFailure(Call call, IOException e) {
		    	failure.apply(e);
		    }

		    @Override
		    public void onResponse(Call call, Response response) throws IOException {
		    	success.apply(response);
		    }
		});
	}

	
}
