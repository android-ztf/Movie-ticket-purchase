package com.bw.movie.view.fragment.mine;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bw.movie.R;
import com.bw.movie.application.App;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.bean.mine.TicketRecordBean;
import com.bw.movie.model.bean.pay_movie.PayMoneyBean;
import com.bw.movie.presenter.MinePresenter;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.activity.mine.RecordDetailActivity;
import com.bw.movie.view.adapter.mine.UserNotRecordAdapter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.tencent.mm.opensdk.modelpay.PayReq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-29
 * INTRODUCE：$
 * 未付款
 */
public class UserNotRecordFragment extends BaseFragment<MinePresenter> implements MineContract.IMineView {

    @BindView(R.id.xrl_not_record)
    XRecyclerView xrlNotRecord;
    @BindView(R.id.rl_not_follow)
    RelativeLayout rlNotFollow;
    @BindView(R.id.tv_nnotfollow)
    TextView tvNnotfollow;

    private int page = 1;
    //1 是代付款 2是已付款
    private int status = 1;
    private UserNotRecordAdapter userNotRecordAdapter;
    private int zf;
    private String orderId;
    private double mPrice;

    @Override
    public int provideLayoutId() {
        return R.layout.fragment_not_record;
    }

    @Override
    protected void inintView() {
        super.inintView();
        userNotRecordAdapter = new UserNotRecordAdapter(getActivity());
    }

    @Override
    protected void initData() {
        super.initData();

        tvNnotfollow.setText("暂时没有未付款电影");

        if (!hasNetWrok()) {
            showNoNetTip();
        } else {
            mPresenter.getBuyTicketRecord(page, 5, status);
        }

        xrlNotRecord.setLayoutManager(new LinearLayoutManager(getActivity()));
        xrlNotRecord.addItemDecoration(new SpacesItemDecoration(10));

        xrlNotRecord.setAdapter(userNotRecordAdapter);

        xrlNotRecord.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xrlNotRecord.setLoadingMoreProgressStyle(ProgressStyle.SquareSpin);


        xrlNotRecord.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //下拉刷新
                page = 1;
                mPresenter.getBuyTicketRecord(page, 5, status);
            }

            @Override
            public void onLoadMore() {
                //上拉加载
                page++;
                mPresenter.getBuyTicketRecord(page, 5, status);
            }
        });

        userNotRecordAdapter.setCallBack(new UserNotRecordAdapter.INotRecordCallBack() {
            @Override
            public void onDetailMovieId(String orderid,String imageUrl, View v ,double price) {
                orderId = orderid;
                mPrice = price;
                if (v instanceof RelativeLayout) {
                    Intent intent = new Intent(getActivity(), RecordDetailActivity.class);
                    intent.putExtra("orderid", orderid);
                    intent.putExtra("imageUrl", imageUrl);
                    startActivity(intent);
                }else{
                    initPopwindow();
                }
            }
        });

    }


    @Override
    protected MinePresenter setPresenter() {
        return new MinePresenter();
    }


    @Override
    public void onTicketRecord(TicketRecordBean ticketRecordBean) {
        Log.i("record_suc", ticketRecordBean.getMessage());
        //停止刷新
        xrlNotRecord.refreshComplete();
        List<TicketRecordBean.ResultBean> result = ticketRecordBean.getResult();
        if (result.size() != 0) {
            xrlNotRecord.setVisibility(View.VISIBLE);
            Collections.reverse(result);
            userNotRecordAdapter.setList(result,status);
            rlNotFollow.setVisibility(View.GONE);
        } else {
            rlNotFollow.setVisibility(View.VISIBLE);
            xrlNotRecord.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPayMoneySuccess(PayMoneyBean payMoneyBean) {

        PayReq req = new PayReq();
        req.appId=payMoneyBean.getAppId();
        req.nonceStr=payMoneyBean.getNonceStr();
        req.packageValue=payMoneyBean.getPackageValue();
        req.partnerId=payMoneyBean.getPartnerId();
        req.sign=payMoneyBean.getSign();
        req.timeStamp=payMoneyBean.getTimeStamp();
        req.prepayId=payMoneyBean.getPrepayId();
        App.mWxApi.sendReq(req);
    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err", e.getMessage());
    }

    private void initPopwindow() {
        View view = View.inflate(getActivity(), R.layout.buyticket_popupwindow, null);
        PopupWindow window = new PopupWindow(view, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        window.setBackgroundDrawable(new ColorDrawable());
        window.setOutsideTouchable(true);

        //设置popupWindow的显示和隐藏动画
        window.setAnimationStyle(R.style.popwin_anim_style);
        //设置PopupWindow是否响应touch事件,默认是true,如果为false,所有按钮不可点击
        window.setTouchable(true);
        //是否可获取焦点,设置为true会响 应back键的返回,同时拥有setOutsideTouchable(true)的作用.
        window.setFocusable(true);

        window.showAtLocation(view, Gravity.BOTTOM,0,0);

        RadioGroup rgPwTicket = (RadioGroup) view.findViewById(R.id.rg_pw_ticket);
        Button butPaymoney = (Button) view.findViewById(R.id.but_paymoney);
        rgPwTicket.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_wx_pw:
                        Log.i("<>","微信");
                        zf = 1;
                        butPaymoney.setText("微信支付"+mPrice+"元");
                        break;
                    case R.id.rb_zfb_pw:
                        Log.i("<>","支付宝"+mPrice+"元");
                        butPaymoney.setText("支付宝支付"+mPrice+"元");

                        zf =2;
                        break;
                }
            }
        });

        butPaymoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zf!=0 && orderId!=null){
                    mPresenter.postPayMoney(zf,orderId);
                }
            }
        });

    }

}
