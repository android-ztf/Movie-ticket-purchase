package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.CinemaContract;
import com.bw.movie.contract.SeekContract;
import com.bw.movie.model.SeekModel;
import com.bw.movie.model.bean.SeekMovieBean;
import com.bw.movie.model.bean.cinema_bean.CinemaCommentBean;
import com.bw.movie.model.bean.cinema_bean.FindCinemaBean;

import java.util.HashMap;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-21
 * INTRODUCE：$
 */
public class SeekPresenter extends BasePresenter<SeekContract.ISeekView> implements SeekContract.ISeekPresenter {

    private SeekModel seekModel;

    public SeekPresenter() {
        seekModel = new SeekModel();
    }

    @Override
    public void getMoviewSeek(String keyword, int page, int count) {

        HashMap<String, Object> params = new HashMap<>();
        params.clear();
        params.put("keyword",keyword);
        params.put("page",page);
        params.put("count",count);

        seekModel.getMoviewSeek(params, new SeekContract.ISeekModel.ISeekModelCallBack() {

            @Override
            public void onMoviewSuccess(SeekMovieBean seekMovieBean) {
                getView().onMoviewSuccess(seekMovieBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    //模糊查询电影院
    @Override
    public void getSeekCinema(String cinemaName, int page, int count) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("cinemaName",cinemaName);
        params.put("page",page);
        params.put("count",count);
        seekModel.getSeekCinema(params, new SeekContract.ISeekModel.ISeekModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onFindCinemaSuccess(FindCinemaBean findCinemaBean) {
                getView().onFindCinemaSuccess(findCinemaBean);
            }
        });
    }

}
