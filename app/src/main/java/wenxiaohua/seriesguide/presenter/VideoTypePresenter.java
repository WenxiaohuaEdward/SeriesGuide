package wenxiaohua.seriesguide.presenter;

import wenxiaohua.seriesguide.impl.IVideoTypeView;
import wenxiaohua.seriesguide.model.VideoTypeModel;
import wenxiaohua.seriesguide.model.impl.IVideoTypeModel;

/**
 * Created by hexun on 2016/6/15.
 */
public class VideoTypePresenter extends BasePresenter<IVideoTypeView> {
    private final IVideoTypeModel mIVideoTypeModel;

    public VideoTypePresenter() {
        mIVideoTypeModel = new VideoTypeModel();
    }
}
