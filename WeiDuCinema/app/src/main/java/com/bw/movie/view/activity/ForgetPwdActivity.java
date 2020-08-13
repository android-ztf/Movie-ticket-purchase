package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.UserInfoContract;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.presenter.UserInfoPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetPwdActivity extends BaseActivity<UserInfoPresenter> implements UserInfoContract.IUserInfoView {

    @BindView(R.id.but_back_forget)
    Button butBackForget;
    @BindView(R.id.et_email_fg)
    EditText etEmailFg;
    @BindView(R.id.et_oldpwd_fg)
    EditText etOldpwdFg;
    @BindView(R.id.sb_progress)
    SeekBar sbProgress;
    @BindView(R.id.et_newpwd1_fg)
    EditText etNewpwd1Fg;
    @BindView(R.id.et_newpwd2_fg)
    EditText etNewpwd2Fg;
    @BindView(R.id.but_login_fg)
    Button butLoginFg;

    private boolean d = false;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_forget_pwd;
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

            sbProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    if (seekBar.getProgress() != seekBar.getMax()) {
                        seekBar.setProgress(0);
                        d = false;
                    } else {
                        etNewpwd1Fg.setFocusableInTouchMode(true);
                        etNewpwd1Fg.setFocusable(true);
                        etNewpwd2Fg.setFocusableInTouchMode(true);
                        etNewpwd2Fg.setFocusable(true);
                        butLoginFg.setEnabled(true);
                        d = true;
                    }
                }
            });

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

    @OnClick({R.id.et_newpwd1_fg, R.id.et_newpwd2_fg, R.id.but_back_forget,R.id.but_login_fg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_newpwd1_fg:
            case R.id.et_newpwd2_fg:
                if (!d) {
                    Toast.makeText(this, "请滑动滑块到指定位置", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.but_login_fg:
                String old_pwd = etOldpwdFg.getText().toString();
                String new1_pwd = etNewpwd1Fg.getText().toString();
                String new2_pwd = etNewpwd2Fg.getText().toString();
                if (old_pwd.equals("")&&new1_pwd.equals("")&&new2_pwd.equals("")){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    mPresenter.postAlterPwd(old_pwd, new1_pwd, new2_pwd);
                }
                break;
            case R.id.but_back_forget:
                finish();
                break;
        }
    }
}
