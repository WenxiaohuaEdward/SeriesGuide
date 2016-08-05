package wenxiaohua.seriesguide.impl;

import java.util.List;

import wenxiaohua.seriesguide.bean.VideoDetailInfo;
import wenxiaohua.seriesguide.bean.VideoM3U8PathBean;

/**
 * Created by hexun on 2016/6/17.
 */
public interface IVideoDetailView extends IBaseView {
    void getVideoDetailWithView(VideoDetailInfo.DataBean data);

    void getVideoPathWithView(List<VideoDetailInfo.DataBean.SeasonDetailBean.PlayUrlListBean> playUrlList);

    void getVideoWithView(VideoM3U8PathBean.DataBean data);
}
