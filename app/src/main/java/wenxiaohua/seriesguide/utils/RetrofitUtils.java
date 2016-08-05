package wenxiaohua.seriesguide.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import wenxiaohua.seriesguide.constant.HostAddress;

/**
 * Created by hexun on 2016/6/14.
 */
public class RetrofitUtils {


    public static Retrofit getRetrofitInstance(String url){
        // 加入链中
//        TokenInterceptor mTokenInterceptor = new TokenInterceptor();
//        RequestInterceptor requestInterceptor = new RequestInterceptor(url);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
//              .addNetworkInterceptor(mTokenInterceptor) //网络拦截器
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(HostAddress.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
    public static Retrofit getRetrofitInstance(String seasonId,String episodeSid){

        RequestBodyInterceptor requestBodyInterceptor = new RequestBodyInterceptor(seasonId,episodeSid);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(requestBodyInterceptor)
//              .addNetworkInterceptor(mTokenInterceptor) //网络拦截器
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(HostAddress.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
    // 自定义okhttp的Interceptor
    public static class RequestInterceptor implements Interceptor {
        private final String url;

        public RequestInterceptor(String url){
            this.url =url;
        }
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request().newBuilder().addHeader("Accept-Encoding", "gzip, deflate").addHeader("Connection","keep-alive").addHeader("clientVersion","2.1.0").addHeader("a","06efb8eb-c798-401b-bb51-1df487b3e5da").addHeader("b",url).addHeader("c","lhy").addHeader("d","1459844453969").addHeader("e","5b28f02089098fcb0bf1efb0e8fe7dc30381bc9f").build();
            return chain.proceed(request);
        }
    }
    // 自定义okhttp的Interceptor
    public static class RequestBodyInterceptor implements Interceptor {
        private final String episodeSid;
        private final String seasonId;

        public RequestBodyInterceptor(String seasonId, String episodeSid) {
            this.seasonId =seasonId;
            this.episodeSid = episodeSid;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();

            //请求定制：添加请求头
            Request.Builder requestBuilder = original.newBuilder();
            requestBuilder.addHeader("Content-Type", "application/json; charset=utf-8").addHeader("clientType", "android_").addHeader("d","1470131601755").addHeader("e","7fb4b459adbaed21514e5c92e511a19cda02fd13").addHeader("b","http://api.rrmj.tv/video/findM3u8ByEpisodeSid").addHeader("c","fc8cd0e2-63ab-4ba2-a972-04f2e5139959").addHeader("a","c239e42b-07e5-4e82-91d0-68d0026d3241").addHeader("clientVersion","3.0.3");
//            //请求体定制：统一添加token参数
                FormBody.Builder newFormBody = new FormBody.Builder();

                newFormBody.add("seasonId",seasonId);
                newFormBody.add("episodeSid",episodeSid);
                newFormBody.add("quality","high");
                requestBuilder.post(newFormBody.build());
            Request request = requestBuilder.build();
            return chain.proceed(request);
        }
    };
}
