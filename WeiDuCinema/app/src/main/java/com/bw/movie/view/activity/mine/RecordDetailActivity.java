package com.bw.movie.view.activity.mine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.bean.mine.BuyTicketBean;
import com.bw.movie.presenter.MinePresenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecordDetailActivity extends BaseActivity<MinePresenter> implements MineContract.IMineView {

    @BindView(R.id.but_back_loign)
    Button butBackLoign;
    @BindView(R.id.sdv_detail_pic_record)
    SimpleDraweeView sdvDetailPicRecord;
    @BindView(R.id.tv_name_record)
    TextView tvNameRecord;
    @BindView(R.id.tv_detail_cinema_name_record)
    TextView tvDetailCinemaNameRecord;
    @BindView(R.id.tv_detail_hall_record)
    TextView tvDetailHallRecord;
    @BindView(R.id.tv_ticket_num_record)
    TextView tvTicketNumRecord;
    @BindView(R.id.tv_seat_record)
    TextView tvSeatRecord;
    @BindView(R.id.tv_detail_time_record)
    TextView tvDetailTimeRecord;
    @BindView(R.id.tv_order_record)
    TextView tvOrderRecord;
    @BindView(R.id.tv_date_record)
    TextView tvDateRecord;
    @BindView(R.id.tv_money_record)
    TextView tvMoneyRecord;
    private String iamgeUrl;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_record_detail;
    }

    @Override
    protected MinePresenter setPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void initView() {
        super.initView();

        Intent intent = getIntent();
        String orderid = intent.getStringExtra("orderid");
        iamgeUrl = intent.getStringExtra("imageUrl");
        if (!hasNetWork()) {
            showNoNetTip();
        } else {
            mPresenter.getBuyTicketDetail(orderid);
        }

    }

    @Override
    public void onBuyTicketDetail(BuyTicketBean buyTicketBean) {
        Log.i("tick_suc", buyTicketBean.getMessage());
        BuyTicketBean.ResultBean result = buyTicketBean.getResult();
        if (buyTicketBean.getStatus().equals("0000")) {

            //sdvDetailPicRecord.setImageURI(Uri.parse(iamgeUrl));
            //sdvDetailPicRecord.setImage
            //sdvDetailPicRecord.set
            DraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setUri(Uri.parse(iamgeUrl))
                    .setAutoPlayAnimations(true)
                    .build();
            sdvDetailPicRecord.setController(controller);

            tvNameRecord.setText(result.getMovieName());
            tvDetailCinemaNameRecord.setText(result.getCinemaName());
            tvTicketNumRecord.setText(result.getAmount()+"张");
            String s = result.getSeat().replace("-", "排");
            String s1 = s.replace(",", "座");
            tvSeatRecord.setText(s1+"座");
            tvOrderRecord.setText(result.getOrderId());
            tvMoneyRecord.setText("¥"+result.getPrice());
            tvDetailHallRecord.setText(result.getScreeningHall());

            Date date = new Date(result.getCreateTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            tvDateRecord.setText(simpleDateFormat.format(date));

            tvDetailTimeRecord.setText(result.getBeginTime()+"-"+result.getEndTime());
        }

    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err", e.getMessage());

    }


    @OnClick(R.id.but_back_loign)
    public void onViewClicked() {
        finish();
    }
}
