package com.bw.movie.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.CinemaContract;
import com.bw.movie.event.CinemaInfoEvent;
import com.bw.movie.model.bean.cinema_bean.CinemaInfoBean;
import com.bw.movie.presenter.CinemaPresenter;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.adapter.MyLabelAdapter;
import com.bw.movie.view.fragment.cinema.CinemaCommentFragment;
import com.bw.movie.view.fragment.cinema.CinemaDetailFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CinemaInfoActivity extends BaseActivity<CinemaPresenter> implements CinemaContract.ICinemaView {

    @BindView(R.id.but_back_cinemainfo)
    Button butBackCinemainfo;
    @BindView(R.id.tv_cinfo_name)
    TextView tvCinfoName;
    @BindView(R.id.cb_cinfo_guanzhu)
    CheckBox cb_cinfo_guanzhu;
    TextView tvCinfoLabel3;
    @BindView(R.id.tl_cinfo)
    TabLayout tlCinfo;
    @BindView(R.id.vp_cinfo)
    ViewPager vpCinfo;
    @BindView(R.id.tv_movielist)
    TextView tvMovielist;
    @BindView(R.id.tv_cinfo_goto)
    TextView tvCinfoGoto;
    @BindView(R.id.rl_cinfo_lable)
    RecyclerView rlCinfoLable;
    private int cinemaId;
    private CinemaInfoBean.ResultBean result;

    private MyLabelAdapter myLabelAdapter;
    private List<String> title_cinfo = new ArrayList<>();
    private List<Fragment> fragment_cinfo = new ArrayList<>();

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_cinema_info;
    }

    @Override
    protected CinemaPresenter setPresenter() {
        return new CinemaPresenter();
    }

    @Override
    protected void initView() {
        super.initView();

        //获取传来的值并全局化
        Intent intent = getIntent();
        cinemaId = intent.getIntExtra("cinemaId", 0);

        myLabelAdapter = new MyLabelAdapter(this);
        rlCinfoLable.setAdapter(myLabelAdapter);
        rlCinfoLable.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        SpacesItemDecoration decoration = new SpacesItemDecoration(10);
        rlCinfoLable.addItemDecoration(decoration);

    }

    @Override
    protected void initData() {
        super.initData();

        if (!hasNetWork()) {
            showNoNetTip();
        } else {
            //请求数据
            if (cinemaId == 0) {
                Toast.makeText(this, "数据请求异常", Toast.LENGTH_SHORT).show();
            } else {
                mPresenter.getCinemaInfo(cinemaId);
            }
        }

        title_cinfo.add("影院详情");
        title_cinfo.add("影院评价");

        fragment_cinfo.add(new CinemaDetailFragment());
        fragment_cinfo.add(new CinemaCommentFragment());
        tlCinfo.setupWithViewPager(vpCinfo);
        vpCinfo.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragment_cinfo.get(position);
            }

            @Override
            public int getCount() {
                return fragment_cinfo.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title_cinfo.get(position);
            }
        });

    }

    //影院详细信息获取成功
    @Override
    public void onCinemaInfoSuccess(CinemaInfoBean cinemaInfoBean) {
        Log.i("cinemainfo_success", cinemaInfoBean.getMessage());

        //讲影院的详细信息存入SharedPreferences,方便详情展示
        String cinemaInfo = new Gson().toJson(cinemaInfoBean);
        CinemaInfoEvent event = new CinemaInfoEvent();
        event.setJson(cinemaInfo);
        EventBus.getDefault().post(event);


        result = cinemaInfoBean.getResult();

        tvCinfoName.setText(result.getName());
        if (result.getFollowCinema() == 1) {
            cb_cinfo_guanzhu.setChecked(true);
        }
        String label = result.getLabel();
        String[] split = label.split(",");
        myLabelAdapter.setLable(split);

    }
    //电影关注成功与否
    @Override
    public void onFollowSuccess(CinemaInfoBean cinemaInfoBean) {
        Log.i("follow_success", cinemaInfoBean.getMessage());
        Toast.makeText(this, cinemaInfoBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("cinemainfo_success", e.getMessage());

    }

    @OnClick({R.id.but_back_cinemainfo, R.id.cb_cinfo_guanzhu, R.id.tv_movielist, R.id.tv_cinfo_goto})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_back_cinemainfo:
                finish();
                break;
            case R.id.cb_cinfo_guanzhu:
                if (cb_cinfo_guanzhu.isChecked()){
                    mPresenter.getFollowCinema(cinemaId);
                }else{
                    mPresenter.getCancelFollowCinema(cinemaId);
                }
                break;
            case R.id.tv_movielist:
                //带着id跳转到影院电影排期页面
                Intent intent = new Intent(this, CinemaMovieListActivity.class);
                intent.putExtra("cinemaId",cinemaId);
                startActivity(intent);
                break;
            case R.id.tv_cinfo_goto:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("出行参考");
                builder.setMessage(result.getVehicleRoute());
                builder.setCancelable(false);
                builder.setPositiveButton("ok,俺知道了", null);
                builder.show();
                break;
        }
    }

}
