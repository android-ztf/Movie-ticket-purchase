package com.bw.movie.view.activity.mine;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.presenter.MinePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeedBackActivity extends BaseActivity<MinePresenter> implements MineContract.IMineView {


    @BindView(R.id.but_back_feedback)
    Button butBackFeedback;
    @BindView(R.id.et_seenback)
    EditText etSeenback;
    @BindView(R.id.but_back_commit)
    Button butBackCommit;
    @BindView(R.id.rl_seenback)
    RelativeLayout rlSeenback;
    @BindView(R.id.rl_fkui)
    RelativeLayout rlFkui;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_feed_bac;
    }

    @Override
    protected MinePresenter setPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void initData() {
        super.initData();


    }

    @Override
    public void onFeedBackSuccess(LoginBean loginBean) {
        Log.i("feedback_suc", loginBean.getMessage());
        Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        if (loginBean.getStatus().equals("0000")) {
            rlFkui.setVisibility(View.VISIBLE);
            rlSeenback.setVisibility(View.GONE);
        } else {
            rlFkui.setVisibility(View.GONE);
            rlSeenback.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err", e.getMessage());
    }

    @OnClick({R.id.but_back_feedback, R.id.but_back_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_back_feedback:
                finish();
                break;
            case R.id.but_back_commit:
                if (!hasNetWork()) {
                    showNoNetTip();
                } else {
                    if (etSeenback.getText().toString() != null && !etSeenback.getText().toString().equals("")) {
                        mPresenter.postFeedBack(etSeenback.getText().toString());
                    } else {
                        Toast.makeText(FeedBackActivity.this, "意见反馈不能为空", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

}
