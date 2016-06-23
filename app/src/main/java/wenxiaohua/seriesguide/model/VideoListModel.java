package wenxiaohua.seriesguide.model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import wenxiaohua.seriesguide.bean.SearchInfo;
import wenxiaohua.seriesguide.inter.ApiService;
import wenxiaohua.seriesguide.model.impl.IVideoListModel;
import wenxiaohua.seriesguide.utils.RetrofitUtils;

/**
 * Created by hexun on 2016/6/15.
 */
public class VideoListModel implements IVideoListModel {
    @Override
    public void getSearchDataWithModel(String page, String rows, String title, String cat, Callback<SearchInfo> callback) {
        Retrofit retrofit= RetrofitUtils.getRetrofitInstance("/video/search");
        ApiService service = retrofit.create(ApiService.class);
        Call<SearchInfo> call = service.getSearchDataWithApi(page,rows,title,cat);
        call.enqueue(callback);
    }

    @Override
    public void getSearchDataHotOrNewWithModel(String page, String rows, String mark, Callback<SearchInfo> callback) {
        Retrofit retrofit= RetrofitUtils.getRetrofitInstance("/v2/video/search?order=desc&sort=createTime&mark="+mark);
        ApiService service = retrofit.create(ApiService.class);
        Call<SearchInfo> call = service.getSearchHotOrNewDataWithApi(page,rows,mark);
        call.enqueue(callback);
    }
}
