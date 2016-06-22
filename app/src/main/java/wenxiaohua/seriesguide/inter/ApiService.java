package wenxiaohua.seriesguide.inter;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import wenxiaohua.seriesguide.bean.DiscoverFragmentInfo;
import wenxiaohua.seriesguide.bean.SearchFragmentHotWord;
import wenxiaohua.seriesguide.bean.SearchInfo;
import wenxiaohua.seriesguide.bean.VideoDetailCommentInfo;
import wenxiaohua.seriesguide.bean.VideoDetailInfo;

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
    @POST("/v3/video/detail")
    Call<VideoDetailInfo> getVideoDetailWithApi(
            @Query("seasonId") String seasonId
    );
    @POST("/v2/video/search")
    Call<SearchInfo> getSearchDataWithApi(
            @Query("page") String page,
            @Query("rows") String rows,
            @Query("title") String title,
            @Query("cat") String cat
    );

}
