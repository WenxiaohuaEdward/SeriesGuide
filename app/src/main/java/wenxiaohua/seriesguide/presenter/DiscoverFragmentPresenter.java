package wenxiaohua.seriesguide.presenter;


import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wenxiaohua.seriesguide.bean.DiscoverFragmentInfo;
import wenxiaohua.seriesguide.bean.SearchInfo;
import wenxiaohua.seriesguide.impl.IDiscoverFragmentView;
import wenxiaohua.seriesguide.model.DiscoverFragmentModel;
import wenxiaohua.seriesguide.model.impl.IDiscoverFragmentModel;

/**
 * Created by hexun on 2016/6/14.
 */
public class DiscoverFragmentPresenter extends BasePresenter<IDiscoverFragmentView>{
    private final IDiscoverFragmentModel mIDiscoverFragmentModel;

    public DiscoverFragmentPresenter() {
        mIDiscoverFragmentModel = new DiscoverFragmentModel();
    }
    public void getDiscoverData(){
        mIDiscoverFragmentModel.getDiscoverDataWithModel(new Callback<DiscoverFragmentInfo>() {
            @Override
            public void onResponse(Call<DiscoverFragmentInfo> call, Response<DiscoverFragmentInfo> response) {
                if (response == null || response.body() == null || response.body().getData() == null||mView==null)
                    return;
                Log.v("SearchFragmentPresenter", response.body().toString());
                mView.getDiscoverDataWithView(response.body().getData());
            }

            @Override
            public void onFailure(Call<DiscoverFragmentInfo> call, Throwable t) {

            }
        });
    }
    public void getSearchData(String page,String rows ,String title, String cat, final int groupPosition){
        mIDiscoverFragmentModel.getSearchDataWithModel(page, rows,title, cat, new Callback<SearchInfo>() {
            @Override
            public void onResponse(Call<SearchInfo> call, Response<SearchInfo> response) {
                if (response == null || response.body() == null || response.body().getData() == null)
                    return;
                mView.getSearchDataWithView(response.body().getData(),groupPosition);
            }

            @Override
            public void onFailure(Call<SearchInfo> call, Throwable t) {

            }
        });
    }
}
