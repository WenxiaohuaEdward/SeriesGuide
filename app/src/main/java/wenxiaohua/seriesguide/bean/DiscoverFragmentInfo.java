package wenxiaohua.seriesguide.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hexun on 2016/6/14.
 */
public class DiscoverFragmentInfo implements Serializable{

    /**
     * code : 0000
     * msg :
     * data : {"adpos":[0,1,0,0,0,0,0],"index":[{"seasonList":[{"title":"黑暗料理","upInfo":7,"cover":"http://img.rrmj.tv/video/20160317/o_1458211122153.jpg","mark":"update","id":1332}],"requestUrl":"/video/search?order=desc&sort=createTime&mark=update","title":"最新更新","displayType":"flow","seasonNo":null,"createTime":1459843474236,"updateTime":1459843474236,"createTimeStr":"4分钟前","id":1},{"seasonList":[{"title":"行尸走肉 第六季 ","upInfo":16,"cover":"http://img.rrmj.tv/video/20151019/o_1445245529315.jpg","mark":"hot","id":503}],"requestUrl":"/video/search?order=desc&sort=createTime&mark=hot","title":"本周热门","displayType":"flow","seasonNo":null,"createTime":1459843474236,"updateTime":1459843474236,"createTimeStr":"4分钟前","id":2},{"seasonList":[{"title":"失落十三年","upInfo":5,"cover":"http://img.rrmj.tv/video/20160323/o_1458703227725.jpg","mark":"update","id":1410}],"requestUrl":"/video/search?area=%E8%8B%B1%E5%9B%BD","title":"英剧","displayType":"list","seasonNo":null,"createTime":1459843474302,"updateTime":1459843474302,"createTimeStr":"4分钟前","id":7},{"seasonList":[{"title":"黑暗料理","upInfo":7,"cover":"http://img.rrmj.tv/video/20160317/o_1458211122153.jpg","mark":"update","id":1332}],"requestUrl":"/video/search?cat=%E5%8E%9F%E5%88%9B","title":"原创","displayType":"list","seasonNo":null,"createTime":1459843474407,"updateTime":1459843474407,"createTimeStr":"4分钟前","id":3},{"seasonList":[{"title":"极速前进 第二十八季 ","upInfo":6,"cover":"http://img.rrmj.tv/video/20160222/o_1456137012152.jpg","mark":"update","id":1172}],"requestUrl":"/video/search?cat=%E5%A8%B1%E4%B9%90","title":"娱乐","displayType":"list","seasonNo":null,"createTime":1459843474504,"updateTime":1459843474504,"createTimeStr":"4分钟前","id":4},{"seasonList":[{"title":"烹","upInfo":1,"cover":"http://img.rrmj.tv/video/20160405/o_1459835939475.jpg","mark":"update","id":1515}],"requestUrl":"/video/search?cat=%E7%BA%AA%E5%BD%95%E7%89%87","title":"纪录片","displayType":"list","seasonNo":null,"createTime":1459843474603,"updateTime":1459843474603,"createTimeStr":"4分钟前","id":5},{"seasonList":[{"title":"政治的道德基础","upInfo":25,"cover":"http://img.rrmj.tv/video/20160324/o_1458810628298.jpg","mark":"none","id":1450}],"requestUrl":"/video/search?cat=%E5%85%AC%E5%BC%80%E8%AF%BE","title":"公开课","displayType":"list","seasonNo":null,"createTime":1459843474725,"updateTime":1459843474725,"createTimeStr":"4分钟前","id":6}],"album":[{"requestUrl":"/video/album?albumId=2","coverUrl":"http://img.rrmj.tv/album/20160218/o_1455790673774.jpg","brief":"2016年最值得观看的剧集都会出现在这里","name":"2016新剧推荐","id":2}]}
     */

    private String code;
    private String msg;
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
        private List<Integer> adpos;
        /**
         * seasonList : [{"title":"黑暗料理","upInfo":7,"cover":"http://img.rrmj.tv/video/20160317/o_1458211122153.jpg","mark":"update","id":1332}]
         * requestUrl : /video/search?order=desc&sort=createTime&mark=update
         * title : 最新更新
         * displayType : flow
         * seasonNo : null
         * createTime : 1459843474236
         * updateTime : 1459843474236
         * createTimeStr : 4分钟前
         * id : 1
         */

        private List<IndexBean> index;
        /**
         * requestUrl : /video/album?albumId=2
         * coverUrl : http://img.rrmj.tv/album/20160218/o_1455790673774.jpg
         * brief : 2016年最值得观看的剧集都会出现在这里
         * name : 2016新剧推荐
         * id : 2
         */

        private List<AlbumBean> album;

        public List<Integer> getAdpos() {
            return adpos;
        }

        public void setAdpos(List<Integer> adpos) {
            this.adpos = adpos;
        }

        public List<IndexBean> getIndex() {
            return index;
        }

        public void setIndex(List<IndexBean> index) {
            this.index = index;
        }

        public List<AlbumBean> getAlbum() {
            return album;
        }

        public void setAlbum(List<AlbumBean> album) {
            this.album = album;
        }

        public static class IndexBean {
            private String requestUrl;
            private String title;
            private String displayType;
            private Object seasonNo;
            private long createTime;
            private long updateTime;
            private String createTimeStr;
            private int id;
            /**
             * title : 黑暗料理
             * upInfo : 7
             * cover : http://img.rrmj.tv/video/20160317/o_1458211122153.jpg
             * mark : update
             * id : 1332
             */

            private List<SeasonList> seasonList;

            public String getRequestUrl() {
                return requestUrl;
            }

            public void setRequestUrl(String requestUrl) {
                this.requestUrl = requestUrl;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDisplayType() {
                return displayType;
            }

            public void setDisplayType(String displayType) {
                this.displayType = displayType;
            }

            public Object getSeasonNo() {
                return seasonNo;
            }

            public void setSeasonNo(Object seasonNo) {
                this.seasonNo = seasonNo;
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

            public List<SeasonList> getSeasonList() {
                return seasonList;
            }

            public void setSeasonList(List<SeasonList> seasonList) {
                this.seasonList = seasonList;
            }

            public static class SeasonList {
                private String title;
                private int upInfo;
                private String cover;
                private String mark;
                private int id;
                private String cat;

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

                public String getMark() {
                    return mark;
                }

                public void setMark(String mark) {
                    this.mark = mark;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }
            }
        }

        public static class AlbumBean {
            private String requestUrl;
            private String coverUrl;
            private String brief;
            private String name;
            private int id;

            public String getRequestUrl() {
                return requestUrl;
            }

            public void setRequestUrl(String requestUrl) {
                this.requestUrl = requestUrl;
            }

            public String getCoverUrl() {
                return coverUrl;
            }

            public void setCoverUrl(String coverUrl) {
                this.coverUrl = coverUrl;
            }

            public String getBrief() {
                return brief;
            }

            public void setBrief(String brief) {
                this.brief = brief;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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
