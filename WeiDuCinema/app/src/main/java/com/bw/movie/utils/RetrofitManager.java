package com.bw.movie.utils;

import android.util.Log;


import com.bw.movie.application.Constant;
import com.bw.movie.model.api.IApi;
import com.bw.movie.model.realm.UserInfoRealm;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-5-28
 * INTRODUCE：$
 */
public class RetrofitManager {

    private Retrofit mRetrofit;
    //默认的IApi
    private IApi mIApi;
    private static int userId;
    private static String sessionId;

    private static final class SingleHolder{
        private static RetrofitManager INSTANCE = new RetrofitManager();
    }

    public static RetrofitManager getInstance(){
        return SingleHolder.INSTANCE;
    }

    private RetrofitManager() {
        mRetrofit = new Retrofit.Builder()
                //添加自动gson解析
                .addConverterFactory(GsonConverterFactory.create())
                //让retrofit支持rxjava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //设置公共的url
                .baseUrl(Constant.BASE_URL)
                //配置自己的okhttpclient
                .client(okHttpClient())
                .build();
    }

    private OkHttpClient okHttpClient(){
        //日子拦截器 并且设置拦截器打印日志的级别
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(5, TimeUnit.SECONDS)//连接超时
                .readTimeout(5, TimeUnit.SECONDS)//读取超时
                .writeTimeout(10, TimeUnit.SECONDS)//写入超时
                .addInterceptor(new HeaderInterceptor())
                .build();

        return okHttpClient;
    }

    private static final class HeaderInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request.Builder builder = chain.request().newBuilder();
            builder.addHeader("userId",userId+"");
            builder.addHeader("sessionId",sessionId+"");
            Request request = builder.build();
            userId=0;
            sessionId=null;

            return chain.proceed(request);
        }
    }

    //创建单例IApi
    public IApi create(){
        Realm realm = Realm.getDefaultInstance();
        UserInfoRealm first = realm.where(UserInfoRealm.class).findFirst();
        if(first!=null) {
            userId = first.getUserId();
            sessionId = first.getSessionId();
            Log.i("realm_iapi","uId"+userId+",sId"+sessionId);
        }
        if (mIApi==null){
            mIApi=mRetrofit.create(IApi.class);
        }
        return mIApi;
    }



}
