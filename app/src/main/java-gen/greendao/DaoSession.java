package greendao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import greendao.SeriesGuideSeason;

import greendao.SeriesGuideSeasonDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig seriesGuideSeasonDaoConfig;

    private final SeriesGuideSeasonDao seriesGuideSeasonDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        seriesGuideSeasonDaoConfig = daoConfigMap.get(SeriesGuideSeasonDao.class).clone();
        seriesGuideSeasonDaoConfig.initIdentityScope(type);

        seriesGuideSeasonDao = new SeriesGuideSeasonDao(seriesGuideSeasonDaoConfig, this);

        registerDao(SeriesGuideSeason.class, seriesGuideSeasonDao);
    }
    
    public void clear() {
        seriesGuideSeasonDaoConfig.getIdentityScope().clear();
    }

    public SeriesGuideSeasonDao getSeriesGuideSeasonDao() {
        return seriesGuideSeasonDao;
    }

}
