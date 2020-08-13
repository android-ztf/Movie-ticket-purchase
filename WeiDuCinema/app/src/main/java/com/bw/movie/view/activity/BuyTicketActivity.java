package com.bw.movie.view.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alipay.sdk.app.PayTask;
import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.application.App;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.BuyTicketContract;
import com.bw.movie.model.bean.DetailMovieBean;
import com.bw.movie.model.bean.PayResult;
import com.bw.movie.model.bean.pay_movie.BuyMovieTicketBean;
import com.bw.movie.model.bean.pay_movie.MovieScheduleBean;
import com.bw.movie.model.bean.pay_movie.PayMoneyBean;
import com.bw.movie.model.bean.pay_movie.SeatInfoBean;
import com.bw.movie.model.realm.UserInfoRealm;
import com.bw.movie.presenter.BuyTicketPresenter;
import com.bw.movie.utils.MD5Util;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.adapter.buy_movie.MyMovieScheduleAdapter;
import com.bw.movie.view.customview.SeatView;
import com.google.gson.Gson;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import io.realm.Realm;

public class BuyTicketActivity extends BaseActivity<BuyTicketPresenter> implements BuyTicketContract.IBuyTicketView {

    @BindView(R.id.seatview)
    SeatView seatview;
    @BindView(R.id.but_back_ticket)
    Button butBackTicket;
    @BindView(R.id.tv_name_ticket)
    TextView tvNameTicket;
    @BindView(R.id.jcvps_ygp_ticket)
    JCVideoPlayerStandard jcvpsYgpTicket;
    @BindView(R.id.tv_halltime_xx)
    TextView tvHalltimeXx;
    @BindView(R.id.rv_hall_ticket)
    RecyclerView rvHallTicket;
    @BindView(R.id.but_buy_ticket)
    Button butBuyTicket;
    private int movieId;
    private int cinemaId;
    private MyMovieScheduleAdapter myMovieScheduleAdapter;
    private double gold = 0.0d;
    private double money_sum = 0.0d;
    private PopupWindow window;
    private View view1;
    private int scheduleId=0;
    private String seat_info=null;
    private int zf=0;
    private String orderId;
    private String orderInfo;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_buy_ticket;
    }

    @Override
    protected BuyTicketPresenter setPresenter() {
        return new BuyTicketPresenter();
    }

    @Override
    protected void initView() {
        super.initView();

        Intent intent = getIntent();
        movieId = intent.getIntExtra("movieId", 0);
        cinemaId = intent.getIntExtra("cinemaId", 0);

        Log.i("-==", movieId + cinemaId + "猴子");

        myMovieScheduleAdapter = new MyMovieScheduleAdapter(this);




    }

    @Override
    protected void initData() {
        super.initData();

        rvHallTicket.setAdapter(myMovieScheduleAdapter);
        rvHallTicket.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        SpacesItemDecoration decoration = new SpacesItemDecoration(20);
        rvHallTicket.addItemDecoration(decoration);

        if (!hasNetWork()) {
            showNoNetTip();
        } else {
            if (movieId != 0 && cinemaId != 0) {
                mPresenter.getMovieSchedule(movieId, cinemaId);
            }
        }

        SharedPreferences data = SharedPreferencesUtils.getInstance().getData();
        String detaiMovie = data.getString("detaiMovie", null);
        if (!detaiMovie.equals("") && detaiMovie != null) {
            DetailMovieBean bean = new Gson().fromJson(detaiMovie, DetailMovieBean.class);
           jcvpsYgpTicket.setUp(bean.getResult().getShortFilmList().get(0).getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
            //if (b) {
                Glide.with(this)
                        .load(bean.getResult().getShortFilmList().get(0).getImageUrl())
                        .into(jcvpsYgpTicket.thumbImageView);
            //}
            tvNameTicket.setText(bean.getResult().getName());
        }


        myMovieScheduleAdapter.setCallBack(new MyMovieScheduleAdapter.OnClickMovieSchedlue() {
            @Override
            public void onClick(int hallId, double money,int id) {
                gold = money;
                scheduleId = id;
                mPresenter.getSeatInfo(hallId);
            }
        });

        //自定义view的回调,回调座位信息并设置价格
        seatview.setCallBack(new SeatView.OnSeatCallBack() {
            @Override
            public void onClickSeat(String seat) {
                if (!seat.equals("") && seat != null) {

                    seat_info = seat.substring(0, seat.length() - 1);
                    Log.i("pp", seat_info + "塔兹米");
                    String[] ticket_num = seat_info.split(",");
                    //设置按钮内容(总价)
                    if (gold != 0.0 && ticket_num.length != 0) {
                        money_sum = ticket_num.length * gold;
                        butBuyTicket.setText("总计 ¥:" + ticket_num.length * gold+" 点击选择支付方式");
                        butBuyTicket.setBackgroundColor(Color.RED);
                        butBuyTicket.setEnabled(true);
                    }

                } else {
                    butBuyTicket.setEnabled(false);
                    butBuyTicket.setText("请先选坐");
                    butBuyTicket.setBackgroundColor(Color.parseColor("#FF72A1"));

                }
            }
        });


    }

    @Override
    public void onFailure(Throwable e) {
        Log.e("err", e.getMessage());
    }

    //电影排期
    @Override
    public void onMovieScheduleSuccess(MovieScheduleBean movieScheduleBean) {
        Log.i("moviewschedule", movieScheduleBean.getMessage());

        List<MovieScheduleBean.ResultBean> result = movieScheduleBean.getResult();

        tvHalltimeXx.setText("选择影厅和时间(" + result.size() + ")");

        //展示电影排期
        myMovieScheduleAdapter.setList(result);

    }

    //座位请求
    @Override
    public void onSeatInfoSuccess(SeatInfoBean seatInfoBean) {

        Log.i("seatinfo", seatInfoBean.getMessage());

        List<SeatInfoBean.ResultBean> result = seatInfoBean.getResult();
        //刷新自定义view的数据
        seatview.setmList(result);


    }

    //购票下单
    @Override
    public void onBuyTicketSuccess(BuyMovieTicketBean buyMovieTicketBean) {
        Log.i("buyticket", buyMovieTicketBean.getMessage());
        Toast.makeText(BuyTicketActivity.this,buyMovieTicketBean.getMessage(),Toast.LENGTH_SHORT).show();
        if (buyMovieTicketBean.getStatus().equals("0000")){
            orderId = buyMovieTicketBean.getOrderId();
            if (zf!=0 && orderId!=null){
                mPresenter.postPayMoney(zf, orderId);
            }
        }
    }

    //微信支付
    @Override
    public void onPayMoneySuccess(PayMoneyBean payMoneyBean) {
        Log.i("paymovey", payMoneyBean.getMessage());
        //Toast.makeText(BuyTicketActivity.this,payMoneyBean.getMessage(),Toast.LENGTH_SHORT).show();
        if (zf==1){
            //IWXAPI api;
            PayReq request = new PayReq();
            request.appId = payMoneyBean.getAppId();
            request.partnerId = payMoneyBean.getPartnerId();
            request.prepayId= payMoneyBean.getPrepayId();
            request.packageValue = payMoneyBean.getPackageValue();
            request.nonceStr= payMoneyBean.getNonceStr();
            request.timeStamp= payMoneyBean.getTimeStamp();
            request.sign= payMoneyBean.getSign();
            App.mWxApi.sendReq(request);
        }else{
            orderInfo = payMoneyBean.getResult();
            Thread payThread = new Thread(payRunnable);
            payThread.start();
        }

    }

    @OnClick({R.id.but_back_ticket, R.id.but_buy_ticket})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_back_ticket:
                finish();
                break;
            case R.id.but_buy_ticket:
                //展示popupwindow
                if (window!=null){
                    window.showAtLocation(view1,Gravity.BOTTOM,0,50);
                }else{
                    initPopupWindow();
                }

                break;
        }
    }

    //初始化popupwindow
    private void initPopupWindow(){
        //初始化popupwindow
        view1 = View.inflate(this, R.layout.buyticket_popupwindow, null);
        window = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置popupwindow背景
        window.setBackgroundDrawable(new ColorDrawable());
        //设置popupWindow的显示和隐藏动画
        window.setAnimationStyle(R.style.popwin_anim_style);
        //设置PopupWindow是否响应touch事件,默认是true,如果为false,所有按钮不可点击
        window.setTouchable(true);
        //是否可获取焦点,设置为true会响 应back键的返回,同时拥有setOutsideTouchable(true)的作用.
        window.setFocusable(true);
        // 外部点击事件
        window.setOutsideTouchable(true);
        window.showAtLocation(view1,Gravity.BOTTOM,0,0);
        //
        RadioGroup rgPwTicket = (RadioGroup) view1.findViewById(R.id.rg_pw_ticket);
        Button butPaymoney = (Button) view1.findViewById(R.id.but_paymoney);
        rgPwTicket.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.rb_wx_pw:
                        Log.i("<>","微信");
                        zf = 1;
                        butPaymoney.setText("微信支付"+money_sum+"元");
                        break;
                    case R.id.rb_zfb_pw:
                        Log.i("<>","支付宝");
                        butPaymoney.setText("支付宝支付"+money_sum+"元");
                        zf =2;
                        break;
                }
                //initDelog();
            }
        });

        butPaymoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (scheduleId!=0 && seat_info!=null){
                    UserInfoRealm infoRealm = Realm.getDefaultInstance().where(UserInfoRealm.class).findFirst();
                    if(infoRealm!=null) {
                        int userId = infoRealm.getUserId();
                        String sessionId = infoRealm.getSessionId();
                        Log.i("realm_iapi","uId"+userId+",sId"+sessionId);
                        //规则：将 userId、scheduleId等参数的值和'movie'单词进行字符串拼接
                        //全部小写就行，然后再进行MD5加密，顺序不可以乱
                        //例如拼接后的字符串格式为： '5'+'1'+'movie'，拼接完后为"51movie",然后对这个字符串进行MD5
                        String sign=String.valueOf(userId)+String.valueOf(scheduleId)+"movie";
                        Log.i("+++","userId="+userId+" seat:"+seat_info+" scheduleId"+scheduleId+" 签名:"+MD5Util.md5Encrypt32Lower(sign)+" sign:"+sign);
                        if (zf!=0){
                            mPresenter.postBuyMovieTicket(scheduleId,seat_info,MD5Util.md5Encrypt32Lower(sign));
                        }else{
                            Toast.makeText(BuyTicketActivity.this,"请选择支付方式",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    Runnable payRunnable = new Runnable() {

        @Override
        public void run() {
            PayTask alipay = new PayTask(BuyTicketActivity.this);
            String result = alipay.pay(orderInfo,true);

            Message msg = new Message();
            msg.what = 9000;
            msg.obj = result;
            mHandler.sendMessage(msg);
        }
    };
    // 必须异步调用


    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1: {
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(BuyTicketActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(BuyTicketActivity.this, "支付结果确认中", Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(BuyTicketActivity.this, "支付失败", Toast.LENGTH_SHORT).show();

                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }

    };

}
