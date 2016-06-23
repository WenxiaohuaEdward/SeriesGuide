package wenxiaohua.seriesguide.impl;

import wenxiaohua.seriesguide.bean.SearchInfo;

/**
 * Created by hexun on 2016/6/15.
 */
public interface IVideoListView extends IBaseView{
    void getSearchDataWithView(SearchInfo.DataBean data);

    void getSearchDataHotOrNewWithView(SearchInfo.DataBean data);
}
