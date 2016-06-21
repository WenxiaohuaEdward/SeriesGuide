package wenxiaohua.seriesguide.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hexun on 2016/6/16.
 */
public class VideoDetailCommentInfo implements Serializable{



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
        private int total;
        private int currentPage;
        /**
         * parentAuthor : null
         * oldSilverCount : null
         * isLiked : false
         * silverCount : null
         * likeCount : 0
         * parentContent :
         * author : {"headImgUrl":"","isConfirmed":false,"nickName":"+微信1245422202","roleInfo":null,"level":"1","createTime":1459844871414,"updateTime":1459844871414,"createTimeStr":"3分钟前","id":6798083}
         * content : 看不了的，想看完整版的可以看我名字
         * createTime : 1459841526000
         * updateTime : 1459841526000
         * createTimeStr : 59分钟前
         * id : 792426
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
            private Object parentAuthor;
            private Object oldSilverCount;
            private boolean isLiked;
            private Object silverCount;
            private int likeCount;
            private String parentContent;
            /**
             * headImgUrl :
             * isConfirmed : false
             * nickName : +微信1245422202
             * roleInfo : null
             * level : 1
             * createTime : 1459844871414
             * updateTime : 1459844871414
             * createTimeStr : 3分钟前
             * id : 6798083
             */

            private AuthorBean author;
            private String content;
            private long createTime;
            private long updateTime;
            private String createTimeStr;
            private int id;

            public Object getParentAuthor() {
                return parentAuthor;
            }

            public void setParentAuthor(Object parentAuthor) {
                this.parentAuthor = parentAuthor;
            }

            public Object getOldSilverCount() {
                return oldSilverCount;
            }

            public void setOldSilverCount(Object oldSilverCount) {
                this.oldSilverCount = oldSilverCount;
            }

            public boolean isIsLiked() {
                return isLiked;
            }

            public void setIsLiked(boolean isLiked) {
                this.isLiked = isLiked;
            }

            public Object getSilverCount() {
                return silverCount;
            }

            public void setSilverCount(Object silverCount) {
                this.silverCount = silverCount;
            }

            public int getLikeCount() {
                return likeCount;
            }

            public void setLikeCount(int likeCount) {
                this.likeCount = likeCount;
            }

            public String getParentContent() {
                return parentContent;
            }

            public void setParentContent(String parentContent) {
                this.parentContent = parentContent;
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
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

            public static class AuthorBean {
                private String headImgUrl;
                private boolean isConfirmed;
                private String nickName;
                private Object roleInfo;
                private String level;
                private long createTime;
                private long updateTime;
                private String createTimeStr;
                private int id;

                public String getHeadImgUrl() {
                    return headImgUrl;
                }

                public void setHeadImgUrl(String headImgUrl) {
                    this.headImgUrl = headImgUrl;
                }

                public boolean isIsConfirmed() {
                    return isConfirmed;
                }

                public void setIsConfirmed(boolean isConfirmed) {
                    this.isConfirmed = isConfirmed;
                }

                public String getNickName() {
                    return nickName;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
                }

                public Object getRoleInfo() {
                    return roleInfo;
                }

                public void setRoleInfo(Object roleInfo) {
                    this.roleInfo = roleInfo;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
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
            }
        }
    }
}
