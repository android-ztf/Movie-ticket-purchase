package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.bean.UserInFoBean;
import com.bw.movie.presenter.MinePresenter;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends BaseActivity<MinePresenter> implements MineContract.IMineView {

    @BindView(R.id.iv_ydy)
    ImageView ivYdy;
    @BindView(R.id.tv_djs)
    TextView tvDjs;
    private int[] movieCover = {R.mipmap.fm, R.mipmap.gjsd,
            R.mipmap.xskdjs, R.mipmap.rzdf, R.mipmap.xyym
    ,R.mipmap.zyzcsq,R.mipmap.mdsd};

    private int djs = 4;


    @Override
    protected int provideLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected MinePresenter setPresenter() {
        return new MinePresenter();
    }


    public void dj(View view) {
        isLogin();
    }

    @Override
    protected void initData() {
        super.initData();
        int i = new Random().nextInt(7);
        //Glide.with(WelcomeActivity.this).load(movieCover[i]).into(ivYdy);
        ivYdy.setImageResource(movieCover[i]);

        handler.sendEmptyMessageDelayed(1, 1000);

    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                if (djs == 0) {
                    tvDjs.setText(djs+"s");
                    isLogin();
                } else {
                    djs--;
                    tvDjs.setText(djs+"s");
                    handler.sendEmptyMessageDelayed(1, 1000);
                    if (djs==2){
                        int i = new Random().nextInt(6);
                        //Glide.with(WelcomeActivity.this).load(movieCover[i]).into(ivYdy);
                        ivYdy.setImageResource(movieCover[i]);
                    }
                }
            }
        }
    };

    private void isLogin() {
        if (hasNetWork()) {
            mPresenter.getUserInFo();
        } else {
            //无网吐司 并跳转到无网页面
            showNoNetTip();
            startActivity(new Intent(this, NotNetActivity.class));

        }
    }

    @Override
    public void onUserInFoSuccess(UserInFoBean userInFoBean) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        if (userInFoBean.getStatus().equals("0000")){
            intent.setClass(this, HomeActivity.class);
        }else {
            intent.setClass(this, LoginActivity.class);
        }
        startActivity(intent);
    }

    @Override
    public void onFailure(Throwable e) {

    }
}
