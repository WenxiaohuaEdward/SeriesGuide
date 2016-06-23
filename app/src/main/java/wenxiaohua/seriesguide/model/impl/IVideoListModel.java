package wenxiaohua.seriesguide.model.impl;

import retrofit2.Callback;
import wenxiaohua.seriesguide.bean.SearchInfo;

/**
 * Created by hexun on 2016/6/15.
 */
public interface IVideoListModel {
    void getSearchDataWithModel(String page, String rows, String title, String cat, Callback<SearchInfo> callback);

    void getSearchDataHotOrNewWithModel(String page, String rows, String mark, Callback<SearchInfo> callback);
}
