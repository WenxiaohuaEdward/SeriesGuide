package wenxiaohua.seriesguide.model.impl;

import retrofit2.Callback;
import wenxiaohua.seriesguide.bean.VideoDetailCommentInfo;

/**
 * Created by hexun on 2016/6/16.
 */
public interface IVideoDetailCommentModel {
    void getVideoDetailCommentWithModel(String page, String rows,String seasonId,Callback<VideoDetailCommentInfo> callback);

}
