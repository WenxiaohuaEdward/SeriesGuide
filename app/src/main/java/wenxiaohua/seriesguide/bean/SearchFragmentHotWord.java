package wenxiaohua.seriesguide.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hexun on 2016/6/13.
 */
public class SearchFragmentHotWord implements Serializable{

    /**
     * code : 0000
     * msg :
     * data : {"wordList":["行尸走肉","吸血鬼日记","生活大爆炸","破产姐妹","神盾局特工","权力的游戏","无耻之徒","闪电侠","初代吸血鬼","格林"]}
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
        private List<String> wordList;

        public List<String> getWordList() {
            return wordList;
        }

        public void setWordList(List<String> wordList) {
            this.wordList = wordList;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "wordList=" + wordList +
                    '}';
        }
    }
}
