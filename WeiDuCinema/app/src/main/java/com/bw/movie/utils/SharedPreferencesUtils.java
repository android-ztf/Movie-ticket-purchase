package com.bw.movie.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.bw.movie.application.App;


/**
 * AUTHOR: MR.Zhang
 * DATE:2020-4-27
 * INTRODUCE：数据缓存工具类$
 */
public class SharedPreferencesUtils {

    //单例模式 恶汉封装
    private final SharedPreferences goods;

    private SharedPreferencesUtils() {
        goods = App.mContext.getSharedPreferences("sp_data", Context.MODE_PRIVATE);
    }

    public static SharedPreferencesUtils getInstance() {
        return SingleHolder.INSTANCE;
    }

    private static final class SingleHolder{
        private static SharedPreferencesUtils INSTANCE = new SharedPreferencesUtils();
    }

    //存储数据
    public SharedPreferences.Editor putData(){
        SharedPreferences.Editor edit = goods.edit();
        return edit;
    }

    //取出数据
    public SharedPreferences getData(){
        return goods;
    }
}
