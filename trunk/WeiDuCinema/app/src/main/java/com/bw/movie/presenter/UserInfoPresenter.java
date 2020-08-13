package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.UserInfoContract;
import com.bw.movie.model.UserInfoModel;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.realm.UserInfoRealm;
import com.bw.movie.utils.EncryptUtil;

import java.util.HashMap;

import io.realm.Realm;
import io.realm.RealmQuery;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-15
 * INTRODUCE：$
 */
public class UserInfoPresenter extends BasePresenter<UserInfoContract.IUserInfoView> implements UserInfoContract.IUserInfoPresenter {

    private UserInfoModel userInfoModel;

    public UserInfoPresenter() {
        userInfoModel = new UserInfoModel();
    }

    @Override
    public void postAuthCode(String email) {
        userInfoModel.postAuthCode(email, new UserInfoContract.IUserInfoModel.IModelCallBack() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                getView().onSuccess(loginBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void postRegister(String nickName, String pwd, String email, String code) {

        HashMap<String, Object> params = new HashMap<>();
        String encrypt_pwd = EncryptUtil.encrypt(pwd);
        params.put("nickName",nickName);
        params.put("pwd",encrypt_pwd);
        params.put("email",email);
        params.put("code",code);

        userInfoModel.postRegister(params, new UserInfoContract.IUserInfoModel.IModelCallBack() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                getView().onSuccess(loginBean);

            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });

    }

    @Override
    public void postLogin(String email, String pwd) {
        HashMap<String, Object> params = new HashMap<>();
        String encrypt_pwd = EncryptUtil.encrypt(pwd);
        params.put("email",email);
        params.put("pwd",encrypt_pwd);

        userInfoModel.postLogin(params, new UserInfoContract.IUserInfoModel.IModelCallBack() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                if (loginBean.getStatus().equals("0000")) {
                    //h获取数据库对象
                    Realm realm = Realm.getDefaultInstance();
                    //必须先开启事务
                    realm.beginTransaction();
                    /**
                     * 每当一个账号首次登陆,需要清空以前的数据库里面的id
                     * 清除时需要判断数据库是否为空,否则和出错
                     */
                    RealmQuery<UserInfoRealm> where = realm.where(UserInfoRealm.class);
                    if (where != null) {
                        realm.delete(UserInfoRealm.class);
                    }

                    //把userId和sessionId保存到Realm数据库
                    UserInfoRealm userInfoRealm = new UserInfoRealm();
                    userInfoRealm.setUserId(loginBean.getResult().getUserId());
                    userInfoRealm.setSessionId(loginBean.getResult().getSessionId());

                    realm.copyToRealmOrUpdate(userInfoRealm);//提交数据
                    realm.commitTransaction();//提交事务

                    getView().onSuccess(loginBean);
                }else{
                    getView().onFailure(new Exception("登录失败"));
                }
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });

    }

    @Override
    public void postAlterPwd(String oldPwd, String newPwd, String newPwd2) {
        HashMap<String, Object> params = new HashMap<>();
        String old_pwd = EncryptUtil.encrypt(oldPwd);
        String new1_pwd = EncryptUtil.encrypt(newPwd);
        String new2_pwd = EncryptUtil.encrypt(newPwd2);
        params.put("oldPwd",old_pwd);
        params.put("newPwd",new1_pwd);
        params.put("newPwd2",new2_pwd);
        userInfoModel.postAlterPwd(params, new UserInfoContract.IUserInfoModel.IModelCallBack() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                getView().onSuccess(loginBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    //微信登录
    @Override
    public void postWeixinLogin(String code) {
        userInfoModel.postWeixinLogin(code, new UserInfoContract.IUserInfoModel.IModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onWeixinLogin(LoginBean loginBean) {
                if (loginBean.getStatus().equals("0000")) {
                    //h获取数据库对象
                    Realm realm = Realm.getDefaultInstance();
                    //必须先开启事务
                    realm.beginTransaction();
                    /**
                     * 每当一个账号首次登陆,需要清空以前的数据库里面的id
                     * 清除时需要判断数据库是否为空,否则和出错
                     */
                    RealmQuery<UserInfoRealm> where = realm.where(UserInfoRealm.class);
                    if (where != null) {
                        realm.delete(UserInfoRealm.class);
                    }

                    //把userId和sessionId保存到Realm数据库
                    UserInfoRealm userInfoRealm = new UserInfoRealm();
                    userInfoRealm.setUserId(loginBean.getResult().getUserId());
                    userInfoRealm.setSessionId(loginBean.getResult().getSessionId());

                    realm.copyToRealmOrUpdate(userInfoRealm);//提交数据
                    realm.commitTransaction();//提交事务

                    getView().onWeixinLogin(loginBean);
                }else{
                    getView().onFailure(new Exception("登录失败"));
                }
            }
        });
    }
}
