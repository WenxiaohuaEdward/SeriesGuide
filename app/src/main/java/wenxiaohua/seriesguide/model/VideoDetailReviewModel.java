package wenxiaohua.seriesguide.model;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import greendao.SeriesGuideSeason;
import wenxiaohua.seriesguide.bean.VideoDetailInfo;
import wenxiaohua.seriesguide.event.Event;
import wenxiaohua.seriesguide.model.impl.IVideoDetailReviewModel;
import wenxiaohua.seriesguide.utils.SeasonDBUtils;

/**
 * Created by hexun on 2016/6/17.
 */
public class VideoDetailReviewModel implements IVideoDetailReviewModel {

    private SeasonDBUtils mSeasonDBUtils;



    @Override
    public void addSeason(Context context,String type, VideoDetailInfo.DataBean videoDetailInfo) {
        if (videoDetailInfo != null) {
            mSeasonDBUtils = SeasonDBUtils.getInstance(context);
            //进行数据库的操作
            if (mSeasonDBUtils.getSeasonWithType(type) != null && !mSeasonDBUtils.getSeasonWithType(type).isEmpty() && mSeasonDBUtils.getSeasonWithType(type).contains(videoDetailInfo)) {
                mSeasonDBUtils.deleteSeason((long) videoDetailInfo.getSeasonDetail().getId());
                SeriesGuideSeason seriesGuideSeason = mSeasonDBUtils.seasonToDb(videoDetailInfo, type);
                mSeasonDBUtils.addSeason(seriesGuideSeason);
                EventBus.getDefault().post(new Event.SeriesGuideSeasonEvent(seriesGuideSeason, true, type));
            } else {
                if (mSeasonDBUtils.getSeasonWithId((long) videoDetailInfo.getSeasonDetail().getId()) != null || !mSeasonDBUtils.getSeasonWithId((long) videoDetailInfo.getSeasonDetail().getId()).isEmpty()) {
                    mSeasonDBUtils.deleteSeason((long) videoDetailInfo.getSeasonDetail().getId());
                }
                SeriesGuideSeason seriesGuideSeason = mSeasonDBUtils.seasonToDb(videoDetailInfo, type);
                mSeasonDBUtils.addSeason(seriesGuideSeason);
                EventBus.getDefault().post(new Event.SeriesGuideSeasonEvent(seriesGuideSeason, false, type));
            }

        }
    }

    @Override
    public void deleteSeason(Context context, String id) {
        if(id!=null||!"".equals(id)){
            mSeasonDBUtils = SeasonDBUtils.getInstance(context);
            EventBus.getDefault().post(new Event.SeriesGuideDeleteSeasonEvent(mSeasonDBUtils.getSeasonWithId(Long.parseLong(id)).get(0)));
            mSeasonDBUtils.deleteSeason(Long.parseLong(id));

        }

    }

    @Override
    public List<SeriesGuideSeason> getSeasonWithId(Context context, String id) {
        if(id!=null||!"".equals(id)){
            mSeasonDBUtils = SeasonDBUtils.getInstance(context);
            List<SeriesGuideSeason> seriesGuideSeasonList=  mSeasonDBUtils.getSeasonWithId(Long.parseLong(id));
            return seriesGuideSeasonList;
        }
        return null;
    }
}
