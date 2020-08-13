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
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.mine.UserFollowMovieBean;
import com.bw.movie.presenter.MinePresenter;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.activity.DetailMovieActivity;
import com.bw.movie.view.adapter.mine.UserFollowMovieAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-23
 * INTRODUCE：$
 */
public class UserFollowMovieFragment extends BaseFragment<MinePresenter> implements MineContract.IMineView {
    @BindView(R.id.rv_user_followmovie)
    RecyclerView rvMore;
    @BindView(R.id.iv_notfollow)
    ImageView ivNotfollow;
    @BindView(R.id.tv_nnotfollow)
    TextView tvNnotfollow;
    private UserFollowMovieAdapter userFollowMovieAdapter;

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

        userFollowMovieAdapter = new UserFollowMovieAdapter(getActivity());
    }

    @Override
    protected void initData() {
        super.initData();

        rvMore.setAdapter(userFollowMovieAdapter);
        rvMore.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvMore.addItemDecoration(new SpacesItemDecoration(10));

        mPresenter.getUserFollowMovieSuccess(1, 100);

        userFollowMovieAdapter.setCallBack(new UserFollowMovieAdapter.IMoreReleaseCallBack() {
            @Override
            public void onDetailMovieId(int movieId,View view) {
                if (movieId != 0) {
                    if (view instanceof ImageView) {
                        mPresenter.getCancelMovieSuccess(movieId);
                    }else{
                        Intent intent = new Intent(getActivity(), DetailMovieActivity.class);
                        intent.putExtra("movieId",movieId);
                        startActivity(intent);
                    }
                }
            }
        });

    }

    @Override
    public void onCancelMovieSuccess(LoginBean loginBean) {
        Log.i("follow_movie", loginBean.getMessage());
        Toast.makeText(getActivity(), loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        if (loginBean.getStatus().equals("0000")) {
            mPresenter.getUserFollowMovieSuccess(1, 100);
        }

    }

    @Override
    public void onUserFollowMovieSuccess(UserFollowMovieBean userFollowMovieBean) {
        Log.i("follow_movie", userFollowMovieBean.getMessage());

        List<UserFollowMovieBean.ResultBean> result = userFollowMovieBean.getResult();

        if (result != null && result.size() != 0) {
            userFollowMovieAdapter.setList(result);
            rvMore.setVisibility(View.VISIBLE);
            ivNotfollow.setVisibility(View.GONE);
            tvNnotfollow.setVisibility(View.GONE);
        } else {
            ivNotfollow.setVisibility(View.VISIBLE);
            tvNnotfollow.setVisibility(View.VISIBLE);
            rvMore.setVisibility(View.GONE);
        }

    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err", e.getMessage());
    }
}
