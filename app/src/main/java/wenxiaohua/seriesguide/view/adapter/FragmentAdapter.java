package wenxiaohua.seriesguide.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by hexun on 2016/6/7.
 */
public class FragmentAdapter extends FragmentPagerAdapter{
    /**
     * The m fragment list.
     */
    private ArrayList<Fragment> mFragmentList = null;
    private ArrayList<String> mTitleList = new ArrayList<>();

    /**
     * Instantiates a new ab fragment pager adapter.
     *  @param mFragmentManager the m fragment manager
     * @param fragmentList     the fragment list
     * @param list_title
     */
    public FragmentAdapter(FragmentManager mFragmentManager, ArrayList<Fragment> fragmentList, ArrayList<String> list_title) {
        super(mFragmentManager);
        mFragmentList = fragmentList;
        mTitleList = list_title;
    }

    /**
     * 描述：获取数量.
     *
     * @return the count
     * @see android.support.v4.view.PagerAdapter#getCount()
     */
    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    /**
     * 描述：获取索引位置的Fragment.
     *
     * @param position the position
     * @return the item
     * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
     */
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        if (position < mFragmentList.size()) {
            fragment = mFragmentList.get(position);
        } else {
            fragment = mFragmentList.get(0);
        }
        return fragment;

    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);//页卡标题
    }

}
