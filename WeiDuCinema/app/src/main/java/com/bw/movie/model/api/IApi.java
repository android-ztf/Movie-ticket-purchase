package com.bw.movie.model.api;

import android.util.Log;

import com.bw.movie.application.Constant;
import com.bw.movie.model.bean.BannerBean;
import com.bw.movie.model.bean.ComingMovieBean;
import com.bw.movie.model.bean.DetailMovieBean;
import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.PutPicBean;
import com.bw.movie.model.bean.ReleaseMovieBean;
import com.bw.movie.model.bean.SeekMovieBean;
import com.bw.movie.model.bean.UserInFoBean;
import com.bw.movie.model.bean.cinema_bean.CinemaCommentBean;
import com.bw.movie.model.bean.cinema_bean.CinemaInfoBean;
import com.bw.movie.model.bean.cinema_bean.CinemaMovieListBean;
import com.bw.movie.model.bean.cinema_bean.CinemaRegionBean;
import com.bw.movie.model.bean.cinema_bean.FindDateBean;
import com.bw.movie.model.bean.cinema_bean.FindCinemaBean;
import com.bw.movie.model.bean.cinema_bean.NearbyCinemasBean;
import com.bw.movie.model.bean.cinema_bean.RegionListBean;
import com.bw.movie.model.bean.detail_movie.MovieCommentBean;
import com.bw.movie.model.bean.detail_movie.ReplyCommentBean;
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
import com.bw.movie.model.bean.pay_movie.BuyMovieTicketBean;
import com.bw.movie.model.bean.pay_movie.CinemaInfoRegionDatePriceBean;
import com.bw.movie.model.bean.pay_movie.MovieScheduleBean;
import com.bw.movie.model.bean.pay_movie.PayMoneyBean;
import com.bw.movie.model.bean.pay_movie.SeatInfoBean;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-15
 * INTRODUCE：$
 */
public interface IApi {

    //发送验证码
    @FormUrlEncoded
    @POST(Constant.AUTH_CODE)
    Observable<LoginBean> postAuthCode(@Field("email") String email);

    //注册
    @FormUrlEncoded
    @POST(Constant.REGISTER)
    Observable<LoginBean> postRegister(@FieldMap HashMap<String,Object> params);

    //登录
    @FormUrlEncoded
    @POST(Constant.LOGIN)
    Observable<LoginBean> postLogin(@FieldMap HashMap<String,Object> params);

    //微信登录
    @FormUrlEncoded
    @POST(Constant.WEIXIN_LOGIN)
    Observable<LoginBean> postWeixinLogin(@Field("code") String code);

    //修改密码
    @FormUrlEncoded
    @POST(Constant.ALTER_PWD)
    Observable<LoginBean> postAlterPwd(@FieldMap HashMap<String,Object> params);

    //轮播图
    @GET(Constant.BANNER)
    Observable<BannerBean> getBanner();

    //预约电影
    @FormUrlEncoded
    @POST(Constant.RESERVE_MOVIE)
    Observable<LoginBean> postReserveMovie(@Field("movieId") int movieId);

    //查询电影详情
    @GET(Constant.DETAIL_MOVIE)
    Observable<DetailMovieBean> getDetailMovie(@Query("movieId") int movieId);

    //查看电影所有评论详细信息
    @GET(Constant.MOVIE_COMMENT_ALL)
    Observable<MovieCommentBean> getMovieComment(@QueryMap HashMap<String,Object> params);


    //正在上映电影
    @GET(Constant.RELEASE_MOVIE)
    Observable<ReleaseMovieBean> getRelease(@Query("page") int page, @Query("count") int cpunt);

    //即将上映电影
    @GET(Constant.COMING_MOVIE)
    Observable<ComingMovieBean> getComing(@Query("page") int page, @Query("count") int cpunt);

    //正在热门电影
    @GET(Constant.HOT_MOVIE)
    Observable<HotMovieBean> getHot(@Query("page") int page,@Query("count") int cpunt);

