package wenxiaohua.seriesguide.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import wenxiaohua.seriesguide.R;

/**
 * Created by hexun on 2016/6/12.
 */
public class LikeFragmentCacheListAdapter extends BaseUIAdapter {
    private ImageView item_like_cache_fragment_cover_iv;
    private TextView item_like_cache_fragment_updateschedule_tv;
    private TextView item_like_cache_fragment_title_tv;
    private TextView item_like_cache_fragment_watchschedule_tv;

    public LikeFragmentCacheListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent, ViewHolder holder) {
        item_like_cache_fragment_cover_iv = (ImageView) holder.obtainView(convertView, R.id.item_like_cache_fragment_cover_iv);
        item_like_cache_fragment_updateschedule_tv = (TextView) holder.obtainView(convertView, R.id.item_like_cache_fragment_updateschedule_tv);
        item_like_cache_fragment_title_tv = (TextView) holder.obtainView(convertView, R.id.item_like_cache_fragment_title_tv);
        item_like_cache_fragment_watchschedule_tv = (TextView) holder.obtainView(convertView, R.id.item_like_cache_fragment_watchschedule_tv);

        return convertView;
    }

    @Override
    public int getItemLayoutResId() {
        return R.layout.item_like_cache_list;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
