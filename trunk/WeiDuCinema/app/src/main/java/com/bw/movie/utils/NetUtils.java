package com.bw.movie.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-5-27
 * INTRODUCE：判断是否有网工具类$
 */
public class NetUtils {

    public static boolean hasNetWork(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null && networkInfo.isAvailable()){
            return true;
        }else{
            return false;
        }
    }

}