    //根据关键字查询电影
    @GET(Constant.SEEK_MOVIE)
    Observable<SeekMovieBean> getMoviewSeek(@QueryMap HashMap<String,Object> params);

    //查询用户信息
    @GET(Constant.USERINFO)
    Observable<UserInFoBean> getUserInFo();

    //修改用户头像
    @Multipart
    @POST(Constant.PUT_PIC)
    Observable<PutPicBean> postPutPic(@Part MultipartBody.Part image);

    //修改用户生日
    @FormUrlEncoded
    @POST(Constant.PUT_BIRTHDAY)
    Observable<LoginBean> postPutBrith(@Field("birthday") String birthday);

    //查询附近影院
    @GET(Constant.SEEK_NEARBY_CINEMAS)
    Observable<NearbyCinemasBean> getNearbyCinemas(@QueryMap HashMap<String,Object> params);

    //查询推荐影院
    @GET(Constant.RECOMMEND_CINEMAS)
    Observable<NearbyCinemasBean> getRecommendCinemas(@Query("page") int page, @Query("count") int count);

    //查看影院详细信息
    @GET(Constant.CINEMAS_INFO)
    Observable<CinemaInfoBean> getCinemaInfo(@Query("cinemaId") int cinemaId);


    //关注影院
    @GET(Constant.CINEMA_FOLLOW)
    Observable<CinemaInfoBean> getFollowCinema(@Query("cinemaId") int cinemaId);

    //取消关注影院
    @GET(Constant.CINEMA_CANCELFOLLOW)
    Observable<CinemaInfoBean> getCancelFollowCinema(@Query("cinemaId") int cinemaId);

    //查询影院用户评论
    @GET(Constant.CINEMA_FINDCOMMENT)
    Observable<CinemaCommentBean> getFindCommentCinema(@QueryMap HashMap<String,Object> queryParam);

    //影院评论点赞
    @FormUrlEncoded
    @POST(Constant.CINEMA_COMMENTGREAT)
    Observable<CinemaCommentBean> postCommentGreat(@Field("commentId") int commentId);

    //查询影院下的电影排期
    @GET(Constant.CINEMA_MOVIELIST)
    Observable<CinemaMovieListBean> getCinemaMovieList(@QueryMap HashMap<String,Object> queryParam);

    //查询一周排期的时间
    @GET(Constant.FINDDATE_LIST)
    Observable<FindDateBean> getFindDate();

    //根据电影院名称模糊查询电影院
    @GET(Constant.SEEK_CINEMA)
    Observable<FindCinemaBean> getSeekCinema(@QueryMap HashMap<String,Object> queryParam);

    //根据区域查询影院
    @GET(Constant.CINEMA_REGION)
    Observable<CinemaRegionBean> getCinemaRegion(@Query("regionId") int regionId);

    //查询区域列表
    @GET(Constant.REGION_LIST)
    Observable<RegionListBean> getRegionList();

    //电影支付 post Header userId(int) sessionId(String) ,FromParam payType(&int) orderId (&String)
    @FormUrlEncoded
    @POST(Constant.PAY_MONEY)
    Observable<PayMoneyBean> postPayMoney(@Field("payType") int payType,@Field("orderId") String orderId);

    //购票下单 post Header userId(int) sessionId(String) ,FromParam scheduleId(&int) seat,sign (&String)
    @FormUrlEncoded
    @POST(Constant.BUY_MOVIETICKET)
    Observable<BuyMovieTicketBean> postBuyMovieTicket(@FieldMap HashMap<String,Object> params);

    //根据电影ID和影院ID查询电影排期列表 get queryParam movieId cinemaId (&&int)
    @GET(Constant.FIND_MOVIE_SCHEDULE)
    Observable<MovieScheduleBean> getMovieSchedule(@Query("movieId") int  movieId,@Query("cinemaId") int cinemaId);


