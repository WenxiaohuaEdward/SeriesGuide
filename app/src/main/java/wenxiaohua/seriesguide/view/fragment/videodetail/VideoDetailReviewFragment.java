package wenxiaohua.seriesguide.view.fragment.videodetail;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.presenter.VideoDetailReviewPresenter;
import wenxiaohua.seriesguide.view.adapter.VideoDetailReviewNumAdapter;
import wenxiaohua.seriesguide.view.fragment.BaseFragment;
import wenxiaohua.seriesguide.view.listener.RecyclerViewItemClickListener;
import wenxiaohua.seriesguide.view.views.NestRecyclerViewLayoutManager;

/**
 * Created by hexun on 2016/6/15.
 */
public class VideoDetailReviewFragment extends BaseFragment {
    private  String seasonId ="";
    @Bind(R.id.fragment_video_detail_review_title)
    TextView fragment_video_detail_review_title;
    @Bind(R.id.fragment_video_detail_review_content)
    TextView fragment_video_detail_review_content;
    @Bind(R.id.fragment_video_detail_listnum_rv)
    RecyclerView fragment_video_detail_listnum_rv;
    private int updateInfo;
    VideoDetailReviewNumAdapter  mVideoDetailReviewNumAdapter;
    public VideoDetailReviewFragment(){
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        mVideoDetailReviewNumAdapter =  new VideoDetailReviewNumAdapter(getActivity());
        fragment_video_detail_listnum_rv.setAdapter(mVideoDetailReviewNumAdapter);
        mVideoDetailReviewNumAdapter.setOnItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {

            }
        });

    }
    public void setReviewData(String brief, String title,int updateInfo){
        if(brief!=null){
            fragment_video_detail_review_content.setText(brief);
            }
        if (title!=null){
            fragment_video_detail_review_title.setText(title);
        }
        this.updateInfo = updateInfo;
        if (updateInfo!=0) {
            int spanCount = 1;
            NestRecyclerViewLayoutManager mStaggeredGridLayoutManager = new NestRecyclerViewLayoutManager(spanCount, StaggeredGridLayoutManager.HORIZONTAL);
            fragment_video_detail_listnum_rv.setLayoutManager(mStaggeredGridLayoutManager);
            fragment_video_detail_listnum_rv.setVisibility(View.VISIBLE);
        }else{
            fragment_video_detail_listnum_rv.setVisibility(View.GONE);
        }
    }
    @Override
    protected void initData(Bundle savedInstanceState) {
        seasonId = getArguments().getString("seasonId");
        List<String> numList = new ArrayList<>();
        for (int i= 0;i<updateInfo;i++){
            numList.add(i+"");
        }
        mVideoDetailReviewNumAdapter.setNumList(numList);
        mVideoDetailReviewNumAdapter.notifyDataSetChanged();
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
}
