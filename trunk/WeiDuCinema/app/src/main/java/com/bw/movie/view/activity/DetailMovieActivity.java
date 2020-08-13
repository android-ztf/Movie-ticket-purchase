package com.bw.movie.view.activity;


import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.bean.DetailMovieBean;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.presenter.DetailPresenter;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.bw.movie.view.fragment.movie_details.DetailFragmnet;
import com.bw.movie.view.fragment.movie_details.MovieCommentFragmnet;
import com.bw.movie.view.fragment.movie_details.PosterFragmnet;
import com.bw.movie.view.fragment.movie_details.ShortFragmnet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailMovieActivity extends BaseActivity<DetailPresenter> implements HomeContract.IDetailView {

    @BindView(R.id.sdv_detail_pic)
    SimpleDraweeView sdvDetailPic;
    @BindView(R.id.but_back_loign)
    Button butBackLoign;
    @BindView(R.id.tv_detail_score)
    TextView tvDetailScore;
    @BindView(R.id.tv_detail_com_num)
    TextView tvDetailComNum;
    @BindView(R.id.tv_detail_name)
    TextView tvDetailName;
    @BindView(R.id.tv_detail_name2)
    TextView tvDetailName2;
    @BindView(R.id.tv_detail_type)
    TextView tvDetailType;
    @BindView(R.id.tv_detail_time)
    TextView tvDetailTime;
    @BindView(R.id.tv_detail_date)
    TextView tvDetailDate;
    @BindView(R.id.tv_detail_place)
    TextView tvDetailPlace;
    @BindView(R.id.Image)
    ImageView Image;
    @BindView(R.id.cb_detail_guanzhu)
    CheckBox cbDetailGuanzhu;
    @BindView(R.id.layout1)
    RelativeLayout layout1;
    @BindView(R.id.tl_detai_xx)
    TabLayout tlDetaiXx;
    @BindView(R.id.myView)
    RelativeLayout myView;
    @BindView(R.id.SlidingDrawer)
    android.widget.SlidingDrawer SlidingDrawer;
    @BindView(R.id.but_writeMovieComment)
    Button butWriteMovieComment;
    @BindView(R.id.but_buyMovieTickets)
    Button butBuyMovieTickets;
    @BindView(R.id.vp_detail)
    ViewPager vpDetail;
    private int movieId;

    private List<String> title = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    DetailFragmnet detailFragmnet = new DetailFragmnet();
    ShortFragmnet shortFragmnet = new ShortFragmnet();
    PosterFragmnet posterFragmnet = new PosterFragmnet();
    MovieCommentFragmnet movieCommentFragmnet = new MovieCommentFragmnet();
    private String detaiMovie;


    @Override
    protected int provideLayoutId() {
        return R.layout.activity_detail_movie;
    }

    @Override
    protected DetailPresenter setPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected void initView() {
        super.initView();

        Intent intent = getIntent();
        movieId = intent.getIntExtra("movieId", 0);

        title.add("介绍");
        title.add("预告");
        title.add("剧照");
        title.add("影评");


        fragments.add(detailFragmnet);
        fragments.add(shortFragmnet);
        fragments.add(posterFragmnet);
        fragments.add(movieCommentFragmnet);
    }

    @Override
    protected void initData() {
        super.initData();

        SharedPreferences.Editor editor = SharedPreferencesUtils.getInstance().putData();
        editor.putInt("movieId", movieId);
        editor.apply();

        if (!hasNetWork()) {
            showNoNetTip();
        } else {
            if (movieId!=0){
                mPresenter.getDetail(movieId);
            }else{
                Toast.makeText(DetailMovieActivity.this,"出现未知异常,返回主页",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DetailMovieActivity.this,HomeActivity.class));
            }

        }

        //滑动到顶部隐藏和展示控件
        SlidingDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                Image.setVisibility(View.GONE);
                tvDetailName.setVisibility(View.GONE);
                tvDetailName2.setVisibility(View.VISIBLE);
                tvDetailScore.setVisibility(View.GONE);
                tvDetailComNum.setVisibility(View.GONE);
                tvDetailDate.setVisibility(View.GONE);
                tvDetailPlace.setVisibility(View.GONE);
                tvDetailTime.setVisibility(View.GONE);
                tvDetailType.setVisibility(View.GONE);
                cbDetailGuanzhu.setVisibility(View.GONE);
            }
        });
        //滑动到底部隐藏和展示控件
        SlidingDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                Image.setVisibility(View.VISIBLE);
                tvDetailName.setVisibility(View.VISIBLE);
                tvDetailName2.setVisibility(View.GONE);
                tvDetailScore.setVisibility(View.VISIBLE);
                tvDetailComNum.setVisibility(View.VISIBLE);
                tvDetailDate.setVisibility(View.VISIBLE);
                tvDetailPlace.setVisibility(View.VISIBLE);
                tvDetailTime.setVisibility(View.VISIBLE);
                tvDetailType.setVisibility(View.VISIBLE);
                cbDetailGuanzhu.setVisibility(View.VISIBLE);
            }
        });

        tlDetaiXx.setupWithViewPager(vpDetail);



    }

    //查看电影详情
    @Override
    public void onDetailSuccess(DetailMovieBean detailMovieBean) {
        Log.i("detaimovie_suc", detailMovieBean.getMessage());

        detaiMovie = new Gson().toJson(detailMovieBean);
        SharedPreferences.Editor editor = SharedPreferencesUtils.getInstance().putData();
        editor.putString("detaiMovie", detaiMovie);
        editor.apply();

        DetailMovieBean.ResultBean result = detailMovieBean.getResult();

        //设置大背景图片
        sdvDetailPic.setImageURI(Uri.parse(result.getImageUrl()));
        //设置电影名称
        tvDetailName.setText(result.getName());
        tvDetailName2.setText(result.getName());
        //设置评分,评论,类型,时长,上映地点,上映时间
        tvDetailScore.setText("评分\t" + result.getScore() + "分");
        tvDetailComNum.setText("评论\t" + result.getCommentNum() + "万条");
        if (!result.getMovieType().equals("")) {
            tvDetailType.setText(result.getMovieType());
        }
        tvDetailTime.setText(result.getDuration());
        tvDetailPlace.setText(result.getPlaceOrigin() + "上映");

        Date date = new Date(result.getReleaseTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        tvDetailDate.setText(format.format(date));
        //判断是否关注
        if (result.getWhetherFollow() == 1) {
            cbDetailGuanzhu.setChecked(true);
            cbDetailGuanzhu.setText("已关注");
        }

        vpDetail.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }
        });

        vpDetail.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < fragments.size(); i++) {

                    fragments.get(i).onHiddenChanged(true);

                }
                fragments.get(position).onHiddenChanged(false);


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    //关注电影
    @Override
    public void onMovieFollow(LoginBean loginBean) {
        Log.i("follow_suc", loginBean.getMessage());
        Toast.makeText(DetailMovieActivity.this,loginBean.getMessage(),Toast.LENGTH_SHORT).show();

    }
    //取消关注电影
    @Override
    public void onCancelMovieFollow(LoginBean loginBean) {
        Log.i("cancelfollow_suc", loginBean.getMessage());
        Toast.makeText(DetailMovieActivity.this,loginBean.getMessage(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("detaimovie_err", e.getMessage());
    }

    @OnClick({R.id.but_back_loign, R.id.but_writeMovieComment, R.id.but_buyMovieTickets, R.id.cb_detail_guanzhu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_back_loign:
                startActivity(new Intent(DetailMovieActivity.this,HomeActivity.class));
                break;
            case R.id.but_writeMovieComment:
                Intent intent = new Intent(this, WriteCommentActivity.class);
                startActivityForResult(intent,1000);
                break;
            case R.id.but_buyMovieTickets:
                startActivity(new Intent(DetailMovieActivity.this, SelectCinemaActivity.class));
                break;
            case R.id.cb_detail_guanzhu:

                if (cbDetailGuanzhu.isChecked()){
                    if (movieId != 0) {
                        mPresenter.getMovieFollow(movieId);
                        cbDetailGuanzhu.setChecked(true);
                        cbDetailGuanzhu.setText("已关注");
                    }
                }else{
                    if (movieId != 0) {
                        mPresenter.getCancelMovieFollow(movieId);
                        cbDetailGuanzhu.setChecked(false);
                        cbDetailGuanzhu.setText("未关注");
                    }
                }

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1000){
            if (resultCode==101){
                vpDetail.setCurrentItem(fragments.size()-1);
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {//如果返回键按下
            //此处写退向后台的处理
            startActivity(new Intent(DetailMovieActivity.this,HomeActivity.class));
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