    //根据影厅id 查询座位信息 get queryParam hallId (&&int)
    @GET(Constant.FIND_SEATINFO)
    Observable<SeatInfoBean> getSeatInfo(@Query("hallId") int hallId);

    //根据电影id,区域id 查询播放影院信息 get queryParam movieId,regionId,page,count (&&int)
    @GET(Constant.FIND_CiNEMAINFO_BYREGION)
    Observable<CinemaInfoRegionDatePriceBean> getCinemaByRegion(@QueryMap HashMap<String,Object> queryParam);

    //根据电影id，时间 查询播放影院信息 get queryParam movieId,page,count (&&int) date (&String)
    @GET(Constant.FIND_SEATINFO)
    Observable<CinemaInfoRegionDatePriceBean> getCinemaByDate(@QueryMap HashMap<String,Object> queryParam);

    //根据电影价格查询播放影院信息 get queryParam movieId,page,count (&&int)
    @GET(Constant.FIND_SEATINFO)
    Observable<CinemaInfoRegionDatePriceBean> getCinemaByPrice(@QueryMap HashMap<String,Object> queryParam);


    //关注电影 get Header userId(int) sessionId(String) , queryParam movieId (&int)
    @GET(Constant.FOLLOW_MOVIE)
    Observable<LoginBean> getMovieFollow(@Query("movieId") int movieId);

    //取消关注电影 get Header userId(int) sessionId(String) , queryParam movieId (&int)
    @GET(Constant.CANCEL_FOLLOW_MOVIE)
    Observable<LoginBean> getCancelMovieFollow(@Query("movieId") int movieId);

    //用户对电影的评论 post Header userId(int) sessionId(String) , queryParam movieId (&int) commentContent(&String) score(&double)
    @FormUrlEncoded
    @POST(Constant.MOVIECOMMENT)
    Observable<LoginBean> postWriteMovieComment(@FieldMap HashMap<String,Object> params);

    //查看影片评论回复 get Header userId(int) sessionId(String) , queryParam commentId page,count (&&int)
    @GET(Constant.FIND_COMMENT_REPLY)
    Observable<ReplyCommentBean> getCommentReplyAll(@QueryMap HashMap<String,Object> params);

    //添加用户对评论的回复 post Header userId(int) sessionId(String) , queryParam commentId (&int) replyContent (&String)
    @FormUrlEncoded
    @POST(Constant.COMMENT_REPLY)
    Observable<LoginBean> postReplyComment(@Field("commentId") int commentId,@Field("replyContent") String replyContent);

    //电影评论点赞 post Header userId(int) sessionId(String) , queryParam commentId (&int)
    @FormUrlEncoded
    @POST(Constant.MOVIE_COMMENT_GREAT)
    Observable<LoginBean> postGreayComment(@Field("commentId") int commentId);

    //查询用户关注电影列表 get Header userId(int) sessionId(String) , queryParam page,count (&&int)
    @GET(Constant.USER_FOLLOW_MOVIE)
    Observable<UserFollowMovieBean> getUserFollowMovie(@Query("page") int page,@Query("count") int count);

    //查询用户关注影院列表 get Header userId(int) sessionId(String) , queryParam page,count (&&int)
    @GET(Constant.USER_FOLLOW_CINEMA)
    Observable<UserFollowCinemaBean> getUserFollowCinema(@Query("page") int page, @Query("count") int count);

    //查询用户预约电影信息 get Header userId(int) sessionId(String)
    @GET(Constant.USER_RESERVE)
    Observable<UserReserveBean> getUserReserve();

    //意见反馈 post Header userId(int) sessionId(String),FromParams content (&String)
    @FormUrlEncoded
    @POST(Constant.FEED_BACK)
    Observable<LoginBean> postFeedBack(@Field("content") String content);

    //查询看过的电影 get Header userId(int) sessionId(String)
    @GET(Constant.USER_SEEN_MOVIE)
    Observable<UserSeenBean> getUserSeen();

