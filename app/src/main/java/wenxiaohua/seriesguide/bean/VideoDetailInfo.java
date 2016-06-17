package wenxiaohua.seriesguide.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hexun on 2016/6/17.
 */
public class VideoDetailInfo implements Serializable {


    /**
     * code : 0000
     * msg :
     * data : {"seasonDetail":{"seriesId":32235,"playUrlList":[{"playLink":"http://api1.rrmj.tv/api/letvyun/letvmmsid.php?vid=47100710","site":"acfun","episodeSid":"10607","id":27848}],"sid":"465","score":7.9,"cat":"剧情 / 动作 / 科幻 / 奇幻 / 冒险","actorList":[],"title":"闪电侠第二季","brief":"本季首播时间：2015.10.711岁时，艾伦（格兰特·古斯汀 Grant Gustin 饰）的母亲离奇死亡，而他的父亲则被当成了凶手。之后，警探乔（杰西·马丁 Jesse L. Martin 饰）收留了孤苦伶仃的艾伦，在乔的耳濡目染之下，成年后的艾伦成为了一名CSI鉴证分析员，在此过程中，他一直没有放弃过对于母亲真正死因的调查。艾伦十分迷恋科学家哈里森（汤姆·加瓦那 Tom Cavanagh 饰）所研究的粒子加速器，然而，一场意外让加速器发生了爆炸，艾伦被击中陷入了昏迷。九个月后，终于苏醒的艾伦惊讶的发现自己体内产生了神奇的变化，因此而获得了特殊能力。随着时间的推移，艾伦开始明白，这个世界上，还有很多和自己一样拥有超能力的人存在，而保护市民的安全成为了他新的责任和任务。","cover":"http://img.rrmj.tv/video/20151009/o_1444392315235.jpg","enTitle":"The Flash","playStatus":"每周三更新","viewCount":7190493,"isFocus":false,"siteList":[{"enSite":"acfun","cnSite":"A站"}],"episode_brief":[{"sid":"7313","text":"","episode":"1"}],"recommend":[{"sid":"a2vxwynpe5m7","score":7.4,"cat":"剧情/动作/科幻","title":"闪电侠 第一季","finish":true,"upInfo":23,"cover":"http://pic7.moretv.com.cn/20141009/20141009111626448.jpg","enTitle":"The Flash","seasonNo":1,"id":447}],"updateinfo":17,"total":19,"createTime":1444392308000,"updateTime":1459344081000,"createTimeStr":"10-09 20:05","id":465}}
     */

