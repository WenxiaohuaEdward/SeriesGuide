package wenxiaohua.seriesguide.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.SearchInfo;
import wenxiaohua.seriesguide.impl.IVideoListView;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.presenter.VideoListPresenter;
import wenxiaohua.seriesguide.view.adapter.VideoListAdapter;
import wenxiaohua.seriesguide.view.views.XListView;

/**
 * Created by wenxiaohua on 2016/6/15.
 * 视频列表
 */
public class VideoListActivity extends BaseActivity implements IVideoListView, XListView.IXListViewListener {
    @Bind(R.id.video_type_toolbar)
    Toolbar video_type_toolbar;
    @Bind(R.id.video_type_xlv)
    XListView video_type_xlv;
    VideoListAdapter mVideoListAdapter ;
    private VideoListPresenter videoListPresenter;
    private int page = 1;
    private String rows = "20";
    private String title = "";
    private String cat = "";

    @Override
    protected void initView() {
        mVideoListAdapter = new VideoListAdapter(this);
        video_type_xlv.setAdapter(mVideoListAdapter);
        video_type_xlv.setDivider(null);
        video_type_xlv.setXListViewListener(this);
        video_type_xlv.setPullLoadEnable(true);
        video_type_xlv.setPullRefreshEnable(true);
        video_type_xlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    return;
                }
                SearchInfo.DataBean.ResultsBean  resultsBean = mVideoListAdapter.getItem(position-1);
                Intent videoDetail = new Intent(VideoListActivity.this,VideoDetailActivity.class);
                videoDetail.putExtra("seasonId",  resultsBean.getId()+"");
                videoDetail.putExtra("seasonTitle", resultsBean.getTitle());
                VideoListActivity.this.startActivity(videoDetail);
            }
        });
    }

    @Override
    protected void initData() {
        if ( getIntent().getStringExtra("videoTypeTitle")!=null) {
            title = getIntent().getStringExtra("videoTypeTitle");
        }
        if ( getIntent().getStringExtra("videoTypeCat")!=null) {
            cat = getIntent().getStringExtra("videoTypeCat");
        }
        video_type_toolbar.setTitle(getIntent().getStringExtra("title"));

        videoListPresenter  = (VideoListPresenter)mPresenter;

        if (getIntent().getBooleanExtra("isHot",false)){
            videoListPresenter.getSearchHotOrNewData(page + "",rows,"hot");
        }else if (getIntent().getBooleanExtra("isNew",false)){
            videoListPresenter.getSearchHotOrNewData(page + "",rows,"update");
        }else{
            videoListPresenter.getSearchData(page + "",rows, title,cat);
        }

    }

    @Override
    public BasePresenter getPresenter() {
        return new VideoListPresenter();
    }

    @Override
    public void bindView(Bundle savedInstanceState) {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_video_type;
    }

    @Override
    public void getSearchDataWithView(SearchInfo.DataBean data) {
            if (!data.getResults().isEmpty()) {
                List<SearchInfo.DataBean.ResultsBean> dataBeanList = mVideoListAdapter.getmSeasonInfoList();
                dataBeanList.addAll(data.getResults());
                mVideoListAdapter.setmSeasonInfoList(dataBeanList);
                mVideoListAdapter.notifyDataSetChanged();
            }

        video_type_xlv.stopRefresh();
        video_type_xlv.stopLoadMore();
    }

    @Override
    public void getSearchDataHotOrNewWithView(SearchInfo.DataBean data) {
        if (!data.getResults().isEmpty()) {
            List<SearchInfo.DataBean.ResultsBean> dataBeanList = mVideoListAdapter.getmSeasonInfoList();
            dataBeanList.addAll(data.getResults());
            mVideoListAdapter.setmSeasonInfoList(dataBeanList);
            mVideoListAdapter.notifyDataSetChanged();
        }

        video_type_xlv.stopRefresh();
        video_type_xlv.stopLoadMore();
    }

    @Override
    public void onRefresh() {
        page = 1;
        mVideoListAdapter.getmSeasonInfoList().clear();

        if (getIntent().getBooleanExtra("isHot",false)){
            videoListPresenter.getSearchHotOrNewData(page + "",rows,"hot");
        }else if (getIntent().getBooleanExtra("isNew",false)){
            videoListPresenter.getSearchHotOrNewData(page + "",rows,"update");
        }else{
            videoListPresenter.getSearchData(page + "",rows, title,cat);
        }
    }

    @Override
    public void onLoadMore() {
        page ++;
        if (getIntent().getBooleanExtra("isHot",false)){
            videoListPresenter.getSearchHotOrNewData(page + "",rows,"hot");
        }else if (getIntent().getBooleanExtra("isNew",false)){
            videoListPresenter.getSearchHotOrNewData(page + "",rows,"update");
        }else{
            videoListPresenter.getSearchData(page + "",rows, title,cat);
        }
    }
}
