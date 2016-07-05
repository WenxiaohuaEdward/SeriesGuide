package wenxiaohua.seriesguide.impl;

import java.util.List;

import greendao.SeriesGuideSeason;

/**
 * Created by hexun on 2016/6/17.
 */
public interface IVideoDetailReviewView extends IBaseView{
    void  getSeasonWithId(List<SeriesGuideSeason> seriesGuideSeasons);
}
