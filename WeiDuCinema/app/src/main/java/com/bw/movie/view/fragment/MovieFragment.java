package com.bw.movie.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.application.App;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.bean.BannerBean;
import com.bw.movie.model.bean.ComingMovieBean;
import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.ReleaseMovieBean;
import com.bw.movie.presenter.HomePresenter;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.activity.DetailMovieActivity;
import com.bw.movie.view.activity.MoreActivity;
import com.bw.movie.view.activity.SeekActivity;
import com.bw.movie.view.adapter.MyComingAdapter;
import com.bw.movie.view.adapter.MyHotAdapter;
import com.bw.movie.view.adapter.MyReleaseAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-16
 * INTRODUCE：电影页面$
 */
public class MovieFragment extends BaseFragment<HomePresenter> implements HomeContract.IHomeView {
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.iv_seek)
    ImageView ivSeek;
    @BindView(R.id.xb_id)
    XBanner xbId;
    @BindView(R.id.tv_location_pic_num)
    TextView tvLocationPicNum;
    @BindView(R.id.tv_release_more)
    TextView tvReleaseMore;
    @BindView(R.id.rv_release)
    RecyclerView rvRelease;
    @BindView(R.id.tv_coming_more)
    TextView tvComingMore;
    @BindView(R.id.rv_coming)
    RecyclerView rvComing;
    @BindView(R.id.tv_hot_more)
    TextView tvHotMore;
    @BindView(R.id.rv_hot)
    RecyclerView rvHot;
    @BindView(R.id.sdv_big)
    SimpleDraweeView sdvBig;
    @BindView(R.id.tv_movie3_score)
    TextView tvMovie3Score;
    @BindView(R.id.tv_movie3_name)
    TextView tvMovie3Name;
    @BindView(R.id.but_big)
    Button butBig;
    @BindView(R.id.sumnum_tv)
    TextView sumnumTv;
    @BindView(R.id.rl_big)
    RelativeLayout rlBig;
    @BindView(R.id.srl_movie)
    SwipeRefreshLayout srlMovie;

    private MyReleaseAdapter myReleaseAdapter;
    private MyComingAdapter myComingAdapter;
    private MyHotAdapter myHotAdapter;

    private int hotbig_movieId;
    private List<BannerBean.ResultBean> result;

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new MyAMapLocationListener();
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;

    private boolean isRefresh = false;//是否刷新中


    @Override
    public int provideLayoutId() {
        return R.layout.fragment_movie;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void inintView() {
        super.inintView();

        myReleaseAdapter = new MyReleaseAdapter(getActivity());
        myComingAdapter = new MyComingAdapter(getActivity());
        myHotAdapter = new MyHotAdapter(getActivity());
    }

    @Override
    protected void initData() {
        super.initData();

        rvRelease.setAdapter(myReleaseAdapter);
        rvRelease.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        rvComing.setAdapter(myComingAdapter);
        rvComing.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));

        rvHot.setAdapter(myHotAdapter);
        rvHot.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        //设置item间距
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(10);
        rvRelease.addItemDecoration(spacesItemDecoration);
        rvHot.addItemDecoration(spacesItemDecoration);
        if (!hasNetWrok()) {
            showNoNetTip();
        } else {
            mPresenter.getBanner();
            mPresenter.getRelease(1, 5);
            mPresenter.getComing(1, 3);
            mPresenter.getHot(1, 5);

            xbId.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    tvLocationPicNum.setText(position + 1 + "/");
                }

                @Override
                public void onPageSelected(int position) {

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

            xbId.setOnItemClickListener(new XBanner.OnItemClickListener() {
                @Override
                public void onItemClick(XBanner banner, int position) {

                    String jumpUrl = result.get(position).getJumpUrl();
                    if (jumpUrl.startsWith("wd://")) {
                        //?为关键字需转义
                        String[] split = jumpUrl.split("\\?");
                        String[] split1 = split[split.length - 1].split("=");
                        Intent detail_movieId = new Intent(getActivity(), DetailMovieActivity.class);
                        ;
                        detail_movieId.putExtra("movieId", Integer.valueOf(split1[split1.length - 1]));
                        startActivity(detail_movieId);
                    }

                }
            });


            //点击预约和点击查看电影详情
            myComingAdapter.setCallBack(new MyComingAdapter.ComingCallBack() {
                @Override
                public void onResereve(int movieId, View v) {
                    if (v instanceof CheckBox) {
                        CheckBox box = (CheckBox) v;
                        box.setText("已预约");
                        box.setChecked(true);
                        mPresenter.postReserve(movieId);
                    } else {
                        Intent detail_movieId = new Intent(getActivity(), DetailMovieActivity.class);
                        ;
                        detail_movieId.putExtra("movieId", movieId);
                        startActivity(detail_movieId);
                    }
                }
            });

            myReleaseAdapter.setCallBack(new MyReleaseAdapter.IReleaseCallBack() {
                @Override
                public void onDetailMovieId(int movieId) {
                    Intent detail_movieId = new Intent(getActivity(), DetailMovieActivity.class);
                    ;
                    detail_movieId.putExtra("movieId", movieId);
                    startActivity(detail_movieId);
                }
            });

            myHotAdapter.setCallBack(new MyReleaseAdapter.IReleaseCallBack() {
                @Override
                public void onDetailMovieId(int movieId) {
                    Intent detail_movieId = new Intent(getActivity(), DetailMovieActivity.class);
                    ;
                    detail_movieId.putExtra("movieId", movieId);
                    startActivity(detail_movieId);
                }
            });

            //获取位置
            init();
        }

        //设置下拉颜色
        srlMovie.setColorSchemeColors(Color.RED,Color.BLUE);

        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        srlMovie.setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        srlMovie.setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        srlMovie.setSize(SwipeRefreshLayout.LARGE);

        srlMovie.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //检查是否处于刷新状态
                if (!isRefresh) {
                    isRefresh = true;
                    //模拟加载网络数据，这里设置4秒，正好能看到4色进度条
                    new Handler().postDelayed(new Runnable() {
                        public void run() {

                            //显示或隐藏刷新进度条
                            srlMovie.setRefreshing(false);
                            isRefresh = false;
                            mPresenter.getBanner();
                            Random random = new Random();
                            int page = random.nextInt(2);
                            mPresenter.getRelease(page+1, 5);
                            mPresenter.getComing(1, 3);
                            mPresenter.getHot(page+1, 5);
                        }
                    }, 2000);
                }
            }
        });


    }

    @Override
    public void onBannerSuccess(BannerBean bannerBean) {
        Log.i("log_banner", bannerBean.getMessage());
        result = bannerBean.getResult();
        //设置xbanner的图片总数
        sumnumTv.setText(String.valueOf(result.size()));
        ArrayList<String> image_list = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            image_list.add(result.get(i).getImageUrl());
        }
        //设置数据
        xbId.setData(image_list, null);
        //设置适配器
        xbId.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity())
                        .load(image_list.get(position))
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .into((ImageView) view);
            }
        });
        // 设置XBanner的页面切换特效
        //xbId.setPageTransformer(Transformer.Default);
        // 设置XBanner页面切换的时间，即动画时长
        //xbId.setPageChangeDuration(1000);

    }

    @Override
    public void onReleaseSuccess(ReleaseMovieBean releaseMovieBean) {
        Log.i("release_log", releaseMovieBean.getMessage());
        List<ReleaseMovieBean.ResultBean> result = releaseMovieBean.getResult();
        myReleaseAdapter.setList(result);
    }

    @Override
    public void onComingSuccess(ComingMovieBean comingMovieBean) {
        Log.i("release_log", comingMovieBean.getMessage());
        List<ComingMovieBean.ResultBean> result = comingMovieBean.getResult();
        myComingAdapter.setList(result);
    }

    @Override
    public void onHotSuccess(HotMovieBean hotMovieBean) {
        Log.i("release_log", hotMovieBean.getMessage());
        List<HotMovieBean.ResultBean> result = hotMovieBean.getResult();
        sdvBig.setImageURI(Uri.parse(result.get(0).getHorizontalImage()));
        tvMovie3Name.setText(result.get(0).getName());
        tvMovie3Score.setText(result.get(0).getScore() + "分");
        hotbig_movieId = result.get(0).getMovieId();
        myHotAdapter.setList(result);
    }

    @Override
    public void onReserveSuccess(LoginBean loginBean) {
        Log.i("release_log", loginBean.getMessage());
        Toast.makeText(getActivity(), loginBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err", e.getMessage() + "异常");
    }


    @Override
    public void onResume() {
        super.onResume();
        xbId.startAutoPlay();
    }


    @Override
    public void onStop() {
        super.onStop();
        xbId.stopAutoPlay();
    }

    @OnClick({R.id.tv_release_more, R.id.tv_coming_more, R.id.tv_hot_more, R.id.tv_location, R.id.iv_seek, R.id.but_big, R.id.rl_big})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_release_more:
                //跳转到更多页面,并在更多页面显示热映电影
                Intent release_more = new Intent(getActivity(), MoreActivity.class);
                release_more.putExtra("more", 1);
                startActivity(release_more);
                break;
            case R.id.tv_coming_more:
                //跳转到更多页面,并在更多页面显示即将上映电影
                Intent coming_more = new Intent(getActivity(), MoreActivity.class);
                coming_more.putExtra("more", 2);
                startActivity(coming_more);
                break;
            case R.id.tv_hot_more:
                //跳转到更多页面,并在更多页面显示热门电影
                Intent hot_more = new Intent(getActivity(), MoreActivity.class);
                hot_more.putExtra("more", 3);
                startActivity(hot_more);
                break;
            case R.id.tv_location:
                break;
            case R.id.iv_seek:
                //跳转到搜索页面
                Intent intent = new Intent(getActivity(), SeekActivity.class);
                intent.putExtra("isM", 1);
                startActivity(intent);
                break;
            case R.id.but_big:
                break;
            case R.id.rl_big:
                Intent detail_movieId = new Intent(getActivity(), DetailMovieActivity.class);
                ;
                detail_movieId.putExtra("movieId", hotbig_movieId);
                startActivity(detail_movieId);
                break;
        }
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
        mLocationOption.setInterval(1000 * 60 * 20);
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
                    tvLocation.setText(aMapLocation.getCity());
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
