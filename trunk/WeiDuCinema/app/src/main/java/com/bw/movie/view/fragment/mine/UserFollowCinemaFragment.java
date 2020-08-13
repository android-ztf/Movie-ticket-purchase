package com.bw.movie.view.fragment.mine;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.bean.cinema_bean.CinemaInfoBean;
import com.bw.movie.model.bean.mine.UserFollowCinemaBean;
import com.bw.movie.presenter.MinePresenter;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.activity.CinemaInfoActivity;
import com.bw.movie.view.adapter.mine.UserFollowCinemaAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-23
 * INTRODUCE：$
 */
public class UserFollowCinemaFragment extends BaseFragment<MinePresenter> implements MineContract.IMineView {
    @BindView(R.id.rv_user_followmovie)
    RecyclerView rvUserFollowmovie;
    @BindView(R.id.iv_notfollow)
    ImageView ivNotfollow;
    @BindView(R.id.tv_nnotfollow)
    TextView tvNnotfollow;

    private UserFollowCinemaAdapter userFollowCinemaAdapter;

    @Override
    public int provideLayoutId() {
        return R.layout.fragment_user_follow_movie;
    }

    @Override
    protected MinePresenter setPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void inintView() {
        super.inintView();
        userFollowCinemaAdapter = new UserFollowCinemaAdapter(getActivity());
    }

    @Override
    protected void initData() {
        super.initData();

        rvUserFollowmovie.setAdapter(userFollowCinemaAdapter);
        rvUserFollowmovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvUserFollowmovie.addItemDecoration(new SpacesItemDecoration(10));

        mPresenter.getUserFollowCinemaSuccess(1,100);

        userFollowCinemaAdapter.setCallBack(new UserFollowCinemaAdapter.OnCinemaCallBack() {
            @Override
            public void getCinemaId(int cinemaId, View view) {
                if (cinemaId!=0){
                    if (view instanceof RelativeLayout){
                        Intent intent = new Intent(getActivity(), CinemaInfoActivity.class);
                        intent.putExtra("cinemaId",cinemaId);
                        startActivity(intent);
                    }else{
                        mPresenter.getCancelCinemaSuccess(cinemaId);
                    }
                }
            }
        });

    }

    @Override
    public void onCancelCinemaSuccess(CinemaInfoBean cinemaInfoBean) {
        Log.i("cancinema_suc",cinemaInfoBean.getMessage());
        Toast.makeText(getActivity(),cinemaInfoBean.getMessage(),Toast.LENGTH_SHORT).show();
        if (cinemaInfoBean.getStatus().equals("0000")){
            mPresenter.getUserFollowCinemaSuccess(1,100);
        }

    }

    @Override
    public void onUserFollowCinemaSuccess(UserFollowCinemaBean userFollowCinemaBean) {
        Log.i("followcinema_suc",userFollowCinemaBean.getMessage());

        List<UserFollowCinemaBean.ResultBean> result = userFollowCinemaBean.getResult();

        if (result!=null && result.size() != 0){
            userFollowCinemaAdapter.setList(result);
            tvNnotfollow.setVisibility(View.GONE);
            ivNotfollow.setVisibility(View.GONE);
        }else{
            tvNnotfollow.setVisibility(View.VISIBLE);
            ivNotfollow.setVisibility(View.VISIBLE);
            rvUserFollowmovie.setVisibility(View.GONE);
        }


    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err",e.getMessage());

    }
}
