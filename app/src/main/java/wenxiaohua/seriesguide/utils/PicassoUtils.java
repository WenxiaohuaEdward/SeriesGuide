package wenxiaohua.seriesguide.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import wenxiaohua.seriesguide.R;

/**
 * Created by hexun on 2016/6/16.
 */
public class PicassoUtils {
    public static void getPicassoInstance(Context context,String url,ImageView imageView){
        if(url!=null||!"".equals(url)){
            Picasso.with(context).load(url)
                    .placeholder(R.drawable.ic_loading)
                    .error(R.drawable.ic_loading_error).into(imageView);
        }

    }
}
