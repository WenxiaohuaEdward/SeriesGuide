package wenxiaohua.seriesguide.view.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.SeasonInfo;
import wenxiaohua.seriesguide.model.impl.IVideoTypeModel;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.presenter.VideoTypePresenter;
import wenxiaohua.seriesguide.view.adapter.VideoListAdapter;
import wenxiaohua.seriesguide.view.views.XListView;

/**
 * Created by wenxiaohua on 2016/6/15.
 * 视频列表
 */
public class VideoListActivity extends BaseActivity implements IVideoTypeModel {
    @Bind(R.id.video_type_toolbar)
    Toolbar video_type_toolbar;
    @Bind(R.id.video_type_xlv)
    XListView video_type_xlv;
    VideoListAdapter mVideoListAdapter ;

    @Override
    protected void initView() {
        mVideoListAdapter = new VideoListAdapter(this);
        video_type_xlv.setAdapter(mVideoListAdapter);
        video_type_toolbar.setTitle(getIntent().getStringExtra("videoTypeTitle"));
    }

    @Override
    protected void initData() {
        ArrayList<SeasonInfo> seasonInfoList = (ArrayList<SeasonInfo>) getIntent().getSerializableExtra("seasonListData");
        mVideoListAdapter.setmSeasonInfoList(seasonInfoList);
        mVideoListAdapter.notifyDataSetChanged();
    }

    @Override
    public BasePresenter getPresenter() {
        return new VideoTypePresenter();
    }

    @Override
    public void bindView(Bundle savedInstanceState) {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_video_type;
    }
}
