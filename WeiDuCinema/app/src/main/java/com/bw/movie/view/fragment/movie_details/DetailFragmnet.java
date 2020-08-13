package com.bw.movie.view.fragment.movie_details;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.bean.DetailMovieBean;
import com.bw.movie.model.bean.detail_movie.PersonBean;
import com.bw.movie.presenter.DetailPresenter;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.adapter.movie_details.MyPersonAdapter;
import com.bw.movie.view.adapter.movie_details.MyPersondaoAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-17
 * INTRODUCE：$
 */
public class DetailFragmnet extends BaseFragment<DetailPresenter>{
    @BindView(R.id.jianjie)
    TextView jianjie;
    @BindView(R.id.movie_synopsis)
    TextView movieSynopsis;
    @BindView(R.id.yanzhi)
    TextView yanzhi;
    @BindView(R.id.movie_daoyan_num)
    TextView movieDaoyanNum;
    @BindView(R.id.movie_dapyan_RecyclerView)
    RecyclerView movieDapyanRecyclerView;
    @BindView(R.id.movie_yanyuan_num)
    TextView movieYanyuanNum;
    @BindView(R.id.movie_yanyuan_Recycler)
    RecyclerView movieYanyuanRecycler;


    private MyPersonAdapter myPersonAdapter;
    private MyPersondaoAdapter myPersonAdapter1;

    @Override
    public int provideLayoutId() {
        return R.layout.fragment_movie_detail;
    }

    @Override
    protected DetailPresenter setPresenter() {
        return new DetailPresenter();
    }


    @Override
    protected void initData() {
        super.initData();

        myPersonAdapter = new MyPersonAdapter(getActivity());
        myPersonAdapter1 = new MyPersondaoAdapter(getActivity());

        SharedPreferences data = SharedPreferencesUtils.getInstance().getData();
        String detaiMovie = data.getString("detaiMovie", "");
        DetailMovieBean detailMovieBean1 = new Gson().fromJson(detaiMovie, DetailMovieBean.class);
        DetailMovieBean.ResultBean bean = detailMovieBean1.getResult();


        SpacesItemDecoration decoration = new SpacesItemDecoration(10);

        movieDapyanRecyclerView.setAdapter(myPersonAdapter1);
        movieDapyanRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        movieDapyanRecyclerView.addItemDecoration(decoration);
        movieYanyuanRecycler.setAdapter(myPersonAdapter);
        movieYanyuanRecycler.setLayoutManager(new GridLayoutManager(getActivity(),4));
        movieYanyuanRecycler.addItemDecoration(decoration);

        //电影简介
        movieSynopsis.setText(bean.getSummary());
        movieDaoyanNum.setText("导演(" + bean.getMovieDirector().size() + ")");

        myPersonAdapter1.setList1(bean.getMovieDirector());

        movieYanyuanNum.setText("演员(" + bean.getMovieActor().size() + ")");
        myPersonAdapter.setList(bean.getMovieActor());

    }



}
