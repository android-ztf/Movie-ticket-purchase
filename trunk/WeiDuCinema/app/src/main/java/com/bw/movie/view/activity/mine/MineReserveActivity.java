package com.bw.movie.view.activity.mine;

import android.content.Intent;
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
import com.bw.movie.model.bean.mine.UserReserveBean;
import com.bw.movie.presenter.MinePresenter;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.activity.DetailMovieActivity;
import com.bw.movie.view.adapter.mine.MineReserveAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineReserveActivity extends BaseActivity<MinePresenter> implements MineContract.IMineView {

    @BindView(R.id.but_back_reserve)
    Button butBackReserve;
    @BindView(R.id.rl_reserve)
    RecyclerView rlReserve;
    @BindView(R.id.iv_notfollow)
    ImageView ivNotfollow;
    @BindView(R.id.tv_nnotfollow)
    TextView tvNnotfollow;

    private MineReserveAdapter mineReserveAdapter;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_mine_reserve;
    }

    @Override
    protected MinePresenter setPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void initData() {
        super.initData();

        tvNnotfollow.setText("暂无预约信息");
        mineReserveAdapter = new MineReserveAdapter(this);

        rlReserve.setAdapter(mineReserveAdapter);
        rlReserve.setLayoutManager(new LinearLayoutManager(this));
        rlReserve.addItemDecoration(new SpacesItemDecoration(10));

        if (!hasNetWork()){
            showNoNetTip();
        }else{
            mPresenter.getUserReserve();
        }

        mineReserveAdapter.setCallBack(new MineReserveAdapter.ComingCallBack() {
            @Override
            public void onResereve(int movieId, View v) {
                Intent intent = new Intent(MineReserveActivity.this, DetailMovieActivity.class);
                intent.putExtra("movieId",movieId);
                startActivity(intent);
            }
        });

    }

    //预约
    @Override
    public void onUserReserveSuccess(UserReserveBean userReserveBean) {
        Log.i("reserve_suc", userReserveBean.getMessage());

        List<UserReserveBean.ResultBean> result = userReserveBean.getResult();
        if (result!=null){
            mineReserveAdapter.setList(result);
            tvNnotfollow.setVisibility(View.GONE);
            ivNotfollow.setVisibility(View.GONE);
        }else{
            tvNnotfollow.setVisibility(View.VISIBLE);
            ivNotfollow.setVisibility(View.VISIBLE);
            rlReserve.setVisibility(View.GONE);
        }

    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err", e.getMessage());
    }

    @OnClick(R.id.but_back_reserve)
    public void onViewClicked() {
        finish();
    }
}
