package wenxiaohua.seriesguide.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;
import wenxiaohua.seriesguide.impl.IBaseView;
import wenxiaohua.seriesguide.inter.IBase;
import wenxiaohua.seriesguide.presenter.BasePresenter;

/**
 * Created by hexun on 2016/6/7.
 */
public abstract class BaseFragment<T extends BasePresenter<IBaseView>> extends Fragment implements IBase {

    public View view;
    public Context context;
    public BasePresenter mPresenter;
    public View mRootView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        mPresenter = getPresenter();
        if (mPresenter != null && this instanceof IBaseView) {
            mPresenter.attach((IBaseView) this);
        }
        super.onCreate(savedInstanceState);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(this.getClass().getSimpleName()); //统计页面，"MainScreen"为页面名称，可自定义
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(this.getClass().getSimpleName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = createView(inflater, container, savedInstanceState);
        }
        context = mRootView.getContext();
        return mRootView;
    }
    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getContentLayout(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    @Nullable
    @Override
    public View getView() {
        return mRootView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        initView(view, savedInstanceState);
    }
    @Override
    public void onDestroy() {
        if (mPresenter != null && this instanceof IBaseView) {
            mPresenter.detachView();
            mPresenter = null;
        }
        context = null;
        super.onDestroy();
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        initData(savedInstanceState);
        super.onActivityCreated(savedInstanceState);
    }

    protected abstract void initView(View view, Bundle savedInstanceState);

    protected abstract void initData(Bundle savedInstanceState);
}
