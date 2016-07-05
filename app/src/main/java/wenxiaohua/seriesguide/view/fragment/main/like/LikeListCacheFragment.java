package wenxiaohua.seriesguide.view.fragment.main.like;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.Bind;
import greendao.SeriesGuideSeason;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.event.Event;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.utils.SeasonDBUtils;
import wenxiaohua.seriesguide.view.activity.VideoDetailActivity;
import wenxiaohua.seriesguide.view.adapter.LikeFragmentCacheListAdapter;
import wenxiaohua.seriesguide.view.fragment.BaseFragment;

/**
 * Created by hexun on 2016/6/12.
 */
public class LikeListCacheFragment extends BaseFragment{
    @Bind(R.id.fragment_like_cache_gv)
    GridView fragment_like_cache_gv;
    LikeFragmentCacheListAdapter likeFragmentCacheListAdapter;
    private int page=0;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        likeFragmentCacheListAdapter= new LikeFragmentCacheListAdapter(getActivity());
        fragment_like_cache_gv.setAdapter(likeFragmentCacheListAdapter);
        EventBus.getDefault().register(this);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Override
    protected void initData(Bundle savedInstanceState) {
        getDataFromDB();
        fragment_like_cache_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                SeriesGuideSeason mSeriesGuideSeason = likeFragmentCacheListAdapter.getItem(position);
                Intent videoDetail = new Intent(getActivity(), VideoDetailActivity.class);
                videoDetail.putExtra("seasonId", mSeriesGuideSeason.getId() + "");
                videoDetail.putExtra("seasonTitle", mSeriesGuideSeason.getTitle());
                getActivity().startActivity(videoDetail);
            }
        });
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void bindView(Bundle savedInstanceState) {

    }
    public void getDataFromDB(){
        List<SeriesGuideSeason> seriesGuideSeasonList = SeasonDBUtils.getInstance(getActivity()).getSeasonWithType("cache");
        if (seriesGuideSeasonList!=null) {
            likeFragmentCacheListAdapter.getSeriesGuideSeasonList().addAll(seriesGuideSeasonList);
            likeFragmentCacheListAdapter.notifyDataSetChanged();
        }
    }
    @Override
    public int getContentLayout() {
        return R.layout.fragment_like_cache_list;
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showCache(Event.SeriesGuideSeasonEvent seasonEvent) {
        if ("cache".equals(seasonEvent.getType())) {
            if (seasonEvent.isExist()) {
                SeriesGuideSeason existSeason = null;
                for (SeriesGuideSeason existSeriesGuideSeason : likeFragmentCacheListAdapter.getSeriesGuideSeasonList()) {
                    if (existSeriesGuideSeason.getId().equals(seasonEvent.getSeriesGuideSeason().getId())) {
                        existSeason = existSeriesGuideSeason;
                    }
                }
                likeFragmentCacheListAdapter.getSeriesGuideSeasonList().remove(existSeason);
                likeFragmentCacheListAdapter.getSeriesGuideSeasonList().add(0, seasonEvent.getSeriesGuideSeason());
            } else {
                likeFragmentCacheListAdapter.getSeriesGuideSeasonList().add(0, seasonEvent.getSeriesGuideSeason());
            }
            likeFragmentCacheListAdapter.notifyDataSetChanged();
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void deleteCache(Event.SeriesGuideDeleteSeasonEvent deleteSeasonEvent){
        likeFragmentCacheListAdapter.getSeriesGuideSeasonList().remove(deleteSeasonEvent.getSeriesGuideSeason());

    }
}
