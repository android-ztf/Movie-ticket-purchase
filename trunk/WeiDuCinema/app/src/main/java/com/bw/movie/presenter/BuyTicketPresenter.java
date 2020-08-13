package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.BuyTicketContract;
import com.bw.movie.contract.CinemaContract;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.BuyTicketModel;
import com.bw.movie.model.bean.DetailMovieBean;
import com.bw.movie.model.bean.cinema_bean.NearbyCinemasBean;
import com.bw.movie.model.bean.pay_movie.BuyMovieTicketBean;
import com.bw.movie.model.bean.pay_movie.CinemaInfoRegionDatePriceBean;
import com.bw.movie.model.bean.pay_movie.MovieScheduleBean;
import com.bw.movie.model.bean.pay_movie.PayMoneyBean;
import com.bw.movie.model.bean.pay_movie.SeatInfoBean;

import java.util.HashMap;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-16
 * INTRODUCE：$
 */
public class BuyTicketPresenter extends BasePresenter<BuyTicketContract.IBuyTicketView> implements BuyTicketContract.IBuyTicketPresenter {

    private BuyTicketModel buyTicketModel;

    public BuyTicketPresenter() {
        buyTicketModel = new BuyTicketModel();
    }

    //电影详情
    @Override
    public void getDetail(int movieId) {
        buyTicketModel.getDetail(movieId, new BuyTicketContract.IBuyTicketModel.IBuyTicketCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onSuccess(NearbyCinemasBean nearbyCinemasBean) {
                getView().onSuccess(nearbyCinemasBean);
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

        buyTicketModel.getNearbyCinemas(params, new BuyTicketContract.IBuyTicketModel.IBuyTicketCallBack() {
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

    //支付
    @Override
    public void postPayMoney(int payType, String orderId) {
        buyTicketModel.postPayMoney(payType, orderId, new BuyTicketContract.IBuyTicketModel.IBuyTicketCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onPayMoneySuccess(PayMoneyBean payMoneyBean) {
                getView().onPayMoneySuccess(payMoneyBean);
            }
        });
    }

    //购票订单
    @Override
    public void postBuyMovieTicket(int scheduleId, String seat, String sign) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("scheduleId",scheduleId);
        params.put("seat",seat);
        params.put("sign",sign);
        buyTicketModel.postBuyMovieTicket(params, new BuyTicketContract.IBuyTicketModel.IBuyTicketCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onBuyTicketSuccess(BuyMovieTicketBean buyMovieTicketBean) {
                getView().onBuyTicketSuccess(buyMovieTicketBean);
            }
        });
    }

    //根据电影ID和影院ID查询电影排期列表 get queryParam movieId cinemaId (&&int)
    @Override
    public void getMovieSchedule(int movieId, int cinemaId) {
        buyTicketModel.getMovieSchedule(movieId, cinemaId, new BuyTicketContract.IBuyTicketModel.IBuyTicketCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onMovieScheduleSuccess(MovieScheduleBean movieScheduleBean) {
                getView().onMovieScheduleSuccess(movieScheduleBean);
            }
        });
    }

    //根据影厅id 查询座位信息 get queryParam hallId (&&int)
    @Override
    public void getSeatInfo(int hallId) {
        buyTicketModel.getSeatInfo(hallId, new BuyTicketContract.IBuyTicketModel.IBuyTicketCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onSeatInfoSuccess(SeatInfoBean seatInfoBean) {
                getView().onSeatInfoSuccess(seatInfoBean);
            }
        });
    }

    // 根据电影id,区域id 查询播放影院信息 get queryParam movieId,regionId,page,count (&&int)
    @Override
    public void getCinemaByRegion(int movieId, int regionId, int page, int count) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("movieId",movieId);
        params.put("regionId",regionId);
        params.put("page",page);
        params.put("count",count);

        buyTicketModel.getCinemaByRegion(params, new BuyTicketContract.IBuyTicketModel.IBuyTicketCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onCinemaByRegionSuccess(CinemaInfoRegionDatePriceBean cinemaInfoRegionDatePriceBean) {
                getView().onCinemaByRegionSuccess(cinemaInfoRegionDatePriceBean);
            }
        });
    }
    //根据电影id，时间 查询播放影院信息 get queryParam movieId,page,count (&&int) date (&String)
    @Override
    public void getCinemaByDate(int movieId, int page, int count, String date) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("movieId",movieId);
        params.put("date",date);
        params.put("page",page);
        params.put("count",count);

        buyTicketModel.getCinemaByDate(params, new BuyTicketContract.IBuyTicketModel.IBuyTicketCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onCinemaByDateSuccess(CinemaInfoRegionDatePriceBean cinemaInfoRegionDatePriceBean) {
                getView().onCinemaByDateSuccess(cinemaInfoRegionDatePriceBean);
            }
        });
    }

    //根据电影价格查询播放影院信息 get queryParam movieId,page,count (&&int)
    @Override
    public void getCinemaByPrice(int movieId, int page, int count) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("movieId",movieId);
        params.put("page",page);
        params.put("count",count);

        buyTicketModel.getCinemaByPrice(params, new BuyTicketContract.IBuyTicketModel.IBuyTicketCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onCinemaByPriceSuccess(CinemaInfoRegionDatePriceBean cinemaInfoRegionDatePriceBean) {
                getView().onCinemaByPriceSuccess(cinemaInfoRegionDatePriceBean);
            }
        });
    }
}
