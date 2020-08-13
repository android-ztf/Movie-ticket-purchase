package com.bw.movie.view.fragment.movie_details;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.bean.DetailMovieBean;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.detail_movie.MovieCommentBean;
import com.bw.movie.presenter.DetailPresenter;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.activity.CommentDetailActivity;
import com.bw.movie.view.adapter.movie_details.MyMovieCommentAdapter;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-17
 * INTRODUCE：$
 */
public class MovieCommentFragmnet extends BaseFragment<DetailPresenter> implements HomeContract.IDetailView {


    @BindView(R.id.rv_more)
    RecyclerView rvMore;
    @BindView(R.id.srl_more)
    SwipeRefreshLayout srlMore;

    private MyMovieCommentAdapter myMovieCommentAdapter;
    private int page = 1;
    private boolean isRefresh;
    private int movieId;

    @Override
    public int provideLayoutId() {
        return R.layout.fragment_moviecomment;
    }

    @Override
    protected DetailPresenter setPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected void inintView() {
        super.inintView();

        myMovieCommentAdapter = new MyMovieCommentAdapter(getActivity());

    }

    @Override
    protected void initData() {
        super.initData();

        SharedPreferences data = SharedPreferencesUtils.getInstance().getData();
        String detaiMovie = data.getString("detaiMovie", "");
        DetailMovieBean detailMovieBean1 = new Gson().fromJson(detaiMovie, DetailMovieBean.class);
        DetailMovieBean.ResultBean bean = detailMovieBean1.getResult();
        movieId = bean.getMovieId();
        mPresenter.getMovieComment(movieId, page, 7);


        //设置下拉颜色
        srlMore.setColorSchemeColors(Color.RED);

        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        srlMore.setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        srlMore.setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        srlMore.setSize(SwipeRefreshLayout.LARGE);

        srlMore.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page=1;
                mPresenter.getMovieComment(movieId, 1, page*7);
            }
        });



        rvMore.setAdapter(myMovieCommentAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rvMore.setLayoutManager(linearLayoutManager);
        rvMore.addItemDecoration(new SpacesItemDecoration(10));

        rvMore.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                //获取当前屏幕可见条目的第一个条目的下标
                int firstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                //获取当前屏幕可见条目的最后一个条目的标
                int lastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                int itemCount = linearLayoutManager.getItemCount();
                // 判断是否到底，到底page++ 加载数据
                if (itemCount - 1 == lastCompletelyVisibleItemPosition && newState == rvMore.SCROLL_STATE_IDLE) {
                    page++;
                    mPresenter.getMovieComment(movieId, 1, page*7);
                }

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });


        myMovieCommentAdapter.setCallBack(new MyMovieCommentAdapter.OnCallBackComment() {
            @Override
            public void ClickGreat(int commentId, View view, int greate_num, View view1) {
                CheckBox box = (CheckBox) view1;
                TextView textView = (TextView) view;
                box.setChecked(true);
                if (commentId != 0 && box.isChecked()) {
                    textView.setText(greate_num + "");
                } else if (commentId != 0 && !box.isChecked()) {
                    textView.setText(greate_num + 1 + "");
                }
                mPresenter.postGreayComment(commentId);
            }

            @Override
            public void ClickComment(String comment) {
                if (comment != null) {
                    Intent intent = new Intent(getActivity(), CommentDetailActivity.class);
                    intent.putExtra("comment", comment);
                    intent.putExtra("movieId", movieId);
                    startActivity(intent);
                }

            }
        });

    }

    @Override
    public void onMovieCommentSuccess(MovieCommentBean movieCommentBean) {

        Log.i("mc_suc", movieCommentBean.getMessage());

        srlMore.setRefreshing(false);

        List<MovieCommentBean.ResultBean> result = movieCommentBean.getResult();

        myMovieCommentAdapter.setList(result);
    }

    @Override
    public void onGreayComment(LoginBean loginBean) {
        Log.i("great_suc", loginBean.getMessage());
        Toast.makeText(getActivity(), loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        if (loginBean.getStatus().equals("0000")) {
            mPresenter.getMovieComment(movieId, 1, 100);
        }
    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err", e.getMessage());
    }


}
