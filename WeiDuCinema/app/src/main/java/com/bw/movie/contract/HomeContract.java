package com.bw.movie.contract;

import com.bw.movie.base.IBaseView;
import com.bw.movie.model.bean.BannerBean;
import com.bw.movie.model.bean.ComingMovieBean;
import com.bw.movie.model.bean.DetailMovieBean;
import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.ReleaseMovieBean;
import com.bw.movie.model.bean.detail_movie.MovieCommentBean;
import com.bw.movie.model.bean.detail_movie.ReplyCommentBean;

import java.util.HashMap;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-16
 * INTRODUCE：首页契约类$
 */
public interface HomeContract {

    public interface IHomeView extends IBaseView{
        void onBannerSuccess(BannerBean bannerBean);//轮播图成功
        void onReleaseSuccess(ReleaseMovieBean releaseMovieBean);//正在上映电影成功
        void onComingSuccess(ComingMovieBean comingMovieBean);//即将上映电影成功
        void onHotSuccess(HotMovieBean hotMovieBean);//热门电影成功
        void onReserveSuccess(LoginBean loginBean);//即将上映 预约
        void onFailure(Throwable e);
    }

    public interface IMoreView extends IBaseView{
        default void onReleaseSuccess(ReleaseMovieBean releaseMovieBean){}//正在上映电影成功
        default void onComingSuccess(ComingMovieBean comingMovieBean){}//即将上映电影成功
        default void onHotSuccess(HotMovieBean hotMovieBean){}//热门电影成功
        default void onReserveSuccess(LoginBean loginBean){}//即将上映 预约
        void onFailure(Throwable e);
    }

    public interface IDetailView extends IBaseView{
        default void onDetailSuccess(DetailMovieBean detailMovieBean){}//查询电影信息
        default void onMovieCommentSuccess(MovieCommentBean movieCommentBean){}//查询电影所有评论

        default void onMovieFollow(LoginBean loginBean){}//关注电影
        default void onCancelMovieFollow(LoginBean loginBean){}//取消关注电影
        default void onWriteMovieComment(LoginBean loginBean){}//用户对电影的评论
        default void onCommentReplyAll(ReplyCommentBean replyCommentBean){}//查看影片评论回复
        default void onReplyComment(LoginBean loginBean){}//添加用户对评论的回复
        default void onGreayComment(LoginBean loginBean){}//电影评论点赞

        void onFailure(Throwable e);
    }

    public interface IHomePresenter{
        //轮播图
        default void getBanner(){}
        //正在上映电影
        default void getRelease(int page,int count){}
        //即将上映电影
        default void getComing(int page,int count){}
        //热门电影
        default void getHot(int page,int count){}
        //预约电影
        default void postReserve(int movieId){}
        //查询电影信息
        default void getDetail(int movieId){}
        //查询电影所有评论
        default void getMovieComment(int movieId,int page,int count){}

        default void getMovieFollow(int movieId){}//关注电影
        default void getCancelMovieFollow(int movieId){}//取消关注电影
        default void postWriteMovieComment(int movieId,String commentContent,double score){}//用户对电影的评论
        default void getCommentReplyAll(int commentId,int page,int count){}//查看影片评论回复
        default void postReplyComment(int commentId,String replyContent){}//添加用户对评论的回复
        default void postGreayComment(int commentId){}//电影评论点赞
    }

    public interface IHomeModel{
        //轮播图
        void getBanner(IHomeModelCallBack callBack);
        //正在上映电影
        void getRelease(int page,int count,IHomeModelCallBack callBack);
        //即将上映电影
        void getComing(int page,int count,IHomeModelCallBack callBack);
        //热门电影
        void getHot(int page,int count,IHomeModelCallBack callBack);
        //预约电影
        void postReserve(int movieId,IHomeModelCallBack callBack);
        //查询电影信息
        void getDetail(int movieId,IHomeModelCallBack callBack);
        //查询电影所有评论
        default void getMovieComment(HashMap<String,Object> params,IHomeModelCallBack callBack){}

        default void getMovieFollow(int movieId,IHomeModelCallBack callBack){}//关注电影

        default void getCancelMovieFollow(int movieId,IHomeModelCallBack callBack){}//取消关注电影

        default void postWriteMovieComment(HashMap<String,Object> params,IHomeModelCallBack callBack){}//用户对电影的评论

        default void getCommentReplyAll(HashMap<String,Object> params,IHomeModelCallBack callBack){}//查看影片评论回复

        default void postReplyComment(int commentId,String replyContent,IHomeModelCallBack callBack){}//添加用户对评论的回复

        default void postGreayComment(int commentId,IHomeModelCallBack callBack){}//电影评论点赞

        public interface IHomeModelCallBack{
            default void onBannerSuccess(BannerBean bannerBean){}//轮播图成功
            default void onReleaseSuccess(ReleaseMovieBean releaseMovieBean){}//正在上映电影成功
            default void onComingSuccess(ComingMovieBean comingMovieBean){}//即将上映电影成功
            default void onHotSuccess(HotMovieBean hotMovieBean){}//热门电影成功
            default void onReserveSuccess(LoginBean loginBean){}//即将上映 预约
            default void onDetailSuccess(DetailMovieBean detailMovieBean){}//查询电影信息
            default void onMovieCommentSuccess(MovieCommentBean movieCommentBean){}//查询电影所有评论
            default void onMovieFollow(LoginBean loginBean){}//关注电影
            default void onCancelMovieFollow(LoginBean loginBean){}//取消关注电影
            default void onWriteMovieComment(LoginBean loginBean){}//用户对电影的评论
            default void onCommentReplyAll(ReplyCommentBean replyCommentBean){}//查看影片评论回复
            default void onReplyComment(LoginBean loginBean){}//添加用户对评论的回复
            default void onGreayComment(LoginBean loginBean){}//电影评论点赞


            void onFailure(Throwable e);
        }

    }



}
