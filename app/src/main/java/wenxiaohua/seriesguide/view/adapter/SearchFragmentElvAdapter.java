package wenxiaohua.seriesguide.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.SearchFragmentElvBean;

/**
 * Created by hexun on 2016/6/8.
 */
public class SearchFragmentElvAdapter extends BaseExpandableListAdapter {
    private final Context context;
    private  ArrayList<SearchFragmentElvBean> resultList = new ArrayList<>();

    public ArrayList<SearchFragmentElvBean> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<SearchFragmentElvBean> resultList) {
        this.resultList = resultList;
    }

    public SearchFragmentElvAdapter(Context context, ArrayList<SearchFragmentElvBean> resultList) {
        this.resultList =resultList ;
        this.context =context ;
    }


    @Override
    public int getGroupCount() {
        return resultList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return resultList.get(groupPosition).values.size();
    }

    @Override
    public String getGroup(int groupPosition) {
        return resultList.get(groupPosition).key;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return resultList.get(groupPosition).values.get(childPosition);
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
        convertView = View.inflate(context,R.layout.item_search_list_group,null);
        TextView groupTextView = (TextView) convertView.findViewById(R.id.item_search_list_group_tv);
        groupTextView.setText(getGroup(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent)  {
        convertView = View.inflate(context,R.layout.item_search_list_child,null);
        TextView childTextView = (TextView) convertView.findViewById(R.id.item_search_list_child_tv);
        childTextView.setText(getChild(groupPosition,childPosition).toString());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
