package wenxiaohua.seriesguide.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import wenxiaohua.seriesguide.impl.IBaseView;
import wenxiaohua.seriesguide.inter.IBase;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.utils.AppManagerUtils;
import wenxiaohua.seriesguide.utils.ContextUtils;

/**
 * Created by hexun on 2016/6/7.
 */
public abstract class BaseActivity< T extends BasePresenter<IBaseView>> extends AppCompatActivity implements IBase{

    private long mUIThreadId; //UI线程ID
    View mRootView ;
    protected BasePresenter mPresenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUIThreadId = android.os.Process.myTid();
        AppManagerUtils.getAppManager().addActivity(this);
        mPresenter = getPresenter();
        if (mPresenter != null && this instanceof IBaseView) {
            mPresenter.attach((IBaseView) this);
        }
        getIntentValue();
        mRootView  = createView(null, null, savedInstanceState);
        setContentView(mRootView);
        setActionBar();
        bindView(savedInstanceState);
        initView();
        initData();
    }
    public void onResume() {
        super.onResume();

    }

    public void onPause() {
        super.onPause();

    }
    public void setActionBar() {

    }

    public void getIntentValue() {

    }
    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = ContextUtils.inflate(this, getContentLayout());
        ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public View getView() {
        return mRootView;
    }
    @Override
    protected void onNewIntent(Intent intent) {
        mUIThreadId = android.os.Process.myTid();
        super.onNewIntent(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManagerUtils.getAppManager().finishActivity(this);
        if (mPresenter != null && this instanceof IBaseView) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }
    /**
     * 是否设置沉浸式
     *
     * @return
     */
    protected boolean isSetStatusBar() {
        return false;
    }
    /**
     * 初始化 View。
     */
    protected abstract void initView();

    /**
     * 对 View 进行数据填充。
     */
    protected abstract void initData();

}
