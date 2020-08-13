package com.bw.movie.model;

import android.content.SharedPreferences;

import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.bean.BannerBean;
import com.bw.movie.model.bean.ComingMovieBean;
import com.bw.movie.model.bean.DetailMovieBean;
import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.ReleaseMovieBean;
import com.bw.movie.model.bean.detail_movie.MovieCommentBean;
import com.bw.movie.model.bean.detail_movie.ReplyCommentBean;
import com.bw.movie.utils.RetrofitManager;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.google.gson.Gson;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-16
 * INTRODUCE：主页m层$
 */
public class HomeModel implements HomeContract.IHomeModel {

    @Override
    public void getBanner(IHomeModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        callBack.onBannerSuccess(bannerBean);
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

    @Override
    public void getRelease(int page, int count, IHomeModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getRelease(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ReleaseMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ReleaseMovieBean releaseMovieBean) {
                        callBack.onReleaseSuccess(releaseMovieBean);
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

    @Override
    public void getComing(int page, int count, IHomeModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getComing(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ComingMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ComingMovieBean comingMovieBean) {
                        callBack.onComingSuccess(comingMovieBean);
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

    @Override
    public void getHot(int page, int count, IHomeModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getHot(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotMovieBean hotMovieBean) {
                        callBack.onHotSuccess(hotMovieBean);
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

    @Override
    public void postReserve(int movieId, IHomeModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postReserveMovie(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onReserveSuccess(loginBean);
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

    @Override
    public void getDetail(int movieId, IHomeModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getDetailMovie(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DetailMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DetailMovieBean detailMovieBean) {

                        callBack.onDetailSuccess(detailMovieBean);
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

    //获取电影所有评论
    @Override
    public void getMovieComment(HashMap<String, Object> params, IHomeModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getMovieComment(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieCommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieCommentBean movieCommentBean) {
                        callBack.onMovieCommentSuccess(movieCommentBean);
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

    //关注电影
    @Override
    public void getMovieFollow(int movieId, IHomeModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getMovieFollow(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onMovieFollow(loginBean);
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

    //取消关注电影
    @Override
    public void getCancelMovieFollow(int movieId, IHomeModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getCancelMovieFollow(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onCancelMovieFollow(loginBean);
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

    //用户对电影的评论
    @Override
    public void postWriteMovieComment(HashMap<String, Object> params, IHomeModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postWriteMovieComment(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onWriteMovieComment(loginBean);
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

    //查看影片评论回复
    @Override
    public void getCommentReplyAll(HashMap<String, Object> params, IHomeModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getCommentReplyAll(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ReplyCommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ReplyCommentBean replyCommentBean) {
                        callBack.onCommentReplyAll(replyCommentBean);
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

    //添加用户对评论的回复
    @Override
    public void postReplyComment(int commentId, String replyContent, IHomeModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postReplyComment(commentId,replyContent)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onReplyComment(loginBean);
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

    //电影评论点赞
    @Override
    public void postGreayComment(int commentId, IHomeModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postGreayComment(commentId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onGreayComment(loginBean);
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
