package wenxiaohua.seriesguide.view.fragment.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.DiscoverFragmentInfo;
import wenxiaohua.seriesguide.impl.IDiscoverFragmentView;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.presenter.DiscoverFragmentPresenter;
import wenxiaohua.seriesguide.view.adapter.DiscoverFragmentElvAdapter;
import wenxiaohua.seriesguide.view.fragment.BaseFragment;

/**
 * Created by hexun on 2016/6/7.
 * 发现
 */
public class DiscoverFragment extends BaseFragment implements IDiscoverFragmentView{
    @Bind(R.id.fragment_discover_elv)
    ExpandableListView fragment_discover_elv;
    private DiscoverFragmentInfo.DataBean discoverData;
    DiscoverFragmentElvAdapter discoverFragmentElvAdapter;


    @Override
    protected void initView(View view, Bundle savedInstanceState) {

         discoverFragmentElvAdapter = new DiscoverFragmentElvAdapter(getActivity());
        fragment_discover_elv.setAdapter(discoverFragmentElvAdapter);
        fragment_discover_elv.setGroupIndicator(null);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        DiscoverFragmentPresenter discoverFragmentPresenter = (DiscoverFragmentPresenter)mPresenter;
        discoverFragmentPresenter.getDiscoverData();
    }

    @Override
    public BasePresenter getPresenter() {

        return new DiscoverFragmentPresenter();
    }

    @Override
    public void bindView(Bundle savedInstanceState) {

    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_discover;
    }

    @Override
    public void getDiscoverDataWithView(DiscoverFragmentInfo.DataBean discoverData) {
        this.discoverData =discoverData;
        discoverFragmentElvAdapter.setResultList(discoverData.getIndex());
        discoverFragmentElvAdapter.notifyDataSetChanged();
        //设置全部展开
        for(int i = 0; i < discoverFragmentElvAdapter.getGroupCount(); i++){
            fragment_discover_elv.expandGroup(i);
        }
    }
}
