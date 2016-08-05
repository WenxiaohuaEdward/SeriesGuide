package wenxiaohua.seriesguide.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    public static final SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final SimpleDateFormat MONTH_FORMAT = new SimpleDateFormat("MM-dd HH:mm");
    public static final SimpleDateFormat HOUR_FORMAT = new SimpleDateFormat(" HH:mm");
    public static String TODAY = "今天";
    public static String YESTERDAY = "昨天" ;

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

    public static String formatTime(long time) {
        Calendar now = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);

        if (now.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
            int dayDiff = now.get(Calendar.DAY_OF_YEAR) - calendar.get(Calendar.DAY_OF_YEAR);
            if (dayDiff == 0) {
                return TODAY + HOUR_FORMAT.format(calendar.getTime());
            } else if (dayDiff == 1) {
                return YESTERDAY + HOUR_FORMAT.format(calendar.getTime());
            } else {
                return MONTH_FORMAT.format(calendar.getTime());
            }
        } else {
            return YEAR_FORMAT.format(calendar.getTime());
        }
    }
}
