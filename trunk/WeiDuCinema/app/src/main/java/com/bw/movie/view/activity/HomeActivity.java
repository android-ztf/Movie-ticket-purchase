package com.bw.movie.view.activity;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bw.movie.R;
import com.bw.movie.application.App;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.bean.mine.NewVersionBean;
import com.bw.movie.model.greendao.Address;
import com.bw.movie.presenter.MinePresenter;
import com.bw.movie.utils.ConfigurationUtil;
import com.bw.movie.utils.Utils;
import com.bw.movie.utils.VersionUtils;
import com.bw.movie.view.fragment.CinemaFragment;
import com.bw.movie.view.fragment.MineFragment;
import com.bw.movie.view.fragment.MovieFragment;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;

public class HomeActivity extends BaseActivity<MinePresenter> implements MineContract.IMineView {

    @BindView(R.id.vp_id)
    ViewPager vpId;
    @BindView(R.id.rb_movie)
    RadioButton rbMovie;
    @BindView(R.id.rb_cinema)
    RadioButton rbCinema;
    @BindView(R.id.rb_mine)
    RadioButton rbMine;
    @BindView(R.id.rg_id)
    RadioGroup rgId;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_home;
    }


    @Override
    protected void initView() {
        super.initView();

//        //定义底部标签图片大小和位置
//        Drawable drawable_news = getResources().getDrawable(R.drawable.movie_select);
//        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
//        drawable_news.setBounds(50, 0, 50, 50);
//        //设置图片在文字的哪个方向
//        rbMovie.setCompoundDrawables(drawable_news, null,null, null);
//        //vie.setC

    }

    @Override
    protected void initData() {
        super.initData();

        //无网吐司
        if (!hasNetWork()){
            showNoNetTip();
        }else{

            ArrayList<Fragment> list = new ArrayList<>();
            list.clear();
            list.add(new MovieFragment());
            list.add(new CinemaFragment());
            list.add(new MineFragment());

            //viewpagets设置适配器
            vpId.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    return list.get(position);
                }

                @Override
                public int getCount() {
                    return list.size();
                }
            });
            //viewpager滑动监听
            vpId.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    rgId.check(rgId.getChildAt(position).getId());
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

            //单选按钮改变监听
            rgId.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    for (int i = 0; i < group.getChildCount(); i++) {
                        if (group.getChildAt(i).getId()==checkedId){
                            vpId.setCurrentItem(i);
                        }
                    }

                    switch (checkedId){
                        case R.id.rb_movie:
                            vpId.setCurrentItem(0);
                            rbMovie.setText("电影");
                            rbCinema.setText(null);
                            rbMine.setText(null);
                            break;
                        case R.id.rb_cinema:
                            vpId.setCurrentItem(1);
                            rbMovie.setText(null);
                            rbCinema.setText("影院");
                            rbMine.setText(null);
                            break;
                        case R.id.rb_mine:
                            vpId.setCurrentItem(2);
                            rbMovie.setText(null);
                            rbCinema.setText(null);
                            rbMine.setText("我的");
                            break;
                    }

                }
            });
        }

        int version = VersionUtils.getVersion(App.mContext);

        mPresenter.getNewVersion(String.valueOf(version));

    }

    @Override
    protected MinePresenter setPresenter() {
        return new MinePresenter();
    }


    @Override
    public void onNewVersionSuccess(NewVersionBean newVersionBean) {


        if (newVersionBean.getFlag() ==1 && newVersionBean!=null){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("版本更新");
            builder.setMessage("当前版本为V"+VersionUtils.getVersionName(App.mContext)+"是否选择更新 ?");
            builder.setPositiveButton("立即更新", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    try {
                        downloadApk(newVersionBean.getDownloadUrl());
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            builder.setCancelable(true);
            builder.show();

        }

    }

    @Override
    public void onFailure(Throwable e) {

    }
    //下载apk
    public void downloadApk(String apkUrl) throws PackageManager.NameNotFoundException {
        Utils.deleteLocal(new File(ConfigurationUtil.APK_PATH_ABSOULT+"GTLXKJ.apk"));//删除旧的apk
        Uri uri = Uri.parse(apkUrl);
        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        // 设置允许使用的网络类型，这里是移动网络和wifi都可以
        request.setAllowedNetworkTypes(request.NETWORK_MOBILE | request.NETWORK_WIFI);
        //设置是否允许漫游
        request.setAllowedOverRoaming(true);
        //设置文件类型
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        String mimeString = mimeTypeMap.getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(apkUrl));
        request.setMimeType(mimeString);
        //在通知栏中显示
        request.setNotificationVisibility(request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setTitle("正在下载");
        request.setVisibleInDownloadsUi(true);
        //sdcard目录下的download文件夹
        request.setDestinationInExternalPublicDir(ConfigurationUtil.APK_PATH, "GTLXKJ.apk");
        // 将下载请求放入队列
        downloadManager.enqueue(request);
    }



}
