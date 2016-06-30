package wenxiaohua.seriesguide.event;

import greendao.SeriesGuideSeason;

/**
 * Created by hexun on 2016/6/30.
 */
public class Event {
    /**
     * Entity mapped to table "SERIES_GUIDE_SEASON".
     */
    public static class SeriesGuideSeasonEvent {
        private SeriesGuideSeason seriesGuideSeason;
        private boolean isExist;

        public SeriesGuideSeasonEvent(SeriesGuideSeason seriesGuideSeason, boolean isExist) {
            this.seriesGuideSeason = seriesGuideSeason;
            this.isExist = isExist;
        }

        public boolean isExist() {
            return isExist;
        }

        public void setIsExist(boolean isExist) {
            this.isExist = isExist;
        }

        public SeriesGuideSeason getSeriesGuideSeason() {
            return seriesGuideSeason;
        }

        public void setSeriesGuideSeason(SeriesGuideSeason seriesGuideSeason) {
            this.seriesGuideSeason = seriesGuideSeason;
        }
    }

}
