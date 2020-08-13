package com.bw.movie.contract;

import com.bw.movie.base.IBaseView;
import com.bw.movie.model.bean.LoginBean;

import java.util.HashMap;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-15
 * INTRODUCE：$
 */
public interface UserInfoContract {

    public interface IUserInfoView extends IBaseView{
        default void onSuccess(LoginBean loginBean){}
        //微信登录
        default void onWeixinLogin(LoginBean loginBean){}

        void onFailure(Throwable e);
    }

    public interface IUserInfoPresenter{
        //获取验证码
        default void postAuthCode(String email){}
        //注册
        default void postRegister(String nickName,String pwd,String email,String code){}
        //登录
        default void postLogin(String email,String pwd){}
        //修改密码
        default void postAlterPwd(String oldPwd,String newPwd,String newPwd2){}
        //微信登录
        default void postWeixinLogin(String code){}

    }

    public interface IUserInfoModel{
        //获取验证码
        default void postAuthCode(String email,IModelCallBack callBack){}
        //注册
        default void postRegister(HashMap<String,Object> params,IModelCallBack callBack){}
        //登录
        default void postLogin(HashMap<String,Object> params,IModelCallBack callBack){}
        //修改密码
        default void postAlterPwd(HashMap<String,Object> params,IModelCallBack callBack){}
        //微信登录
        default void postWeixinLogin(String code,IModelCallBack callBack){}
        public interface IModelCallBack{
            default void onSuccess(LoginBean loginBean){}
            //微信登录
            default void onWeixinLogin(LoginBean loginBean){}
            void onFailure(Throwable e);
        }

    }


}
