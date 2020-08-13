package com.bw.movie.view.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bw.movie.R;
import com.bw.movie.application.App;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.event.AddEvent;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.bw.movie.view.activity.SeekActivity;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-16
 * INTRODUCE：影院页面$
 */
public class CinemaFragment extends BaseFragment {
    @BindView(R.id.tv_location_cinema)
    TextView tvLocationCinema;
    @BindView(R.id.iv_seek_cinema)
    ImageView ivSeekCinema;
    @BindView(R.id.tl_cinema)
    TabLayout tlCinema;
    @BindView(R.id.vp_cinema)
    ViewPager vpCinema;

    private List<String> title_cinema = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new MyAMapLocationListener();
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;

    @Override
    public int provideLayoutId() {
        return R.layout.fragment_cinema;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void inintView() {


        title_cinema.add("推荐影院");
        title_cinema.add("附近影院");
        title_cinema.add("海淀区");


        fragments.add(new RecommendFragment());
        fragments.add(new NearbyFragment());
        fragments.add(new AddressFragment());

    }

    @Override
    protected void initData() {
        super.initData();

        tlCinema.setupWithViewPager(vpCinema);
        vpCinema.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title_cinema.get(position);
            }
        });

        if (!hasNetWrok()) {
            showNoNetTip();
        } else {
            init();
        }

    }

    @OnClick(R.id.iv_seek_cinema)
    public void onViewClicked() {
        //跳转到搜索页面
        Intent intent = new Intent(getActivity(), SeekActivity.class);
        intent.putExtra("isM", 2);
        startActivity(intent);
    }

    private void init() {
        //初始化定位
        mLocationClient = new AMapLocationClient(App.getInstance());
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
//初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
//设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//获取一次定位结果：
//该方法默认为false。
        mLocationOption.setOnceLocation(false);
//获取最近3s内精度最高的一次定位结果：
        mLocationOption.setInterval(1000*60*20);
//设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        mLocationOption.setOnceLocationLatest(true);
//设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
//设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
//关闭缓存机制
        mLocationOption.setLocationCacheEnable(false);
//给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
//启动定位
        mLocationClient.startLocation();
    }

    private class MyAMapLocationListener implements AMapLocationListener {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {
                    String address = aMapLocation.getAddress();
                    tvLocationCinema.setText(aMapLocation.getCity());
                    double latitude = aMapLocation.getLatitude();//获取纬度
                    double longitude = aMapLocation.getLongitude();//获取经度
                    aMapLocation.getCountry();//国家信息
                    aMapLocation.getProvince();//省信息
                    aMapLocation.getCity();//城市信息
                    aMapLocation.getDistrict();//城区信息
                    aMapLocation.getStreet();//街道信息
                    aMapLocation.getStreetNum();//街道门牌号信息
                    aMapLocation.getCityCode();//城市编码
                    aMapLocation.getAdCode();//地区编码


                    Log.e("位置：", aMapLocation.getAddress() + "纬度:" + latitude + ",经度:" + longitude);
                    //保存经纬度
                    SharedPreferences.Editor editor = SharedPreferencesUtils.getInstance().putData();
                    editor.putString("jinwei",longitude+","+latitude);
                    editor.apply();
                } else {
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError", "location Error, ErrCode:"
                            + aMapLocation.getErrorCode() + ", errInfo:"
                            + aMapLocation.getErrorInfo());
                }
            }
        }
    }

}
