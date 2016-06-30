package wenxiaohua.seriesguide.presenter;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import greendao.SeriesGuideSeason;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wenxiaohua.seriesguide.bean.VideoDetailInfo;
import wenxiaohua.seriesguide.event.Event;
import wenxiaohua.seriesguide.impl.IVideoDetailView;
import wenxiaohua.seriesguide.model.VideoDetailModel;
import wenxiaohua.seriesguide.model.impl.IVideoDetailModel;
import wenxiaohua.seriesguide.utils.SeasonDBUtils;

/**
 * Created by hexun on 2016/6/17.
 */
public class VideoDetailPresenter extends BasePresenter<IVideoDetailView> {
    private final IVideoDetailModel mIVideoDetailModel;
    private SeasonDBUtils mSeasonDBUtils;


    public VideoDetailPresenter() {
        mIVideoDetailModel = new VideoDetailModel();
    }
    public void getVideoDetail(final Context context ,String seasonId){
        mIVideoDetailModel.getVideoDetailWithModel(seasonId, new Callback<VideoDetailInfo>() {
            @Override
            public void onResponse(Call<VideoDetailInfo> call, Response<VideoDetailInfo> response) {
                if (response == null || response.body() == null || response.body().getData() == null)
                    return;
                mView.getVideoDetailWithView(response.body().getData());
                mSeasonDBUtils = SeasonDBUtils.getInstance(context);
                //进行数据库的操作
                if(mSeasonDBUtils.getSeason((long) response.body().getData().getSeasonDetail().getId())!=null&&!mSeasonDBUtils.getSeason((long) response.body().getData().getSeasonDetail().getId()).isEmpty()){
                    mSeasonDBUtils.deleteSeason((long) response.body().getData().getSeasonDetail().getId());
                    SeriesGuideSeason seriesGuideSeason =  seasonToDb(response.body().getData());
                    mSeasonDBUtils.addSeason(seriesGuideSeason);
                    EventBus.getDefault().post(new Event.SeriesGuideSeasonEvent(seriesGuideSeason,true));
                }else{
                    SeriesGuideSeason seriesGuideSeason =  seasonToDb(response.body().getData());
                    mSeasonDBUtils.addSeason(seriesGuideSeason);
                    EventBus.getDefault().post(new Event.SeriesGuideSeasonEvent(seriesGuideSeason, false));
                }
            }

            @Override
            public void onFailure(Call<VideoDetailInfo> call, Throwable t) {

            }
        });

    }
    public SeriesGuideSeason seasonToDb(VideoDetailInfo.DataBean data){
        SeriesGuideSeason seriesGuideSeason = new SeriesGuideSeason();
        seriesGuideSeason.setTitle(data.getSeasonDetail().getTitle());
        seriesGuideSeason.setId((long) data.getSeasonDetail().getId());
        seriesGuideSeason.setCover(data.getSeasonDetail().getCover());
        seriesGuideSeason.setBrief(data.getSeasonDetail().getBrief());
        seriesGuideSeason.setCat(data.getSeasonDetail().getCat());
        seriesGuideSeason.setCreateTime(System.currentTimeMillis());
        seriesGuideSeason.setEnTitle(data.getSeasonDetail().getEnTitle());
        seriesGuideSeason.setPlayStatus(data.getSeasonDetail().getPlayStatus());
        seriesGuideSeason.setViewCount(data.getSeasonDetail().getViewCount());
        seriesGuideSeason.setUpdateInfo(data.getSeasonDetail().getUpdateinfo());
        seriesGuideSeason.setTotal(data.getSeasonDetail().getTotal());
        seriesGuideSeason.setUpdateTime(data.getSeasonDetail().getUpdateTime());
        return seriesGuideSeason;
    }
}
