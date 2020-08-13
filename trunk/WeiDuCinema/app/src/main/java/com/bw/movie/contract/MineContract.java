package com.bw.movie.contract;

import com.bw.movie.application.Constant;
import com.bw.movie.base.IBaseView;
import com.bw.movie.model.bean.BannerBean;
import com.bw.movie.model.bean.ComingMovieBean;
import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.PutPicBean;
import com.bw.movie.model.bean.ReleaseMovieBean;
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
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-18
 * INTRODUCE：我的页面 契约类$
 */
public interface MineContract {

    public interface IMineView extends IBaseView{
        default void onUserInFoSuccess(UserInFoBean userInFoBean){}//获取用户信息
        default void onPutPicSuccess(PutPicBean putPicBean){}//用户上传头像 和 用户修改头像 使用一个出参

        default void onPutBrithSuccess(LoginBean loginBean){}//修改用户生日


        //取消关注电影
        default void onCancelMovieSuccess(LoginBean loginBean){}
        //取消关注影院
        default void onCancelCinemaSuccess(CinemaInfoBean cinemaInfoBean){}
        //查看用户关注电影列表
        default void onUserFollowMovieSuccess(UserFollowMovieBean userFollowMovieBean){}
        //查看用户关注影院列表
        default void onUserFollowCinemaSuccess(UserFollowCinemaBean userFollowCinemaBean){}

        //查询用户预约电影信息 get Header userId(int) sessionId(String)
        default void onUserReserveSuccess(UserReserveBean userReserveBean){}
        //意见反馈 post Header userId(int) sessionId(String),FromParams content (&String)
        default void onFeedBackSuccess(LoginBean loginBean){}
        //查询看过的电影 get Header userId(int) sessionId(String)
        default void onUserSeenSuccess(UserSeenBean userSeenBean){}
        //查询我对电影的评论列表 get Header userId(int) sessionId(String) ,queryParam page,count (&&int)
        default void onUserCommnetMovieSuccess(UserCommentMovie userCommentMovie){}
        //查询我对影院的评论列表 get Header userId(int) sessionId(String) ,queryParam longitude , latitude (&&String), page,count (&&int)
        default void onUserCommnetCinemaSuccess(UserCommentCinema userCommentCinema){}

        //查询新版本 get Header userId(int) sessionId  ak (String)
        default void onNewVersionSuccess(NewVersionBean newVersionBean){}
        //修改密码
        default void onSuccess(LoginBean loginBean){}

        //购票记录
        default void onTicketRecord(TicketRecordBean ticketRecordBean){}
        //修改用户手机号
        default void onUpdatePhone(LoginBean loginBean){}
        //绑定微信支付账号
        default void onBindWeixin(LoginBean loginBean){}
        //是否绑定微信账号
        default void onWhetherBindWeixin(BindWeixinBean bindWeixinBean){}
        //查询取票码
        default void onExchangeCode(ExchangeCodeBean exchangeCodeBean){}
        //查看订单详情
        default void onBuyTicketDetail(BuyTicketBean buyTicketBean){}
        //查询用户观看后的电影评论
        default void onSeenComment(SeenCommentBean seenCommentBean){}
        //支付
        default void onPayMoneySuccess(PayMoneyBean payMoneyBean){}

        //我的电影票
        default void onMyMovieTicket(MyMovieTicketBean myMovieTicketBean){}

        //查询系统消息列表 get Header userId(int) sessionId , queryParam page,count (&&int)
        default void onSysMsgAll(SysMsgAllBean sysMsgAllBean){}

        //系统消息读取状态修改 get Header userId(int) sessionId , queryParam id(&&int)
        default void onChangeSysMsg(LoginBean loginBean){}

        //查询用户当前未读消息数量 get Header userId(int) sessionId
        default void onUnreadMsgCount(UnreadMsgCountBean unreadMsgCountBean){}

        //上传消息推送使用的token (腾讯信鸽) post Header userId(int) sessionId ,FormParam token(&String) os(&int)
        default void onUploadToken(LoginBean loginBean){}

        //微信分享前置接口，获取分享所需参数 get queryParam sign , time (&&String)
        default void onWXShare(LoginBean loginBean){}

        void onFailure(Throwable e);
    }

    public interface IMinePresenter{
        //获取用户信息
        default void getUserInFo(){}
        default void postPutPicSuccess(MultipartBody.Part image){}

        //取消关注电影
        default void getCancelMovieSuccess(int movieId){}
        //取消关注影院
        default void getCancelCinemaSuccess(int cinemaId){}
        //查看用户关注电影列表
        default void getUserFollowMovieSuccess(int page,int count){}
        //查看用户关注影院列表
        default void getUserFollowCinemaSuccess(int page,int count){}

