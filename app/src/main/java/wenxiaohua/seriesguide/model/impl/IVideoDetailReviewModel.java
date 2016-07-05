package wenxiaohua.seriesguide.model.impl;

import android.content.Context;

import java.util.List;

import greendao.SeriesGuideSeason;
import wenxiaohua.seriesguide.bean.VideoDetailInfo;

/**
 * Created by hexun on 2016/6/17.
 */
public interface IVideoDetailReviewModel {
    void addSeason(Context context ,String type, VideoDetailInfo.DataBean videoDetailInfo);

    void deleteSeason(Context context, String id);

    List<SeriesGuideSeason> getSeasonWithId(Context context, String id);
}
