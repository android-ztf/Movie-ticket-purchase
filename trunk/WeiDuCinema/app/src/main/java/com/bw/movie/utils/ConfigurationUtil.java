package com.bw.movie.utils;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-8-3
 * INTRODUCE：$
 */

import android.os.Environment;

import java.io.File;


public class ConfigurationUtil {
    public static final String URL = "http://192.168.1.98:8011/ams/user?wsdl";

    //public static final String HOST = "http://172.16.121.140:8888/test/upload";
    public static final String HOST = "http://192.168.1.98:8011/upload/recieveUploadFile";
    public static final String WEBVERSION = "http://192.168.1.98:8011/upload/queryVersion";
    public static final String APKHOST = "http://192.168.1.98:8011/GTLXKJ.apk";

    public static final int SUCCESSCODE = 1;//成功标识
    public static final int FAILURECODE = 0;//失败标识
    public static final int ERRORCODE = 2;//网络请求异常标识

    public static final int DBVERSION = 2;//数据库版本
    public static final String DBNAME = "gtlxkj.db";//数据库名称
    public static final String NAMESPACE="http://service.com/";

    public static final String SDFILE = Environment.getExternalStoragePublicDirectory("") + File.separator + "hnlx/gt/";

    public static final String FILE_PATH = ConfigurationUtil.SDFILE + "camera" + File.separator;
    public static final String APK_PATH = "hnlx/gt/"+ "apk" + File.separator;
    public static final String APK_PATH_ABSOULT = ConfigurationUtil.SDFILE+ "apk" + File.separator;
    public static final String RECORD_PATH_ABSOULT = ConfigurationUtil.SDFILE+ "record" + File.separator;
}



