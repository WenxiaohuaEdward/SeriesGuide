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
        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public SeriesGuideSeasonEvent(SeriesGuideSeason seriesGuideSeason, boolean isExist, String type) {
            this.seriesGuideSeason = seriesGuideSeason;
            this.isExist = isExist;
            this.type =type;
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
    public static class SeriesGuideDeleteSeasonEvent {
        private SeriesGuideSeason seriesGuideSeason;


        public SeriesGuideDeleteSeasonEvent(SeriesGuideSeason seriesGuideSeason) {
            this.seriesGuideSeason = seriesGuideSeason;
        }

        public void setSeriesGuideSeason(SeriesGuideSeason seriesGuideSeason) {
            this.seriesGuideSeason = seriesGuideSeason;
        }

        public SeriesGuideSeason getSeriesGuideSeason() {
            return seriesGuideSeason;
        }
    }
}
