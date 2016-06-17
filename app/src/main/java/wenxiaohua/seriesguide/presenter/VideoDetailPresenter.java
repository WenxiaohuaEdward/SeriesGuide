package wenxiaohua.seriesguide.presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wenxiaohua.seriesguide.bean.VideoDetailInfo;
import wenxiaohua.seriesguide.impl.IVideoDetailView;
import wenxiaohua.seriesguide.model.VideoDetailModel;
import wenxiaohua.seriesguide.model.impl.IVideoDetailModel;

/**
 * Created by hexun on 2016/6/17.
 */
public class VideoDetailPresenter extends BasePresenter<IVideoDetailView> {
    private final IVideoDetailModel mIVideoDetailModel;


    public VideoDetailPresenter() {
        mIVideoDetailModel = new VideoDetailModel();
    }
    public void getVideoDetail(String seasonId){
        mIVideoDetailModel.getVideoDetailWithModel(seasonId, new Callback<VideoDetailInfo>() {
            @Override
            public void onResponse(Call<VideoDetailInfo> call, Response<VideoDetailInfo> response) {
                if (response == null || response.body() == null || response.body().getData() == null)
                    return;
                mView.getVideoDetailWithView(response.body().getData());
            }

            @Override
            public void onFailure(Call<VideoDetailInfo> call, Throwable t) {

            }
        });

    }
}
