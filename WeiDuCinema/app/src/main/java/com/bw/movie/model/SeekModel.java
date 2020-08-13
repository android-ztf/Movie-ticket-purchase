package com.bw.movie.model;

import com.bw.movie.contract.SeekContract;
import com.bw.movie.model.bean.SeekMovieBean;
import com.bw.movie.model.bean.cinema_bean.FindCinemaBean;
import com.bw.movie.utils.RetrofitManager;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-21
 * INTRODUCE：$
 */
public class SeekModel implements SeekContract.ISeekModel {
    @Override
    public void getMoviewSeek(HashMap<String, Object> params, ISeekModelCallBack callBack) {

        RetrofitManager.getInstance()
                .create()
                .getMoviewSeek(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SeekMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SeekMovieBean seekMovieBean) {
                        callBack.onMoviewSuccess(seekMovieBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    //根据电影院名称模糊查询电影院
    @Override
    public void getSeekCinema(HashMap<String, Object> params, ISeekModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getSeekCinema(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindCinemaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindCinemaBean findCinemaBean) {
                        callBack.onFindCinemaSuccess(findCinemaBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
