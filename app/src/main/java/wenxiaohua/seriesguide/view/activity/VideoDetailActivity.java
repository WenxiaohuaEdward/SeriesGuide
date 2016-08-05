package wenxiaohua.seriesguide.view.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.VideoDetailInfo;
import wenxiaohua.seriesguide.bean.VideoM3U8PathBean;
import wenxiaohua.seriesguide.event.Event;
import wenxiaohua.seriesguide.impl.IVideoDetailView;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.presenter.VideoDetailPresenter;
import wenxiaohua.seriesguide.utils.PicassoUtils;
import wenxiaohua.seriesguide.view.adapter.FragmentAdapter;
import wenxiaohua.seriesguide.view.fragment.videodetail.VideoDetailCommentFragment;
import wenxiaohua.seriesguide.view.fragment.videodetail.VideoDetailReviewFragment;
import wenxiaohua.seriesguide.view.listener.RecyclerViewItemClickListener;

/**
 * Created by hexun on 2016/6/15.
 */
public class VideoDetailActivity extends BaseActivity implements IVideoDetailView {

    @Bind(R.id.video_detail_toolbar)
    Toolbar video_detail_toolbar;
    @Bind(R.id.video_detail_vp)
    ViewPager video_detail_vp;
    @Bind(R.id.video_detail_tabs)
    TabLayout video_detail_tabs;

    @Bind(R.id.video_detail_play_bt)
    Button video_detail_play_bt;
    @Bind(R.id.video_detail_cover)
    ImageView video_detail_cover;

    @Bind(R.id.video_detail_vv)
    VideoView mvdView;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private ArrayList<String> titleList =new ArrayList<String>();
    private String seasonId;
    private VideoDetailInfo.DataBean data;
    VideoDetailReviewFragment videoDetailReviewFragment;
    String strPath = "";

    VideoDetailPresenter videoDetailPresenter;
    private String TAG = "VideoDetailActivity";


    @Override
    protected void initView() {
        video_detail_toolbar.setTitle(getIntent().getStringExtra("seasonTitle"));
        seasonId = getIntent().getStringExtra("seasonId");
        video_detail_play_bt.requestFocus();
        video_detail_play_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(videoDetailPresenter!=null){
                    if( data.getSeasonDetail()!=null) {
                        videoDetailPresenter.getVideo(VideoDetailActivity.this, seasonId, data.getSeasonDetail().getPlayUrlList().get( data.getSeasonDetail().getPlayUrlList().size()-1).getEpisodeSid());
                    }
                }

            }
        });
        EventBus.getDefault().register(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private  void  playVideo(String strPath) {
        mvdView.setVisibility(View.VISIBLE);
        video_detail_cover.setVisibility(View.GONE);
        video_detail_play_bt.setVisibility(View.GONE);
        Uri uri = Uri.parse(strPath);
        mvdView.setVideoURI(uri);   // mvdView是一个videoView控件
        mvdView.setMediaController(new MediaController(this));
//        mvdView.requestFocus();
        mvdView.start();
    }

    private void stopPlay() {
        mvdView.stopPlayback();
    }

    @Override
    protected void initData() {
        mvdView.setVisibility(View.GONE);
        video_detail_cover.setVisibility(View.VISIBLE);
        video_detail_play_bt.setVisibility(View.VISIBLE);
        videoDetailReviewFragment= new VideoDetailReviewFragment();
        Bundle bundleReview =  new Bundle();
        bundleReview.putString("seasonId", seasonId);
        videoDetailReviewFragment.setArguments(bundleReview);
        videoDetailReviewFragment.setReviewNumOnItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                videoDetailPresenter.getVideo(VideoDetailActivity.this, seasonId, data.getSeasonDetail().getPlayUrlList().get(postion ).getEpisodeSid());

            }
        });
        fragmentList.add(videoDetailReviewFragment);
        VideoDetailCommentFragment videoDetailCommentFragment = new VideoDetailCommentFragment();
        Bundle bundleComment =  new Bundle();
        bundleComment.putString("seasonId", seasonId);
        videoDetailCommentFragment.setArguments(bundleComment);
        fragmentList.add(videoDetailCommentFragment);
        titleList.add("简介");
        titleList.add("评论");
        //为TabLayout添加tab名称
        video_detail_tabs.addTab(video_detail_tabs.newTab().setText(titleList.get(0)));
        video_detail_tabs.addTab(video_detail_tabs.newTab().setText(titleList.get(1)));

        final FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),fragmentList,titleList);

        video_detail_vp.setAdapter(fragmentAdapter);
        video_detail_vp.setCurrentItem(0, true);
        video_detail_vp.setOffscreenPageLimit(2);
        video_detail_tabs.setupWithViewPager(video_detail_vp);//将TabLayout和ViewPager关联起来

        videoDetailPresenter = (VideoDetailPresenter)mPresenter;
        videoDetailPresenter.getVideoDetail(getApplicationContext(),seasonId);
    }



    @Override
    public BasePresenter getPresenter() {
        return new VideoDetailPresenter();
    }

    @Override
    public void bindView(Bundle savedInstanceState) {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_video_detail;
    }

    @Override
    public void getVideoDetailWithView(VideoDetailInfo.DataBean data) {
        this.data = data;
        PicassoUtils.getPicassoInstance(VideoDetailActivity.this, data.getSeasonDetail().getCover(), video_detail_cover);

        videoDetailReviewFragment.setReviewData(data.getSeasonDetail().getBrief(), data.getSeasonDetail().getCover(), data.getSeasonDetail().getTitle(), data.getSeasonDetail().getScore() + "", data.getSeasonDetail().getUpdateinfo(), data);

    }

    @Override
    public void getVideoPathWithView(List<VideoDetailInfo.DataBean.SeasonDetailBean.PlayUrlListBean> playUrlList) {

    }

    @Override
    public void getVideoWithView(VideoM3U8PathBean.DataBean data) {
        if (data.getM3u8()!=null) {
            strPath = data.getM3u8().getUrl();
            playVideo(strPath);
            videoDetailReviewFragment.setVideoUrl(strPath);
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showHistory(Event.SeriesGuideSeasonEvent seasonEvent){

    }
}