package com.bw.movie.application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import androidx.multidex.MultiDex;

import com.bw.movie.model.greendao.DaoMaster;
import com.bw.movie.model.greendao.DaoSession;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.util.ByteConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * AUTHOR: MR.Zhang
 * DATE:2020-5-22
 * INTRODUCE：$
 * 在 Android 中使用全局变量，除 public 静态变量，还有就是使用 android.app.Application。
 * Android 系统 会为每个程序运行时创建一个 Application 类的对象且仅创建一个，
 * 所以 Application 可以说是单例 (singleton)模式的一个类所以在不同的 Activity、Service 中获得的对象都是同一个对象，
 * 所以通过 Application 来进行一些，数据传递，数据共享等，数据缓存等操作。在启动 Application 时，
 *系统会创建一个 PID,就是 进程 ID，所有的 Activity 会在此进程上运行，在创建 Application 时初始化全局变量，
 * 同一个应用的所有 Activity 都会获取这些全局变量的值，可用于保存登录状态。
 * Application 中的全局变量值会在 Activity 中被改变，其生命周期等于整个程序的生命周期
 */
public class App extends Application {

    public static App mContext;
    public static IWXAPI mWxApi;
    private static DaoSession daoSession;

    /**
     * 第三方库的初始化（网络请求、推送、地图、分享等）、MultiDex（分包配置）、
     * 全局对象、环境配置变量、全局数据共享存储，不能做耗时操作，要不然影响 App 的启动速度
     */
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        //注册微信
        mWxApi = WXAPIFactory.createWXAPI(this, Constant.WEIXIN, false);
        mWxApi.registerApp(Constant.WEIXIN);

        //设置磁盘缓存
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(this)
                //设置目录路径     获取外部存储目录
                .setBaseDirectoryPath(Environment.getExternalStorageDirectory())
                //设置目录名
                .setBaseDirectoryName("pic_name")
                //设置最大存储
                .setMaxCacheSize(100 * ByteConstants.MB)
                .build();
        //设置磁盘缓存的配置,生成配置文件
        ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig.newBuilder(this)
                //是否启动磁盘缓存
                .setDiskCacheEnabled(true)
                //设置磁盘缓存配置
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();

        //初始化fresco
        Fresco.initialize(this);

        //初始化reaml数据库
        Realm.init(this);
        //使用自定义配置
        RealmConfiguration comfig = new RealmConfiguration.Builder()
                .name("myRelm.realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(comfig);

        // 初始化MultiDex
        MultiDex.install(this);

        //greendao初始化
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "mGreenDao.db", null);
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        daoSession = new DaoMaster(db).newSession();

        //注册二维码生成
        ZXingLibrary.initDisplayOpinion(this);

//        XGPushConfig.enableDebug(this,true);

    }
    //为外部提供实例
    public static App getInstance(){
        return mContext;
    }

    public static DaoSession getDaoSession(){
        return daoSession;
    }



}
