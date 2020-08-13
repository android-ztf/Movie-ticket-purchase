package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.MineModel;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.PutPicBean;
import com.bw.movie.model.bean.UserInFoBean;
import com.bw.movie.model.bean.cinema_bean.CinemaInfoBean;
import com.bw.movie.model.bean.mine.BindWeixinBean;
import com.bw.movie.model.bean.mine.BuyTicketBean;
import com.bw.movie.model.bean.mine.ExchangeCodeBean;
import com.bw.movie.model.bean.mine.MyMovieTicketBean;
import com.bw.movie.model.bean.mine.NewVersionBean;
import com.bw.movie.model.bean.mine.SeenCommentBean;
import com.bw.movie.model.bean.mine.SysMsgAllBean;
import com.bw.movie.model.bean.mine.TicketRecordBean;
import com.bw.movie.model.bean.mine.UnreadMsgCountBean;
import com.bw.movie.model.bean.mine.UserCommentCinema;
import com.bw.movie.model.bean.mine.UserCommentMovie;
import com.bw.movie.model.bean.mine.UserFollowCinemaBean;
import com.bw.movie.model.bean.mine.UserFollowMovieBean;
import com.bw.movie.model.bean.mine.UserReserveBean;
import com.bw.movie.model.bean.mine.UserSeenBean;
import com.bw.movie.model.bean.pay_movie.PayMoneyBean;

import java.util.HashMap;

import okhttp3.MultipartBody;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-28
 * INTRODUCE：$
 */
public class MinePresenter extends BasePresenter<MineContract.IMineView> implements MineContract.IMinePresenter {

    private MineModel mineModel;

    public MinePresenter() {
        mineModel = new MineModel();
    }

