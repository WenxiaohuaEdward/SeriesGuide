package wenxiaohua.seriesguide.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.view.listener.RecyclerViewItemClickListener;

/**
 * Created by hexun on 2016/6/23.
 */
    public class VideoDetailReviewNumAdapter extends  RecyclerView.Adapter<VideoDetailReviewNumAdapter.ViewHolder> {
    private final Context mContext;
    private RecyclerViewItemClickListener mItemClickListener;
    private List<String> numList = new ArrayList<>();
    public VideoDetailReviewNumAdapter(Context context) {
        this.mContext = context;
    }


    public List<String> getNumList() {
        return numList;
    }

    public void setNumList(List<String> numList) {
        this.numList = numList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_detail_review_num, parent, false), mItemClickListener);
        return viewHolder;
    }


    /**
     * 设置Item点击监听
     *
     * @param listener
     */
    public void setOnItemClickListener(RecyclerViewItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.adapter_video_detail_review_num_tv.setText(numList.get(position));

    }

    @Override
    public int getItemCount() {
        return numList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView adapter_video_detail_review_num_tv;
        private RecyclerViewItemClickListener mListener;

        public ViewHolder(View view, RecyclerViewItemClickListener listener) {
            super(view);
            adapter_video_detail_review_num_tv = (TextView) view.findViewById(R.id.adapter_video_detail_review_num_tv);
            this.mListener = listener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemClick(v, getAdapterPosition());
            }
        }
    }
}
