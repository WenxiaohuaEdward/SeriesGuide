package wenxiaohua.seriesguide.view.fragment.videodetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.media.UMImage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import greendao.SeriesGuideSeason;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.VideoDetailInfo;
import wenxiaohua.seriesguide.event.Event;
import wenxiaohua.seriesguide.impl.IVideoDetailReviewView;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.presenter.VideoDetailReviewPresenter;
import wenxiaohua.seriesguide.utils.SeasonDBUtils;
import wenxiaohua.seriesguide.view.adapter.VideoDetailReviewNumAdapter;
import wenxiaohua.seriesguide.view.fragment.BaseFragment;
import wenxiaohua.seriesguide.view.listener.RecyclerViewItemClickListener;
import wenxiaohua.seriesguide.view.views.layoutmanager.NestGridLayoutManager;

/**
 * Created by hexun on 2016/6/15.
 */
public class VideoDetailReviewFragment extends BaseFragment implements View.OnClickListener,IVideoDetailReviewView{
    private  String seasonId ="";
    @Bind(R.id.fragment_video_detail_review_title)
    TextView fragment_video_detail_review_title;
    @Bind(R.id.fragment_video_detail_review_content)
    TextView fragment_video_detail_review_content;
    @Bind(R.id.fragment_video_detail_review_grade)
    TextView fragment_video_detail_review_grade;
    @Bind(R.id.fragment_video_detail_review_collect)
    TextView fragment_video_detail_review_collect;
    @Bind(R.id.fragment_video_detail_review_cache)
    TextView fragment_video_detail_review_cache;
    @Bind(R.id.fragment_video_detail_listnum_rv)
    RecyclerView fragment_video_detail_listNum_rv;
    private VideoDetailReviewNumAdapter mVideoDetailReviewNumAdapter;
    private int updateinfo;

    private String cover;
    UMImage image;
    private SeasonDBUtils mSeasonDBUtils;
    private VideoDetailInfo.DataBean videoDetailInfo;
    VideoDetailReviewPresenter videoDetailReviewPresenter;
    private boolean isCollectExist = false; //判断是否收藏
    private boolean isCacheExist = false; //判断是否缓存

    public VideoDetailReviewFragment(){
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        /**
         * 选集、
         */

        fragment_video_detail_listNum_rv. setNestedScrollingEnabled(false);
        mVideoDetailReviewNumAdapter =  new VideoDetailReviewNumAdapter(getActivity());
        fragment_video_detail_listNum_rv.setAdapter(mVideoDetailReviewNumAdapter);
        mVideoDetailReviewNumAdapter.setOnItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {

            }
        });
        fragment_video_detail_review_collect.setOnClickListener(this);
        fragment_video_detail_review_cache.setOnClickListener(this);
        EventBus.getDefault().register(this);

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void setReviewData(String brief, String cover, String title, String score,int updateinfo,VideoDetailInfo.DataBean videoDetailInfo){
        if(brief!=null){
            fragment_video_detail_review_content.setText(brief);
            }
        if (title!=null){
            fragment_video_detail_review_title.setText(title);
        }
        if(score!=null){
            fragment_video_detail_review_grade.setText("评分："+score);
        }
        this.videoDetailInfo =videoDetailInfo;
        this.updateinfo =updateinfo;
        this.cover =cover;
        image = new UMImage(getActivity(), cover);
        List<String> numList = new ArrayList<>();
        for (int i= 1;i<=updateinfo;i++){
            numList.add(i+"");
        }
        mVideoDetailReviewNumAdapter.setNumList(numList);
        mVideoDetailReviewNumAdapter.notifyDataSetChanged();
        int spanCount = 4;
        NestGridLayoutManager mNestGridLayoutManager = new NestGridLayoutManager(getActivity(),spanCount, GridLayoutManager.VERTICAL,false);
        fragment_video_detail_listNum_rv.setLayoutManager(mNestGridLayoutManager);
    }
    @Override
    protected void initData(Bundle savedInstanceState) {
        seasonId = getArguments().getString("seasonId");
        videoDetailReviewPresenter = (VideoDetailReviewPresenter)mPresenter;
        videoDetailReviewPresenter.getSeasonWithId(getActivity(),seasonId);

    }

    @Override
    public BasePresenter getPresenter() {
        return new VideoDetailReviewPresenter();
    }

    @Override
    public void bindView(Bundle savedInstanceState) {

    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_video_detail_review;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== fragment_video_detail_review_collect.getId()){
            if(isCollectExist){
                videoDetailReviewPresenter.deleteSeason(getActivity(),seasonId);
                fragment_video_detail_review_collect.setText("收藏");
                isCollectExist = false;
            }else{
                videoDetailReviewPresenter.addSeason(getActivity(),"collect",videoDetailInfo);
                fragment_video_detail_review_collect.setText("已收藏");
                isCollectExist = true;
            }

        }else if(v.getId()== fragment_video_detail_review_cache.getId()){
            if(isCacheExist) {
                videoDetailReviewPresenter.deleteSeason(getActivity(),seasonId);
                fragment_video_detail_review_cache.setText("缓存");
                isCacheExist = false;
            }else{
                videoDetailReviewPresenter.addSeason(getActivity(), "cache", videoDetailInfo);
                fragment_video_detail_review_cache.setText("已缓存");
                isCacheExist = true;
            }

        }

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(getActivity()).onActivityResult( requestCode, resultCode, data);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showHistory(Event.SeriesGuideSeasonEvent seasonEvent){

    }

    @Override
    public void getSeasonWithId(List<SeriesGuideSeason> seriesGuideSeasons) {
        if(seriesGuideSeasons!=null&&!seriesGuideSeasons.isEmpty()){
            if ("collect".equals(seriesGuideSeasons.get(0).getType())){
                fragment_video_detail_review_collect.setText("已收藏");
                isCollectExist = true;
            }else  if ("collect".equals(seriesGuideSeasons.get(0).getType())) {
                fragment_video_detail_review_cache.setText("已缓存");
                isCacheExist = true;

            }
        }
    }
}
