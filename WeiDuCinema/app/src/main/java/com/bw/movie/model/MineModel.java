package com.bw.movie.model;

import com.bw.movie.contract.MineContract;
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
import com.bw.movie.utils.RetrofitManager;
import com.bw.movie.view.adapter.ScheduleAdapter;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-28
 * INTRODUCE：$
 */
public class MineModel implements MineContract.IMineModel {
    //获取用户信息
    @Override
    public void getUserInFo(IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getUserInFo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInFoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserInFoBean userInFoBean) {
                        callBack.onUserInFoSuccess(userInFoBean);
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

    //头像上传
    @Override
    public void postPutPicSuccess(MultipartBody.Part image, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postPutPic(image)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PutPicBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PutPicBean putPicBean) {
                        callBack.onPutPicSuccess(putPicBean);
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

    //修改用户生日
    @Override
    public void postPutBrithSuccess(String birthday, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postPutBrith(birthday)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onPutBrithSuccess(loginBean);
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

    //取消电影
    @Override
    public void getCancelMovieSuccess(int movieId, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getCancelMovieFollow(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onCancelMovieSuccess(loginBean);
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

    //取消影院
    @Override
    public void getCancelCinemaSuccess(int cinemaId, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getCancelFollowCinema(cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaInfoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaInfoBean cinemaInfoBean) {
                        callBack.onCancelCinemaSuccess(cinemaInfoBean);
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

    //查看用户关注电影

    @Override
    public void getUserFollowMovieSuccess(int page, int count, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getUserFollowMovie(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserFollowMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserFollowMovieBean userFollowMovieBean) {
                        callBack.onUserFollowMovieSuccess(userFollowMovieBean);
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

    //查看用户关注影院
    @Override
    public void getUserFollowCinemaSuccess(int page, int count, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getUserFollowCinema(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserFollowCinemaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserFollowCinemaBean userFollowCinemaBean) {
                        callBack.onUserFollowCinemaSuccess(userFollowCinemaBean);
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

    //预约的电影
    @Override
    public void getUserReserve(IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getUserReserve()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserReserveBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserReserveBean userReserveBean) {
                        callBack.onUserReserveSuccess(userReserveBean);
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

    //意见反馈
    @Override
    public void postFeedBack(String content, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postFeedBack(content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onFeedBackSuccess(loginBean);
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


    //看过的电影
    @Override
    public void getUserSeen(IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getUserSeen()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserSeenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserSeenBean userSeenBean) {
                        callBack.onUserSeenSuccess(userSeenBean);
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

    //查看对电影的评论
    @Override
    public void getUserCommnetMovie(int page, int count, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getUserCommnetMovie(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserCommentMovie>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserCommentMovie userCommentMovie) {
                        callBack.onUserCommnetMovieSuccess(userCommentMovie);
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

    //查看对影院的评论
    @Override
    public void getUserCommentCinema(HashMap<String, Object> params, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getUserCommnetCinema(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserCommentCinema>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserCommentCinema userCommentCinema) {
                        callBack.onUserCommnetCinemaSuccess(userCommentCinema);
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

    //修改密码
    @Override
    public void postAlterPwd(HashMap<String, Object> params, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postAlterPwd(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onSuccess(loginBean);
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

    //查询新版本
    @Override
    public void getNewVersion(String ak, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getNewVersion(ak)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewVersionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewVersionBean newVersionBean) {
                        callBack.onNewVersionSuccess(newVersionBean);
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

    //购票记录
    @Override
    public void getBuyTicketRecord(HashMap<String, Object> params, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getBuyTicketRecord(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TicketRecordBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TicketRecordBean ticketRecordBean) {
                        callBack.onTicketRecord(ticketRecordBean);
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

    //修改用户手机号
    @Override
    public void postUpdatePhone(String phone, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postUpdatePhone(phone)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onUpdatePhone(loginBean);
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

    //是否绑定微信支付账号
    @Override
    public void getWhetherBindWeixin(IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getWhetherBindWeixin()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BindWeixinBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BindWeixinBean bindWeixinBean) {
                        callBack.onWhetherBindWeixin(bindWeixinBean);
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

    //绑定微信账号
    @Override
    public void postBindWeixin(String code, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postWeixinLogin(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onBindWeixin(loginBean);
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

    //查询取票码
    @Override
    public void getExchangeCode(int recordId, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getExchangeCode(recordId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ExchangeCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ExchangeCodeBean exchangeCodeBean) {
                        callBack.onExchangeCode(exchangeCodeBean);
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

    //查看订单详情
    @Override
    public void getBuyTicketDetail(String orderId, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getBuyTicketDetail(orderId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BuyTicketBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BuyTicketBean buyTicketBean) {
                        callBack.onBuyTicketDetail(buyTicketBean);
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

    //查询用户观看后的电影评论
    @Override
    public void getSeenComment(int recordId, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getSeenComment(recordId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SeenCommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SeenCommentBean seenCommentBean) {
                        callBack.onSeenComment(seenCommentBean);
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
    public void postPayMoney(int payType, String orderId, IMineModelCallBack callBack) {
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

    //我的电影票
    @Override
    public void getMyMovieTicket(IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getMyMovieTicket()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyMovieTicketBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(MyMovieTicketBean myMovieTicketBean) {
                        callBack.onMyMovieTicket(myMovieTicketBean);
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

    //查看系统消息列表
    @Override
    public void getSysMsgAll(int page, int count, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getSysMsgAll(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SysMsgAllBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SysMsgAllBean sysMsgAllBean) {
                        callBack.onSysMsgAll(sysMsgAllBean);
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

    //系统消息读取状态修改
    @Override
    public void getChangeSysMsg(int id, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getChangeSysMsg(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onChangeSysMsg(loginBean);
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

    //查询用户当前未读消息数量
    @Override
    public void getUnreadMsgCount(IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getUnreadMsgCount()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UnreadMsgCountBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UnreadMsgCountBean unreadMsgCountBean) {
                        callBack.onUnreadMsgCount(unreadMsgCountBean);
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

    //上传消息推送使用的token
    @Override
    public void postUploadToken(String token, int os, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .postUploadToken(token,os)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onUploadToken(loginBean);
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


    //微信分享前置接口，获取分享所需参数
    @Override
    public void getWXShare(String sign, String time, IMineModelCallBack callBack) {
        RetrofitManager.getInstance()
                .create()
                .getWXShare(sign,time)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onWXShare(loginBean);
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
