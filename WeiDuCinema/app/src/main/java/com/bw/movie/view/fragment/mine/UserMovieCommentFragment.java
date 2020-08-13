package com.bw.movie.view.fragment.mine;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.bean.mine.UserCommentMovie;
import com.bw.movie.presenter.MinePresenter;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.activity.DetailMovieActivity;
import com.bw.movie.view.adapter.mine.UserMovieCommentAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-24
 * INTRODUCE：$
 */
public class UserMovieCommentFragment extends BaseFragment<MinePresenter> implements MineContract.IMineView {
    @BindView(R.id.rv_user_followmovie)
    RecyclerView rvUserFollowmovie;
    @BindView(R.id.iv_notfollow)
    ImageView ivNotfollow;
    @BindView(R.id.tv_nnotfollow)
    TextView tvNnotfollow;

    private UserMovieCommentAdapter userMovieCommentAdapter;

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
        userMovieCommentAdapter = new UserMovieCommentAdapter(getActivity());
    }

    @Override
    protected void initData() {
        super.initData();

        rvUserFollowmovie.setAdapter(userMovieCommentAdapter);
        rvUserFollowmovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvUserFollowmovie.addItemDecoration(new SpacesItemDecoration(10));

        mPresenter.getUserCommnetMovie(1,100);

        userMovieCommentAdapter.setCallBack(new UserMovieCommentAdapter.OnCinemaCallBack() {
            @Override
            public void getCinemaId(int cinemaId, View view) {
                Intent intent = new Intent(getActivity(), DetailMovieActivity.class);
                intent.putExtra("movieId",cinemaId);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onUserCommnetMovieSuccess(UserCommentMovie userCommentMovie) {

        Log.i("moviecoment_suc",userCommentMovie.getMessage());

        List<UserCommentMovie.ResultBean> result = userCommentMovie.getResult();

            if (result.size()!=0){
                userMovieCommentAdapter.setList(result);
                tvNnotfollow.setVisibility(View.GONE);
                ivNotfollow.setVisibility(View.GONE);
                rvUserFollowmovie.setVisibility(View.VISIBLE);
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
