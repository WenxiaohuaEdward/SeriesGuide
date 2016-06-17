package wenxiaohua.seriesguide.impl;

import wenxiaohua.seriesguide.bean.VideoDetailCommentInfo;

/**
 * Created by hexun on 2016/6/16.
 */
public interface IVideoDetailCommentView extends IBaseView{
    void getVideoDetailCommentWithView(VideoDetailCommentInfo.DataBean dataBean);
}
