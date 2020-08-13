package com.bw.movie.view.activity.mine;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.bean.mine.UserSeenBean;
import com.bw.movie.presenter.MinePresenter;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.adapter.mine.UserSeenAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserSeenActivity extends BaseActivity<MinePresenter> implements MineContract.IMineView {


    @BindView(R.id.but_back_loign)
    Button butBackLoign;
    @BindView(R.id.rv_user_seen)
    RecyclerView rvUserSeen;
    @BindView(R.id.tv_nnotfollow)
    TextView tvNnotfollow;
    @BindView(R.id.iv_notfollow)
    ImageView ivNotfollow;
    private UserSeenAdapter userSeenAdapter;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_user_seen;
    }

    @Override
    protected MinePresenter setPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        userSeenAdapter = new UserSeenAdapter(this);

        tvNnotfollow.setText("暂无看过的电影");

        rvUserSeen.setAdapter(userSeenAdapter);
        rvUserSeen.setLayoutManager(new LinearLayoutManager(this));
        rvUserSeen.addItemDecoration(new SpacesItemDecoration(10));

        if (!hasNetWork()){
            showNoNetTip();
        }else{
            mPresenter.getUserSeen();
        }
    }

    @Override
    public void onUserSeenSuccess(UserSeenBean userSeenBean) {
        Log.i("seen_suc", userSeenBean.getMessage());

        List<UserSeenBean.ResultBean> result = userSeenBean.getResult();
        if (result != null && result.size()!=0) {
            userSeenAdapter.setList(result);
            tvNnotfollow.setVisibility(View.GONE);
            ivNotfollow.setVisibility(View.GONE);
        }else{
            tvNnotfollow.setVisibility(View.VISIBLE);
            ivNotfollow.setVisibility(View.VISIBLE);
            rvUserSeen.setVisibility(View.GONE);
        }

    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err", e.getMessage());
    }


    @OnClick(R.id.but_back_loign)
    public void onViewClicked() {
        finish();
    }
}
