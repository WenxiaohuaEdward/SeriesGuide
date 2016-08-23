package wenxiaohua.seriesguide.utils;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import wenxiaohua.seriesguide.R;

/**
 * Created by hexun on 2016/8/22.
 */
public class FormatTimeUtils {
    public static final SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final SimpleDateFormat MONTH_FORMAT = new SimpleDateFormat("MM-dd HH:mm");
    public static final SimpleDateFormat HOUR_FORMAT = new SimpleDateFormat(" HH:mm");
    public static String TODAY, YESTERDAY;
    private volatile static FormatTimeUtils mFormatTimeUtils;
    private final Context context;

    private FormatTimeUtils(Context context){
        this.context =context ;
        TODAY = context.getResources().getString(R.string.today);
        YESTERDAY = context.getResources().getString(R.string.yesterday);
    }

    public static FormatTimeUtils getInstance(Context context) {
        if (mFormatTimeUtils == null) {
            synchronized (SeasonDBUtils.class) {
                if (mFormatTimeUtils == null) {
                    mFormatTimeUtils = new FormatTimeUtils(context);
                }
            }
        }
        return mFormatTimeUtils;
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
