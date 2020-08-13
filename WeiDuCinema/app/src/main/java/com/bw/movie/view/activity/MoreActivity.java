package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.bean.ComingMovieBean;
import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.bean.ReleaseMovieBean;
import com.bw.movie.presenter.HomePresenter;
import com.bw.movie.view.fragment.ComingFragment;
import com.bw.movie.view.fragment.HotFragment;
import com.bw.movie.view.fragment.ReleaseFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoreActivity extends BaseActivity<HomePresenter>{

    @BindView(R.id.but_back_more)
    Button butBackMore;
    @BindView(R.id.et_seek_more)
    EditText etSeekMore;
    @BindView(R.id.iv_seek_more)
    ImageView ivSeekMore;
    @BindView(R.id.tl_more)
    TabLayout tlMore;
    @BindView(R.id.vp_more)
    ViewPager vpMore;

    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_more;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        super.initView();
        fragments.add(new ReleaseFragment());
        fragments.add(new ComingFragment());
        fragments.add(new HotFragment());

        titles.add("正在热映");
        titles.add("即将上映");
        titles.add("热门电影");

    }

    @Override
    protected void initData() {
        super.initData();

        if (!hasNetWork()){
            showNoNetTip();
        }else{

        }



        vpMore.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
                return titles.get(position);
            }

        });

        tlMore.setupWithViewPager(vpMore);

        Intent intent = getIntent();
        int more = intent.getIntExtra("more", 0);
        if (more!=0){
            vpMore.setCurrentItem(more-1);
        }


    }



    @OnClick({R.id.but_back_more, R.id.iv_seek_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_back_more:
                finish();
                break;
            case R.id.iv_seek_more:
                break;
        }
    }
}
