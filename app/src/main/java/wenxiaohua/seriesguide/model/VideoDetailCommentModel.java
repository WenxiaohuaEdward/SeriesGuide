package wenxiaohua.seriesguide.model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import wenxiaohua.seriesguide.bean.VideoDetailCommentInfo;
import wenxiaohua.seriesguide.inter.ApiService;
import wenxiaohua.seriesguide.model.impl.IVideoDetailCommentModel;
import wenxiaohua.seriesguide.utils.RetrofitUtils;

/**
 * Created by hexun on 2016/6/16.
 */
public class VideoDetailCommentModel implements IVideoDetailCommentModel {

    @Override
    public void getVideoDetailCommentWithModel(String page, String rows,String seasonId,Callback<VideoDetailCommentInfo> callback) {
        Retrofit retrofit= RetrofitUtils.getRetrofitInstance("/v2/comment/list");
        ApiService service = retrofit.create(ApiService.class);
        Call<VideoDetailCommentInfo> call = service.getVideoDetailCommentWithApi(page,rows,seasonId);
        call.enqueue(callback);
    }
}
