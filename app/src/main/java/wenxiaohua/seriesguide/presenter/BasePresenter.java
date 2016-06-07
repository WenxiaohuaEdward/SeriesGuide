package wenxiaohua.seriesguide.presenter;

import wenxiaohua.seriesguide.impl.IBaseView;

public abstract class BasePresenter<T extends IBaseView> {
    public T mView;

    public void attach(T mView) {
        this.mView = mView;
    }

    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }
}
