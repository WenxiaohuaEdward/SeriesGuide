package wenxiaohua.seriesguide.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hexun on 2016/6/20.
 */
public class SecrchInfo implements Serializable {

    /**
     * code : 0000
     * msg :
     * data : {"total":5,"results":[{"sid":"509","score":7.9,"cat":"喜剧 / 动作 / 科幻","title":"最后一个男人 第二季","brief":"　FOX#续订#了季中新喜剧#最后一个男人#第二季。在未来的某一天，地球上除了Phil Miller，好像就没有别人了？！ 　　Phil到处搜寻其他幸存者却一无所获，但无论如何他都不会放弃，因为他坚信自己不是一个人。如果有一天他终于遇见了她，那就太妙了！","upInfo":13,"cover":"http://img.rrmj.tv/video/20151013/o_1444732802291.jpg","enTitle":"The Last Man On Earth Season 2","mark":"none","seasonNo":2,"id":509}],"currentPage":1}
     */

    private String code;
    private String msg;
    /**
     * total : 5
     * results : [{"sid":"509","score":7.9,"cat":"喜剧 / 动作 / 科幻","title":"最后一个男人 第二季","brief":"　FOX#续订#了季中新喜剧#最后一个男人#第二季。在未来的某一天，地球上除了Phil Miller，好像就没有别人了？！ 　　Phil到处搜寻其他幸存者却一无所获，但无论如何他都不会放弃，因为他坚信自己不是一个人。如果有一天他终于遇见了她，那就太妙了！","upInfo":13,"cover":"http://img.rrmj.tv/video/20151013/o_1444732802291.jpg","enTitle":"The Last Man On Earth Season 2","mark":"none","seasonNo":2,"id":509}]
     * currentPage : 1
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
        private int total;
        private int currentPage;
        /**
         * sid : 509
         * score : 7.9
         * cat : 喜剧 / 动作 / 科幻
         * title : 最后一个男人 第二季
         * brief : 　FOX#续订#了季中新喜剧#最后一个男人#第二季。在未来的某一天，地球上除了Phil Miller，好像就没有别人了？！ 　　Phil到处搜寻其他幸存者却一无所获，但无论如何他都不会放弃，因为他坚信自己不是一个人。如果有一天他终于遇见了她，那就太妙了！
         * upInfo : 13
         * cover : http://img.rrmj.tv/video/20151013/o_1444732802291.jpg
         * enTitle : The Last Man On Earth Season 2
         * mark : none
         * seasonNo : 2
         * id : 509
         */

        private List<ResultsBean> results;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            private String sid;
            private double score;
            private String cat;
            private String title;
            private String brief;
            private int upInfo;
            private String cover;
            private String enTitle;
            private String mark;
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

            public String getBrief() {
                return brief;
            }

            public void setBrief(String brief) {
                this.brief = brief;
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

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
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
