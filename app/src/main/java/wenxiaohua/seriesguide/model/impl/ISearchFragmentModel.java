package wenxiaohua.seriesguide.model.impl;

import retrofit2.Callback;
import wenxiaohua.seriesguide.bean.SearchFragmentHotWord;
import wenxiaohua.seriesguide.bean.SearchInfo;

/**
 * Created by hexun on 2016/6/13.
 */
public interface ISearchFragmentModel {

     void getHotWordWithModel(Callback<SearchFragmentHotWord> callback);
     void getSearchDataWithModel(String page,String rows , String title,String cat,Callback<SearchInfo> callback);

}
