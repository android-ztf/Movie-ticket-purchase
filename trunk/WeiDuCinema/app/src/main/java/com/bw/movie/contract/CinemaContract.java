package com.bw.movie.contract;

import com.bw.movie.application.Constant;
import com.bw.movie.base.IBaseView;
import com.bw.movie.model.bean.cinema_bean.CinemaCommentBean;
import com.bw.movie.model.bean.cinema_bean.CinemaInfoBean;
import com.bw.movie.model.bean.cinema_bean.CinemaMovieListBean;
import com.bw.movie.model.bean.cinema_bean.CinemaRegionBean;
import com.bw.movie.model.bean.cinema_bean.FindCinemaBean;
import com.bw.movie.model.bean.cinema_bean.FindDateBean;
import com.bw.movie.model.bean.cinema_bean.NearbyCinemasBean;
import com.bw.movie.model.bean.cinema_bean.RegionListBean;

import java.util.HashMap;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-2
 * INTRODUCE：$
 */
public interface CinemaContract {

    public interface ICinemaView extends IBaseView{
        //查询推荐影院和查询附近影院的成功回调
        default void onSuccess(NearbyCinemasBean nearbyCinemasBean){}
        //查询影院详情
        default void onCinemaInfoSuccess(CinemaInfoBean cinemaInfoBean){}
        //关注影院和取消关注影院
        default void onFollowSuccess(CinemaInfoBean cinemaInfoBean){}
        //查询影院用户评论
        default void onFindCommentSuccess(CinemaCommentBean cinemaCommentBean){}
        //影院评论点赞
        default void onCommentGreatSuccess(CinemaCommentBean cinemaCommentBean){}
        //查询影院下的电影排期
        default void onMovieListSuccess(CinemaMovieListBean cinemaMovieListBean){}
        //查询一周排期的时间
        default void onFindDateSuccess(FindDateBean findDateBean){}
        //根据区域查询影院
        default void onCinemaRegionSuccess(CinemaRegionBean cinemaRegionBean){}
        //查询区域列表
        default void onRegionListSuccess(RegionListBean regionListBean){}


        void onFailure(Throwable e);
    }

    public interface ICinemaPresenter{
        //查询推荐影院
        default void getRecommendCinemas(int page,int count){}
        //查询附件影院
        default void getNearbyCinemas(int page,int count,String la,String lo){}
        //查询影院详情
        default void getCinemaInfo(int cinemaId){}
        //关注影院
        default void getFollowCinema(int cinemaId){}
        //取消关注影院
        default void getCancelFollowCinema(int cinemaId){}
        //查询影院用户评论
        default void getFindCommentCinema(int cinemaId,int page,int count){}
        //影院评论点赞
        default void postCommentGreat(int commentId){}
        //查询影院下的电影排期
        default void getCinemaMovieList(int cinemaId,int page,int count){}
        //查询一周排期的时间
        default void getFindDate(){}
        //根据区域查询影院
        default void getCinemaRegion(int regionId){}
        //查询区域列表
        default void getRegionList(){}


    }

    public interface ICinemaModel{
        //查询推荐影院
        default void getRecommendCinemas(int page,int count,ICinemaCallBack callBack){}
        //查询附件影院
        default void getNearbyCinemas(HashMap<String,Object> params,ICinemaCallBack callBack){}
        //查询影院详情
        default void getCinemaInfo(int cinemaId,ICinemaCallBack callBack){}
        //关注影院
        default void getFollowCinema(int cinemaId,ICinemaCallBack callBack){}
        //取消关注影院
        default void getCancelFollowCinema(int cinemaId,ICinemaCallBack callBack){}
        //查询影院用户评论
        default void getFindCommentCinema(HashMap<String,Object> params,ICinemaCallBack callBack){}
        //影院评论点赞
        default void postCommentGreat(int commentId,ICinemaCallBack callBack){}
        //查询影院下的电影排期
        default void getCinemaMovieList(HashMap<String,Object> params,ICinemaCallBack callBack){}
        //查询一周排期的时间
        default void getFindDate(ICinemaCallBack callBack){}
        //根据区域查询影院
        default void getCinemaRegion(int regionId,ICinemaCallBack callBack){}
        //查询区域列表
        default void getRegionList(ICinemaCallBack callBack){}


        public interface ICinemaCallBack{
            //查询推荐影院和查询附近影院的成功回调
            default void onSuccess(NearbyCinemasBean nearbyCinemasBean){}
            //查询影院详情 关注影院和取消关注影院
            default void onCinemaInfoSuccess(CinemaInfoBean cinemaInfoBean){}
            //查询影院用户评论 和 点赞
            default void onFindCommentSuccess(CinemaCommentBean cinemaCommentBean){}
            //查询影院下的电影排期
            default void onMovieListSuccess(CinemaMovieListBean cinemaMovieListBean){}
            //查询一周排期的时间
            default void onFindDateSuccess(FindDateBean findDateBean){}
            //根据区域查询影院
            default void onCinemaRegionSuccess(CinemaRegionBean cinemaRegionBean){}
            //查询区域列表
            default void onRegionListSuccess(RegionListBean regionListBean){}

            void onFailure(Throwable e);
        }

    }




}
