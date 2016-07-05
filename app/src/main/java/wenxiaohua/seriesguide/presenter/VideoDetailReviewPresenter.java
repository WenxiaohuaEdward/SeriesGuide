package wenxiaohua.seriesguide.presenter;

import android.content.Context;

import java.util.List;

import greendao.SeriesGuideSeason;
import wenxiaohua.seriesguide.bean.VideoDetailInfo;
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
    public void addSeason(Context context,String type, VideoDetailInfo.DataBean videoDetailInfo){
        mIVideoDetailReviewModel.addSeason(context, type,  videoDetailInfo);
        }
    public void deleteSeason(Context context,String id){
        mIVideoDetailReviewModel.deleteSeason(context, id);
    }
    public void getSeasonWithId(Context context,String id){
        List<SeriesGuideSeason> seriesGuideSeasonList =  mIVideoDetailReviewModel.getSeasonWithId(context, id);
        if (seriesGuideSeasonList!=null&&!seriesGuideSeasonList.isEmpty()){
            mView.getSeasonWithId(seriesGuideSeasonList);
        }
    }
    }
