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
public class LikeListCollectFragment extends BaseFragment{
    @Bind(R.id.fragment_like_collect_gv)
    GridView fragment_like_collect_gv;
    LikeFragmentCacheListAdapter likeFragmentCollectListAdapter;
    private int page = 0;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        likeFragmentCollectListAdapter = new LikeFragmentCacheListAdapter(getActivity());
        fragment_like_collect_gv.setAdapter(likeFragmentCollectListAdapter);
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
        fragment_like_collect_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                SeriesGuideSeason mSeriesGuideSeason = likeFragmentCollectListAdapter.getItem(position);
                Intent videoDetail = new Intent(getActivity(), VideoDetailActivity.class);
                videoDetail.putExtra("seasonId", mSeriesGuideSeason.getId() + "");
                videoDetail.putExtra("seasonTitle", mSeriesGuideSeason.getTitle());
                getActivity().startActivity(videoDetail);
            }
        });
    }
    public void getDataFromDB(){
        List<SeriesGuideSeason> seriesGuideSeasonList = SeasonDBUtils.getInstance(getActivity()).getSeasonWithType("collect");
        if (seriesGuideSeasonList!=null) {
            likeFragmentCollectListAdapter.getSeriesGuideSeasonList().addAll(seriesGuideSeasonList);
            likeFragmentCollectListAdapter.notifyDataSetChanged();
        }
    }
    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void bindView(Bundle savedInstanceState) {

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showCollect(Event.SeriesGuideSeasonEvent seasonEvent) {
        if ("collect".equals(seasonEvent.getType())) {
            if (seasonEvent.isExist()) {
                SeriesGuideSeason existSeason = null;
                for (SeriesGuideSeason existSeriesGuideSeason : likeFragmentCollectListAdapter.getSeriesGuideSeasonList()) {
                    if (existSeriesGuideSeason.getId().equals(seasonEvent.getSeriesGuideSeason().getId())) {
                        existSeason = existSeriesGuideSeason;
                    }
                }
                likeFragmentCollectListAdapter.getSeriesGuideSeasonList().remove(existSeason);
                likeFragmentCollectListAdapter.getSeriesGuideSeasonList().add(0, seasonEvent.getSeriesGuideSeason());
            } else {
                likeFragmentCollectListAdapter.getSeriesGuideSeasonList().add(0, seasonEvent.getSeriesGuideSeason());
            }
            likeFragmentCollectListAdapter.notifyDataSetChanged();
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void deleteCollect(Event.SeriesGuideDeleteSeasonEvent deleteSeasonEvent){
        likeFragmentCollectListAdapter.getSeriesGuideSeasonList().remove(deleteSeasonEvent.getSeriesGuideSeason());

    }
    @Override
    public int getContentLayout() {
        return R.layout.fragment_like_collect_list;
    }
}
