package wenxiaohua.seriesguide.impl;

import wenxiaohua.seriesguide.bean.DiscoverFragmentInfo;
import wenxiaohua.seriesguide.bean.SearchInfo;

/**
 * Created by hexun on 2016/6/14.
 */
public interface IDiscoverFragmentView extends IBaseView{
    void getDiscoverDataWithView(DiscoverFragmentInfo.DataBean discoverData);
    void getSearchDataWithView(SearchInfo.DataBean dataBean,int groupPosition);
}
