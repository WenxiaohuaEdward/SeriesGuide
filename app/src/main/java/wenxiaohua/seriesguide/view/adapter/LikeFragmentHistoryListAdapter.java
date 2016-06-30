package wenxiaohua.seriesguide.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

import greendao.SeriesGuideSeason;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.utils.PicassoUtils;

/**
 * Created by hexun on 2016/6/12.
 */
public class LikeFragmentHistoryListAdapter extends android.widget.BaseAdapter {
    private final Context context;
    private ImageView item_like_history_fragment_cover_iv;
    private TextView item_like_history_fragment_title;
    private TextView item_like_history_fragment_updatetime;
    private TextView item_like_history_fragment_schedule;
    private TextView item_like_history_fragment_lasttime;
    private List<SeriesGuideSeason> seriesGuideSeasonList  = new ArrayList<>();
    public LikeFragmentHistoryListAdapter(Context context) {
        this.context = context;
    }

    public List<SeriesGuideSeason> getSeriesGuideSeasonList() {
        return seriesGuideSeasonList;
    }

    public void setSeriesGuideSeasonList(List<SeriesGuideSeason> seriesGuideSeasonList) {
        this.seriesGuideSeasonList = seriesGuideSeasonList;
    }

    @Override
    public int getCount() {
        return seriesGuideSeasonList.size();
    }

    @Override
    public SeriesGuideSeason getItem(int position) {
        return seriesGuideSeasonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            holder= new ViewHolder();
            convertView = View.inflate(context,R.layout.item_like_history_list,null);
            // 获取布局的子元素
            holder.item_like_history_fragment_cover_iv = (ImageView) convertView.findViewById(R.id.item_like_history_fragment_cover_iv);
            holder.item_like_history_fragment_title = (TextView) convertView.findViewById( R.id.item_like_history_fragment_title);
            holder.item_like_history_fragment_updatetime = (TextView) convertView.findViewById( R.id.item_like_history_fragment_updatetime);
            holder.item_like_history_fragment_schedule = (TextView) convertView.findViewById(R.id.item_like_history_fragment_schedule);
            holder.item_like_history_fragment_lasttime = (TextView) convertView.findViewById(R.id.item_like_history_fragment_lasttime);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder)convertView.getTag();
        }
        SeriesGuideSeason seriesGuideSeason = getItem(position);
        if(seriesGuideSeason!=null&&!"".equals(seriesGuideSeason.getCover())) {
            PicassoUtils.getPicassoInstance(context,seriesGuideSeason.getCover(),holder.item_like_history_fragment_cover_iv);
        }else{
            holder.item_like_history_fragment_cover_iv.setImageResource(R.mipmap.ic_launcher);
        }
        holder.item_like_history_fragment_title.setText(seriesGuideSeason.getTitle());
        holder.item_like_history_fragment_updatetime.setText(seriesGuideSeason.getUpdateTime()+"");
        holder.item_like_history_fragment_lasttime.setText(seriesGuideSeason.getBrief());
        return convertView;
    }
    public class ViewHolder{
        public ImageView  item_like_history_fragment_cover_iv ;
        public TextView item_like_history_fragment_title  ;
        public TextView item_like_history_fragment_updatetime ;
        public TextView item_like_history_fragment_schedule ;
        public TextView item_like_history_fragment_lasttime ;
    }
}
