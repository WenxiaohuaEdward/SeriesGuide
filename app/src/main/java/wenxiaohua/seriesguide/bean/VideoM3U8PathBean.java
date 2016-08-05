package wenxiaohua.seriesguide.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hexun on 2016/8/2.
 */
public class VideoM3U8PathBean implements Serializable{


    /**
     * code : 0000
     * msg :
     * data : {"account":{"plat":"","accountName":"","password":""},"m3u8":{"parserType":"DIRECT","url":"http://api1.rrmj.tv/test/baidu/ac.php?vid=CNTMxNzI4MA==&format=hd&t=1470193232465&sign=YWRmYzg4NjBmM2RiZGY0Y2ZlNjA1YTFkNWQwZDQxZmUyNDg1YzIwMA%3D%3D","currentQuality":"high","qualityArr":["low","high","super"],"source":""},"episodeList":[{"sid":"23279","site":null,"text":null,"episodeNo":1,"id":23279},{"sid":"23280","site":null,"text":null,"episodeNo":2,"id":23280},{"sid":"23281","site":null,"text":null,"episodeNo":3,"id":23281},{"sid":"23282","site":null,"text":null,"episodeNo":4,"id":23282},{"sid":"23283","site":null,"text":null,"episodeNo":5,"id":23283},{"sid":"23284","site":null,"text":null,"episodeNo":6,"id":23284},{"sid":"23285","site":null,"text":null,"episodeNo":7,"id":23285},{"sid":"23286","site":null,"text":null,"episodeNo":8,"id":23286},{"sid":"23287","site":null,"text":null,"episodeNo":9,"id":23287},{"sid":"23288","site":null,"text":null,"episodeNo":10,"id":23288}]}
     */

    private String code;
    private String msg;
    /**
     * account : {"plat":"","accountName":"","password":""}
     * m3u8 : {"parserType":"DIRECT","url":"http://api1.rrmj.tv/test/baidu/ac.php?vid=CNTMxNzI4MA==&format=hd&t=1470193232465&sign=YWRmYzg4NjBmM2RiZGY0Y2ZlNjA1YTFkNWQwZDQxZmUyNDg1YzIwMA%3D%3D","currentQuality":"high","qualityArr":["low","high","super"],"source":""}
     * episodeList : [{"sid":"23279","site":null,"text":null,"episodeNo":1,"id":23279},{"sid":"23280","site":null,"text":null,"episodeNo":2,"id":23280},{"sid":"23281","site":null,"text":null,"episodeNo":3,"id":23281},{"sid":"23282","site":null,"text":null,"episodeNo":4,"id":23282},{"sid":"23283","site":null,"text":null,"episodeNo":5,"id":23283},{"sid":"23284","site":null,"text":null,"episodeNo":6,"id":23284},{"sid":"23285","site":null,"text":null,"episodeNo":7,"id":23285},{"sid":"23286","site":null,"text":null,"episodeNo":8,"id":23286},{"sid":"23287","site":null,"text":null,"episodeNo":9,"id":23287},{"sid":"23288","site":null,"text":null,"episodeNo":10,"id":23288}]
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
         * plat :
         * accountName :
         * password :
         */

        private AccountBean account;
        /**
         * parserType : DIRECT
         * url : http://api1.rrmj.tv/test/baidu/ac.php?vid=CNTMxNzI4MA==&format=hd&t=1470193232465&sign=YWRmYzg4NjBmM2RiZGY0Y2ZlNjA1YTFkNWQwZDQxZmUyNDg1YzIwMA%3D%3D
         * currentQuality : high
         * qualityArr : ["low","high","super"]
         * source :
         */

        private M3u8Bean m3u8;
        /**
         * sid : 23279
         * site : null
         * text : null
         * episodeNo : 1
         * id : 23279
         */

        private List<EpisodeListBean> episodeList;

        public AccountBean getAccount() {
            return account;
        }

        public void setAccount(AccountBean account) {
            this.account = account;
        }

        public M3u8Bean getM3u8() {
            return m3u8;
        }

        public void setM3u8(M3u8Bean m3u8) {
            this.m3u8 = m3u8;
        }

        public List<EpisodeListBean> getEpisodeList() {
            return episodeList;
        }

        public void setEpisodeList(List<EpisodeListBean> episodeList) {
            this.episodeList = episodeList;
        }

        public static class AccountBean {
            private String plat;
            private String accountName;
            private String password;

            public String getPlat() {
                return plat;
            }

            public void setPlat(String plat) {
                this.plat = plat;
            }

            public String getAccountName() {
                return accountName;
            }

            public void setAccountName(String accountName) {
                this.accountName = accountName;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }
        }

        public static class M3u8Bean {
            private String parserType;
            private String url;
            private String currentQuality;
            private String source;
            private List<String> qualityArr;

            public String getParserType() {
                return parserType;
            }

            public void setParserType(String parserType) {
                this.parserType = parserType;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCurrentQuality() {
                return currentQuality;
            }

            public void setCurrentQuality(String currentQuality) {
                this.currentQuality = currentQuality;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public List<String> getQualityArr() {
                return qualityArr;
            }

            public void setQualityArr(List<String> qualityArr) {
                this.qualityArr = qualityArr;
            }
        }

        public static class EpisodeListBean {
            private String sid;
            private Object site;
            private Object text;
            private int episodeNo;
            private int id;

            public String getSid() {
                return sid;
            }

            public void setSid(String sid) {
                this.sid = sid;
            }

            public Object getSite() {
                return site;
            }

            public void setSite(Object site) {
                this.site = site;
            }

            public Object getText() {
                return text;
            }

            public void setText(Object text) {
                this.text = text;
            }

            public int getEpisodeNo() {
                return episodeNo;
            }

            public void setEpisodeNo(int episodeNo) {
                this.episodeNo = episodeNo;
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
