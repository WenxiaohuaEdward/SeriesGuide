package wenxiaohua.seriesguide.utils;

import android.content.Context;

/**
 * Created by hexun on 2016/7/11.
 */
public class WIFIDownLoadUtils {
    private volatile static WIFIDownLoadUtils mWIFIDownLoadUtils;
    private final Context context;

    private WIFIDownLoadUtils(Context context){
        this.context =context ;

    }

    public static WIFIDownLoadUtils getInstance(Context context) {
        if (mWIFIDownLoadUtils == null) {
            synchronized (SeasonDBUtils.class) {
                if (mWIFIDownLoadUtils == null) {
                    mWIFIDownLoadUtils = new WIFIDownLoadUtils(context);
                }
            }
        }
        return mWIFIDownLoadUtils;
    }
}
