package wenxiaohua.seriesguide.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baidu.mobads.AppActivity;
import com.baidu.mobads.SplashAd;
import com.baidu.mobads.SplashAdListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringListener;
import com.facebook.rebound.SpringSystem;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.utils.SpringUtil;

/**
 * Created by hexun on 2016/8/18.
 */
public class LauncherActivity extends BaseActivity implements SpringListener {
    @Bind(R.id.launcher_root_ll)
     ViewGroup adsParent ;
    @Bind(R.id.launcher_iv)
     ImageView launcherIv;



    private void initSpring() {
        SpringSystem mSpringSystem = SpringSystem.create();
        final Spring mSpring = mSpringSystem.createSpring();
        mSpring.addListener(this);
        adsParent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // When pressed start solving the spring to 1.
                        mSpring.setEndValue(1);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // When released start solving the spring to 0.
                        mSpring.setEndValue(0);
                        break;
                }
                return true;
            }
        });
    }
    //实现SpringListener接口，需要实现下面方法
    @Override
    public void onSpringUpdate(Spring spring) {
        float scale = (float)SpringUtil.mapValueFromRangeToRange(spring.getCurrentValue(), 0, 1, 1, 0.5);
        launcherIv.setScaleX(scale);
        launcherIv.setScaleY(scale);
    }
    @Override
    public void onSpringAtRest(Spring spring) {
    }
    @Override
    public void onSpringActivate(Spring spring) {
    }
    @Override
    public void onSpringEndStateChange(Spring spring) {
    }
    private void initAds() {
        AppActivity.setActionBarColorTheme(AppActivity.ActionBarColorTheme.ACTION_BAR_BLUE_THEME);
        SplashAdListener listener=new SplashAdListener() {
            @Override
            public void onAdDismissed() {
                Log.i("RSplashActivity", "onAdDismissed");
                jump();// 跳转至您的应用主界面
            }
            @Override
            public void onAdFailed(String arg0) {
                Log.i("RSplashActivity", "onAdFailed");
                jump();
            }
            @Override
            public void onAdPresent() {
                Log.i("RSplashActivity", "onAdPresent");
            }
            @Override
            public void onAdClick() {
                Log.i("RSplashActivity", "onAdClick");
//设置开屏可接受点击时，该回调可用
            }
        };
        String adPlaceId = "cbc534e5";//重要：请填上你的代码位ID,否则无法请求到广告
        new SplashAd(this, adsParent, listener, adPlaceId, true);

    }

    private void jump() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void initView() {
        initSpring();
        jump();
    }

    @Override
    protected void initData() {

    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void bindView(Bundle savedInstanceState) {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_launcher;
    }
}
