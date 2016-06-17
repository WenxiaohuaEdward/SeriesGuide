package wenxiaohua.seriesguide.inter;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import wenxiaohua.seriesguide.bean.DiscoverFragmentInfo;
import wenxiaohua.seriesguide.bean.SearchFragmentHotWord;
import wenxiaohua.seriesguide.bean.VideoDetailCommentInfo;

/**
 * Created by hexun on 2016/6/13.
 */
public interface ApiService {

    @POST("/v2/video/hotWord")
    Call<SearchFragmentHotWord> getHotWordWithApi();
    @POST("/v2/video/indexInfo")
    Call<DiscoverFragmentInfo> getDiscoverDataWithApi();
    @POST("/v2/comment/list")
    Call<VideoDetailCommentInfo> getVideoDetailCommentWithApi(
            @Query("page") String page,
            @Query("rows") String rows,
            @Query("seasonId") String seasonId
    );

}
