package wenxiaohua.seriesguide.view.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.networkbench.agent.impl.NBSAppAgent;

import java.util.ArrayList;

import butterknife.Bind;
import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.constant.AppKeyConstants;
import wenxiaohua.seriesguide.impl.IMainView;
import wenxiaohua.seriesguide.presenter.BasePresenter;
import wenxiaohua.seriesguide.presenter.MainPresenter;
import wenxiaohua.seriesguide.view.adapter.FragmentAdapter;
import wenxiaohua.seriesguide.view.fragment.main.DiscoverFragment;
import wenxiaohua.seriesguide.view.fragment.main.LikeFragment;
import wenxiaohua.seriesguide.view.fragment.main.SearchFragment;
import wenxiaohua.seriesguide.view.views.NoScrollViewPager;

public class MainActivity extends BaseActivity implements IMainView, View.OnClickListener {

    @Bind(R.id.main_toolbar)
    Toolbar main_toolbar;
    @Bind(R.id.main_viewpager)
    NoScrollViewPager main_viewpager;
    @Bind(R.id.main_radiogroup)
    RadioGroup main_radiogroup;
    @Bind(R.id.main_like_radiobutton)
    RadioButton main_like_radiobutton;
    @Bind(R.id.main_discover_radiobutton)
    RadioButton main_discover_radiobutton;
    @Bind(R.id.main_search_radiobutton)
    RadioButton main_search_radiobutton;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private ArrayList<String> titleList =new ArrayList<String>();



    @Override
    protected void initView() {
        //听云APP初始化
        NBSAppAgent.setLicenseKey(AppKeyConstants.TINGYUN_APPKEY).withLocationServiceEnabled(true).start(this.getApplicationContext());
        fragmentList.add(new LikeFragment());
        fragmentList.add(new DiscoverFragment());
        fragmentList.add(new SearchFragment());
        titleList.add("喜欢");
        titleList.add("发现");
        titleList.add("搜索");
        final FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),fragmentList,titleList);

        main_viewpager.setAdapter(fragmentAdapter);
        main_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                main_toolbar.setTitle(fragmentAdapter.getPageTitle(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        main_toolbar.setTitle("发现");
        main_viewpager.setCurrentItem(1, true);
        main_viewpager.setOffscreenPageLimit(2);
        main_like_radiobutton.setOnClickListener(this);
        main_discover_radiobutton.setOnClickListener(this);
        main_search_radiobutton.setOnClickListener(this);
        main_viewpager.setNoScroll(true);

//        checkVersion();


    }
//
//    private void checkVersion() {
//        try {
//            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
//            SharedPreferences sp = getSharedPreferences(SPConstants.SP_APP_VERSION , MODE_PRIVATE);
//            SharedPreferences.Editor editor = sp.edit();
//            if (sp.getInt(SPConstants.SP_APP_VERSION_CODE,0) ==0){
//                editor.putInt(SPConstants.SP_APP_VERSION_CODE, packageInfo.versionCode);
//                editor.putString(SPConstants.SP_APP_VERSION_NAME, packageInfo.versionName);
//                editor.putString(SPConstants.SP_APP_VERSION_RELEASENOTES,packageInfo.packageName);
//                editor.commit();
//            }else if(sp.getInt(SPConstants.SP_APP_VERSION_CODE,0)< packageInfo.versionCode){
//                if(isWifi(this)){
//                    Toast.makeText(this, "下载APK", Toast.LENGTH_LONG);
//                }
//                editor.putInt(SPConstants.SP_APP_VERSION_CODE, packageInfo.versionCode);
//                editor.putString(SPConstants.SP_APP_VERSION_NAME, packageInfo.versionName);
//                editor.putString(SPConstants.SP_APP_VERSION_RELEASENOTES,packageInfo.packageName);
//                editor.commit();
//                UpdateVersionUtils.getInstance(this);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * make true current connect service is wifi
     * @param mContext
     * @return
     */
    private static boolean isWifi(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null
                && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }
    @Override
    protected void initData() {

    }

    @Override
    public BasePresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    public void bindView(Bundle savedInstanceState) {
        Log.v("bindView", "bindView");
    }


    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==main_like_radiobutton.getId()){
            main_viewpager.setCurrentItem(0,true);
        }else if(v.getId()==main_discover_radiobutton.getId()){
            main_viewpager.setCurrentItem(1,true);
        }else if(v.getId()==main_search_radiobutton.getId()){
            main_viewpager.setCurrentItem(2,true);
        }
    }
}
