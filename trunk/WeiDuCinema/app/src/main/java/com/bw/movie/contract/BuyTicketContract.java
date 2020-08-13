package com.bw.movie.contract;

import com.bw.movie.base.IBaseView;
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
public interface BuyTicketContract {

    public interface IBuyTicketView extends IBaseView{
        void onFailure(Throwable e);
        //支付
        default void onPayMoneySuccess(PayMoneyBean payMoneyBean){}
        //购票下单
        default void  onBuyTicketSuccess(BuyMovieTicketBean buyMovieTicketBean){}
        //根据电影ID和影院ID查询电影排期列表 get queryParam movieId cinemaId (&&int)
        default void  onMovieScheduleSuccess(MovieScheduleBean movieScheduleBean){}
        //根据影厅id 查询座位信息 get queryParam hallId (&&int)
        default void  onSeatInfoSuccess(SeatInfoBean seatInfoBean){}
        //根据电影id,区域id 查询播放影院信息 get queryParam movieId,regionId,page,count (&&int)
        default void onCinemaByRegionSuccess(CinemaInfoRegionDatePriceBean cinemaInfoRegionDatePriceBean){}
        //根据电影id，时间 查询播放影院信息 get queryParam movieId,page,count (&&int) date (&String)
        default void onCinemaByDateSuccess(CinemaInfoRegionDatePriceBean cinemaInfoRegionDatePriceBean){}
        //根据电影价格查询播放影院信息 get queryParam movieId,page,count (&&int)
        default void onCinemaByPriceSuccess(CinemaInfoRegionDatePriceBean cinemaInfoRegionDatePriceBean){}
        //查询电影信息
        default void onDetailSuccess(DetailMovieBean detailMovieBean){}
        //查询推荐影院和查询附近影院的成功回调
        default void onSuccess(NearbyCinemasBean nearbyCinemasBean){}
    }

    public interface IBuyTicketPresenter{
        //查询电影信息
        default void getDetail(int movieId){}
        //查询附件影院
        default void getNearbyCinemas(int page,int count,String la,String lo){}
        //支付
        default void postPayMoney(int payType,String orderId){}
        //购票订单
        default void postBuyMovieTicket(int scheduleId,String seat,String sign){}
        //根据电影ID和影院ID查询电影排期列表 get queryParam movieId cinemaId (&&int)
        default void getMovieSchedule(int movieId,int cinemaId){}
        //根据影厅id 查询座位信息 get queryParam hallId (&&int)
        default void getSeatInfo(int hallId){}
        //根据电影id,区域id 查询播放影院信息 get queryParam movieId,regionId,page,count (&&int)
        default void getCinemaByRegion(int movieId,int regionId,int page,int count){}
        //根据电影id，时间 查询播放影院信息 get queryParam movieId,page,count (&&int) date (&String)
        default void getCinemaByDate(int movieId,int page,int count,String date){}
        //根据电影价格查询播放影院信息 get queryParam movieId,page,count (&&int)
        default void getCinemaByPrice(int movieId,int page,int count){}
    }

    public interface IBuyTicketModel{
        //查询电影信息
        default void getDetail(int movieId,IBuyTicketCallBack callBack){}
        //查询附件影院
        default void getNearbyCinemas(HashMap<String,Object> params,IBuyTicketCallBack callBack){}
        //支付
        default void postPayMoney(int payType,String orderId,IBuyTicketCallBack callBack){}
        //购票订单
        default void postBuyMovieTicket(HashMap<String,Object> params,IBuyTicketCallBack callBack){}

        //根据电影ID和影院ID查询电影排期列表 get queryParam movieId cinemaId (&&int)
        default void getMovieSchedule(int movieId,int cinemaId,IBuyTicketCallBack callBack){}

        //根据影厅id 查询座位信息 get queryParam hallId (&&int)
        default void getSeatInfo(int hallId,IBuyTicketCallBack callBack){}

        //根据电影id,区域id 查询播放影院信息 get queryParam movieId,regionId,page,count (&&int)
        default void getCinemaByRegion(HashMap<String,Object> params,IBuyTicketCallBack callBack){}

        //根据电影id，时间 查询播放影院信息 get queryParam movieId,page,count (&&int) date (&String)
        default void getCinemaByDate(HashMap<String,Object> params,IBuyTicketCallBack callBack){}

        //根据电影价格查询播放影院信息 get queryParam movieId,page,count (&&int)
        default void getCinemaByPrice(HashMap<String,Object> params,IBuyTicketCallBack callBack){}

        public interface IBuyTicketCallBack{
            void onFailure(Throwable e);
            //支付
            default void onPayMoneySuccess(PayMoneyBean payMoneyBean){}
            //购票下单
            default void  onBuyTicketSuccess(BuyMovieTicketBean buyMovieTicketBean){}
            //根据电影ID和影院ID查询电影排期列表 get queryParam movieId cinemaId (&&int)
            default void  onMovieScheduleSuccess(MovieScheduleBean movieScheduleBean){}
            //根据影厅id 查询座位信息 get queryParam hallId (&&int)
            default void  onSeatInfoSuccess(SeatInfoBean seatInfoBean){}
            //根据电影id,区域id 查询播放影院信息 get queryParam movieId,regionId,page,count (&&int)
            default void onCinemaByRegionSuccess(CinemaInfoRegionDatePriceBean cinemaInfoRegionDatePriceBean){}
            //根据电影id，时间 查询播放影院信息 get queryParam movieId,page,count (&&int) date (&String)
            default void onCinemaByDateSuccess(CinemaInfoRegionDatePriceBean cinemaInfoRegionDatePriceBean){}
            //根据电影价格查询播放影院信息 get queryParam movieId,page,count (&&int)
            default void onCinemaByPriceSuccess(CinemaInfoRegionDatePriceBean cinemaInfoRegionDatePriceBean){}
            //查询电影信息
            default void onDetailSuccess(DetailMovieBean detailMovieBean){}
            //查询推荐影院和查询附近影院的成功回调
            default void onSuccess(NearbyCinemasBean nearbyCinemasBean){}
        }
    }

}
