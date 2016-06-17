package wenxiaohua.seriesguide.view.fragment.videodetail;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.presenter.VideoDetailReviewPresenter;
import wenxiaohua.seriesguide.view.fragment.BaseFragment;

/**
 * Created by hexun on 2016/6/15.
 */
public class VideoDetailReviewFragment extends BaseFragment {
    private  String seasonId ="";
    @Bind(R.id.fragment_video_detail_review_title)
    TextView fragment_video_detail_review_title;
    @Bind(R.id.fragment_video_detail_review_content)
    TextView fragment_video_detail_review_content;

    public VideoDetailReviewFragment(){
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
    public void setReviewData(String brief, String title){
        fragment_video_detail_review_title.setText(title);
        fragment_video_detail_review_content.setText(brief);
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
