package com.bw.movie.model;

import com.bw.movie.contract.CinemaContract;
import com.bw.movie.model.bean.cinema_bean.CinemaCommentBean;
import com.bw.movie.model.bean.cinema_bean.CinemaInfoBean;
import com.bw.movie.model.bean.cinema_bean.CinemaMovieListBean;
import com.bw.movie.model.bean.cinema_bean.CinemaRegionBean;
import com.bw.movie.model.bean.cinema_bean.FindCinemaBean;
import com.bw.movie.model.bean.cinema_bean.FindDateBean;
import com.bw.movie.model.bean.cinema_bean.NearbyCinemasBean;
import com.bw.movie.model.bean.cinema_bean.RegionListBean;
import com.bw.movie.utils.RetrofitManager;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-2
 * INTRODUCE：$
 */
public class CinemaModel implements CinemaContract.ICinemaModel {

    //推荐影院
    @Override
    public void getRecommendCinemas(int page, int count, ICinemaCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getRecommendCinemas(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NearbyCinemasBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NearbyCinemasBean nearbyCinemasBean) {
                        callBack.onSuccess(nearbyCinemasBean);
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

    //附近影院
    @Override
    public void getNearbyCinemas(HashMap<String, Object> params, ICinemaCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getNearbyCinemas(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NearbyCinemasBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NearbyCinemasBean nearbyCinemasBean) {
                        callBack.onSuccess(nearbyCinemasBean);
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

    //查询影院详细信息
    @Override
    public void getCinemaInfo(int cinemaId, ICinemaCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getCinemaInfo(cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaInfoBean>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaInfoBean cinemaInfoBean) {
                        callBack.onCinemaInfoSuccess(cinemaInfoBean);
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

    //关注影院
    @Override
    public void getFollowCinema(int cinemaId,ICinemaCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getFollowCinema(cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaInfoBean>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaInfoBean cinemaInfoBean) {
                        callBack.onCinemaInfoSuccess(cinemaInfoBean);
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
    //取消关注影院
    @Override
    public void getCancelFollowCinema(int cinemaId,ICinemaCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getCancelFollowCinema(cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaInfoBean>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaInfoBean cinemaInfoBean) {
                        callBack.onCinemaInfoSuccess(cinemaInfoBean);
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

    //查看用户所有评论
    @Override
    public void getFindCommentCinema(HashMap<String, Object> params, ICinemaCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getFindCommentCinema(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaCommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaCommentBean cinemaCommentBean) {
                        callBack.onFindCommentSuccess(cinemaCommentBean);
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
    //用户点赞影院
    @Override
    public void postCommentGreat(int commentId, ICinemaCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postCommentGreat(commentId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaCommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaCommentBean cinemaCommentBean) {
                        callBack.onFindCommentSuccess(cinemaCommentBean);
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
    //查询影院下的电影排期
    @Override
    public void getCinemaMovieList(HashMap<String, Object> params, ICinemaCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getCinemaMovieList(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaMovieListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaMovieListBean cinemaMovieListBean) {
                        callBack.onMovieListSuccess(cinemaMovieListBean);
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
    //查询一周排期的时间
    @Override
    public void getFindDate(ICinemaCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getFindDate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindDateBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindDateBean findDateBean) {
                        callBack.onFindDateSuccess(findDateBean);
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
    //根据区域查询影院
    @Override
    public void getCinemaRegion(int regionId, ICinemaCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getCinemaRegion(regionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaRegionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaRegionBean cinemaRegionBean) {
                        callBack.onCinemaRegionSuccess(cinemaRegionBean);
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
    //查询区域列表
    @Override
    public void getRegionList(ICinemaCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getRegionList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegionListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegionListBean regionListBean) {
                        callBack.onRegionListSuccess(regionListBean);
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
