package com.bw.movie.model;

import com.bw.movie.contract.BuyTicketContract;
import com.bw.movie.model.bean.DetailMovieBean;
import com.bw.movie.model.bean.cinema_bean.NearbyCinemasBean;
import com.bw.movie.model.bean.pay_movie.BuyMovieTicketBean;
import com.bw.movie.model.bean.pay_movie.CinemaInfoRegionDatePriceBean;
import com.bw.movie.model.bean.pay_movie.MovieScheduleBean;
import com.bw.movie.model.bean.pay_movie.PayMoneyBean;
import com.bw.movie.model.bean.pay_movie.SeatInfoBean;
import com.bw.movie.utils.RetrofitManager;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-16
 * INTRODUCE：$
 */
public class BuyTicketModel implements BuyTicketContract.IBuyTicketModel {

    //附近影院
    @Override
    public void getNearbyCinemas(HashMap<String, Object> params, IBuyTicketCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getNearbyCinemas(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NearbyCinemasBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NearbyCinemasBean nearbyCinemasBean) {
                        callBack.onSuccess(nearbyCinemasBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //查询电影详细
    @Override
    public void getDetail(int movieId, IBuyTicketCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getDetailMovie(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DetailMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DetailMovieBean detailMovieBean) {
                        callBack.onDetailSuccess(detailMovieBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //支付
    @Override
    public void postPayMoney(int payType, String orderId, IBuyTicketCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postPayMoney(payType,orderId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PayMoneyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PayMoneyBean payMoneyBean) {
                        callBack.onPayMoneySuccess(payMoneyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //购票下单
    @Override
    public void postBuyMovieTicket(HashMap<String, Object> params, IBuyTicketCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postBuyMovieTicket(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BuyMovieTicketBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BuyMovieTicketBean buyMovieTicketBean) {
                        callBack.onBuyTicketSuccess(buyMovieTicketBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //根据电影ID和影院ID查询电影排期列表 get queryParam movieId cinemaId (&&int)
    @Override
    public void getMovieSchedule(int movieId,int cinemaId, IBuyTicketCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getMovieSchedule(movieId,cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieScheduleBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieScheduleBean movieScheduleBean) {
                        callBack.onMovieScheduleSuccess(movieScheduleBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //根据影厅id 查询座位信息 get queryParam hallId (&&int)
    @Override
    public void getSeatInfo(int hallId, IBuyTicketCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getSeatInfo(hallId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SeatInfoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SeatInfoBean seatInfoBean) {
                        callBack.onSeatInfoSuccess(seatInfoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //根据电影id,区域id 查询播放影院信息 get queryParam movieId,regionId,page,count (&&int)
    @Override
    public void getCinemaByRegion(HashMap<String, Object> params, IBuyTicketCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getCinemaByRegion(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaInfoRegionDatePriceBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaInfoRegionDatePriceBean cinemaInfoRegionDatePriceBean) {
                        callBack.onCinemaByRegionSuccess(cinemaInfoRegionDatePriceBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //根据电影id，时间 查询播放影院信息 get queryParam movieId,page,count (&&int) date (&String)
    @Override
    public void getCinemaByDate(HashMap<String, Object> params, IBuyTicketCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getCinemaByDate(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaInfoRegionDatePriceBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaInfoRegionDatePriceBean cinemaInfoRegionDatePriceBean) {
                        callBack.onCinemaByDateSuccess(cinemaInfoRegionDatePriceBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //根据电影价格查询播放影院信息 get queryParam movieId,page,count (&&int)
    @Override
    public void getCinemaByPrice(HashMap<String, Object> params, IBuyTicketCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getCinemaByPrice(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaInfoRegionDatePriceBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaInfoRegionDatePriceBean cinemaInfoRegionDatePriceBean) {
                        callBack.onCinemaByPriceSuccess(cinemaInfoRegionDatePriceBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
