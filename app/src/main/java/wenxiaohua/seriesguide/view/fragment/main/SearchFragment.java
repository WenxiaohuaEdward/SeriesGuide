package wenxiaohua.seriesguide.view.fragment.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.SearchFragmentElvBean;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.presenter.SearchFragmentPersenter;
import wenxiaohua.seriesguide.view.adapter.SearchFragmentElvAdapter;
import wenxiaohua.seriesguide.view.fragment.BaseFragment;
import wenxiaohua.seriesguide.view.views.SearchEditText;

/**
 * Created by hexun on 2016/6/7.
 * 搜索
 */
public class SearchFragment extends BaseFragment {
    @Bind(R.id.fragment_search_input_edittext)
    SearchEditText fragment_search_input_edittext;
    @Bind(R.id.fragment_search_elv)
    ExpandableListView fragment_search_elv;
    private ArrayList<SearchFragmentElvBean> resultList = new ArrayList<>();

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        SearchFragmentElvBean r = new SearchFragmentElvBean();
        r.key = "热门搜索";
        ArrayList<String> rList = new ArrayList<>();
        rList.add("行尸走肉");
        rList.add("行尸走肉");
        rList.add("行尸走肉");
        rList.add("行尸走肉");
        r.values = rList;
        SearchFragmentElvBean l = new SearchFragmentElvBean();
        l.key = "最近搜索";
        ArrayList<String> lList = new ArrayList<>();
        lList.add("行尸走肉");
       lList.add("行尸走肉");
        lList.add("行尸走肉");
        lList.add("行尸走肉");
        l.values = lList;
        resultList.add(r);
        resultList.add(l);
        SearchFragmentElvAdapter searchFragmentElvAdapter = new SearchFragmentElvAdapter(getActivity(),resultList);
        fragment_search_elv.setAdapter(searchFragmentElvAdapter);
        fragment_search_elv.setGroupIndicator(null);
        //设置全部展开
        for(int i = 0; i < searchFragmentElvAdapter.getGroupCount(); i++){
            fragment_search_elv.expandGroup(i);
        }
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public BasePresenter getPresenter() {
        return new SearchFragmentPersenter();
    }

    @Override
    public void bindView(Bundle savedInstanceState) {

    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_search;
    }
}
