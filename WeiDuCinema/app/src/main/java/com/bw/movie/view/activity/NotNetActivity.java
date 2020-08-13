package com.bw.movie.view.activity;

import android.os.Bundle;
import android.widget.Button;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotNetActivity extends BaseActivity {

    @BindView(R.id.but_back_)
    Button butBack;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_not_net;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @OnClick(R.id.but_back_)
    public void onViewClicked() {
        finish();
    }
}
