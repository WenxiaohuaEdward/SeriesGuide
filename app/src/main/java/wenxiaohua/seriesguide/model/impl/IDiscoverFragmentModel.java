package wenxiaohua.seriesguide.model.impl;

import retrofit2.Callback;
import wenxiaohua.seriesguide.bean.DiscoverFragmentInfo;
import wenxiaohua.seriesguide.bean.SearchInfo;

/**
 * Created by hexun on 2016/6/14.
 */
public interface IDiscoverFragmentModel {
    void getDiscoverDataWithModel(Callback<DiscoverFragmentInfo> callback);
    void getSearchDataWithModel(String page, String rows,String title, String cat, Callback<SearchInfo> callback);
}
