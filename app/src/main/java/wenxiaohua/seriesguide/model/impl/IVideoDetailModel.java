package wenxiaohua.seriesguide.model.impl;

import retrofit2.Callback;
import wenxiaohua.seriesguide.bean.VideoDetailInfo;
import wenxiaohua.seriesguide.bean.VideoM3U8PathBean;

/**
 * Created by hexun on 2016/6/17.
 */
public interface IVideoDetailModel {

    void getVideoDetailWithModel(  String seasonId, Callback<VideoDetailInfo> callback);


    void getVideoWithModel(String seasonId, String episodeSid, Callback<VideoM3U8PathBean> callback);
}
