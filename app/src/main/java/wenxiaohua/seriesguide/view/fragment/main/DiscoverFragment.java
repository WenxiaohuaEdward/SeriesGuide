package wenxiaohua.seriesguide.view.fragment.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.DiscoverFragmentInfo;
import wenxiaohua.seriesguide.impl.IDiscoverFragmentView;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.presenter.DiscoverFragmentPresenter;
import wenxiaohua.seriesguide.utils.ContextUtils;
import wenxiaohua.seriesguide.utils.PicassoUtils;
import wenxiaohua.seriesguide.view.activity.VideoListActivity;
import wenxiaohua.seriesguide.view.adapter.BannerAdapter;
import wenxiaohua.seriesguide.view.adapter.DiscoverFragmentElvAdapter;
import wenxiaohua.seriesguide.view.fragment.BaseFragment;

/**
 * Created by hexun on 2016/6/7.
 * 发现
 */
public class DiscoverFragment extends BaseFragment implements IDiscoverFragmentView{
    @Bind(R.id.fragment_discover_elv)
    ExpandableListView fragment_discover_elv;
//    @Bind(R.id.fragment_discover_banner_vp)
    ViewPager fragment_discover_banner_vp;

    /** Banner滚动线程是否销毁的标志，默认不销毁 */
    private boolean isStop = false;
    /** Banner的切换下一个page的间隔时间 */
    private long scrollTimeOffset = 4000;
    private DiscoverFragmentInfo.DataBean discoverData;
    DiscoverFragmentElvAdapter discoverFragmentElvAdapter;
    private List<ImageView> imageViewContainer = new ArrayList<>();
    BannerAdapter bannerAdapter;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        fragment_discover_banner_vp = new ViewPager(getActivity());
        fragment_discover_banner_vp.setLayoutParams(new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT, ContextUtils.dip2px(getActivity(),180)));
        bannerAdapter =  new BannerAdapter(getActivity(),imageViewContainer);
        fragment_discover_banner_vp.setAdapter(bannerAdapter);
        fragment_discover_banner_vp.setCurrentItem(0, true);
        fragment_discover_banner_vp.setOffscreenPageLimit(2);
        fragment_discover_elv.addHeaderView(fragment_discover_banner_vp, null, true);
         discoverFragmentElvAdapter = new DiscoverFragmentElvAdapter(getActivity());
        fragment_discover_elv.setAdapter(discoverFragmentElvAdapter);
        fragment_discover_elv.setGroupIndicator(null);
        //设置不折叠。
        fragment_discover_elv
                .setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent,
                                                View v, int groupPosition, long childPosition) {

                        Intent videoTypeIntent = new Intent(getActivity(), VideoListActivity.class);
                        videoTypeIntent.putExtra("videoTypeTitle",discoverData.getIndex().get(groupPosition).getTitle());
                        videoTypeIntent.putExtra("videoTypeId",discoverData.getIndex().get(groupPosition).getId());

                        getActivity().startActivity(videoTypeIntent);
                        return true;
                    }
                });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        DiscoverFragmentPresenter discoverFragmentPresenter = (DiscoverFragmentPresenter)mPresenter;
        discoverFragmentPresenter.getDiscoverData();
        startBannerScrollThread();
    }

    @Override
    public BasePresenter getPresenter() {

        return new DiscoverFragmentPresenter();
    }

    @Override
    public void bindView(Bundle savedInstanceState) {

    }

    @Override
    public void onPause() {
        super.onPause();
        isStop = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        isStop = false;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_discover;
    }

    @Override
    public void getDiscoverDataWithView(DiscoverFragmentInfo.DataBean discoverData) {
        this.discoverData = discoverData;
        discoverFragmentElvAdapter.setResultList(discoverData.getIndex());
        discoverFragmentElvAdapter.notifyDataSetChanged();
        for (DiscoverFragmentInfo.DataBean.AlbumBean albumbean:discoverData.getAlbum()) {

            ImageView imageView = new ImageView(getActivity());
            PicassoUtils.getPicassoInstance(getActivity(),albumbean.getCoverUrl(),imageView);
            imageViewContainer.add(imageView);
        }
        bannerAdapter.notifyDataSetChanged();
        //设置全部展开
        for(int i = 0; i < discoverFragmentElvAdapter.getGroupCount(); i++){
            fragment_discover_elv.expandGroup(i);
        }
    }
    /**
     * 开启Banner滚动线程
     */
    private void startBannerScrollThread() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (!isStop) {
                    //每个两秒钟发一条消息到主线程，更新viewpager界面
                    SystemClock.sleep(scrollTimeOffset);
                    if ( getActivity()==null){
                        return;
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            int newindex = fragment_discover_banner_vp.getCurrentItem() + 1;
                            fragment_discover_banner_vp.setCurrentItem(newindex);
                        }
                    });
                }
            }
        }).start();
    }
}
