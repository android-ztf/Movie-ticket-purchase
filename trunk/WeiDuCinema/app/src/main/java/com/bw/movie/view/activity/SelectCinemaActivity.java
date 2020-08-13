package com.bw.movie.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.BuyTicketContract;
import com.bw.movie.model.bean.DetailMovieBean;
import com.bw.movie.model.bean.cinema_bean.NearbyCinemasBean;
import com.bw.movie.presenter.BuyTicketPresenter;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.adapter.MyCienamAdapter;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class SelectCinemaActivity extends BaseActivity<BuyTicketPresenter> implements BuyTicketContract.IBuyTicketView {
    @BindView(R.id.but_back_buy)
    Button butBackBuy;
    @BindView(R.id.jcvps_ygp_buy)
    JCVideoPlayerStandard jcvpsYgpBuy;
    @BindView(R.id.tv_name_buy)
    TextView tvNameBuy;
    @BindView(R.id.tv_time_buy)
    TextView tvTimeBuy;
    @BindView(R.id.tv_score_buy)
    TextView tvScoreBuy;
    @BindView(R.id.tv_dao_buy)
    TextView tvDaoBuy;
    @BindView(R.id.xx_ll)
    LinearLayout xxLl;
    @BindView(R.id.rv_cinema_buy)
    RecyclerView rvCinemaBuy;

    private String detaiMovie;
    private String jinwei;

    private MyCienamAdapter myCienamAdapter;
    private DetailMovieBean detailMovieBean;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_select_cinema;
    }

    @Override
    protected BuyTicketPresenter setPresenter() {
        return new BuyTicketPresenter();
    }

    @Override
    protected void initView() {
        super.initView();
        SharedPreferences data = SharedPreferencesUtils.getInstance().getData();
        detaiMovie = data.getString("detaiMovie", "");
        jinwei = data.getString("jinwei", "");


        myCienamAdapter = new MyCienamAdapter(this);
    }

    @Override
    protected void initData() {
        super.initData();
        if (!hasNetWork()){
            showNoNetTip();
        }else{
            if (!detaiMovie.equals("")&&detaiMovie!=null){
                detailMovieBean = new Gson().fromJson(detaiMovie, DetailMovieBean.class);
                DetailMovieBean.ResultBean result = detailMovieBean.getResult();
                //设置视频地址、缩略图地址、标题
               jcvpsYgpBuy.setUp(result.getShortFilmList().get(1).getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
               // if (setUp){
                    Glide.with(this)
                            .load(result.getShortFilmList().get(1).getImageUrl())
                            .into(jcvpsYgpBuy.thumbImageView);
                //}

                tvNameBuy.setText(result.getName());
                tvDaoBuy.setText("导演:\n\n"+result.getMovieDirector().get(0).getName());
                tvScoreBuy.setText("评分:\n\n"+result.getScore()+"分");
                tvTimeBuy.setText("时长:\n\n"+result.getDuration()+"分钟");

            }

            if (jinwei!=null&&!jinwei.equals("")){
                String[] jinwei = this.jinwei.split(",");
                Log.i("jinwei",jinwei[0]+jinwei[1]+"猴子");
                mPresenter.getNearbyCinemas(1,10,jinwei[1],jinwei[0]);
            }

            rvCinemaBuy.setAdapter(myCienamAdapter);
            rvCinemaBuy.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
            SpacesItemDecoration decoration = new SpacesItemDecoration(10);
            rvCinemaBuy.addItemDecoration(decoration);

            //点击跳转到
            myCienamAdapter.setCallBack(new MyCienamAdapter.OnCinemaCallBack() {
                @Override
                public void getCinemaId(int cinemaId) {
                    Intent intent = new Intent(SelectCinemaActivity.this, BuyTicketActivity.class);
                    intent.putExtra("movieId",detailMovieBean.getResult().getMovieId());
                    intent.putExtra("cinemaId",cinemaId);
                    startActivity(intent);
                }
            });

        }
    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err", e.getMessage());
    }

    @Override
    public void onSuccess(NearbyCinemasBean nearbyCinemasBean) {
        Log.i("sl_fuji_su",nearbyCinemasBean.getMessage());

        List<NearbyCinemasBean.ResultBean> result = nearbyCinemasBean.getResult();
        myCienamAdapter.setList(result);
    }


    @OnClick({R.id.but_back_buy, R.id.jcvps_ygp_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_back_buy:
                finish();
                break;
            case R.id.jcvps_ygp_buy:
                break;
        }
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

}
