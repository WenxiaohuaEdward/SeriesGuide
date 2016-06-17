package wenxiaohua.seriesguide.impl;

import wenxiaohua.seriesguide.bean.VideoDetailInfo;

/**
 * Created by hexun on 2016/6/17.
 */
public interface IVideoDetailView extends IBaseView {
    void getVideoDetailWithView(VideoDetailInfo.DataBean data);
}
