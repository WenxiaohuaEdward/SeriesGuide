package wenxiaohua.seriesguide.model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import wenxiaohua.seriesguide.bean.SearchFragmentHotWord;
import wenxiaohua.seriesguide.inter.ApiService;
import wenxiaohua.seriesguide.model.impl.ISearchFragmentModel;
import wenxiaohua.seriesguide.utils.RetrofitUtils;

/**
 * Created by hexun on 2016/6/13.
 */
public class SearchFragmentModel implements ISearchFragmentModel{

    @Override
    public void getHotWordWithModel(Callback<SearchFragmentHotWord> callback) {

        Retrofit  retrofit= RetrofitUtils.getRetrofitInstance("/video/hotWord");
        ApiService service = retrofit.create(ApiService.class);
        Call<SearchFragmentHotWord> call = service.getHotWordWithApi();
        call.enqueue(callback);
    }



}
