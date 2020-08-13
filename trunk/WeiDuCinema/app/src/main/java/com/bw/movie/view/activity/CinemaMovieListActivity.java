package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.CinemaContract;
import com.bw.movie.model.bean.cinema_bean.CinemaMovieListBean;
import com.bw.movie.model.bean.cinema_bean.FindDateBean;
import com.bw.movie.presenter.CinemaPresenter;
import com.bw.movie.view.fragment.cinema.ScheduleFragment;
import com.google.android.material.tabs.TabLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CinemaMovieListActivity extends BaseActivity<CinemaPresenter> implements CinemaContract.ICinemaView {

    @BindView(R.id.but_back_movielist)
    Button butBackMovielist;
    @BindView(R.id.tl_movielist)
    TabLayout tlMovielist;
    @BindView(R.id.vp_movielist)
    ViewPager vpMovielist;
    List<Fragment> list=new ArrayList<>();
    List<String> tablist=new ArrayList<>();

    private List<String> date = new ArrayList<>();
    private int cinemaId;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_cinema_movie_list;
    }

    @Override
    protected CinemaPresenter setPresenter() {
        return new CinemaPresenter();
    }

    @Override
    protected void initView() {
        super.initView();

        Intent intent = getIntent();
        cinemaId = intent.getIntExtra("cinemaId", 0);


    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getFindDate();
        if (cinemaId != 0) {
            mPresenter.getCinemaMovieList(cinemaId, 1, 5);
        }
    }

    @Override
    public void onFindDateSuccess(FindDateBean findDateBean) {
        Log.i("findate_success", findDateBean.getMessage());
        List<String> result = findDateBean.getResult();
        for (int i = 0; i < result.size(); i++) {

            String date = null;
            if (i == 0) {
                date = "今天";
            } else if (i == 1) {
                date = "明天";
            } else if (i == 2) {
                date = "后天";
            } else {
                SimpleDateFormat f = new SimpleDateFormat("MM-dd");
                String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
                Calendar cal = Calendar.getInstance(); // 获得一个日历
                Date datet = null;
                try {
                    datet = f.parse(result.get(i));
                    cal.setTime(datet);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
                if (w < 0)
                    w = 0;
                date = weekDays[w];
            }
            tablist.add(date+" "+result.get(i));
            ScheduleFragment scheduleFragment = new ScheduleFragment();
            list.add(scheduleFragment);
        }

        tlMovielist.setupWithViewPager(vpMovielist);

        vpMovielist.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tablist.get(position);
            }
        });


    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err", e.getMessage());
    }

    @OnClick(R.id.but_back_movielist)
    public void onViewClicked() {
        finish();
    }

}
