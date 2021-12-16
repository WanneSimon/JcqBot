package cc.wanforme.qbot.util;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author wanne
 * 2021年12月6日
 */
public class SimpleOkHttp {

	private final OkHttpClient client;
	
	public SimpleOkHttp() throws NoSuchAlgorithmException, KeyManagementException {
        X509TrustManager trustManager = trustedCertificatesInputStream();

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { trustManager }, null);
        
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        
        
		Builder builder = new OkHttpClient.Builder()
				.connectTimeout(30, TimeUnit.SECONDS)
				.callTimeout(120, TimeUnit.SECONDS)
				.pingInterval(5, TimeUnit.SECONDS)
				.readTimeout(60, TimeUnit.SECONDS)
				.writeTimeout(60, TimeUnit.SECONDS)
				;
        
        builder.sslSocketFactory(sslSocketFactory, trustManager);
//        builder.hostnameVerifier( (hostname, session) -> true); // 忽略认证
        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                Certificate[] localCertificates = new Certificate[0];
                try {
                    //获取证书链中的全部证书
                    localCertificates = session.getPeerCertificates();
                } catch (SSLPeerUnverifiedException e) {
                    e.printStackTrace();
                }
                //打印全部证书内容
                for (Certificate c : localCertificates) {
                    System.out.println( "verify: "+c.toString());
                }
                return true;
            }
        });
        this.client = builder.build();
	}
	
    private X509TrustManager trustedCertificatesInputStream() {
        return new X509TrustManager() {

			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return new java.security.cert.X509Certificate[] {};
			}
        	
        };
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
		
		Call call = client.newCall(request);
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

	public void downloadGet(String url, String savePath) throws IOException {
		Request request = new Request.Builder()
				.url(url)
				.build();
		Response response = client.newCall(request).execute();
		byte[] bs = response.body().bytes();
		
		FileUtil.saveFile(bs, savePath);
	}
	
	public static void main(String[] args) throws IOException, 
	KeyManagementException, NoSuchAlgorithmException {
		
		String url = "https://i.pixiv.cat/img-original/img/2021/11/13/12/29/34/94101036_p0.png";
		String file = "94711101_p0.jpg";
		
		SimpleOkHttp http = new SimpleOkHttp();
		http.downloadGet(url, file);
		
		System.out.println("end");
	}
	
}
