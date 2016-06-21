package wenxiaohua.seriesguide.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.SeasonInfo;
import wenxiaohua.seriesguide.utils.PicassoUtils;

/**
 * Created by hexun on 2016/6/15.
 */
public class VideoListAdapter extends android.widget.BaseAdapter {
    private final Context context;
    private ImageView item_video_type_iv;
    private TextView item_video_type_title;
    private TextView item_video_type_movie_review;
    private TextView item_video_type_commentSum;
    private TextView item_video_type_watchSum;
    List<SeasonInfo> mSeasonInfoList = new ArrayList<>();
    public VideoListAdapter(Context context) {
        this.context =context;

    }

    public List<SeasonInfo> getmSeasonInfoList() {
        return mSeasonInfoList;
    }

    public void setmSeasonInfoList(List<SeasonInfo> mSeasonInfoList) {
        this.mSeasonInfoList = mSeasonInfoList;
    }


    @Override
    public int getCount() {
        return mSeasonInfoList.size();
    }

    @Override
    public SeasonInfo getItem(int position) {
        return mSeasonInfoList.get(position);
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
            convertView = View.inflate(context,R.layout.item_video_list,null);
            // 获取布局的子元素
            holder.item_video_type_iv = (ImageView) convertView.findViewById(R.id.item_video_type_iv);
            holder.item_video_type_title = (TextView) convertView.findViewById( R.id.item_video_type_title);
            holder.item_video_type_movie_review = (TextView) convertView.findViewById( R.id.item_video_type_movie_review);
            holder.item_video_type_commentSum = (TextView) convertView.findViewById(R.id.item_video_type_commentSum);
            holder.item_video_type_watchSum = (TextView) convertView.findViewById(R.id.item_video_type_watchSum);

            convertView.setTag(holder);
        }else{
            holder= (ViewHolder)convertView.getTag();
        }

        SeasonInfo seasonInfo  = getItem(position);
        if(seasonInfo!=null&&!"".equals(seasonInfo.getCover())) {
            PicassoUtils.getPicassoInstance(context, seasonInfo.getCover(), holder.item_video_type_iv);
        }else{
            holder.item_video_type_iv.setImageResource(R.mipmap.ic_launcher);
        }
        holder.item_video_type_title.setText(seasonInfo.getTitle());
        holder.item_video_type_movie_review.setText(seasonInfo.getBrief());
        holder.item_video_type_watchSum.setText(seasonInfo.getViewCount()+"");


        return convertView;
    }
    public class ViewHolder{
        private ImageView item_video_type_iv;
        private TextView item_video_type_title;
        private TextView item_video_type_movie_review;
        private TextView item_video_type_commentSum;
        private TextView item_video_type_watchSum;
    }
}
