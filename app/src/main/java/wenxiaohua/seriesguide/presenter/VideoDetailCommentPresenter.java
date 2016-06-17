package wenxiaohua.seriesguide.presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wenxiaohua.seriesguide.bean.VideoDetailCommentInfo;
import wenxiaohua.seriesguide.impl.IVideoDetailCommentView;
import wenxiaohua.seriesguide.model.VideoDetailCommentModel;
import wenxiaohua.seriesguide.model.impl.IVideoDetailCommentModel;

/**
 * Created by hexun on 2016/6/16.
 */
public class VideoDetailCommentPresenter extends BasePresenter<IVideoDetailCommentView> {

    private final IVideoDetailCommentModel mIVideoDetailCommentModel;


    public VideoDetailCommentPresenter() {
        mIVideoDetailCommentModel = new VideoDetailCommentModel();

    }
    public void getVideoDetailComment(String page, String rows,String seasonId){
        mIVideoDetailCommentModel.getVideoDetailCommentWithModel( page,  rows, seasonId,new Callback<VideoDetailCommentInfo>() {
            @Override
            public void onResponse(Call<VideoDetailCommentInfo> call, Response<VideoDetailCommentInfo> response) {
                if (response == null || response.body() == null || response.body().getData() == null)
                    return;
                mView.getVideoDetailCommentWithView(response.body().getData());
            }

            @Override
            public void onFailure(Call<VideoDetailCommentInfo> call, Throwable t) {

            }
        });
    }
}
