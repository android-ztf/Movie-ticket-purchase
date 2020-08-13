package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.HomeModel;
import com.bw.movie.model.bean.BannerBean;
import com.bw.movie.model.bean.ComingMovieBean;
import com.bw.movie.model.bean.DetailMovieBean;
import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.ReleaseMovieBean;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-16
 * INTRODUCE：$
 */
public class HomePresenter extends BasePresenter<HomeContract.IHomeView> implements HomeContract.IHomePresenter {

    private HomeModel homeModel;

    public HomePresenter() {
        homeModel = new HomeModel();
    }

    @Override
    public void getBanner() {
        homeModel.getBanner(new HomeContract.IHomeModel.IHomeModelCallBack() {

            @Override
            public void onBannerSuccess(BannerBean bannerBean) {
                getView().onBannerSuccess(bannerBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void getRelease(int page, int count) {
        homeModel.getRelease(page,count,new HomeContract.IHomeModel.IHomeModelCallBack() {

            @Override
            public void onReleaseSuccess(ReleaseMovieBean releaseMovieBean) {
                getView().onReleaseSuccess(releaseMovieBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void getComing(int page, int count) {
        homeModel.getComing(page, count, new HomeContract.IHomeModel.IHomeModelCallBack() {

            @Override
            public void onComingSuccess(ComingMovieBean comingMovieBean) {
                getView().onComingSuccess(comingMovieBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void getHot(int page, int count) {
        homeModel.getHot(page, count, new HomeContract.IHomeModel.IHomeModelCallBack() {

            @Override
            public void onHotSuccess(HotMovieBean hotMovieBean) {
                getView().onHotSuccess(hotMovieBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void postReserve(int movieId) {
        homeModel.postReserve(movieId, new HomeContract.IHomeModel.IHomeModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onReserveSuccess(LoginBean loginBean) {
                getView().onReserveSuccess(loginBean);
            }
        });
    }


}
