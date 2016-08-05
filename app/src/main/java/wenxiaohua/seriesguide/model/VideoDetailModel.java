package wenxiaohua.seriesguide.model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import wenxiaohua.seriesguide.bean.VideoDetailInfo;
import wenxiaohua.seriesguide.bean.VideoM3U8PathBean;
import wenxiaohua.seriesguide.inter.ApiService;
import wenxiaohua.seriesguide.model.impl.IVideoDetailModel;
import wenxiaohua.seriesguide.utils.RetrofitUtils;

/**
 * Created by hexun on 2016/6/17.
 */
public class VideoDetailModel implements IVideoDetailModel {
    @Override
    public void getVideoDetailWithModel(String seasonId, Callback<VideoDetailInfo> callback) {
        Retrofit retrofit= RetrofitUtils.getRetrofitInstance("video/detail");
        ApiService service = retrofit.create(ApiService.class);
        Call<VideoDetailInfo> call = service.getVideoDetailWithApi(seasonId);
        call.enqueue(callback);
    }



    @Override
    public void getVideoWithModel(String seasonId, String episodeSid, Callback<VideoM3U8PathBean> callback) {
        Retrofit retrofit= RetrofitUtils.getRetrofitInstance(seasonId,episodeSid);
        ApiService service = retrofit.create(ApiService.class);
        Call<VideoM3U8PathBean> call = service.getVideoWithApi();
        call.enqueue(callback);
    }

}
