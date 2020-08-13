package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.HomeModel;
import com.bw.movie.model.bean.DetailMovieBean;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.detail_movie.MovieCommentBean;
import com.bw.movie.model.bean.detail_movie.ReplyCommentBean;
import com.bw.movie.utils.RetrofitManager;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-30
 * INTRODUCE：$
 */
public class DetailPresenter extends BasePresenter<HomeContract.IDetailView> implements HomeContract.IHomePresenter {

    private HomeModel homeModel;

    public DetailPresenter() {
        homeModel = new HomeModel();
    }

    //电影详情
    @Override
    public void getDetail(int movieId) {
        homeModel.getDetail(movieId, new HomeContract.IHomeModel.IHomeModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onDetailSuccess(DetailMovieBean detailMovieBean) {
                getView().onDetailSuccess(detailMovieBean);
            }
        });
    }

    //电影的所有评论
    @Override
    public void getMovieComment(int movieId, int page, int count) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("movieId",movieId);
        params.put("page",page);
        params.put("count",count);

        homeModel.getMovieComment(params, new HomeContract.IHomeModel.IHomeModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onMovieCommentSuccess(MovieCommentBean movieCommentBean) {
                getView().onMovieCommentSuccess(movieCommentBean);
            }
        });

    }

    //关注电影
    @Override
    public void getMovieFollow(int movieId) {
        homeModel.getMovieFollow(movieId, new HomeContract.IHomeModel.IHomeModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onMovieFollow(LoginBean loginBean) {
                getView().onMovieFollow(loginBean);
            }
        });
    }

    //取消关注电影
    @Override
    public void getCancelMovieFollow(int movieId) {
        homeModel.getCancelMovieFollow(movieId, new HomeContract.IHomeModel.IHomeModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onCancelMovieFollow(LoginBean loginBean) {
                getView().onCancelMovieFollow(loginBean);
            }
        });
    }

    //用户对电影的评论
    @Override
    public void postWriteMovieComment(int movieId, String commentContent, double score) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("movieId",movieId);
        params.put("commentContent",commentContent);
        params.put("score",score);

        homeModel.postWriteMovieComment(params, new HomeContract.IHomeModel.IHomeModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onWriteMovieComment(LoginBean loginBean) {
                getView().onWriteMovieComment(loginBean);
            }
        });
    }


    //查看影片评论回复
    @Override
    public void getCommentReplyAll(int commentId, int page, int count) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("commentId",commentId);
        params.put("page",page);
        params.put("count",count);

        homeModel.getCommentReplyAll(params, new HomeContract.IHomeModel.IHomeModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onCommentReplyAll(ReplyCommentBean replyCommentBean) {
                getView().onCommentReplyAll(replyCommentBean);
            }
        });

    }


    //添加用户对评论的回复
    @Override
    public void postReplyComment(int commentId, String replyContent) {
        homeModel.postReplyComment(commentId, replyContent, new HomeContract.IHomeModel.IHomeModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onReplyComment(LoginBean loginBean) {
                getView().onReplyComment(loginBean);
            }
        });
    }

    //电影评论点赞
    @Override
    public void postGreayComment(int commentId) {
        homeModel.postGreayComment(commentId, new HomeContract.IHomeModel.IHomeModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onGreayComment(LoginBean loginBean) {
                getView().onGreayComment(loginBean);
            }
        });
    }

}
