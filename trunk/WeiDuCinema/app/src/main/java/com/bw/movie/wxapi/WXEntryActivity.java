package com.bw.movie.wxapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.application.App;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.UserInfoContract;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.presenter.UserInfoPresenter;
import com.bw.movie.view.activity.HomeActivity;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXEntryActivity extends BaseActivity<UserInfoPresenter> implements IWXAPIEventHandler, UserInfoContract.IUserInfoView {

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_wxentry;
    }

    @Override
    protected UserInfoPresenter setPresenter() {
        return new UserInfoPresenter();
    }

    @Override
    protected void initView() {
        super.initView();
        App.mWxApi.handleIntent(getIntent(), this);

    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {

        int errCode = baseResp.errCode;
        Log.i("errCode",errCode+"");
        if ( errCode==BaseResp.ErrCode.ERR_OK){

        }

        switch (baseResp.errCode){
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                break;
            case BaseResp.ErrCode.ERR_OK:
                SendAuth.Resp type = (SendAuth.Resp) baseResp;
                String code = type.code;
                Log.i("code",code+"");
                if (code!=null){
                    mPresenter.postWeixinLogin(code);
                }
                break;
        }


    }

    @Override
    public void onWeixinLogin(LoginBean loginBean) {
        Log.i("weixin_suc",loginBean.getMessage());
        Toast.makeText(this,loginBean.getMessage(),Toast.LENGTH_SHORT).show();
        if (loginBean.getStatus().equals("0000")) {
            Log.i("uidsid", loginBean.getResult().getUserId() + "&" + loginBean.getResult().getSessionId());
            Intent intent = new Intent();
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setClass(this, HomeActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err",e.getMessage());
    }
}
