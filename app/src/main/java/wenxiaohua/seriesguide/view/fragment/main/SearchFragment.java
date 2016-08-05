package wenxiaohua.seriesguide.view.fragment.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.IndexBean;
import wenxiaohua.seriesguide.bean.SearchFragmentHotWord;
import wenxiaohua.seriesguide.bean.SeasonInfo;
import wenxiaohua.seriesguide.bean.SearchInfo;
import wenxiaohua.seriesguide.constant.SPConstants;
import wenxiaohua.seriesguide.impl.ISearchFragmentView;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.presenter.SearchFragmentPresenter;
import wenxiaohua.seriesguide.view.activity.VideoListActivity;
import wenxiaohua.seriesguide.view.adapter.SearchFragmentElvAdapter;
import wenxiaohua.seriesguide.view.fragment.BaseFragment;
import wenxiaohua.seriesguide.view.views.SearchEditText;

/**
 * Created by hexun on 2016/6/7.
 * 搜索
 */
public class SearchFragment extends BaseFragment implements ISearchFragmentView{
    @Bind(R.id.fragment_search_input_edittext)
    SearchEditText fragment_search_input_edittext;
    @Bind(R.id.fragment_search_elv)
    ExpandableListView fragment_search_elv;
    private ArrayList<IndexBean> resultList = new ArrayList<>();

    /**
     * 搜索状态
     */
    private enum SEARCH_STATUS {
        SEARCH_HOTWORD, SEARCH_EDITTEXT
    }
    private SEARCH_STATUS mSearchStatus = SEARCH_STATUS.SEARCH_HOTWORD;
    private SearchFragmentHotWord.DataBean hotWordData = new SearchFragmentHotWord.DataBean();
    SearchFragmentElvAdapter searchFragmentElvAdapter;
    private SearchInfo.DataBean data;
    SearchFragmentPresenter searchFragmentPresenter;
    private String page = "0";
    private String rows = "10";
    String childClickText;
    List<String> clickTextListFromSP = new ArrayList<>();
    IndexBean newIndexBean ;
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        searchFragmentPresenter  = (SearchFragmentPresenter)mPresenter;

        searchFragmentElvAdapter= new SearchFragmentElvAdapter(getActivity(),resultList);
        fragment_search_elv.setAdapter(searchFragmentElvAdapter);
        fragment_search_elv.setGroupIndicator(null);
        //设置不折叠。
        fragment_search_elv
                .setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent,
                                                View v, int groupPosition, long childPosition) {
                        return true;
                    }
                });
        fragment_search_elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                ArrayList<IndexBean> list = searchFragmentElvAdapter.getResultList();
                mSearchStatus = SEARCH_STATUS.SEARCH_HOTWORD;
                childClickText = list.get(groupPosition).values.get(childPosition);