    //查询我对电影的评论列表 get Header userId(int) sessionId(String) ,queryParam page,count (&&int)
    @GET(Constant.USER_COMMENT_MOVIE)
    Observable<UserCommentMovie> getUserCommnetMovie(@Query("page") int page,@Query("count") int count);

    //查询我对影院的评论列表 get Header userId(int) sessionId(String) ,queryParam longitude , latitude (&&String), page,count (&&int)
    @GET(Constant.USER_COMMENT_CINEMA)
    Observable<UserCommentCinema> getUserCommnetCinema(@QueryMap HashMap<String,Object> params);

    //查询新版本 get Header userId(int) sessionId  ak (String)
    @GET(Constant.NEW_VERSION)
    Observable<NewVersionBean> getNewVersion(@Header("ak") String ak);

    //购票记录 get Header userId(int) sessionId , queryParam page,count status (&&int)
    @GET(Constant.BUY_TICKET_RECORD)
    Observable<TicketRecordBean> getBuyTicketRecord(@QueryMap HashMap<String,Object> params);

    //修改用户手机号 post Header userId(int) sessionId , FromParams phone (&String)
    @FormUrlEncoded
    @POST(Constant.UPDATE_PHONE)
    Observable<LoginBean> postUpdatePhone(@Field("phone") String phone);

    //绑定微信账号 post Header userId(int) sessionId , FromParams code (&String)
    @FormUrlEncoded
    @POST(Constant.BIND_WEIXIN)
    Observable<LoginBean> postBindWeixin(@Field("code") String code);

    //是否绑定微信账号 get Header userId(int) sessionId (&String)
    @GET(Constant.WHETHER_BIND_WEIXIN)
    Observable<BindWeixinBean> getWhetherBindWeixin();

    //查询取票码 get Header userId(int) sessionId (&String),QueryParam recordId (&int)
    @GET(Constant.FIND_EXCHANGE_CODE)
    Observable<ExchangeCodeBean> getExchangeCode(@Query("recordId") int recordId);

    //查看订单详情 get Header userId(int) sessionId (&String),QueryParam orderId (&int)
    @GET(Constant.FIND_BUYTICKET)
    Observable<BuyTicketBean> getBuyTicketDetail(@Query("orderId") String orderId);

    //查询用户观看后的电影评论 get Header userId(int) sessionId (&String),QueryParam recordId (&int)
    @GET(Constant.FIND_SEEN_COMMENT)
    Observable<SeenCommentBean> getSeenComment(@Query("recordId") int recordId);

    //我的电影票 get Header userId(int) sessionId (&String)
    @GET(Constant.MY_MOVIE_TICKET)
    Observable<MyMovieTicketBean> getMyMovieTicket();

    //查询系统消息列表 get Header userId(int) sessionId , queryParam page,count (&&int)
    @GET(Constant.FIND_ALL_SYS_MSG)
    Observable<SysMsgAllBean> getSysMsgAll(@Query("page") int page,@Query("count") int count);

   //系统消息读取状态修改 get Header userId(int) sessionId , queryParam id(&&int)
   @GET(Constant.CHANGE_SYS_MSG)
   Observable<LoginBean> getChangeSysMsg(@Query("id") int id);

   //查询用户当前未读消息数量 get Header userId(int) sessionId
   @GET(Constant.FIND_UNREAD_MSG_COUNT)
   Observable<UnreadMsgCountBean> getUnreadMsgCount();

    //上传消息推送使用的token (腾讯信鸽) post Header userId(int) sessionId ,FormParam token(&String) os(&int)
    @FormUrlEncoded
    @POST(Constant.UPLOAD_TOKEN)
    Observable<LoginBean> postUploadToken(@Field("token") String token,@Field("os") int os);

   //微信分享前置接口，获取分享所需参数 get queryParam sign , time (&&String)
    @GET(Constant.WX_SHARE)
    Observable<LoginBean> getWXShare(@Query("sign") String sign,@Query("time") String time);

}