        //查询用户预约电影信息 get Header userId(int) sessionId(String)
        default void getUserReserve(){}
        //意见反馈 post Header userId(int) sessionId(String),FromParams content (&String)
        default void postFeedBack(String content){}
        //查询看过的电影 get Header userId(int) sessionId(String)
        default void getUserSeen(){}
        //查询我对电影的评论列表 get Header userId(int) sessionId(String) ,queryParam page,count (&&int)
        default void getUserCommnetMovie(int page,int count){}
        //查询我对影院的评论列表 get Header userId(int) sessionId(String) ,queryParam longitude , latitude (&&String), page,count (&&int)
        default void getUserCommentCinema(int page,int count,String longitude,String latitude){}

        //查询新版本 get Header userId(int) sessionId  ak (String)
        default void getNewVersion(String ak){}
        //修改密码
        default void postAlterPwd(String oldPwd,String newPwd,String newPwd2){}

        //购票记录
        default void getBuyTicketRecord(int page,int count,int status){}
        //修改用户手机号
        default void postUpdatePhone(String phone){}
        //绑定微信支付账号
        default void postBindWeixin(String code){}
        //是否绑定微信账号
        default void getWhetherBindWeixin(){}
        //查询取票码
        default void getExchangeCode(int recordId){}
        //查看订单详情
        default void getBuyTicketDetail(String orderId){}
        //查询用户观看后的电影评论
        default void getSeenComment(int recordId){}
        //支付
        default void postPayMoney(int payType,String orderId){}

        //我的电影票
        default void getMyMovieTicket(){}

        default void postPutBrithSuccess(String birthday){}//修改用户生日

        //查询系统消息列表 get Header userId(int) sessionId , queryParam page,count (&&int)
        default void getSysMsgAll(int page,int count){}

        //系统消息读取状态修改 get Header userId(int) sessionId , queryParam id(&&int)
        default void getChangeSysMsg(int id){}

        //查询用户当前未读消息数量 get Header userId(int) sessionId
        default void getUnreadMsgCount(){}

        //上传消息推送使用的token (腾讯信鸽) post Header userId(int) sessionId ,FormParam token(&String) os(&int)
        default void postUploadToken(String token,int os){}

        //微信分享前置接口，获取分享所需参数 get queryParam sign , time (&&String)
        default void getWXShare(String time){}

    }

    public interface IMineModel{
        //获取用户信息
        default void getUserInFo(IMineModelCallBack callBack){}
        default void postPutPicSuccess(MultipartBody.Part image,IMineModelCallBack callBack){}


        //取消关注电影
        default void getCancelMovieSuccess(int movieId,IMineModelCallBack callBack){}
        //取消关注影院
        default void getCancelCinemaSuccess(int cinemaId,IMineModelCallBack callBack){}
        //查看用户关注电影列表
        default void getUserFollowMovieSuccess(int page,int count,IMineModelCallBack callBack){}
        //查看用户关注影院列表
        default void getUserFollowCinemaSuccess(int page,int count,IMineModelCallBack callBack){}

        //查询用户预约电影信息 get Header userId(int) sessionId(String)
        default void getUserReserve(IMineModelCallBack callBack){}
        //意见反馈 post Header userId(int) sessionId(String),FromParams content (&String)
        default void postFeedBack(String content,IMineModelCallBack callBack){}
        //查询看过的电影 get Header userId(int) sessionId(String)
        default void getUserSeen(IMineModelCallBack callBack){}
        //查询我对电影的评论列表 get Header userId(int) sessionId(String) ,queryParam page,count (&&int)
        default void getUserCommnetMovie(int page,int count,IMineModelCallBack callBack){}
        //查询我对影院的评论列表 get Header userId(int) sessionId(String) ,queryParam longitude , latitude (&&String), page,count (&&int)
        default void getUserCommentCinema(HashMap<String,Object> params,IMineModelCallBack callBack){}
        //查询新版本
        default void getNewVersion(String ak,IMineModelCallBack callBack){}
        //修改密码
        default void postAlterPwd(HashMap<String,Object> params,IMineModelCallBack callBack){}

        //购票记录
        default void getBuyTicketRecord(HashMap<String,Object> params,IMineModelCallBack callBack){}
        //修改用户手机号
        default void postUpdatePhone(String phone,IMineModelCallBack callBack){}
        //绑定微信支付账号
        default void postBindWeixin(String code,IMineModelCallBack callBack){}
        //是否绑定微信账号
        default void getWhetherBindWeixin(IMineModelCallBack callBack){}
        //查询取票码
        default void getExchangeCode(int recordId,IMineModelCallBack callBack){}
        //查看订单详情
        default void getBuyTicketDetail(String orderId,IMineModelCallBack callBack){}
        //查询用户观看后的电影评论
        default void getSeenComment(int recordId,IMineModelCallBack callBack){}
        //支付
        default void postPayMoney(int payType,String orderId,IMineModelCallBack callBack){}

