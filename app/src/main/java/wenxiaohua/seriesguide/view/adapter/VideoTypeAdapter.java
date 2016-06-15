package wenxiaohua.seriesguide.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import wenxiaohua.seriesguide.R;

/**
 * Created by hexun on 2016/6/15.
 */
public class VideoTypeAdapter extends BaseUIAdapter {
    private ImageView item_video_type_iv;
    private TextView item_video_type_title;
    private TextView item_video_type_movie_review;
    private TextView item_video_type_commentSum;
    private TextView item_video_type_watchSum;

    public VideoTypeAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent, ViewHolder holder) {
        item_video_type_iv = (ImageView) holder.obtainView(convertView, R.id.item_video_type_iv);
        item_video_type_title = (TextView) holder.obtainView(convertView, R.id.item_video_type_title);
        item_video_type_movie_review = (TextView) holder.obtainView(convertView, R.id.item_video_type_movie_review);
        item_video_type_commentSum = (TextView) holder.obtainView(convertView, R.id.item_video_type_commentSum);
        item_video_type_watchSum = (TextView) holder.obtainView(convertView, R.id.item_video_type_watchSum);

        return convertView;
    }

    @Override
    public int getItemLayoutResId() {
        return R.layout.item_video_type;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
