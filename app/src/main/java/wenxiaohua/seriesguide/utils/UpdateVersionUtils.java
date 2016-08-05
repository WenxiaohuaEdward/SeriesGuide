package wenxiaohua.seriesguide.utils;

import android.content.Context;
import android.content.SharedPreferences;

import wenxiaohua.seriesguide.bean.UpgradeSetting;
import wenxiaohua.seriesguide.constant.SPConstants;
import wenxiaohua.seriesguide.view.views.UpgradeDialog;

/**
 * Created by hexun on 2016/7/11.
 */
public class UpdateVersionUtils {
    private volatile static UpdateVersionUtils mUpdateVersionUtils;
    private  Context context;


    private UpdateVersionUtils(Context context){
        this.context =context ;

        SharedPreferences sp =context.getSharedPreferences(SPConstants.SP_APP_VERSION, context.MODE_PRIVATE);
        UpgradeSetting setting = new UpgradeSetting();
        setting.setVersionCode(sp.getInt(SPConstants.SP_APP_VERSION_CODE,0) + "");
        setting.setVersionName(sp.getString(SPConstants.SP_APP_VERSION_NAME, ""));
        setting.setVersionName(sp.getString(SPConstants.SP_APP_VERSION_RELEASENOTES, ""));
        setting.setReleaseNotes(sp.getString(SPConstants.SP_APP_VERSION_RELEASENOTES, ""));
        showUpgradeDialog(setting);


    }
    private void showUpgradeDialog(UpgradeSetting setting) {
        new UpgradeDialog(context, setting).show();
    }
    public static UpdateVersionUtils getInstance(Context context) {
        if (mUpdateVersionUtils == null) {
            synchronized (SeasonDBUtils.class) {
                if (mUpdateVersionUtils == null) {
                    mUpdateVersionUtils = new UpdateVersionUtils(context);
                }
            }
        }
        return mUpdateVersionUtils;
    }
}
