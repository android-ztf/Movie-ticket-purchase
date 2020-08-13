package com.bw.movie.contract;

import com.bw.movie.base.IBaseView;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.SeekMovieBean;
import com.bw.movie.model.bean.cinema_bean.FindCinemaBean;

import java.util.HashMap;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-21
 * INTRODUCE：$
 */
public interface SeekContract {

    public interface ISeekView extends IBaseView{
        void onMoviewSuccess(SeekMovieBean seekMovieBean);
        void onFailure(Throwable e);
        //根据电影院名称模糊查询电影院
        default  void onFindCinemaSuccess(FindCinemaBean findCinemaBean){}
    }

    public interface ISeekPresenter{
        void getMoviewSeek(String keyword,int page,int count);
        //根据电影院名称模糊查询电影院
        default  void getSeekCinema(String cinemaName,int page,int count){}
    }

    public interface ISeekModel{
        void getMoviewSeek(HashMap<String,Object> params,ISeekModelCallBack callBack);
        //根据电影院名称模糊查询电影院
        default  void getSeekCinema(HashMap<String,Object> params,ISeekModelCallBack callBack){}

        public interface ISeekModelCallBack{
            default void onMoviewSuccess(SeekMovieBean seekMovieBean){};
            //根据电影院名称模糊查询电影院
            default  void onFindCinemaSuccess(FindCinemaBean findCinemaBean){}
            void onFailure(Throwable e);
        }

    }

}
