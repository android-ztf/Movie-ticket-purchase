package com.bw.movie.application;

public interface Constant {

    // 外网
    public static final String BASE_URL= "http://mobile.bwstudent.com/";
    // 内网
    public static final String BASE_URL_SCHOOL= "http://172.17.8.100/";
    //微信 appId
    public static final String WEIXIN= "wxb3852e6a6b7d9516";

    //注册 post Body nickName & pwd & email & code (&&String)
    public static final String REGISTER = "movieApi/user/v2/register";

    //登录 post Body email & pwd (&&String)
    public static final String LOGIN = "movieApi/user/v2/login";

    //微信登录 post Body code (&&String)
    public static final String WEIXIN_LOGIN = "movieApi/user/v1/weChatBindingLogin";

    //发送验证码  post email(String)
    public static final String AUTH_CODE = "movieApi/user/v2/sendOutEmailCode";

    //修改密码 post Header userId(int) sessionId(String) params oldPwd & newPwd & newPwd2 (&&String)
    public static final String ALTER_PWD = "movieApi/user/v1/verify/modifyUserPwd";

    //热门电影 get params page & count (&&int)
    public static final String HOT_MOVIE = "movieApi/movie/v2/findHotMovieList";

    //即将上映电影 get Header userId(int) sessionId(String) ,params page & count (&&int)
    public static final String COMING_MOVIE = "movieApi/movie/v2/findComingSoonMovieList";

    //正在上映电影 get params page & count (&&int)
    public static final String RELEASE_MOVIE = "movieApi/movie/v2/findReleaseMovieList";

    //轮播图(大概) get (无参)
    public static final String BANNER = "movieApi/tool/v2/banner";

    //电影预约 post Header userId(int) sessionId(String) ,params movieId(int)
    public static final String RESERVE_MOVIE = "movieApi/movie/v2/verify/reserve";

    //查询电影详情 get Header userId(int) sessionId(String) ,params movieId(int)
    public static final String DETAIL_MOVIE = "movieApi/movie/v2/findMoviesDetail";

    //查询用户信息 get Header userId(int) sessionId(String)
    public static final String USERINFO = "movieApi/user/v1/verify/getUserInfoByUserId";

    //修改用户头像 post Header userId(int) sessionId(String) & params image(file)
    public static final String PUT_PIC = "movieApi/user/v1/verify/uploadHeadPic";

    //修改用户生日 post Header userId(int) sessionId(String) & params birthday(String)
    public static final String PUT_BIRTHDAY = "movieApi/user/v2/verify/updateUserBirthday";

    //修改用户手机号 post Header userId(int) sessionId(String) & params birthday(String)
    public static final String PUT_PHONE = "movieApi/user/v2/verify/updateUserPhone";

    //根据关键字查询电影 get queryParam keyword(String) & page & count (&&int)
    public static final String SEEK_MOVIE = "movieApi/movie/v2/findMovieByKeyword";

    //根据关键字查询附近影院 get Header userId(int) sessionId(String) ,queryParam longitude & latitude(&&String) & page & count (&&int)
    public static final String SEEK_NEARBY_CINEMAS = "movieApi/cinema/v1/findNearbyCinemas";

    //查看推荐影院 get Header userId(int) sessionId(String) ,queryParam page & count (&&int)
    public static final String RECOMMEND_CINEMAS= "movieApi/cinema/v1/findRecommendCinemas";

    //查看影院详细信息 get Header userId(int) sessionId(String) ,queryParam cinemaId (&int)
    public static final String CINEMAS_INFO= "movieApi/cinema/v1/findCinemaInfo";

    //查看电影所有评论 get Header userId(int) sessionId(String) ,queryParam movieId & params page & count (&&int)
    public static final String MOVIE_COMMENT_ALL= "movieApi/movie/v2/findAllMovieComment";

    //关注影院 get Header userId(int) sessionId(String) ,queryParam cinemaId (&int)
    public static final String CINEMA_FOLLOW= "movieApi/cinema/v1/verify/followCinema";

    //取消关注影院 get Header userId(int) sessionId(String) ,queryParam cinemaId (&int)
    public static final String CINEMA_CANCELFOLLOW= "movieApi/cinema/v1/verify/cancelFollowCinema";

