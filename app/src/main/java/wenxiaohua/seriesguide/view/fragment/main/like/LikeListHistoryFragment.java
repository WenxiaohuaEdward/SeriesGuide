package wenxiaohua.seriesguide.view.fragment.main.like;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

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
import wenxiaohua.seriesguide.view.adapter.LikeFragmentHistoryListAdapter;
import wenxiaohua.seriesguide.view.fragment.BaseFragment;
import wenxiaohua.seriesguide.view.views.XListView;

/**
 * Created by hexun on 2016/6/12.
 */
public class LikeListHistoryFragment extends BaseFragment implements  XListView.IXListViewListener{
    @Bind(R.id.fragment_like_history_listview)
    XListView fragment_like_history_listview;
    LikeFragmentHistoryListAdapter likeFragmentHistoryListAdapter;
    private int page =  0;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        likeFragmentHistoryListAdapter= new LikeFragmentHistoryListAdapter(getActivity());
        fragment_like_history_listview.setAdapter(likeFragmentHistoryListAdapter);
        EventBus.getDefault().register(this);
        fragment_like_history_listview.setDivider(null);
        fragment_like_history_listview.setXListViewListener(this);
        fragment_like_history_listview.setPullLoadEnable(true);
        fragment_like_history_listview.setPullRefreshEnable(true);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Override
    protected void initData(Bundle savedInstanceState) {
        getDataFromDB();
        fragment_like_history_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    return;
                }
                 SeriesGuideSeason mSeriesGuideSeason = likeFragmentHistoryListAdapter.getItem(position-1);
                Intent videoDetail = new Intent(getActivity(),VideoDetailActivity.class);
                videoDetail.putExtra("seasonId",  mSeriesGuideSeason.getId()+"");
                videoDetail.putExtra("seasonTitle", mSeriesGuideSeason.getTitle());
                getActivity().startActivity(videoDetail);
            }
        });
    }
    public void getDataFromDB(){
        List<SeriesGuideSeason> seriesGuideSeasonList = SeasonDBUtils.getInstance(getActivity()).getAllSeason(page);
        likeFragmentHistoryListAdapter.getSeriesGuideSeasonList().addAll(seriesGuideSeasonList);
        likeFragmentHistoryListAdapter.notifyDataSetChanged();
        fragment_like_history_listview.stopRefresh();
        fragment_like_history_listview.stopLoadMore();
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
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showHistory(Event.SeriesGuideSeasonEvent seasonEvent){
        if(seasonEvent.isExist()){
            SeriesGuideSeason existSeason = null;
            for (SeriesGuideSeason existSeriesGuideSeason : likeFragmentHistoryListAdapter.getSeriesGuideSeasonList()){
                if (existSeriesGuideSeason.getId().equals(seasonEvent.getSeriesGuideSeason().getId())){
                    existSeason = existSeriesGuideSeason;
                }
            }
            likeFragmentHistoryListAdapter.getSeriesGuideSeasonList().remove(existSeason);
            likeFragmentHistoryListAdapter.getSeriesGuideSeasonList().add(0,seasonEvent.getSeriesGuideSeason());
        } else {
            likeFragmentHistoryListAdapter.getSeriesGuideSeasonList().add(0,seasonEvent.getSeriesGuideSeason());
        }
        likeFragmentHistoryListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        likeFragmentHistoryListAdapter.getSeriesGuideSeasonList().clear();
        page = 0;
        getDataFromDB();
    }

    @Override
    public void onLoadMore() {
        page ++;
        getDataFromDB();
    }
}