        //我的电影票
        default void getMyMovieTicket(IMineModelCallBack callBack){}

        default void postPutBrithSuccess(String birthday,IMineModelCallBack callBack){}//修改用户生日

        //查询系统消息列表 get Header userId(int) sessionId , queryParam page,count (&&int)
        default void getSysMsgAll(int page,int count,IMineModelCallBack callBack){}

        //系统消息读取状态修改 get Header userId(int) sessionId , queryParam id(&&int)
        default void getChangeSysMsg(int id,IMineModelCallBack callBack){}

        //查询用户当前未读消息数量 get Header userId(int) sessionId
        default void getUnreadMsgCount(IMineModelCallBack callBack){}

        //上传消息推送使用的token (腾讯信鸽) post Header userId(int) sessionId ,FormParam token(&String) os(&int)
        default void postUploadToken(String token,int os,IMineModelCallBack callBack){}

        //微信分享前置接口，获取分享所需参数 get queryParam sign , time (&&String)
        default void getWXShare(String sign,String time,IMineModelCallBack callBack){}

        public interface IMineModelCallBack{
            //获取用户信息
            default void onUserInFoSuccess(UserInFoBean userInFoBean){}
            default void onPutPicSuccess(PutPicBean putPicBean){}//用户上传头像 和 用户修改头像 使用一个出参

            //取消关注电影
            default void onCancelMovieSuccess(LoginBean loginBean){}
            //取消关注影院
            default void onCancelCinemaSuccess(CinemaInfoBean cinemaInfoBean){}
            //查看用户关注电影列表
            default void onUserFollowMovieSuccess(UserFollowMovieBean userFollowMovieBean){}
            //查看用户关注影院列表
            default void onUserFollowCinemaSuccess(UserFollowCinemaBean userFollowCinemaBean){}

            //查询用户预约电影信息 get Header userId(int) sessionId(String)
            default void onUserReserveSuccess(UserReserveBean userReserveBean){}
            //意见反馈 post Header userId(int) sessionId(String),FromParams content (&String)
            default void onFeedBackSuccess(LoginBean loginBean){}
            //查询看过的电影 get Header userId(int) sessionId(String)
            default void onUserSeenSuccess(UserSeenBean userSeenBean){}
            //查询我对电影的评论列表 get Header userId(int) sessionId(String) ,queryParam page,count (&&int)
            default void onUserCommnetMovieSuccess(UserCommentMovie userCommentMovie){}
            //查询我对影院的评论列表 get Header userId(int) sessionId(String) ,queryParam longitude , latitude (&&String), page,count (&&int)
            default void onUserCommnetCinemaSuccess(UserCommentCinema userCommentCinema){}

            //查询新版本 get Header userId(int) sessionId  ak (String)
            default void onNewVersionSuccess(NewVersionBean newVersionBean){}
            //修改密码
            default void onSuccess(LoginBean loginBean){}

            //购票记录
            default void onTicketRecord(TicketRecordBean ticketRecordBean){}
            //修改用户手机号
            default void onUpdatePhone(LoginBean loginBean){}
            //绑定微信支付账号
            default void onBindWeixin(LoginBean loginBean){}
            //是否绑定微信账号
            default void onWhetherBindWeixin(BindWeixinBean bindWeixinBean){}
            //查询取票码
            default void onExchangeCode(ExchangeCodeBean exchangeCodeBean){}
            //查看订单详情
            default void onBuyTicketDetail(BuyTicketBean buyTicketBean){}
            //查询用户观看后的电影评论
            default void onSeenComment(SeenCommentBean seenCommentBean){}
            //支付
            default void onPayMoneySuccess(PayMoneyBean payMoneyBean){}

            //我的电影票
            default void onMyMovieTicket(MyMovieTicketBean myMovieTicketBean){}

            default void onPutBrithSuccess(LoginBean loginBean){}//修改用户生日

            //查询系统消息列表 get Header userId(int) sessionId , queryParam page,count (&&int)
            default void onSysMsgAll(SysMsgAllBean sysMsgAllBean){}

            //系统消息读取状态修改 get Header userId(int) sessionId , queryParam id(&&int)
            default void onChangeSysMsg(LoginBean loginBean){}

            //查询用户当前未读消息数量 get Header userId(int) sessionId
            default void onUnreadMsgCount(UnreadMsgCountBean unreadMsgCountBean){}

            //上传消息推送使用的token (腾讯信鸽) post Header userId(int) sessionId ,FormParam token(&String) os(&int)
            default void onUploadToken(LoginBean loginBean){}

            //微信分享前置接口，获取分享所需参数 get queryParam sign , time (&&String)
            default void onWXShare(LoginBean loginBean){}


            void onFailure(Throwable e);
        }
    }

}
