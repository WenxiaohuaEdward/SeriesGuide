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
public class LikeFragmentHistoryListAdapter extends BaseUIAdapter {
    private ImageView item_like_history_fragment_cover_iv;
    private TextView item_like_history_fragment_title;
    private TextView item_like_history_fragment_updatetime;
    private TextView item_like_history_fragment_schedule;
    private TextView item_like_history_fragment_lasttime;

    public LikeFragmentHistoryListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent, ViewHolder holder) {
        // 获取布局的子元素
        item_like_history_fragment_cover_iv = (ImageView) holder.obtainView(convertView, R.id.item_like_history_fragment_cover_iv);
        item_like_history_fragment_title = (TextView) holder.obtainView(convertView, R.id.item_like_history_fragment_title);
        item_like_history_fragment_updatetime = (TextView) holder.obtainView(convertView, R.id.item_like_history_fragment_updatetime);
        item_like_history_fragment_schedule = (TextView) holder.obtainView(convertView, R.id.item_like_history_fragment_schedule);
        item_like_history_fragment_lasttime = (TextView) holder.obtainView(convertView, R.id.item_like_history_fragment_lasttime);

        return convertView;
    }

    @Override
    public int getItemLayoutResId() {
        return R.layout.item_like_history_list;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
