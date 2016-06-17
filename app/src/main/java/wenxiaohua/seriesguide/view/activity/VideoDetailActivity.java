package wenxiaohua.seriesguide.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.view.adapter.FragmentAdapter;
import wenxiaohua.seriesguide.view.fragment.videodetail.VideoDetailCommentFragment;
import wenxiaohua.seriesguide.view.fragment.videodetail.VideoDetailReviewFragment;

/**
 * Created by hexun on 2016/6/15.
 */
public class VideoDetailActivity extends BaseActivity{

    @Bind(R.id.video_detail_toolbar)
    Toolbar video_detail_toolbar;
    @Bind(R.id.video_detail_vp)
    ViewPager video_detail_vp;
    @Bind(R.id.video_detail_tabs)
    TabLayout video_detail_tabs;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private ArrayList<String> titleList =new ArrayList<String>();
    private String seasonId;

    @Override
    protected void initView() {
        video_detail_toolbar.setTitle(getIntent().getStringExtra("seasonTitle"));
        seasonId = getIntent().getStringExtra("seasonId");
    }

    @Override
    protected void initData() {
        fragmentList.add(new VideoDetailReviewFragment(seasonId));
        VideoDetailCommentFragment videoDetailCommentFragment = new VideoDetailCommentFragment();
        Bundle bundle =  new Bundle();
         bundle.putString("seasonId", seasonId);
        videoDetailCommentFragment.setArguments(bundle);
        fragmentList.add(videoDetailCommentFragment);
        titleList.add("简介");
        titleList.add("评论");
        //设置TabLayout的模式
        video_detail_tabs.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        video_detail_tabs.addTab(video_detail_tabs.newTab().setText(titleList.get(0)));
        video_detail_tabs.addTab(video_detail_tabs.newTab().setText(titleList.get(1)));

        final FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),fragmentList,titleList);

        video_detail_vp.setAdapter(fragmentAdapter);
        video_detail_vp.setCurrentItem(0, true);
        video_detail_vp.setOffscreenPageLimit(2);
        video_detail_tabs.setupWithViewPager(video_detail_vp);//将TabLayout和ViewPager关联起来

    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void bindView(Bundle savedInstanceState) {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_video_detail;
    }
}
