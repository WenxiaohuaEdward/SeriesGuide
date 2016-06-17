package wenxiaohua.seriesguide.model.impl;

import retrofit2.Callback;
import wenxiaohua.seriesguide.bean.VideoDetailInfo;

/**
 * Created by hexun on 2016/6/17.
 */
public interface IVideoDetailModel {

    void getVideoDetailWithModel(  String seasonId, Callback<VideoDetailInfo> callback);
}
