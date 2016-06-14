package wenxiaohua.seriesguide.view.fragment.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.IndexBean;
import wenxiaohua.seriesguide.bean.SearchFragmentHotWord;
import wenxiaohua.seriesguide.impl.ISearchFragmentView;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.presenter.SearchFragmentPresenter;
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

    private SearchFragmentHotWord.DataBean hotWordData = new SearchFragmentHotWord.DataBean();
    SearchFragmentElvAdapter searchFragmentElvAdapter;
    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        searchFragmentElvAdapter= new SearchFragmentElvAdapter(getActivity(),resultList);
        fragment_search_elv.setAdapter(searchFragmentElvAdapter);
        fragment_search_elv.setGroupIndicator(null);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        SearchFragmentPresenter searchFragmentPresenter = (SearchFragmentPresenter)mPresenter;
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
        IndexBean r = new IndexBean();
        r.key = "热门搜索";
        if (hotWordData!=null&&hotWordData.getWordList()!=null&&!hotWordData.getWordList().isEmpty()){
            r.values =hotWordData.getWordList();
            Log.e("SearchFragment",hotWordData.getWordList().toString());

        }
        resultList.add(r);
        searchFragmentElvAdapter.setResultList(resultList);
        searchFragmentElvAdapter.notifyDataSetChanged();
        //设置全部展开
        for(int i = 0; i < searchFragmentElvAdapter.getGroupCount(); i++){
            fragment_search_elv.expandGroup(i);
        }
    }
}
