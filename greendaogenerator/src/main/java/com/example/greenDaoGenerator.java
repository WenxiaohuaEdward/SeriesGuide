package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class greenDaoGenerator {
        public static void main(String[] args) throws Exception {
            Schema schema = new Schema(1, "greendao");
//      schema.setDefaultJavaPackageDao("wenxiaohua.seriesguide.dao");

            addSeason(schema);

            new DaoGenerator().generateAll(schema, "E:\\seriesguide\\app\\src\\main\\java-gen");
        }

        /**
         * @param schema
         */
        private static void addSeason(Schema schema) {
            Entity season = schema.addEntity("SeriesGuideSeason");

            season.addIdProperty();
//            season.addIntProperty("id").notNull();
            season.addStringProperty("title");
            season.addDoubleProperty("score");
            season.addStringProperty("cat");
            season.addStringProperty("brief");
            season.addStringProperty("cover");
            season.addStringProperty("enTitle");
            season.addStringProperty("playStatus");
            season.addStringProperty("createTimeStr");
            season.addBooleanProperty("isFocus");
            season.addIntProperty("viewCount");
            season.addIntProperty("updateInfo");
            season.addIntProperty("total");
            season.addLongProperty("createTime");
            season.addLongProperty("updateTime");
        }
    }
