package com.bw.movie.view.fragment.cinema;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.CinemaContract;
import com.bw.movie.model.bean.cinema_bean.CinemaInfoBean;
import com.bw.movie.model.bean.cinema_bean.CinemaMovieListBean;
import com.bw.movie.presenter.CinemaPresenter;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.activity.DetailMovieActivity;
import com.bw.movie.view.adapter.ScheduleAdapter;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import io.reactivex.schedulers.Schedulers;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-6
 * INTRODUCE：$
 */
public class ScheduleFragment extends BaseFragment<CinemaPresenter> implements CinemaContract.ICinemaView {
    @BindView(R.id.rv_more)
    RecyclerView rvMore;
    private ScheduleAdapter scheduleAdapter;

    @Override
    public int provideLayoutId() {
        return R.layout.fragment_more;
    }

    @Override
    protected CinemaPresenter setPresenter() {
        return new CinemaPresenter();
    }

    @Override
    protected void initData() {
        super.initData();

        scheduleAdapter= new ScheduleAdapter(getActivity());
        rvMore.setAdapter(scheduleAdapter);
        rvMore.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        SpacesItemDecoration decoration = new SpacesItemDecoration(10);
        rvMore.addItemDecoration(decoration);

        SharedPreferences data = SharedPreferencesUtils.getInstance()
                .getData();
        String string = data.getString("cinemaInfo", "");
        CinemaInfoBean bean = new Gson().fromJson(string, CinemaInfoBean.class);
        mPresenter.getCinemaMovieList(bean.getResult().getId(), 1, 6);

        scheduleAdapter.setCallBack(new ScheduleAdapter.OnMovieListCallBack() {
            @Override
            public void onClick(int id) {
                Intent detail_movieId=new Intent(getActivity(), DetailMovieActivity.class);;
                detail_movieId.putExtra("movieId",id);
                startActivity(detail_movieId);
            }
        });

    }

    @Override
    public void onMovieListSuccess(CinemaMovieListBean cinemaMoviListBean) {
        Log.i("movielist_su",cinemaMoviListBean.getMessage());
        List<CinemaMovieListBean.ResultBean> result = cinemaMoviListBean.getResult();
        scheduleAdapter.setList(result);

    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("movielist_su",e.getMessage());
    }
}
