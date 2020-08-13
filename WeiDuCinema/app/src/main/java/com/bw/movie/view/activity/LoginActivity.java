package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bw.movie.R;
import com.bw.movie.application.App;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.UserInfoContract;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.presenter.UserInfoPresenter;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<UserInfoPresenter> implements UserInfoContract.IUserInfoView{

    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.but_setPwd)
    Button butSetPwd;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.but_login)
    Button butLogin;
    @BindView(R.id.but_back_loign)
    Button butBackLoign;
    @BindView(R.id.but_wx)
    ImageButton butWx;
    private String email;
    private String pwd;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected UserInfoPresenter setPresenter() {
        return new UserInfoPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        if (!hasNetWork()) {
            //无网吐司 并跳转到无网页面
            showNoNetTip();
            startActivity(new Intent(this, NotNetActivity.class));
        } else {

        }
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
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
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (resultCode == 100) {
                etEmail.setText(data.getStringExtra("email"));
                etPwd.setText(data.getStringExtra("pwd"));
            }
        }
    }

    @OnClick({R.id.but_setPwd, R.id.tv_register, R.id.but_login, R.id.but_back_loign,R.id.but_wx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_setPwd:
                startActivity(new Intent(LoginActivity.this, ForgetPwdActivity.class));
                break;
            case R.id.tv_register:
                startActivityForResult(new Intent(LoginActivity.this, RegisterActivity.class), 101);
                break;
            case R.id.but_login:
                email = etEmail.getText().toString();
                pwd = etPwd.getText().toString();
                mPresenter.postLogin(email, pwd);
                break;
            case R.id.but_back_loign:
                finish();
                break;
            case R.id.but_wx:
                wechatLogin();
                break;
        }
    }

    private void wechatLogin() {
        IWXAPI wxapi = App.mWxApi;
        if(!wxapi.isWXAppInstalled()){
            Toast.makeText(this,"您还未安装微信客户端",Toast.LENGTH_SHORT).show();
            return;
        }
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "yuanda_wx_login";
        wxapi.sendReq(req);

    }


}
