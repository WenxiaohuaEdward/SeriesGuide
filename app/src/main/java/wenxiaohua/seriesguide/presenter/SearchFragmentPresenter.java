package wenxiaohua.seriesguide.presenter;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wenxiaohua.seriesguide.bean.SearchFragmentHotWord;
import wenxiaohua.seriesguide.bean.SecrchInfo;
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
    public void getSearchData(String page,String rows , String title){
        mISearchFragmentModel.getSearchDataWithModel(page, rows, title, new Callback<SecrchInfo>() {
            @Override
            public void onResponse(Call<SecrchInfo> call, Response<SecrchInfo> response) {
                if (response == null || response.body() == null || response.body().getData() == null)
                    return;
                mView.getSearchDataWithView(response.body().getData());
            }

            @Override
            public void onFailure(Call<SecrchInfo> call, Throwable t) {

            }
        });
    }

    public void getHotWord(){
        mISearchFragmentModel.getHotWordWithModel(new Callback<SearchFragmentHotWord>() {
            @Override
            public void onResponse(Call<SearchFragmentHotWord> call, Response<SearchFragmentHotWord> response) {
                if (response == null || response.body() == null || response.body().getData() == null)
                    return;
                mView.getHotWordWithView(response.body().getData());
            }

            @Override
            public void onFailure(Call<SearchFragmentHotWord> call, Throwable t) {

            }
        });

    }
}
