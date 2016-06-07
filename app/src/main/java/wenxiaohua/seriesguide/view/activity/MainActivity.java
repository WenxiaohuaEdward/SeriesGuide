package wenxiaohua.seriesguide.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.RadioGroup;

import java.util.ArrayList;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.impl.IMainView;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.presenter.MainPresenter;
import wenxiaohua.seriesguide.view.adapter.FragmentAdapter;
import wenxiaohua.seriesguide.view.fragment.main.DiscoverFragment;
import wenxiaohua.seriesguide.view.fragment.main.LikeFragment;
import wenxiaohua.seriesguide.view.fragment.main.SearchFragment;

public class MainActivity extends BaseActivity implements IMainView {

    @Bind(R.id.main_toolbar)
    Toolbar main_toolbar;
    @Bind(R.id.main_viewpager)
    ViewPager main_viewpager;
    @Bind(R.id.main_radiogroup)
    RadioGroup main_radiogroup;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();

    @Override
    public int getToolBarId() {
        return R.id.main_toolbar;
    }

    @Override
    protected void initView() {
        fragmentList.add(new LikeFragment());
        fragmentList.add(new DiscoverFragment());
        fragmentList.add(new SearchFragment());
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),fragmentList,new ArrayList<String>());
        main_viewpager.setAdapter(fragmentAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    public BasePresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    public void bindView(Bundle savedInstanceState) {
        Log.v("bindView", "bindView");
    }


    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }
}
