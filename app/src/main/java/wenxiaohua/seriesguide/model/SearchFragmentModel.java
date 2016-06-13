package wenxiaohua.seriesguide.model;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import wenxiaohua.seriesguide.bean.SearchFragmentHotWord;
import wenxiaohua.seriesguide.constant.HostAddress;
import wenxiaohua.seriesguide.inter.ApiService;
import wenxiaohua.seriesguide.model.impl.ISearchFragmentModel;

/**
 * Created by hexun on 2016/6/13.
 */
public class SearchFragmentModel implements ISearchFragmentModel{

    @Override
    public void getHotWordWithModel(Callback<SearchFragmentHotWord> callback) {
        // 加入链中
        RequestInterceptor requestInterceptor = new RequestInterceptor();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(requestInterceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
//                .addNetworkInterceptor(mTokenInterceptor) 拦截器
                .build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(HostAddress.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        ApiService service = retrofit.create(ApiService.class);
        Call<SearchFragmentHotWord> call = service.getHotWordWithApi();
        call.enqueue(callback);
    }
    // 自定义okhttp的Interceptor
    public class RequestInterceptor implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
             Request request = chain.request().newBuilder().addHeader("Accept-Encoding", "gzip, deflate").build();
            return chain.proceed(request);
        }
    }


}
