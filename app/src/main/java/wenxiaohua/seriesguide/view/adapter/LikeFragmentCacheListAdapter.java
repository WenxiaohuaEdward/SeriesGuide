package wenxiaohua.seriesguide.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import greendao.SeriesGuideSeason;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.utils.PicassoUtils;

/**
 * Created by hexun on 2016/6/12.
 */
public class LikeFragmentCacheListAdapter extends BaseAdapter {
    private ImageView item_like_cache_fragment_cover_iv;
    private TextView item_like_cache_fragment_updateschedule_tv;
    private TextView item_like_cache_fragment_title_tv;
    private TextView item_like_cache_fragment_watchschedule_tv;



    private final Context context;

    private List<SeriesGuideSeason> seriesGuideSeasonList  = new ArrayList<>();
    public LikeFragmentCacheListAdapter(Context context) {
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
            convertView = View.inflate(context,R.layout.item_like_cache_list,null);
            // 获取布局的子元素
            holder.item_like_cache_fragment_cover_iv = (ImageView) convertView.findViewById(R.id.item_like_cache_fragment_cover_iv);
            holder.item_like_cache_fragment_updateschedule_tv = (TextView) convertView.findViewById( R.id.item_like_cache_fragment_updateschedule_tv);
            holder.item_like_cache_fragment_title_tv = (TextView) convertView.findViewById( R.id.item_like_cache_fragment_title_tv);
            holder.item_like_cache_fragment_watchschedule_tv = (TextView) convertView.findViewById(R.id.item_like_cache_fragment_watchschedule_tv);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder)convertView.getTag();
        }
        SeriesGuideSeason seriesGuideSeason = getItem(position);
        if(seriesGuideSeason!=null&&!"".equals(seriesGuideSeason.getCover())) {
            PicassoUtils.getPicassoInstance(context, seriesGuideSeason.getCover(), holder.item_like_cache_fragment_cover_iv);
        }else{
            holder.item_like_cache_fragment_cover_iv.setImageResource(R.mipmap.ic_launcher);
        }
        holder.item_like_cache_fragment_updateschedule_tv.setText(seriesGuideSeason.getTitle());
        holder.item_like_cache_fragment_title_tv.setText(seriesGuideSeason.getUpdateTime()+"");
        holder.item_like_cache_fragment_watchschedule_tv.setText(seriesGuideSeason.getCat());
        return convertView;
    }
    public class ViewHolder{
        public ImageView  item_like_cache_fragment_cover_iv ;
        public TextView item_like_cache_fragment_updateschedule_tv;
        public TextView item_like_cache_fragment_title_tv ;
        public TextView item_like_cache_fragment_watchschedule_tv ;
    }
}