    private String code;
    private String msg;
    /**
     * seasonDetail : {"seriesId":32235,"playUrlList":[{"playLink":"http://api1.rrmj.tv/api/letvyun/letvmmsid.php?vid=47100710","site":"acfun","episodeSid":"10607","id":27848}],"sid":"465","score":7.9,"cat":"剧情 / 动作 / 科幻 / 奇幻 / 冒险","actorList":[],"title":"闪电侠第二季","brief":"本季首播时间：2015.10.711岁时，艾伦（格兰特·古斯汀 Grant Gustin 饰）的母亲离奇死亡，而他的父亲则被当成了凶手。之后，警探乔（杰西·马丁 Jesse L. Martin 饰）收留了孤苦伶仃的艾伦，在乔的耳濡目染之下，成年后的艾伦成为了一名CSI鉴证分析员，在此过程中，他一直没有放弃过对于母亲真正死因的调查。艾伦十分迷恋科学家哈里森（汤姆·加瓦那 Tom Cavanagh 饰）所研究的粒子加速器，然而，一场意外让加速器发生了爆炸，艾伦被击中陷入了昏迷。九个月后，终于苏醒的艾伦惊讶的发现自己体内产生了神奇的变化，因此而获得了特殊能力。随着时间的推移，艾伦开始明白，这个世界上，还有很多和自己一样拥有超能力的人存在，而保护市民的安全成为了他新的责任和任务。","cover":"http://img.rrmj.tv/video/20151009/o_1444392315235.jpg","enTitle":"The Flash","playStatus":"每周三更新","viewCount":7190493,"isFocus":false,"siteList":[{"enSite":"acfun","cnSite":"A站"}],"episode_brief":[{"sid":"7313","text":"","episode":"1"}],"recommend":[{"sid":"a2vxwynpe5m7","score":7.4,"cat":"剧情/动作/科幻","title":"闪电侠 第一季","finish":true,"upInfo":23,"cover":"http://pic7.moretv.com.cn/20141009/20141009111626448.jpg","enTitle":"The Flash","seasonNo":1,"id":447}],"updateinfo":17,"total":19,"createTime":1444392308000,"updateTime":1459344081000,"createTimeStr":"10-09 20:05","id":465}
     */

    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * seriesId : 32235
         * playUrlList : [{"playLink":"http://api1.rrmj.tv/api/letvyun/letvmmsid.php?vid=47100710","site":"acfun","episodeSid":"10607","id":27848}]
         * sid : 465
         * score : 7.9
         * cat : 剧情 / 动作 / 科幻 / 奇幻 / 冒险
         * actorList : []
         * title : 闪电侠第二季
         * brief : 本季首播时间：2015.10.711岁时，艾伦（格兰特·古斯汀 Grant Gustin 饰）的母亲离奇死亡，而他的父亲则被当成了凶手。之后，警探乔（杰西·马丁 Jesse L. Martin 饰）收留了孤苦伶仃的艾伦，在乔的耳濡目染之下，成年后的艾伦成为了一名CSI鉴证分析员，在此过程中，他一直没有放弃过对于母亲真正死因的调查。艾伦十分迷恋科学家哈里森（汤姆·加瓦那 Tom Cavanagh 饰）所研究的粒子加速器，然而，一场意外让加速器发生了爆炸，艾伦被击中陷入了昏迷。九个月后，终于苏醒的艾伦惊讶的发现自己体内产生了神奇的变化，因此而获得了特殊能力。随着时间的推移，艾伦开始明白，这个世界上，还有很多和自己一样拥有超能力的人存在，而保护市民的安全成为了他新的责任和任务。
         * cover : http://img.rrmj.tv/video/20151009/o_1444392315235.jpg
         * enTitle : The Flash
         * playStatus : 每周三更新
         * viewCount : 7190493
         * isFocus : false
         * siteList : [{"enSite":"acfun","cnSite":"A站"}]
         * episode_brief : [{"sid":"7313","text":"","episode":"1"}]
         * recommend : [{"sid":"a2vxwynpe5m7","score":7.4,"cat":"剧情/动作/科幻","title":"闪电侠 第一季","finish":true,"upInfo":23,"cover":"http://pic7.moretv.com.cn/20141009/20141009111626448.jpg","enTitle":"The Flash","seasonNo":1,"id":447}]
         * updateinfo : 17
         * total : 19
         * createTime : 1444392308000
         * updateTime : 1459344081000
         * createTimeStr : 10-09 20:05
         * id : 465
         */

        private SeasonDetailBean seasonDetail;

        public SeasonDetailBean getSeasonDetail() {
            return seasonDetail;
        }

        public void setSeasonDetail(SeasonDetailBean seasonDetail) {
            this.seasonDetail = seasonDetail;
        }

        public static class SeasonDetailBean {
            private int seriesId;
            private String sid;
            private double score;
            private String cat;
            private String title;
            private String brief;
            private String cover;
            private String enTitle;
            private String playStatus;
            private int viewCount;
            private boolean isFocus;
            private int updateinfo;
            private int total;
            private long createTime;
            private long updateTime;
            private String createTimeStr;
            private int id;
            /**
             * playLink : http://api1.rrmj.tv/api/letvyun/letvmmsid.php?vid=47100710
             * site : acfun
             * episodeSid : 10607
             * id : 27848
             */

            private List<PlayUrlListBean> playUrlList;
            private List<?> actorList;
            /**
             * enSite : acfun
             * cnSite : A站
             */

            private List<SiteListBean> siteList;
            /**
             * sid : 7313
             * text :
             * episode : 1
             */

            private List<EpisodeBriefBean> episode_brief;
            /**
             * sid : a2vxwynpe5m7
             * score : 7.4
             * cat : 剧情/动作/科幻
             * title : 闪电侠 第一季
             * finish : true
             * upInfo : 23
             * cover : http://pic7.moretv.com.cn/20141009/20141009111626448.jpg
             * enTitle : The Flash
             * seasonNo : 1
             * id : 447
             */

            private List<RecommendBean> recommend;

            public int getSeriesId() {
                return seriesId;
            }

            public void setSeriesId(int seriesId) {
                this.seriesId = seriesId;
            }

            public String getSid() {
                return sid;
            }