    //查询影院用户评论 get Header userId(int) sessionId(String) ,queryParam cinemaId & page & count (&&int)
    public static final String CINEMA_FINDCOMMENT= "movieApi/cinema/v1/findAllCinemaComment";

    //对影院进行评论 post Header userId(int) sessionId(String) ,queryParam cinemaId (&&int) & commentContent (&String)
    public static final String CINEMA_COMMENT= "movieApi/cinema/v1/verify/cinemaComment";

    //根据电影院名称模糊查询电影院 get queryParam page & count (&&int) & cinemaName(&String)
    public static final String SEEK_CINEMA= "movieApi/cinema/v1/findAllCinemas";

    //影院评论点赞 post Header userId(int) sessionId(String) ,queryParam cinemaId (&&int)
    public static final String CINEMA_COMMENTGREAT= "movieApi/cinema/v1/verify/cinemaCommentGreat";

    //查询影院下的电影排期 get Header userId(int) sessionId(String) ,queryParam cinemaId & page & count (&&int)
    public static final String CINEMA_MOVIELIST= "movieApi/cinema/v2/findCinemaScheduleList";

    //查询一周排期的时间 get
    public static final String FINDDATE_LIST= "movieApi/tool/v2/findDateList";

    //查询区域列表 get
    public static final String REGION_LIST = "movieApi/tool/v2/findRegionList";

    //根据区域查询影院 get queryParam regionId (&&int)
    public static final String CINEMA_REGION= "movieApi/cinema/v2/findCinemaByRegion";

    //电影支付 post Header userId(int) sessionId(String) ,FromParam payType(&int) orderId (&String)
    public static final String PAY_MONEY= "movieApi/movie/v2/verify/pay";

    //购票下单 post Header userId(int) sessionId(String) ,FromParam scheduleId(&int) seat,sign (&String)
    public static final String BUY_MOVIETICKET= "movieApi/movie/v2/verify/buyMovieTickets";

    //根据电影ID和影院ID查询电影排期列表 get queryParam movieId cinemaId (&&int)
    public static final String FIND_MOVIE_SCHEDULE = "movieApi/movie/v2/findMovieSchedule";

    //根据影厅id 查询座位信息 get queryParam hallId (&&int)
    public static final String FIND_SEATINFO = "movieApi/movie/v2/findSeatInfo";

    //根据电影id,区域id 查询播放影院信息 get queryParam movieId,regionId,page,count (&&int)
    public static final String FIND_CiNEMAINFO_BYREGION = "movieApi/movie/v2/findCinemasInfoByRegion";

    //根据电影id，时间 查询播放影院信息 get queryParam movieId,page,count (&&int) date (&String)
    public static final String FIND_CiNEMAINFO_BYDATE = "movieApi/movie/v2/findCinemasInfoByDate";

    //根据电影价格查询播放影院信息 get queryParam movieId,page,count (&&int)
    public static final String FIND_CiNEMAINFO_BYPRICE = "movieApi/movie/v2/findCinemasInfoByPrice";

    //关注电影 get Header userId(int) sessionId(String) , queryParam movieId (&int)
    public static final String FOLLOW_MOVIE = "movieApi/movie/v1/verify/followMovie";

    //取消关注电影 get Header userId(int) sessionId(String) , queryParam movieId (&int)
    public static final String CANCEL_FOLLOW_MOVIE = "movieApi/movie/v1/verify/cancelFollowMovie";

    //用户对电影的评论 post Header userId(int) sessionId(String) , queryParam movieId (&int) commentContent(&String) score(&double)
    public static final String MOVIECOMMENT = "movieApi/movie/v1/verify/movieComment";

    //查看影片评论回复 get Header userId(int) sessionId(String) , queryParam commentId page,count (&&int)
    public static final String FIND_COMMENT_REPLY = "movieApi/movie/v1/findCommentReply";

    //添加用户对评论的回复 post Header userId(int) sessionId(String) , queryParam commentId (&int) replyContent (&String)
    public static final String COMMENT_REPLY = "movieApi/movie/v1/verify/commentReply";

    //电影评论点赞 post Header userId(int) sessionId(String) , queryParam commentId (&int)
    public static final String MOVIE_COMMENT_GREAT = "movieApi/movie/v1/verify/movieCommentGreat";