//                searchFragmentPresenter.getSearchData(page, rows,childClickText,"");

                Intent clickTextIntent = new Intent(getActivity(), VideoListActivity.class);
                clickTextIntent.putExtra("videoTypeTitle", childClickText);
                getActivity().startActivity(clickTextIntent);
                return true;
            }
        });

        fragment_search_input_edittext.setOnKeyListener(new View.OnKeyListener() {//输入完后按键盘上的搜索键【回车键改为了搜索键】

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {//修改回车键功能
                    // 先隐藏键盘
                    ((InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(
                                    getActivity()
                                            .getCurrentFocus()
                                            .getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                    if (resultList != null) {
                        //显示最近搜索内容
                        if (resultList.get(1) != null) {
                            if (resultList.get(1).values.size() >= 5) {
                                resultList.get(1).values.remove(resultList.get(1).values.size() - 1);
                            }
                            resultList.get(1).values.add(0, fragment_search_input_edittext.getText().toString());
                        }
                        searchFragmentElvAdapter.setResultList(resultList);
                        searchFragmentElvAdapter.notifyDataSetChanged();

                        mSearchStatus = SEARCH_STATUS.SEARCH_EDITTEXT;
                        SharedPreferences sp = getActivity().getSharedPreferences(SPConstants.SP_SEARCH_CLICK_NAME, getActivity().MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        for (int i = 0; i < resultList.get(1).values.size(); i++) {
                            editor.putString(SPConstants.SEARCH_CLICK + "_" + i, resultList.get(1).values.get(i));
                        }
                        editor.commit();
                        //跳转到搜索结果界面
                        Intent searchTextIntent = new Intent(getActivity(), VideoListActivity.class);
                        searchTextIntent.putExtra("videoTypeTitle", fragment_search_input_edittext.getText().toString());
                        getActivity().startActivity(searchTextIntent);
//                    searchFragmentPresenter.getSearchData(page, rows, fragment_search_input_edittext.getText().toString(),"");


                        return true;
                    }
                    }
                    return false;
                }
        });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        searchFragmentPresenter.getHotWord();

    }

    @Override
    public BasePresenter getPresenter() {
        return new SearchFragmentPresenter();
    }

    @Override
    public void bindView(Bundle savedInstanceState) {

    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_search;
    }

    @Override
    public void getHotWordWithView(SearchFragmentHotWord.DataBean hotWordData) {
        this.hotWordData = hotWordData;
        IndexBean hotIndexBean = new IndexBean();
        hotIndexBean.key = "热门搜索";
        if (hotWordData!=null&&hotWordData.getWordList()!=null&&!hotWordData.getWordList().isEmpty()){
            hotIndexBean.values =hotWordData.getWordList();
            Log.e("SearchFragment",hotWordData.getWordList().toString());

        }
        resultList.add(hotIndexBean);

        for (int i = 0;i<5;i++) {
            if (!"".equals(getActivity().getSharedPreferences(SPConstants.SP_SEARCH_CLICK_NAME, getActivity().MODE_PRIVATE).getString(SPConstants.SEARCH_CLICK+"_"+i, ""))){
                clickTextListFromSP.add(getActivity().getSharedPreferences(SPConstants.SP_SEARCH_CLICK_NAME, getActivity().MODE_PRIVATE).getString(SPConstants.SEARCH_CLICK+"_"+i, ""));
            }
        }
        newIndexBean = new IndexBean();
        newIndexBean.key = "最近搜索";
        newIndexBean.values =clickTextListFromSP;
        resultList.add(newIndexBean);

        searchFragmentElvAdapter.setResultList(resultList);
        searchFragmentElvAdapter.notifyDataSetChanged();
        //设置全部展开
        for(int i = 0; i < searchFragmentElvAdapter.getGroupCount(); i++){
            fragment_search_elv.expandGroup(i);
        }
    }

    @Override
    public void getSearchDataWithView(SearchInfo.DataBean data) {
        this.data = data;
        ArrayList<SeasonInfo> mSeasonInfoList = new ArrayList<>();
        for (SearchInfo.DataBean.ResultsBean secrchInfo : data.getResults()){
            SeasonInfo seasonInfo = new SeasonInfo();
            seasonInfo.setTitle(secrchInfo.getTitle());
            seasonInfo.setCover(secrchInfo.getCover());
            seasonInfo.setId(secrchInfo.getId());
            seasonInfo.setBrief(secrchInfo.getBrief());
            seasonInfo.setViewCount(secrchInfo.getUpInfo());
            mSeasonInfoList.add(seasonInfo);
        }
        Intent videoList = new Intent(context,VideoListActivity.class);
        if (mSearchStatus == SEARCH_STATUS.SEARCH_EDITTEXT){
            videoList.putExtra("videoTypeTitle", fragment_search_input_edittext.getText().toString());
            videoList.putExtra("title", fragment_search_input_edittext.getText().toString());

        }else  if (mSearchStatus == SEARCH_STATUS.SEARCH_HOTWORD){
            videoList.putExtra("videoTypeTitle", childClickText);
            videoList.putExtra("title", childClickText);

        }
        videoList.putExtra("seasonListData", mSeasonInfoList);
        getActivity().startActivity(videoList);

    }
}
