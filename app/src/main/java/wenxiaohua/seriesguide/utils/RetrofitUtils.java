package wenxiaohua.seriesguide.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
        RequestInterceptor requestInterceptor = new RequestInterceptor(url);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(requestInterceptor)
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
//    // 自定义okhttp的Interceptor
//    public static class TokenInterceptor implements Interceptor {
//        @Override
//        public okhttp3.Response intercept(Chain chain) throws IOException {
////            Request request = chain.request().newBuilder().addHeader("Accept-Encoding", "gzip, deflate").addHeader("Connection","keep-alive").addHeader("clientVersion","2.1.0").addHeader("a","06efb8eb-c798-401b-bb51-1df487b3e5da").addHeader("b","/video/hotWord").addHeader("c","lhy").addHeader("d","1459844453969").addHeader("e","5b28f02089098fcb0bf1efb0e8fe7dc30381bc9f").build();
//            return null;
//        }
//    }
}
