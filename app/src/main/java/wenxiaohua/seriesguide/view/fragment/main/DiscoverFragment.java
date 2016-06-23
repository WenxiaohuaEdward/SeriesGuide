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
import wenxiaohua.seriesguide.bean.SeasonInfo;
import wenxiaohua.seriesguide.bean.SearchInfo;
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
    ViewPager fragment_discover_banner_vp;

    /** Banner滚动线程是否销毁的标志，默认不销毁 */
    private boolean isStop = false;
    /** Banner的切换下一个page的间隔时间 */
    private long scrollTimeOffset = 4000;
    private DiscoverFragmentInfo.DataBean discoverData;
    DiscoverFragmentElvAdapter discoverFragmentElvAdapter;
    private List<ImageView> imageViewContainer = new ArrayList<>();
    BannerAdapter bannerAdapter;
    private int currentItem = 0;
    DiscoverFragmentPresenter discoverFragmentPresenter;
    private String page = "1";
    private String rows = "20";
    public String[] typeList =  {"动作","剧情","喜剧","生活","科幻","音乐","悬疑","犯罪","惊悚"};
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        fragment_discover_banner_vp = new ViewPager(getActivity());
        fragment_discover_banner_vp.setLayoutParams(new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT, ContextUtils.dip2px(getActivity(),180)));
        bannerAdapter =  new BannerAdapter(getActivity(),imageViewContainer);
        fragment_discover_banner_vp.setAdapter(bannerAdapter);
        fragment_discover_banner_vp.setCurrentItem(0, true);
        fragment_discover_banner_vp.setOffscreenPageLimit(2);
        fragment_discover_banner_vp.setOnPageChangeListener(new BannerPageChangeListener());
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
                        List<DiscoverFragmentInfo.DataBean.IndexBean> list =  discoverFragmentElvAdapter.getResultList();
                        if ("flow".equals(list.get(groupPosition).getDisplayType())){
                            if ("本周热门".equals( discoverData.getIndex().get(groupPosition).getTitle())){
                                Intent videoCatListIntent = new Intent(getActivity(), VideoListActivity.class);
                                videoCatListIntent.putExtra("title", discoverData.getIndex().get(groupPosition).getTitle());
                                videoCatListIntent.putExtra("isHot", true);
                                getActivity().startActivity(videoCatListIntent);
                            }else if ("最新更新".equals( discoverData.getIndex().get(groupPosition).getTitle())){
                                Intent videoCatListIntent = new Intent(getActivity(), VideoListActivity.class);
                                videoCatListIntent.putExtra("title", discoverData.getIndex().get(groupPosition).getTitle());
                                videoCatListIntent.putExtra("isNew", true);
                                getActivity().startActivity(videoCatListIntent);
                            }
                        }else if("custom".equals(list.get(groupPosition).getDisplayType())){

                        } else{
                            Intent videoCatListIntent = new Intent(getActivity(), VideoListActivity.class);
                            videoCatListIntent.putExtra("title", discoverData.getIndex().get(groupPosition).getTitle());
                            videoCatListIntent.putExtra("videoTypeCat", discoverData.getIndex().get(groupPosition).getTitle());
                            getActivity().startActivity(videoCatListIntent);
                        }
                            return true;
                    }
                });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        discoverFragmentPresenter = (DiscoverFragmentPresenter)mPresenter;
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
/**
 193.
 *
 ViewPager的监听器
 194.
 *
 当ViewPager中页面的状态发生改变时调用
 195.
 *
 @author caizhiming
 196.
 */
    private class BannerPageChangeListener implements ViewPager.OnPageChangeListener {
        boolean isAutoPlay
                = false;
        @Override
        public void onPageScrollStateChanged(int arg0)
        {
//
          //  TODO Auto-generated method stub
            switch (arg0)
            {
                case 1://
                    //手势滑动，空闲中
                    isAutoPlay
                            = false;
                    break;
                case 2://
                    //界面切换中
                    isAutoPlay
                            = true;
                    break;
                case 0://
//                    滑动结束，即切换完毕或者加载完毕
//
//                    当前为最后一张，此时从右向左滑，则切换到第一张
                    if (fragment_discover_banner_vp.getCurrentItem()
                            == fragment_discover_banner_vp.getAdapter().getCount() - 1 &&
                            !isAutoPlay) {
                        fragment_discover_banner_vp.setCurrentItem(0);
                    }
//
//                    当前为第一张，此时从左向右滑，则切换到最后一张
                    else if (fragment_discover_banner_vp.getCurrentItem()
                        == 0 &&
                        !isAutoPlay) {
                        fragment_discover_banner_vp.setCurrentItem(fragment_discover_banner_vp.getAdapter().getCount()
                            - 1);
                }
                    break;
            }
        }
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2)
    {
    }
    @Override
    public void onPageSelected(int pos)
    {
    }

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
        DiscoverFragmentInfo.DataBean.IndexBean typeIndexBean = new DiscoverFragmentInfo.DataBean.IndexBean();
        typeIndexBean.setDisplayType("custom");
        List<DiscoverFragmentInfo.DataBean.IndexBean.SeasonList> seasonLists = new ArrayList<>();
        for(int i = 0;i<typeList.length;i++){
            DiscoverFragmentInfo.DataBean.IndexBean.SeasonList seasonList = new DiscoverFragmentInfo.DataBean.IndexBean.SeasonList();
            seasonList.setCat(typeList[i]);
            seasonList.setTitle(typeList[i]);
            seasonList.setCover("http://img.rrmj.tv/video/20160324/o_1458810628298.jpg");
            seasonLists.add(seasonList);
        }
        typeIndexBean.setSeasonList(seasonLists);
        discoverData.getIndex().add(2,typeIndexBean);
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

    @Override
    public void getSearchDataWithView(SearchInfo.DataBean dataBean,int groupPosition) {
        ArrayList<SeasonInfo> mSeasonInfoList = new ArrayList<>();
        for (SearchInfo.DataBean.ResultsBean searchInfo : dataBean.getResults()){
            if (discoverData.getIndex().get(groupPosition).getTitle().equals(searchInfo)) {
                SeasonInfo seasonInfo = new SeasonInfo();
                seasonInfo.setTitle(searchInfo.getTitle());
                seasonInfo.setCover(searchInfo.getCover());
                seasonInfo.setId(searchInfo.getId());
                seasonInfo.setBrief(searchInfo.getBrief());
                seasonInfo.setViewCount(searchInfo.getUpInfo());
                mSeasonInfoList.add(seasonInfo);
            }
        }
        Intent videoCatListIntent = new Intent(getActivity(), VideoListActivity.class);
        videoCatListIntent.putExtra("videoTypeTitle", discoverData.getIndex().get(groupPosition).getTitle());
        videoCatListIntent.putExtra("videoTypeId", discoverData.getIndex().get(groupPosition).getId());


        getActivity().startActivity(videoCatListIntent);
    }

    /**
     * 开启Banner滚动线程
     */
    private void startBannerScrollThread() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (fragment_discover_banner_vp) {
                    while (!isStop) {
                        //每个四秒钟发一条消息到主线程，更新viewpager界面
                        SystemClock.sleep(scrollTimeOffset);
                        if (getActivity() == null) {
                            return;
                        }

                        getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                if (bannerAdapter.getCount()!=0) {
                                    currentItem
                                            = (currentItem + 1) % bannerAdapter.getCount();
                                    fragment_discover_banner_vp.setCurrentItem(currentItem);
                                }
                            }
                        });
                    }
                }
            }
        }).start();
    }
}
