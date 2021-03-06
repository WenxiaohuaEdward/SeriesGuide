package wenxiaohua.seriesguide.utils;

import android.content.Context;
import android.database.Cursor;

import java.util.List;

import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;
import greendao.SeriesGuideSeason;
import greendao.SeriesGuideSeasonDao;
import wenxiaohua.seriesguide.SeriesGuideApplication;
import wenxiaohua.seriesguide.bean.VideoDetailInfo;

/**
 * Created by hexun on 2016/6/21.
 */
public class SeasonDBUtils {
    private volatile static SeasonDBUtils mSeasonDBUtils;
    private final Cursor cursor;
    SeriesGuideSeasonDao seriesGuideSeasonDao;
    static final int pageSize=20;//分页时，每页的数据总数
    private SeasonDBUtils(Context context){

        SeriesGuideApplication seriesGuideApplication  =  (SeriesGuideApplication)context.getApplicationContext();

        seriesGuideSeasonDao= seriesGuideApplication.getDaoSession().getSeriesGuideSeasonDao();
        String textColumn = SeriesGuideSeasonDao.Properties.ViewCount.columnName;
        String orderBy = textColumn + " COLLATE LOCALIZED ASC";
        cursor = seriesGuideApplication.getDb().query(seriesGuideSeasonDao.getTablename(), seriesGuideSeasonDao.getAllColumns(), null, null, null, null, orderBy);

    }

    public static SeasonDBUtils getInstance(Context context) {
        if (mSeasonDBUtils == null) {
            synchronized (SeasonDBUtils.class) {
                if (mSeasonDBUtils == null) {
                    mSeasonDBUtils = new SeasonDBUtils(context);
                }
            }
        }
        return mSeasonDBUtils;
    }
    public void addSeason(SeriesGuideSeason info){
        if (info!=null&&0!=info.getId()){
            seriesGuideSeasonDao.insert(info);
        }

    }
    public List<SeriesGuideSeason> getSeasonWithId (Long id){
        if (id!=null&&0!=id){

            // Query 类代表了一个可以被重复执行的查询
            Query query = seriesGuideSeasonDao.queryBuilder()
                    .where(SeriesGuideSeasonDao.Properties.Id.eq(id))
                    .orderDesc(SeriesGuideSeasonDao.Properties.CreateTime)
                    .build();
            // 查询结果以 List 返回
            List notes = query.list();
            // 在 QueryBuilder 类中内置两个 Flag 用于方便输出执行的 SQL 语句与传递参数的值
            QueryBuilder.LOG_SQL = true;
            QueryBuilder.LOG_VALUES = true;
            if(null == notes){
                return null;
            }else{
                return notes;
            }
        }
        return null;
    }
    public List<SeriesGuideSeason> getSeasonWithType(String type){
        if (type != null &&! "".equals(type)) {
            // Query 类代表了一个可以被重复执行的查询
            Query query = seriesGuideSeasonDao.queryBuilder()
                    .where(SeriesGuideSeasonDao.Properties.Type.eq(type))
                    .orderDesc(SeriesGuideSeasonDao.Properties.CreateTime)
                    .build();

            // 查询结果以 List 返回
            List notes = query.list();
            // 在 QueryBuilder 类中内置两个 Flag 用于方便输出执行的 SQL 语句与传递参数的值
            QueryBuilder.LOG_SQL = true;
            QueryBuilder.LOG_VALUES = true;
            if(null == notes){
                return null;
            }else{
                return notes;
            }
        }
        return null;
    }
    public List<SeriesGuideSeason> getAllSeason(int page){
            // Query 类代表了一个可以被重复执行的查询
            Query query = seriesGuideSeasonDao.queryBuilder()
                    .orderDesc(SeriesGuideSeasonDao.Properties.CreateTime)
                    .limit(pageSize)
                    .offset(page*pageSize)
                    .build();
            // 查询结果以 List 返回
            List notes = query.list();
            // 在 QueryBuilder 类中内置两个 Flag 用于方便输出执行的 SQL 语句与传递参数的值
            QueryBuilder.LOG_SQL = true;
            QueryBuilder.LOG_VALUES = true;
            if(null == notes){
                return null;
            }else{
                return notes;
            }
    }
    public void deleteSeason(Long id){
        if (id!=null&&0!=id){
            // 删除操作，你可以通过「id」也可以一次性删除所有
            seriesGuideSeasonDao.deleteByKey(id);
        }

    }
    public SeriesGuideSeason seasonToDb(VideoDetailInfo.DataBean data,String type){
        SeriesGuideSeason seriesGuideSeason = new SeriesGuideSeason();
        seriesGuideSeason.setTitle(data.getSeasonDetail().getTitle());
        seriesGuideSeason.setId((long) data.getSeasonDetail().getId());
        seriesGuideSeason.setCover(data.getSeasonDetail().getCover());
        seriesGuideSeason.setBrief(data.getSeasonDetail().getBrief());
        seriesGuideSeason.setCat(data.getSeasonDetail().getCat());
        seriesGuideSeason.setCreateTime(System.currentTimeMillis());
        seriesGuideSeason.setEnTitle(data.getSeasonDetail().getEnTitle());
        seriesGuideSeason.setPlayStatus(data.getSeasonDetail().getPlayStatus());
        seriesGuideSeason.setViewCount(data.getSeasonDetail().getViewCount());
        seriesGuideSeason.setUpdateInfo(data.getSeasonDetail().getUpdateinfo());
        seriesGuideSeason.setTotal(data.getSeasonDetail().getTotal());
        seriesGuideSeason.setUpdateTime(data.getSeasonDetail().getUpdateTime());
        seriesGuideSeason.setType(type);
        return seriesGuideSeason;
    }
}
