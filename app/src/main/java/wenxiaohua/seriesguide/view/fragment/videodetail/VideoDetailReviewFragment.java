package wenxiaohua.seriesguide.view.fragment.videodetail;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import wenxiaohua.seriesguide.view.views.layoutmanager.NestGridLayoutManager;

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
    RecyclerView fragment_video_detail_listNum_rv;
    private VideoDetailReviewNumAdapter mVideoDetailReviewNumAdapter;
    private int updateinfo;

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

    }
    public void setReviewData(String brief, String title,int updateinfo){
        if(brief!=null){
            fragment_video_detail_review_content.setText(brief);
            }
        if (title!=null){
            fragment_video_detail_review_title.setText(title);
        }
        this.updateinfo =updateinfo;
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
