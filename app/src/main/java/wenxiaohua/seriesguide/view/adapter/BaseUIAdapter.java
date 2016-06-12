package wenxiaohua.seriesguide.view.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhjchen on 15/11/5.
 */
public abstract class BaseUIAdapter<T> extends BaseAdapter<T> {

    public BaseUIAdapter(Context context){
        mContext = context;
    }

    @SuppressWarnings("unchecked")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(getItemLayoutResId(), null);
            holder = new ViewHolder();
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return getView(position, convertView, parent, holder);
    }

    protected class ViewHolder {

        private SparseArray<View> views = new SparseArray<View>();

        @SuppressWarnings("unchecked")
        public <E extends View> E obtainView(View convertView, int resId) {

            View v = views.get(resId);

            if (null == v) {
                v = convertView.findViewById(resId);
                views.put(resId, v);
            }

            return (E) v;
        }

    }

    public abstract View getView(int position, View convertView, ViewGroup parent, ViewHolder holder);

    public abstract int getItemLayoutResId();
}