    //查询用户关注电影列表 get Header userId(int) sessionId(String) , queryParam page,count (&&int)
    public static final String USER_FOLLOW_MOVIE = "movieApi/user/v2/verify/findUserFollowMovieList";

    //查询用户关注影院列表 get Header userId(int) sessionId(String) ,
    public static final String USER_FOLLOW_CINEMA= "movieApi/user/v2/verify/findUserFollowCinemaList";

    //查询用户预约电影信息 get Header userId(int) sessionId(String)
    public static final String USER_RESERVE= "movieApi/user/v2/verify/findUserReserve";

    //意见反馈 post Header userId(int) sessionId(String),FromParams content (&String)
    public static final String FEED_BACK= "movieApi/tool/v1/verify/recordFeedBack";

    //查询看过的电影 get Header userId(int) sessionId(String)
    public static final String USER_SEEN_MOVIE= "movieApi/user/v2/verify/findSeenMovie";

    //查询我对电影的评论列表 get Header userId(int) sessionId(String) ,queryParam page,count (&&int)
    public static final String USER_COMMENT_MOVIE= "movieApi/user/v2/verify/findMyMovieCommentList";

    //查询我对影院的评论列表 get Header userId(int) sessionId(String) ,queryParam longitude , latitude (&&String), page,count (&&int)
    public static final String USER_COMMENT_CINEMA= "movieApi/user/v2/verify/findMyCinemaCommentList";

    //查询新版本 get Header userId(int) sessionId , ak(String)
    public static final String NEW_VERSION= "movieApi/tool/v1/findNewVersion";

    //购票记录 get Header userId(int) sessionId , queryParam page,count status (&&int)
    public static final String BUY_TICKET_RECORD= "movieApi/user/v2/verify/findUserBuyTicketRecord";

    //修改用户手机号 post Header userId(int) sessionId , FromParams phone (&String)
    public static final String UPDATE_PHONE= "movieApi/user/v2/verify/updateUserPhone";

    //绑定微信账号 post Header userId(int) sessionId , FromParams code (&String)
    public static final String BIND_WEIXIN= "movieApi/user/v1/verify/bindWeChat";

    //是否绑定微信账号 get Header userId(int) sessionId (&String)
    public static final String WHETHER_BIND_WEIXIN= "movieApi/user/v1/verify/whetherToBindWeChat";

    //查询取票码 get Header userId(int) sessionId (&String),QueryParam recordId (&int)
    public static final String FIND_EXCHANGE_CODE= "movieApi/user/v2/verify/findExchangeCode";

    //查看订单详情 get Header userId(int) sessionId (&String),QueryParam orderId (&int)
    public static final String FIND_BUYTICKET= "movieApi/user/v2/verify/findBuyTicketRecordByOrderId";

    //查询用户观看后的电影评论 get Header userId(int) sessionId (&String),QueryParam recordId (&int)
    public static final String FIND_SEEN_COMMENT= "movieApi/user/v2/verify/findSeenMovieComment";

    //我的电影票 get Header userId(int) sessionId (&String)
    public static final String MY_MOVIE_TICKET= "movieApi/user/v2/verify/findMyMovieTicket";

    //查询系统消息列表 get Header userId(int) sessionId , queryParam page,count (&&int)
    public static final String FIND_ALL_SYS_MSG= "movieApi/tool/v1/verify/findAllSysMsgList";

    //系统消息读取状态修改 get Header userId(int) sessionId , queryParam id(&&int)
    public static final String CHANGE_SYS_MSG= "movieApi/tool/v1/verify/changeSysMsgStatus";

    //查询用户当前未读消息数量 get Header userId(int) sessionId
    public static final String FIND_UNREAD_MSG_COUNT= "movieApi/tool/v1/verify/findUnreadMessageCount";

    //上传消息推送使用的token (腾讯信鸽) post Header userId(int) sessionId ,FormParam token(&String) os(&int)
    public static final String UPLOAD_TOKEN= "movieApi/tool/v1/verify/uploadPushToken";

    //微信分享前置接口，获取分享所需参数 get queryParam sign , time (&&String)
    public static final String WX_SHARE= "movieApi/tool/v1/wxShare";



}
