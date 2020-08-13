package com.bw.movie.view.fragment.mine;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.bean.mine.UserCommentCinema;
import com.bw.movie.presenter.MinePresenter;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.activity.CinemaInfoActivity;
import com.bw.movie.view.adapter.mine.UserCinemaCommentAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-24
 * INTRODUCE：$
 */
public class UserCinemaCommentFragment extends BaseFragment<MinePresenter> implements MineContract.IMineView {
    @BindView(R.id.rv_user_followmovie)
    RecyclerView rvUserFollowmovie;
    @BindView(R.id.iv_notfollow)
    ImageView ivNotfollow;
    @BindView(R.id.tv_nnotfollow)
    TextView tvNnotfollow;

    private UserCinemaCommentAdapter userCinemaCommentAdapter;

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

        userCinemaCommentAdapter = new UserCinemaCommentAdapter(getActivity());
    }

    @Override
    protected void initData() {
        super.initData();

        rvUserFollowmovie.setAdapter(userCinemaCommentAdapter);
        rvUserFollowmovie.addItemDecoration(new SpacesItemDecoration(10));
        rvUserFollowmovie.setLayoutManager(new LinearLayoutManager(getActivity()));

        SharedPreferences data = SharedPreferencesUtils.getInstance().getData();
        String string = data.getString("jinwei", "");
        if (!string.equals("")){
            if (!hasNetWrok()){
                showNoNetTip();
            }else{
                String[] s = string.split(",");
                mPresenter.getUserCommentCinema(1,100,s[0],s[1]);
            }
        }

        userCinemaCommentAdapter.setCallBack(new UserCinemaCommentAdapter.OnCinemaCallBack() {
            @Override
            public void getCinemaId(int cinemaId, View view) {
                Intent intent = new Intent(getActivity(), CinemaInfoActivity.class);
                intent.putExtra("cinemaId",cinemaId);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onUserCommnetCinemaSuccess(UserCommentCinema userCommentCinema) {
        Log.i("cinemacoment_suc", userCommentCinema.getMessage());
        List<UserCommentCinema.ResultBean> result = userCommentCinema.getResult();

        if (result.size() != 0) {
            userCinemaCommentAdapter.setList(result);
            tvNnotfollow.setVisibility(View.GONE);
            ivNotfollow.setVisibility(View.GONE);
            rvUserFollowmovie.setVisibility(View.VISIBLE);
        } else {
            tvNnotfollow.setVisibility(View.VISIBLE);
            ivNotfollow.setVisibility(View.VISIBLE);
            rvUserFollowmovie.setVisibility(View.GONE);
        }
    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err", e.getMessage());

    }
}
