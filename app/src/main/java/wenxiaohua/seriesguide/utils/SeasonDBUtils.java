package wenxiaohua.seriesguide.utils;

import android.content.Context;
import android.database.Cursor;

import java.util.List;

import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;
import greendao.SeriesGuideSeason;
import greendao.SeriesGuideSeasonDao;
import wenxiaohua.seriesguide.SeriesGuideApplication;

/**
 * Created by hexun on 2016/6/21.
 */
public class SeasonDBUtils {
    private final Cursor cursor;
    SeriesGuideSeasonDao seriesGuideSeasonDao;
    public SeasonDBUtils(Context context){

        SeriesGuideApplication seriesGuideApplication  =  (SeriesGuideApplication)context.getApplicationContext();

        seriesGuideSeasonDao= seriesGuideApplication.getDaoSession().getSeriesGuideSeasonDao();
        String textColumn = SeriesGuideSeasonDao.Properties.ViewCount.columnName;
        String orderBy = textColumn + " COLLATE LOCALIZED ASC";
        cursor = seriesGuideApplication.getDb().query(seriesGuideSeasonDao.getTablename(), seriesGuideSeasonDao.getAllColumns(), null, null, null, null, orderBy);
    }
    public void addSeason(SeriesGuideSeason info){
        if (info!=null&&0!=info.getId()){
            seriesGuideSeasonDao.insert(info);
            cursor.requery();
        }

    }
    public void getSeason(Long id){
        if (id!=null&&0!=id){
            // Query 类代表了一个可以被重复执行的查询
            Query query = seriesGuideSeasonDao.queryBuilder()
                    .where(SeriesGuideSeasonDao.Properties.Id.eq(id))
                    .orderAsc(SeriesGuideSeasonDao.Properties.ViewCount)
                    .build();
            // 查询结果以 List 返回
            List notes = query.list();
            // 在 QueryBuilder 类中内置两个 Flag 用于方便输出执行的 SQL 语句与传递参数的值
            QueryBuilder.LOG_SQL = true;
            QueryBuilder.LOG_VALUES = true;
        }

    }
    public void deleteSeason(Long id){
        if (id!=null&&0!=id){
            // 删除操作，你可以通过「id」也可以一次性删除所有
            seriesGuideSeasonDao.deleteByKey(id);
            cursor.requery();
        }

    }
}