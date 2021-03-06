package wenxiaohua.seriesguide.model;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import wenxiaohua.seriesguide.bean.DiscoverFragmentInfo;
import wenxiaohua.seriesguide.bean.SearchInfo;
import wenxiaohua.seriesguide.inter.ApiService;
import wenxiaohua.seriesguide.model.impl.IDiscoverFragmentModel;
import wenxiaohua.seriesguide.utils.RetrofitUtils;

/**
 * Created by hexun on 2016/6/14.
 */
public class DiscoverFragmentModel implements IDiscoverFragmentModel {
    @Override
    public void getDiscoverDataWithModel(Callback<DiscoverFragmentInfo> callback) {
        Retrofit retrofit= RetrofitUtils.getRetrofitInstance("/video/indexInfo");
        ApiService service = retrofit.create(ApiService.class);
        Call<DiscoverFragmentInfo> call = service.getDiscoverDataWithApi();
        call.enqueue(callback);
    }

    @Override
    public void getSearchDataWithModel(String page, String rows, String title,String cat, Callback<SearchInfo> callback) {
        Retrofit  retrofit= RetrofitUtils.getRetrofitInstance("/video/search");
        ApiService service = retrofit.create(ApiService.class);
        Call<SearchInfo> call = service.getSearchDataWithApi(page, rows, title, cat);
        call.enqueue(callback);
    }
}
