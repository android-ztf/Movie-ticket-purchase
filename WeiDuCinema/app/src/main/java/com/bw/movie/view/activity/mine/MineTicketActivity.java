package com.bw.movie.view.activity.mine;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.bean.mine.ExchangeCodeBean;
import com.bw.movie.model.bean.mine.MyMovieTicketBean;
import com.bw.movie.presenter.MinePresenter;
import com.bw.movie.utils.RetrofitManager;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.adapter.mine.MyMovieTicketAdapter;
import com.facebook.common.util.HashCodeUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.camera.BitmapLuminanceSource;
import com.uuzuche.lib_zxing.decoding.DecodeFormatManager;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.http.Url;

public class MineTicketActivity extends BaseActivity<MinePresenter> implements MineContract.IMineView {

    @BindView(R.id.but_back_mineticket)
    Button butBackMineticket;
    @BindView(R.id.xrl_mineticket)
    XRecyclerView xrlMineticket;
    private MyMovieTicketAdapter myMovieTicketAdapter;
    private String twoCode;
    private String exchangeCode;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_mine_ticket;
    }

    @Override
    protected MinePresenter setPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void initView() {
        super.initView();
        myMovieTicketAdapter = new MyMovieTicketAdapter(this);
    }

    @Override
    protected void initData() {
        super.initData();

        xrlMineticket.setAdapter(myMovieTicketAdapter);
        xrlMineticket.setLayoutManager(new LinearLayoutManager(this));
        xrlMineticket.addItemDecoration(new SpacesItemDecoration(10));

        if (!hasNetWork()){
            showNoNetTip();
        }else{
            mPresenter.getMyMovieTicket();
        }

        xrlMineticket.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //下拉刷新
                mPresenter.getMyMovieTicket();
            }

            @Override
            public void onLoadMore() {
                //上拉加载
            }
        });

        myMovieTicketAdapter.setCallBack(new MyMovieTicketAdapter.MyMovieCallBack() {
            @Override
            public void onResereve(int recordId) {
                if (recordId!=0){
                    mPresenter.getExchangeCode(recordId);
                }
            }
        });

    }

    @Override
    public void onExchangeCode(ExchangeCodeBean exchangeCodeBean) {
        Log.e("erweima",exchangeCodeBean.getMessage());

        ExchangeCodeBean.ResultBean result = exchangeCodeBean.getResult();
        exchangeCode = result.getExchangeCode();
        if (exchangeCode !=null){
            initPopwindow(exchangeCode);
        }
    }

    @Override
    public void onMyMovieTicket(MyMovieTicketBean myMovieTicketBean) {
        Log.i("my_ticket",myMovieTicketBean.getMessage());

        xrlMineticket.refreshComplete();
        List<MyMovieTicketBean.ResultBean> result = myMovieTicketBean.getResult();

        myMovieTicketAdapter.setList(result);

    }

    @Override
    public void onFailure(Throwable e) {
        Log.e("err",e.getMessage());
    }


    @OnClick(R.id.but_back_mineticket)
    public void onViewClicked() {
        finish();
    }

    private void initPopwindow(String exchangeCode){

        Log.e("exchangeCode",exchangeCode);


        View view = View.inflate(MineTicketActivity.this, R.layout.popwindow_erweima, null);
        PopupWindow window = new PopupWindow(view, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        window.setBackgroundDrawable(new ColorDrawable());
        window.setOutsideTouchable(false);

        window.showAtLocation(view, Gravity.CENTER,0,0);

        ImageView iv = (ImageView) view.findViewById(R.id.iv_code);

        view.findViewById(R.id.but_back_aa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });
        view.findViewById(R.id.but_qux).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });

        Glide.with(this)
                .load(exchangeCode)
                .placeholder(R.mipmap.zzjz)
                .error(R.mipmap.failure)
                .into(iv);


    }




}
