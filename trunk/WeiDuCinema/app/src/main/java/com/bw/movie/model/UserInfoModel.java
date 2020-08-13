package com.bw.movie.model;

import com.bw.movie.contract.UserInfoContract;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.utils.RetrofitManager;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-15
 * INTRODUCE：$
 */
public class UserInfoModel implements UserInfoContract.IUserInfoModel {

    @Override
    public void postAuthCode(String email, IModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postAuthCode(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onSuccess(loginBean);
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
    public void postRegister(HashMap<String, Object> params, IModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postRegister(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onSuccess(loginBean);
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
    public void postLogin(HashMap<String, Object> params, IModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postLogin(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onSuccess(loginBean);
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
    public void postAlterPwd(HashMap<String, Object> params, IModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postAlterPwd(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onSuccess(loginBean);
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

    //微信登录
    @Override
    public void postWeixinLogin(String code, IModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postWeixinLogin(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onWeixinLogin(loginBean);
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
