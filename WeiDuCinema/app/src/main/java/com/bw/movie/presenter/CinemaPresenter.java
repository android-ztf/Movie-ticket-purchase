package com.bw.movie.presenter;

import android.content.SharedPreferences;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.CinemaContract;
import com.bw.movie.model.CinemaModel;
import com.bw.movie.model.bean.cinema_bean.CinemaCommentBean;
import com.bw.movie.model.bean.cinema_bean.CinemaInfoBean;
import com.bw.movie.model.bean.cinema_bean.CinemaMovieListBean;
import com.bw.movie.model.bean.cinema_bean.CinemaRegionBean;
import com.bw.movie.model.bean.cinema_bean.FindCinemaBean;
import com.bw.movie.model.bean.cinema_bean.FindDateBean;
import com.bw.movie.model.bean.cinema_bean.NearbyCinemasBean;
import com.bw.movie.model.bean.cinema_bean.RegionListBean;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-2
 * INTRODUCE：$
 */
public class CinemaPresenter extends BasePresenter<CinemaContract.ICinemaView> implements CinemaContract.ICinemaPresenter {

    private CinemaModel cinemaModel;

    public CinemaPresenter() {
        cinemaModel = new CinemaModel();
    }

    //推荐影院
    @Override
    public void getRecommendCinemas(int page, int count) {
        cinemaModel.getRecommendCinemas(page, count, new CinemaContract.ICinemaModel.ICinemaCallBack() {
            @Override
            public void onSuccess(NearbyCinemasBean nearbyCinemasBean) {
                getView().onSuccess(nearbyCinemasBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    //附近影院
    @Override
    public void getNearbyCinemas(int page, int count,String la,String lo) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("longitude",lo);
        params.put("latitude",la);
        params.put("page",page);
        params.put("count",count);

        cinemaModel.getNearbyCinemas(params, new CinemaContract.ICinemaModel.ICinemaCallBack() {
            @Override
            public void onSuccess(NearbyCinemasBean nearbyCinemasBean) {
                getView().onSuccess(nearbyCinemasBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    //查看影院详细信息
    @Override
    public void getCinemaInfo(int cinemaId) {
        cinemaModel.getCinemaInfo(cinemaId, new CinemaContract.ICinemaModel.ICinemaCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onCinemaInfoSuccess(CinemaInfoBean cinemaInfoBean) {

                if (cinemaInfoBean.getStatus().equals("0000")) {
                    SharedPreferences.Editor editor = SharedPreferencesUtils.getInstance().putData();
                    String json = new Gson().toJson(cinemaInfoBean);
                    editor.putString("cinemaInfo", json);
                    editor.commit();

                    getView().onCinemaInfoSuccess(cinemaInfoBean);
                }else{
                    getView().onFailure(new Exception("错误"));
                }
            }
        });
    }

    //关注影院
    @Override
    public void getFollowCinema(int cinemaId) {
        cinemaModel.getFollowCinema(cinemaId, new CinemaContract.ICinemaModel.ICinemaCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onCinemaInfoSuccess(CinemaInfoBean cinemaInfoBean) {
                getView().onFollowSuccess(cinemaInfoBean);
            }
        });
    }

    //取消关注影院
    @Override
    public void getCancelFollowCinema(int cinemaId) {
        cinemaModel.getCancelFollowCinema(cinemaId, new CinemaContract.ICinemaModel.ICinemaCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onCinemaInfoSuccess(CinemaInfoBean cinemaInfoBean) {
                getView().onFollowSuccess(cinemaInfoBean);
            }
        });
    }

    //查看用户所有评论
    @Override
    public void getFindCommentCinema(int cinemaId, int page, int count) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("cinemaId",cinemaId);
        params.put("page",page);
        params.put("count",count);
        cinemaModel.getFindCommentCinema(params, new CinemaContract.ICinemaModel.ICinemaCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
            @Override
            public void onFindCommentSuccess(CinemaCommentBean cinemaCommentBean) {

                getView().onFindCommentSuccess(cinemaCommentBean);
            }
        });
    }
    //用户点赞影院
    @Override
    public void postCommentGreat(int commentId) {
        cinemaModel.postCommentGreat(commentId, new CinemaContract.ICinemaModel.ICinemaCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onFindCommentSuccess(CinemaCommentBean cinemaCommentBean) {
                getView().onCommentGreatSuccess(cinemaCommentBean);
            }
        });
    }
    //查询影院下的电影排期
    @Override
    public void getCinemaMovieList(int cinemaId, int page, int count) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("cinemaId",cinemaId);
        params.put("page",page);
        params.put("count",count);
        cinemaModel.getCinemaMovieList(params, new CinemaContract.ICinemaModel.ICinemaCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
            @Override
            public void onMovieListSuccess(CinemaMovieListBean cinemaMovieListBean) {
                getView().onMovieListSuccess(cinemaMovieListBean);
            }
        });
    }
    //查询一周排期的时间
    @Override
    public void getFindDate() {
        cinemaModel.getFindDate(new CinemaContract.ICinemaModel.ICinemaCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onFindDateSuccess(FindDateBean findDateBean) {
                getView().onFindDateSuccess(findDateBean);
            }
        });
    }

    //查询区域列表
    @Override
    public void getCinemaRegion(int regionId) {
        cinemaModel.getCinemaRegion(regionId, new CinemaContract.ICinemaModel.ICinemaCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onCinemaRegionSuccess(CinemaRegionBean cinemaRegionBean) {
                getView().onCinemaRegionSuccess(cinemaRegionBean);
            }
        });
    }
    //根据区域查询影院
    @Override
    public void getRegionList() {
        cinemaModel.getRegionList(new CinemaContract.ICinemaModel.ICinemaCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onRegionListSuccess(RegionListBean regionListBean) {
                getView().onRegionListSuccess(regionListBean);
            }
        });
    }


}
