package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.UserInfoContract;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.presenter.UserInfoPresenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<UserInfoPresenter> implements UserInfoContract.IUserInfoView {

    @BindView(R.id.et_nickName_rg)
    EditText etNickNameRg;
    @BindView(R.id.et_email_rg)
    EditText etEmailRg;
    @BindView(R.id.et_pwd_rg)
    EditText etPwdRg;
    @BindView(R.id.et_authCode_rg)
    EditText etAuthCodeRg;
    @BindView(R.id.but_setPwd_rg)
    Button butSetPwdRg;
    @BindView(R.id.tv_login_rg)
    TextView tvLoginRg;
    @BindView(R.id.but_register_rg)
    Button butRegisterRg;
    @BindView(R.id.but_back)
    Button butBack;
    @BindView(R.id.ll_id_rg)
    LinearLayout llIdRg;
    private String nickName;
    private String email;
    private String pwd;
    private String authCode;

    private int i=120;
    private boolean t=true;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected UserInfoPresenter setPresenter() {
        return new UserInfoPresenter();
    }

    @Override
    protected void initData() {
        super.initData();

        if (hasNetWork()) {

        } else {
            //无网吐司 并跳转到无网页面
            showNoNetTip();
            startActivity(new Intent(this,NotNetActivity.class));
        }
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Throwable e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @OnClick({R.id.but_setPwd_rg, R.id.tv_login_rg, R.id.but_register_rg,R.id.but_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_setPwd_rg:
                email = etEmailRg.getText().toString();
                if (!email.equals("")) {
                    if (isMobileNO(email)&&t) {
                        mPresenter.postAuthCode(email);
                        handler.sendEmptyMessageDelayed(0,1000);
                        butSetPwdRg.setEnabled(false);
                    } else {
                        Toast.makeText(this, "邮箱格式不对", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "邮箱为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tv_login_rg:
                Intent intent = new Intent();
                intent.putExtra("email", etEmailRg.getText().toString());
                intent.putExtra("pwd", etPwdRg.getText().toString());
                setResult(100, intent);
                finish();
                break;
            case R.id.but_register_rg:
                nickName = etNickNameRg.getText().toString();
                email = etEmailRg.getText().toString();
                pwd = etPwdRg.getText().toString();
                authCode = etAuthCodeRg.getText().toString();
                mPresenter.postRegister(nickName, pwd, email, authCode);
                break;
            case R.id.but_back:
                finish();
                break;
        }
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (i>0){
                i--;
                butSetPwdRg.setText("重新获取:("+i+")");
                sendEmptyMessageDelayed(0,1000);
                t=false;
            }else{
                butSetPwdRg.setEnabled(true);
                butSetPwdRg.setText("获取验证码");
                i=120;
                t=true;
            }
        }
    };

    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern
                .compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
}
