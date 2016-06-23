package wenxiaohua.seriesguide.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.DiscoverFragmentInfo.DataBean.IndexBean.SeasonList;
import wenxiaohua.seriesguide.utils.PicassoUtils;
import wenxiaohua.seriesguide.view.listener.RecyclerViewItemClickListener;

/**
 * Created by hexun on 2016/6/14.
 */
public class DiscoverFragmentAdapter extends  RecyclerView.Adapter<DiscoverFragmentAdapter.ViewHolder>{
    private final Context mContext;
    private List<SeasonList> discoverFragmentInfoList =new ArrayList<>();
    private RecyclerViewItemClickListener mItemClickListener ;

    public DiscoverFragmentAdapter(Context context) {
        this.mContext = context;
    }

    public List<SeasonList> getDiscoverFragmentInfoList() {
        return discoverFragmentInfoList;
    }

    public void setDiscoverFragmentInfoList(List<SeasonList> discoverFragmentInfoList) {
        this.discoverFragmentInfoList = discoverFragmentInfoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_fragment,parent,false),mItemClickListener);
        return viewHolder;
    }
    /**
     * 设置Item点击监听
     * @param listener
     */
    public void setOnItemClickListener(RecyclerViewItemClickListener listener){
        this.mItemClickListener = listener;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PicassoUtils.getPicassoInstance(mContext, discoverFragmentInfoList.get(position).getCover(), holder.fragment_discover_cover_iv);
        if (discoverFragmentInfoList.get(position).getUpInfo()!=0){
            holder.fragment_discover_schedule_tv.setText("更新至"+discoverFragmentInfoList.get(position).getUpInfo()+"集");
        }
        holder.fragment_discover_title_tv.setText(discoverFragmentInfoList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return discoverFragmentInfoList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView fragment_discover_cover_iv;
        TextView fragment_discover_title_tv;
        TextView fragment_discover_schedule_tv;
        private RecyclerViewItemClickListener mListener;
        public ViewHolder(View view,RecyclerViewItemClickListener listener) {
            super(view);
             fragment_discover_cover_iv = (ImageView) view.findViewById(R.id.fragment_discover_cover_iv);
            fragment_discover_title_tv = (TextView) view.findViewById(R.id.fragment_discover_title_tv);
            fragment_discover_schedule_tv = (TextView) view.findViewById(R.id.fragment_discover_schedule_tv);
            this.mListener = listener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mListener != null){
                mListener.onItemClick(v,getAdapterPosition());
            }
        }
    }

}
