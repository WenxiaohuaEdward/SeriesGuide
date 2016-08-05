package wenxiaohua.seriesguide.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import wenxiaohua.seriesguide.view.activity.BaseActivity;

/**
 * Created by hexun on 2016/7/20.
 */
public class NetUtils {
    public static int isWifi(BaseActivity mActivity) {
        ConnectivityManager connectMgr = (ConnectivityManager) mActivity
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectMgr.getActiveNetworkInfo();
        if (info == null) {
            // 没网
            return 0;
        } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {
            return 1;
        } else {
            return 2;
        }
    }
}