    //获取用户信息
    @Override
    public void getUserInFo() {
        mineModel.getUserInFo(new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onUserInFoSuccess(UserInFoBean userInFoBean) {
                getView().onUserInFoSuccess(userInFoBean);
            }
        });
    }

    //头像上传
    @Override
    public void postPutPicSuccess(MultipartBody.Part image) {
        mineModel.postPutPicSuccess(image, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onPutPicSuccess(PutPicBean putPicBean) {
                getView().onPutPicSuccess(putPicBean);
            }
        });
    }

    //修改用户生日
    @Override
    public void postPutBrithSuccess(String birthday) {
        mineModel.postPutBrithSuccess(birthday, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onPutBrithSuccess(LoginBean loginBean) {
                getView().onPutBrithSuccess(loginBean);
            }
        });
    }

    //取消关注电影
    @Override
    public void getCancelMovieSuccess(int movieId) {
        mineModel.getCancelMovieSuccess(movieId, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onCancelMovieSuccess(LoginBean loginBean) {
                getView().onCancelMovieSuccess(loginBean);
            }
        });
    }

    //取消关注影院
    @Override
    public void getCancelCinemaSuccess(int cinemaId) {
        mineModel.getCancelCinemaSuccess(cinemaId, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onCancelCinemaSuccess(CinemaInfoBean cinemaInfoBean) {
                getView().onCancelCinemaSuccess(cinemaInfoBean);
            }
        });
    }

    //查看关注电影
    @Override
    public void getUserFollowMovieSuccess(int page, int count) {
        mineModel.getUserFollowMovieSuccess(page,count, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onUserFollowMovieSuccess(UserFollowMovieBean userFollowMovieBean) {
                getView().onUserFollowMovieSuccess(userFollowMovieBean);
            }
        });
    }

    //查看关注影院
    @Override
    public void getUserFollowCinemaSuccess(int page, int count) {
        mineModel.getUserFollowCinemaSuccess(page,count, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onUserFollowCinemaSuccess(UserFollowCinemaBean userFollowCinemaBean) {
                getView().onUserFollowCinemaSuccess(userFollowCinemaBean);
            }
        });
    }

    //预约的电影
    @Override
    public void getUserReserve() {
        mineModel.getUserReserve(new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onUserReserveSuccess(UserReserveBean userReserveBean) {
                getView().onUserReserveSuccess(userReserveBean);
            }
        });
    }

    //意见反馈
    @Override
    public void postFeedBack(String content) {
        mineModel.postFeedBack(content,new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onFeedBackSuccess(LoginBean loginBean) {
                getView().onFeedBackSuccess(loginBean);
            }
        });
    }

    //看过的电影
    @Override
    public void getUserSeen() {
        mineModel.getUserSeen(new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onUserSeenSuccess(UserSeenBean userSeenBean) {
                getView().onUserSeenSuccess(userSeenBean);
            }
        });
    }

    //查询我对电影的评论
    @Override
    public void getUserCommnetMovie(int page, int count) {
        mineModel.getUserCommnetMovie(page,count,new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onUserCommnetMovieSuccess(UserCommentMovie userCommentMovie) {
                getView().onUserCommnetMovieSuccess(userCommentMovie);
            }
        });
    }

    //查询我对影院的评论
    @Override
    public void getUserCommentCinema(int page, int count, String longitude, String latitude) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("count",count);
        params.put("longitude",longitude);
        params.put("latitude",latitude);

        mineModel.getUserCommentCinema(params,new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onUserCommnetCinemaSuccess(UserCommentCinema userCommentCinema) {
                getView().onUserCommnetCinemaSuccess(userCommentCinema);
            }
        });
    }

    //查询新版本
    @Override
    public void getNewVersion(String ak) {
        mineModel.getNewVersion(ak, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onNewVersionSuccess(NewVersionBean newVersionBean) {
                getView().onNewVersionSuccess(newVersionBean);
            }
        });
    }

    //修改密码
    @Override
    public void postAlterPwd(String oldPwd, String newPwd, String newPwd2) {
        HashMap<String, Object> params = new HashMap<>();
        mineModel.postAlterPwd(params, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onSuccess(LoginBean loginBean) {
                getView().onSuccess(loginBean);
            }
        });
    }

    //购票记录
    @Override
    public void getBuyTicketRecord(int page, int count, int status) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("count",count);
        params.put("status",status);

        mineModel.getBuyTicketRecord(params, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onTicketRecord(TicketRecordBean ticketRecordBean) {
                getView().onTicketRecord(ticketRecordBean);
            }
        });
    }

    //修改用户手机号
    @Override
    public void postUpdatePhone(String phone) {
        mineModel.postUpdatePhone(phone, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onUpdatePhone(LoginBean loginBean) {
                getView().onUpdatePhone(loginBean);
            }
        });
    }

    //绑定微信支付账号
    @Override
    public void postBindWeixin(String code) {
        mineModel.postBindWeixin(code, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onBindWeixin(LoginBean loginBean) {
                getView().onBindWeixin(loginBean);
            }
        });
    }

    //是否绑定微信账号
    @Override
    public void getWhetherBindWeixin() {
        mineModel.getWhetherBindWeixin(new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onWhetherBindWeixin(BindWeixinBean bindWeixinBean) {
                getView().onWhetherBindWeixin(bindWeixinBean);
            }
        });
    }

    //查询取票码
    @Override
    public void getExchangeCode(int recordId) {
        mineModel.getExchangeCode(recordId, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onExchangeCode(ExchangeCodeBean exchangeCodeBean) {
                getView().onExchangeCode(exchangeCodeBean);
            }
        });
    }

    //查看订单详情
    @Override
    public void getBuyTicketDetail(String orderId) {
        mineModel.getBuyTicketDetail(orderId, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onBuyTicketDetail(BuyTicketBean buyTicketBean) {
                getView().onBuyTicketDetail(buyTicketBean);
            }
        });
    }

    //查询用户观看后的电影评论
    @Override
    public void getSeenComment(int recordId) {
        mineModel.getSeenComment(recordId, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onSeenComment(SeenCommentBean seenCommentBean) {
                getView().onSeenComment(seenCommentBean);
            }
        });
    }

    //支付
    @Override
    public void postPayMoney(int payType, String orderId) {
        mineModel.postPayMoney(payType, orderId, new MineContract.IMineModel.IMineModelCallBack() {
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

    //我的电影票
    @Override
    public void getMyMovieTicket() {
        mineModel.getMyMovieTicket(new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onMyMovieTicket(MyMovieTicketBean myMovieTicketBean) {
                getView().onMyMovieTicket(myMovieTicketBean);
            }
        });
    }

    //查看系统消息列表
    @Override
    public void getSysMsgAll(int page, int count) {
        mineModel.getSysMsgAll(page, count, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onSysMsgAll(SysMsgAllBean sysMsgAllBean) {
                getView().onSysMsgAll(sysMsgAllBean);
            }
        });
    }


    //系统消息读取状态修改
    @Override
    public void getChangeSysMsg(int id) {
        mineModel.getChangeSysMsg(id, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onChangeSysMsg(LoginBean loginBean) {
                getView().onChangeSysMsg(loginBean);
            }
        });
    }

    //查询用户当前未读消息数量
    @Override
    public void getUnreadMsgCount() {
        mineModel.getUnreadMsgCount(new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onUnreadMsgCount(UnreadMsgCountBean unreadMsgCountBean) {
                getView().onUnreadMsgCount(unreadMsgCountBean);
            }
        });
    }

    //上传消息推送使用的token
    @Override
    public void postUploadToken(String token, int os) {
        mineModel.postUploadToken(token, os, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onUploadToken(LoginBean loginBean) {
                getView().onUploadToken(loginBean);
            }
        });
    }

    //微信分享前置接口，获取分享所需参数
    @Override
    public void getWXShare(String time) {
        String sign=time+"wxShare"+"movie";
        mineModel.getWXShare(sign, time, new MineContract.IMineModel.IMineModelCallBack() {
            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onWXShare(LoginBean loginBean) {
                getView().onWXShare(loginBean);
            }
        });
    }
}
