package wenxiaohua.seriesguide.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.VideoDetailCommentInfo;
import wenxiaohua.seriesguide.bean.VideoDetailCommentInfo.DataBean.ResultsBean;
import wenxiaohua.seriesguide.utils.PicassoUtils;

/**
 * Created by hexun on 2016/6/16.
 */
public class VideoDetailCommentFragmentAdapter extends android.widget.BaseAdapter {
    private final Context context;
    private List<ResultsBean> mVideoDetailCommentInfoList = new ArrayList<>();


    public VideoDetailCommentFragmentAdapter(Context context) {
        this.context = context;
    }

    public List<VideoDetailCommentInfo.DataBean.ResultsBean> getmVideoDetailCommentInfoList() {
        return mVideoDetailCommentInfoList;
    }

    public void setmVideoDetailCommentInfoList(List<ResultsBean> mVideoDetailCommentInfoList) {
        this.mVideoDetailCommentInfoList = mVideoDetailCommentInfoList;
    }

    @Override
    public int getCount() {
        return getmVideoDetailCommentInfoList().size();
    }

    @Override
    public ResultsBean getItem(int position) {
        return getmVideoDetailCommentInfoList().get(position);
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
            convertView = View.inflate(context,R.layout.item_video_detail_comment,null);
            // 获取布局的子元素
            holder.video_detail_comment_cover_iv = (ImageView) convertView.findViewById(R.id.video_detail_comment_cover_iv);
            holder.video_detail_comment_username_tv = (TextView) convertView.findViewById( R.id.video_detail_comment_username_tv);
            holder.video_detail_comment_time_tv = (TextView) convertView.findViewById( R.id.video_detail_comment_time_tv);
            holder.video_detail_comment_content_tv = (TextView) convertView.findViewById(R.id.video_detail_comment_content_tv);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder)convertView.getTag();
        }

        ResultsBean resultsBean  = getmVideoDetailCommentInfoList().get(position);
        if(resultsBean!=null&&resultsBean.getAuthor().getHeadImgUrl()!=null&&!"".equals(resultsBean.getAuthor().getHeadImgUrl())) {
            PicassoUtils.getPicassoInstance(context, resultsBean.getAuthor().getHeadImgUrl(), holder.video_detail_comment_cover_iv);
        }else{
            holder.video_detail_comment_cover_iv.setImageResource(R.mipmap.ic_launcher);
        }
        holder.video_detail_comment_content_tv.setText(resultsBean.getContent());
        holder.video_detail_comment_time_tv.setText(resultsBean.getAuthor().getUpdateTime()+"");
        holder.video_detail_comment_username_tv.setText(resultsBean.getAuthor().getNickName());
        return convertView;
    }
    public class ViewHolder{
        private ImageView video_detail_comment_cover_iv;
        private TextView video_detail_comment_username_tv;
        private TextView video_detail_comment_time_tv;
        private TextView video_detail_comment_content_tv;
    }
}
