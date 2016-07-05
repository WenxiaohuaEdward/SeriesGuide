package wenxiaohua.seriesguide.view.fragment.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.view.adapter.FragmentAdapter;
import wenxiaohua.seriesguide.view.fragment.BaseFragment;
import wenxiaohua.seriesguide.view.fragment.main.like.LikeListCacheFragment;
import wenxiaohua.seriesguide.view.fragment.main.like.LikeListCollectFragment;
import wenxiaohua.seriesguide.view.fragment.main.like.LikeListHistoryFragment;

/**
 * Created by hexun on 2016/6/7.
 * 喜欢
 */
public class LikeFragment extends BaseFragment {
    @Bind(R.id.fragment_like_viewpager)
    ViewPager fragment_like_viewpager;
    @Bind(R.id.tab_likeFragment_title)
    TabLayout tab_likeFragment_title;

    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private ArrayList<String> titleList = new ArrayList<>();

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        titleList.add("历史");
        titleList.add("收藏");
        titleList.add("缓存");
        fragmentList.add(new LikeListHistoryFragment());
        fragmentList.add(new LikeListCollectFragment());
        fragmentList.add(new LikeListCacheFragment());
        //设置TabLayout的模式
        tab_likeFragment_title.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tab_likeFragment_title.addTab(tab_likeFragment_title.newTab().setText(titleList.get(0)));
        tab_likeFragment_title.addTab(tab_likeFragment_title.newTab().setText(titleList.get(1)));
        tab_likeFragment_title.addTab(tab_likeFragment_title.newTab().setText(titleList.get(2)));
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager(),fragmentList,titleList);
        fragment_like_viewpager.setAdapter(fragmentAdapter);
        tab_likeFragment_title.setupWithViewPager(fragment_like_viewpager);//将TabLayout和ViewPager关联起来
        fragment_like_viewpager.setOffscreenPageLimit(3);
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
        return R.layout.fragment_like;
    }
}
