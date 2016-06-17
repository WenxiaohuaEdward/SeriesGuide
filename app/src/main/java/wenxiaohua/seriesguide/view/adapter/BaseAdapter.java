package wenxiaohua.seriesguide.view.adapter;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by zhjchen on 15/11/5.
 */
public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {

    protected Context mContext;
    protected List<T> mList;

    public BaseAdapter() {
        mList = new ArrayList<T>();
    }

    public BaseAdapter(Context context) {
        mContext = context;
        mList = new ArrayList<T>();
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T findViewById(View view, int id) {
        return (T) view.findViewById(id);
    }

    public int findPosition(T message) {
        int position = -1;
        for (int i = 0; i < mList.size(); i++) {
            if (message.equals(mList.get(i))) {
                position = i;
                break;
            }
        }
        return position;
    }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();

    }

    public int findPosition(long id) {

        int index = getCount();
        int position = -1;

        while (index-- > 0) {
            if (getItemId(index) == id) {
                position = index;
                break;
            }
        }

        return position;
    }

    public void addCollection(Collection<T> collection) {
        mList.addAll(collection);
    }

    public void addCollection(T... collection) {

        for (T t : collection) {
            mList.add(t);
        }
    }

    public void add(T t) {
        mList.add(t);
    }

    public void add(T t, int position) {
        mList.add(position, t);
    }

    public void remove(int position) {
        mList.remove(position);
    }


    public void clear() {
        mList.clear();
    }

    @Override
    public int getCount() {
        if (mList == null)
            return 0;

        return mList.size();
    }

    @Override
    public T getItem(int position) {

        if (mList == null)
            return null;

        if (position >= mList.size())
            return null;

        return mList.get(position);
    }

    /**
     * 增加 adapter 中点击 item 中的 View 事件监听。
     */
    public interface OnItemViewClickListener {
        /**
         *
         * @param viewId view 的唯一标识。
         * @param position  View 在 adapter 中的位置。
         */
        public void onItemViewClick(int viewId, int position);
    }

    public OnItemViewClickListener getItemViewClickListener() {
        return mItemViewClickListener;
    }

   protected OnItemViewClickListener mItemViewClickListener;

    /**
     * 设置监听。
     * @param mItemViewClickListener
     */
    public void setItemViewClickListener(OnItemViewClickListener mItemViewClickListener) {
        this.mItemViewClickListener = mItemViewClickListener;
    }
}
