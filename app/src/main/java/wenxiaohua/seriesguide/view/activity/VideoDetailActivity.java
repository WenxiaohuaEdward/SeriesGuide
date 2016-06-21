package wenxiaohua.seriesguide.view.activity;

import android.os.*;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.baidu.cyberplayer.core.BVideoView;

import java.util.ArrayList;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.VideoDetailInfo;
import wenxiaohua.seriesguide.impl.IVideoDetailView;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.presenter.VideoDetailPresenter;
import wenxiaohua.seriesguide.view.adapter.FragmentAdapter;
import wenxiaohua.seriesguide.view.fragment.videodetail.VideoDetailCommentFragment;
import wenxiaohua.seriesguide.view.fragment.videodetail.VideoDetailReviewFragment;

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
    @Bind(R.id.video_view)
    BVideoView video_view;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private ArrayList<String> titleList =new ArrayList<String>();
    private String seasonId;
    private VideoDetailInfo.DataBean data;
    VideoDetailReviewFragment videoDetailReviewFragment;
    /**
     * 播放状态
     */
    private enum PLAYER_STATUS {
        PLAYER_IDLE, PLAYER_PREPARING, PLAYER_PREPARED,
    }
    private PLAYER_STATUS mPlayerStatus = PLAYER_STATUS.PLAYER_IDLE;
    private String mVideoSource; //播放url
    private final int EVENT_PLAY = 0;
    private final int UI_EVENT_UPDATE_CURRPOSITION = 1;
    private final Object SYNC_Playing = new Object();
    /**
     * 记录播放位置
     */
    private int mLastPos = 0;
    private String TAG = "VideoDetailActivity";
    private HandlerThread mHandlerThread;
    private EventHandler mEventHandler;

    @Override
    protected void initView() {
        video_detail_toolbar.setTitle(getIntent().getStringExtra("seasonTitle"));
        seasonId = getIntent().getStringExtra("seasonId");
        /**
         * 开启后台事件处理线程
         */
        mHandlerThread = new HandlerThread("event handler thread",
                android.os.Process.THREAD_PRIORITY_BACKGROUND);
        mHandlerThread.start();
        mEventHandler = new EventHandler(mHandlerThread.getLooper());

    }

    @Override
    protected void initData() {

        videoDetailReviewFragment= new VideoDetailReviewFragment();
        Bundle bundleReview =  new Bundle();
        bundleReview.putString("seasonId", seasonId);
        videoDetailReviewFragment.setArguments(bundleReview);
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
        VideoDetailPresenter videoDetailPresenter = (VideoDetailPresenter)mPresenter;
        videoDetailPresenter.getVideoDetail(seasonId);
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
        videoDetailReviewFragment.setReviewData(data.getSeasonDetail().getBrief(),data.getSeasonDetail().getTitle());
        video_view.setVideoPath(data.getSeasonDetail().getPlayUrlList().get(0).getPlayLink());
    }
    class EventHandler extends Handler {
        public EventHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case EVENT_PLAY:
                    /**
                     * 如果已经播放了，等待上一次播放结束
                     */
                    if (mPlayerStatus != PLAYER_STATUS.PLAYER_IDLE) {
                        synchronized (SYNC_Playing) {
                            try {
                                SYNC_Playing.wait();
                                Log.v(TAG, "wait player status to idle");
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }

                    /**
                     * 设置播放url
                     */
                    mVideoSource = (String) msg.obj ;
                    video_view.setVideoPath(mVideoSource);

                    /**
                     * 续播，如果需要如此
                     */
                    if (mLastPos > 0) {

                        video_view.seekTo(mLastPos);
                        mLastPos = 0;
                    }

                    /**
                     * 显示或者隐藏缓冲提示
                     */
                    video_view.showCacheInfo(true);

                    /**
                     * 开始播放
                     */
                    video_view.start();
                    mPlayerStatus = PLAYER_STATUS.PLAYER_PREPARING;
                    break;
                default:
                    break;
            }
        }
    }


}
