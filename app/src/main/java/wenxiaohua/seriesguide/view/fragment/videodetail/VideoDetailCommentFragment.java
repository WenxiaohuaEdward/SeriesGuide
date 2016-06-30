package wenxiaohua.seriesguide.view.fragment.videodetail;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.VideoDetailCommentInfo;
import wenxiaohua.seriesguide.impl.IVideoDetailCommentView;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.presenter.VideoDetailCommentPresenter;
import wenxiaohua.seriesguide.view.adapter.VideoDetailCommentFragmentAdapter;
import wenxiaohua.seriesguide.view.fragment.BaseFragment;
import wenxiaohua.seriesguide.view.views.XListView;

/**
 * Created by hexun on 2016/6/15.
 */
public class VideoDetailCommentFragment extends BaseFragment implements IVideoDetailCommentView, XListView.IXListViewListener {
    @Bind(R.id.fragment_video_detail_comment_xlv)
    XListView fragment_video_detail_comment_xlv;
    private int page =1;
    private String rows = "20";
    private String seasonId;
    VideoDetailCommentFragmentAdapter mVideoDetailCommentFragmentAdapter;
    private VideoDetailCommentInfo.DataBean dataBean;
    private List<VideoDetailCommentInfo.DataBean.ResultsBean> mVideoDetailCommentInfoList =new ArrayList<>();


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mVideoDetailCommentFragmentAdapter = new VideoDetailCommentFragmentAdapter(getActivity());
        fragment_video_detail_comment_xlv.setAdapter(mVideoDetailCommentFragmentAdapter);
        fragment_video_detail_comment_xlv.setDivider(null);
        fragment_video_detail_comment_xlv.setXListViewListener(this);
        fragment_video_detail_comment_xlv.setPullLoadEnable(true);
        fragment_video_detail_comment_xlv.setPullRefreshEnable(true);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        seasonId = getArguments().getString("seasonId");
        VideoDetailCommentPresenter videoDetailCommentPresenter = (VideoDetailCommentPresenter)mPresenter;
        videoDetailCommentPresenter.getVideoDetailComment(0+"",rows,seasonId);
    }

    @Override
    public BasePresenter getPresenter() {
        return new VideoDetailCommentPresenter();
    }

    @Override
    public void bindView(Bundle savedInstanceState) {

    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_video_detail_comment;
    }

    @Override
    public void getVideoDetailCommentWithView(VideoDetailCommentInfo.DataBean dataBean) {
        this.dataBean = dataBean;
        mVideoDetailCommentInfoList .addAll(dataBean.getResults());
        mVideoDetailCommentFragmentAdapter.setmVideoDetailCommentInfoList(mVideoDetailCommentInfoList);
        mVideoDetailCommentFragmentAdapter.notifyDataSetChanged();
        fragment_video_detail_comment_xlv.stopRefresh();
        fragment_video_detail_comment_xlv.stopLoadMore();
    }

    @Override
    public void onRefresh() {
        page = 1;
        mVideoDetailCommentFragmentAdapter.getmVideoDetailCommentInfoList().clear();
        VideoDetailCommentPresenter videoDetailCommentPresenter = (VideoDetailCommentPresenter)mPresenter;
        videoDetailCommentPresenter.getVideoDetailComment(page+"",rows,seasonId);
    }

    @Override
    public void onLoadMore() {
        page ++;
        VideoDetailCommentPresenter videoDetailCommentPresenter = (VideoDetailCommentPresenter)mPresenter;
        videoDetailCommentPresenter.getVideoDetailComment(page+"",rows,seasonId);
    }
}
