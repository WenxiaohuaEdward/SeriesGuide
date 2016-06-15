package wenxiaohua.seriesguide.view.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.model.impl.IVideoTypeModel;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.presenter.VideoTypePresenter;
import wenxiaohua.seriesguide.view.adapter.VideoTypeAdapter;
import wenxiaohua.seriesguide.view.views.XListView;

/**
 * Created by wenxiaohua on 2016/6/15.
 * 视频分类
 */
public class VideoTypeActivity extends BaseActivity implements IVideoTypeModel {
    @Bind(R.id.video_type_toolbar)
    Toolbar video_type_toolbar;
    @Bind(R.id.video_type_xlv)
    XListView video_type_xlv;


    @Override
    protected void initView() {
        VideoTypeAdapter mVideoTypeAdapter = new VideoTypeAdapter(this);
        video_type_xlv.setAdapter(mVideoTypeAdapter);
        video_type_toolbar.setTitle(getIntent().getStringExtra("videoTypeTitle"));
    }

    @Override
    protected void initData() {

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
