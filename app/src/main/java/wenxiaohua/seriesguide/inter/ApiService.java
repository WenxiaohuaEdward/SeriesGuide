package wenxiaohua.seriesguide.inter;

import retrofit2.Call;
import retrofit2.http.POST;
import wenxiaohua.seriesguide.bean.SearchFragmentHotWord;

/**
 * Created by hexun on 2016/6/13.
 */
public interface ApiService {

    @POST("/v2/video/hotWord")
    Call<SearchFragmentHotWord> getHotWordWithApi();
}
