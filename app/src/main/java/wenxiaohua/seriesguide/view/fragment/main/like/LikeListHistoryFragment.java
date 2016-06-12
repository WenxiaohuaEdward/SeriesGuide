package wenxiaohua.seriesguide.view.fragment.main.like;

import android.os.Bundle;
import android.view.View;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.view.adapter.LikeFragmentHistoryListAdapter;
import wenxiaohua.seriesguide.view.fragment.BaseFragment;
import wenxiaohua.seriesguide.view.views.XListView;

/**
 * Created by hexun on 2016/6/12.
 */
public class LikeListHistoryFragment extends BaseFragment{
    @Bind(R.id.fragment_like_history_listview)
    XListView fragment_like_history_listview;
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        LikeFragmentHistoryListAdapter likeFragmentHistoryListAdapter = new LikeFragmentHistoryListAdapter(getActivity());
        fragment_like_history_listview.setAdapter(likeFragmentHistoryListAdapter);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

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
        return R.layout.fragment_like_history_list;
    }
}
