package wenxiaohua.seriesguide.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.DiscoverFragmentInfo.DataBean.IndexBean;
import wenxiaohua.seriesguide.view.activity.VideoDetailActivity;
import wenxiaohua.seriesguide.view.activity.VideoListActivity;
import wenxiaohua.seriesguide.view.listener.RecyclerViewItemClickListener;
import wenxiaohua.seriesguide.view.views.NestRecyclerViewLayoutManager;

/**
 * Created by hexun on 2016/6/8.
 */
public class DiscoverFragmentElvAdapter extends BaseExpandableListAdapter {
    private final Context context;
    private  List<IndexBean> resultList = new ArrayList<>();
    DiscoverFragmentAdapter discoverFragmentAdapter;

    public List<IndexBean> getResultList() {
        return resultList;
    }

    public void setResultList(List<IndexBean> resultList) {
        this.resultList = resultList;
    }

    public DiscoverFragmentElvAdapter(Context context) {
        this.context =context ;
    }


    @Override
    public int getGroupCount() {
        return resultList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public String getGroup(int groupPosition) {
        return resultList.get(groupPosition).getTitle();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return resultList.get(groupPosition).getSeasonList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (resultList.get(groupPosition).getSeasonList().isEmpty()){
            return new View(context);
        }
        convertView = View.inflate(context,R.layout.item_discover_list_group,null);
        TextView groupTextView = (TextView) convertView.findViewById(R.id.item_discover_list_group_tv);
        TextView groupAllTextView = (TextView) convertView.findViewById(R.id.item_discover_list_group_all_tv);
        groupTextView.setText(getGroup(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent)  {
        convertView = View.inflate(context,R.layout.item_discover_list_child,null);
        RecyclerView fragment_discover_rv = (RecyclerView) convertView.findViewById(R.id.fragment_discover_rv);
        int spanCount = 1; // 只显示一行
        NestRecyclerViewLayoutManager mStaggeredGridLayoutManager= new NestRecyclerViewLayoutManager(spanCount, StaggeredGridLayoutManager.HORIZONTAL);
        fragment_discover_rv.setLayoutManager(mStaggeredGridLayoutManager);
        discoverFragmentAdapter  = new DiscoverFragmentAdapter(context);
        discoverFragmentAdapter.setDiscoverFragmentInfoList(resultList.get(groupPosition).getSeasonList());
        discoverFragmentAdapter.setOnItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int ItemPostion) {
                if("custom".equals(resultList.get(groupPosition).getDisplayType())){
                    Intent videoCatListIntent = new Intent(context, VideoListActivity.class);
                    videoCatListIntent.putExtra("title", resultList.get(groupPosition).getSeasonList().get(ItemPostion).getTitle());
                    videoCatListIntent.putExtra("videoTypeCat", resultList.get(groupPosition).getSeasonList().get(ItemPostion).getCat());
                    context.startActivity(videoCatListIntent);

                }else{
                    Intent videoDetail = new Intent(context,VideoDetailActivity.class);
                    videoDetail.putExtra("seasonId",  resultList.get(groupPosition).getSeasonList().get(ItemPostion).getId()+"");
                    videoDetail.putExtra("seasonTitle", resultList.get(groupPosition).getSeasonList().get(ItemPostion).getTitle());
                    context.startActivity(videoDetail);
                }

            }
        });
        fragment_discover_rv.setAdapter(discoverFragmentAdapter);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
