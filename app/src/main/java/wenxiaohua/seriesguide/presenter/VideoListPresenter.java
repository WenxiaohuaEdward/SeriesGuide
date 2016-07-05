package wenxiaohua.seriesguide.presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wenxiaohua.seriesguide.bean.SearchInfo;
import wenxiaohua.seriesguide.impl.IVideoListView;
import wenxiaohua.seriesguide.model.VideoListModel;
import wenxiaohua.seriesguide.model.impl.IVideoListModel;

/**
 * Created by hexun on 2016/6/15.
 */
public class VideoListPresenter extends BasePresenter<IVideoListView> {
    private final IVideoListModel mIVideoListModel;

    public VideoListPresenter() {
        mIVideoListModel = new VideoListModel();
    }
    public void getSearchData(String page,String rows , String title,String cat){
        mIVideoListModel.getSearchDataWithModel(page, rows, title,cat, new Callback<SearchInfo>() {
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
    public void getSearchHotOrNewData(String page,String rows , String mark){
        mIVideoListModel.getSearchDataHotOrNewWithModel(page, rows, mark, new Callback<SearchInfo>() {
            @Override
            public void onResponse(Call<SearchInfo> call, Response<SearchInfo> response) {
                if (response == null || response.body() == null || response.body().getData() == null)
                    return;
                mView.getSearchDataHotOrNewWithView(response.body().getData());
            }

            @Override
            public void onFailure(Call<SearchInfo> call, Throwable t) {

            }
        });
    }
}
