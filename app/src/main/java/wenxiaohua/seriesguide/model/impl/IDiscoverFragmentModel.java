package wenxiaohua.seriesguide.model.impl;

import retrofit2.Callback;
import wenxiaohua.seriesguide.bean.DiscoverFragmentInfo;

/**
 * Created by hexun on 2016/6/14.
 */
public interface IDiscoverFragmentModel {
    void getDiscoverDataWithModel(Callback<DiscoverFragmentInfo> callback);
}
