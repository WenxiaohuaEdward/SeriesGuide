package wenxiaohua.seriesguide.presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wenxiaohua.seriesguide.bean.SearchFragmentHotWord;
import wenxiaohua.seriesguide.bean.SearchInfo;
import wenxiaohua.seriesguide.impl.ISearchFragmentView;
import wenxiaohua.seriesguide.model.SearchFragmentModel;
import wenxiaohua.seriesguide.model.impl.ISearchFragmentModel;

/**
 * Created by hexun on 2016/6/8.
 */
public class SearchFragmentPresenter extends BasePresenter<ISearchFragmentView> {

    private final ISearchFragmentModel mISearchFragmentModel;

    public SearchFragmentPresenter() {
        mISearchFragmentModel = new SearchFragmentModel();
    }
    public void getSearchData(String page,String rows , String title,String cat){
        mISearchFragmentModel.getSearchDataWithModel(page, rows, title,cat, new Callback<SearchInfo>() {
            @Override
            public void onResponse(Call<SearchInfo> call, Response<SearchInfo> response) {
                if (response == null || response.body() == null || response.body().getData() == null||mView==null)
                    return;
                mView.getSearchDataWithView(response.body().getData());
            }

            @Override
            public void onFailure(Call<SearchInfo> call, Throwable t) {

            }
        });
    }

    public void getHotWord(){
        mISearchFragmentModel.getHotWordWithModel(new Callback<SearchFragmentHotWord>() {
            @Override
            public void onResponse(Call<SearchFragmentHotWord> call, Response<SearchFragmentHotWord> response) {
                if (response == null || response.body() == null || response.body().getData() == null) {
                    return;
                }
                mView.getHotWordWithView(response.body().getData());
            }

            @Override
            public void onFailure(Call<SearchFragmentHotWord> call, Throwable t) {

            }
        });

    }
}
