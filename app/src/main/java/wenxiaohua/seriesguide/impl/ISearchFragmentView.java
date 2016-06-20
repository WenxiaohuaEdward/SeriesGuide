package wenxiaohua.seriesguide.impl;

import wenxiaohua.seriesguide.bean.SearchFragmentHotWord;
import wenxiaohua.seriesguide.bean.SecrchInfo;

/**
 * Created by hexun on 2016/6/8.
 */
public interface ISearchFragmentView extends IBaseView {
    void getHotWordWithView(SearchFragmentHotWord.DataBean hotWordData);

    void getSearchDataWithView(SecrchInfo.DataBean data);
}
