package wenxiaohua.seriesguide.presenter;

import wenxiaohua.seriesguide.impl.IVideoDetailReviewView;
import wenxiaohua.seriesguide.model.VideoDetailReviewModel;
import wenxiaohua.seriesguide.model.impl.IVideoDetailReviewModel;

/**
 * Created by hexun on 2016/6/17.
 */
public class VideoDetailReviewPresenter extends BasePresenter<IVideoDetailReviewView> {
    private final IVideoDetailReviewModel mIVideoDetailReviewModel;


    public VideoDetailReviewPresenter() {
        mIVideoDetailReviewModel = new VideoDetailReviewModel();
    }
    public void getReview(){

    }
}