            public void setSid(String sid) {
                this.sid = sid;
            }

            public double getScore() {
                return score;
            }

            public void setScore(double score) {
                this.score = score;
            }

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getBrief() {
                return brief;
            }

            public void setBrief(String brief) {
                this.brief = brief;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getEnTitle() {
                return enTitle;
            }

            public void setEnTitle(String enTitle) {
                this.enTitle = enTitle;
            }

            public String getPlayStatus() {
                return playStatus;
            }

            public void setPlayStatus(String playStatus) {
                this.playStatus = playStatus;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }

            public boolean isIsFocus() {
                return isFocus;
            }

            public void setIsFocus(boolean isFocus) {
                this.isFocus = isFocus;
            }

            public int getUpdateinfo() {
                return updateinfo;
            }

            public void setUpdateinfo(int updateinfo) {
                this.updateinfo = updateinfo;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public String getCreateTimeStr() {
                return createTimeStr;
            }

            public void setCreateTimeStr(String createTimeStr) {
                this.createTimeStr = createTimeStr;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public List<PlayUrlListBean> getPlayUrlList() {
                return playUrlList;
            }

            public void setPlayUrlList(List<PlayUrlListBean> playUrlList) {
                this.playUrlList = playUrlList;
            }

            public List<?> getActorList() {
                return actorList;
            }

            public void setActorList(List<?> actorList) {
                this.actorList = actorList;
            }

            public List<SiteListBean> getSiteList() {
                return siteList;
            }

            public void setSiteList(List<SiteListBean> siteList) {
                this.siteList = siteList;
            }

            public List<EpisodeBriefBean> getEpisode_brief() {
                return episode_brief;
            }

            public void setEpisode_brief(List<EpisodeBriefBean> episode_brief) {
                this.episode_brief = episode_brief;
            }

            public List<RecommendBean> getRecommend() {
                return recommend;
            }

            public void setRecommend(List<RecommendBean> recommend) {
                this.recommend = recommend;
            }

            public static class PlayUrlListBean {
                private String playLink;
                private String site;
                private String episodeSid;
                private int id;

                public String getPlayLink() {
                    return playLink;
                }

                public void setPlayLink(String playLink) {
                    this.playLink = playLink;
                }

                public String getSite() {
                    return site;
                }

                public void setSite(String site) {
                    this.site = site;
                }

                public String getEpisodeSid() {
                    return episodeSid;
                }

                public void setEpisodeSid(String episodeSid) {
                    this.episodeSid = episodeSid;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }
            }

            public static class SiteListBean {
                private String enSite;
                private String cnSite;

                public String getEnSite() {
                    return enSite;
                }

                public void setEnSite(String enSite) {
                    this.enSite = enSite;
                }

                public String getCnSite() {
                    return cnSite;
                }

                public void setCnSite(String cnSite) {
                    this.cnSite = cnSite;
                }
            }

            public static class EpisodeBriefBean {
                private String sid;
                private String text;
                private String episode;

                public String getSid() {
                    return sid;
                }

                public void setSid(String sid) {
                    this.sid = sid;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getEpisode() {
                    return episode;
                }

                public void setEpisode(String episode) {
                    this.episode = episode;
                }
            }

            public static class RecommendBean {
                private String sid;
                private double score;
                private String cat;
                private String title;
                private boolean finish;
                private int upInfo;
                private String cover;
                private String enTitle;
                private int seasonNo;
                private int id;

                public String getSid() {
                    return sid;
                }

                public void setSid(String sid) {
                    this.sid = sid;
                }

                public double getScore() {
                    return score;
                }

                public void setScore(double score) {
                    this.score = score;
                }

                public String getCat() {
                    return cat;
                }

                public void setCat(String cat) {
                    this.cat = cat;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public boolean isFinish() {
                    return finish;
                }

                public void setFinish(boolean finish) {
                    this.finish = finish;
                }

                public int getUpInfo() {
                    return upInfo;
                }

                public void setUpInfo(int upInfo) {
                    this.upInfo = upInfo;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getEnTitle() {
                    return enTitle;
                }

                public void setEnTitle(String enTitle) {
                    this.enTitle = enTitle;
                }

                public int getSeasonNo() {
                    return seasonNo;
                }

                public void setSeasonNo(int seasonNo) {
                    this.seasonNo = seasonNo;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }
            }
        }
    }
}
