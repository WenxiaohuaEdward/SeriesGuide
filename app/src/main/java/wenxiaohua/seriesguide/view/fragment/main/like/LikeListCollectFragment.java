package wenxiaohua.seriesguide.view.fragment.main.like;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.view.adapter.LikeFragmentCacheListAdapter;
import wenxiaohua.seriesguide.view.fragment.BaseFragment;

/**
 * Created by hexun on 2016/6/12.
 */
public class LikeListCollectFragment extends BaseFragment{
    @Bind(R.id.fragment_like_collect_gv)
    GridView fragment_like_collect_gv;
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        LikeFragmentCacheListAdapter likeFragmentCacheListAdapter = new LikeFragmentCacheListAdapter(getActivity());
        fragment_like_collect_gv.setAdapter(likeFragmentCacheListAdapter);
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
        return R.layout.fragment_like_collect_list;
    }
}
