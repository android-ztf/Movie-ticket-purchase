package com.bw.movie.view.activity.mine;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.view.fragment.mine.UserNotRecordFragment;
import com.bw.movie.view.fragment.mine.UserRecordFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineTicketRecordActivity extends BaseActivity {

    @BindView(R.id.but_back_record)
    Button butBackRecord;
    @BindView(R.id.tl_record_mine)
    TabLayout tlRecordMine;
    @BindView(R.id.vp_record_mine)
    ViewPager vpRecordMine;

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> title = new ArrayList<>();

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_mine_ticket_record;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        super.initView();

        fragments.add(new UserNotRecordFragment());
        fragments.add(new UserRecordFragment());
        title.add("未付款");
        title.add("以付款");

        tlRecordMine.setupWithViewPager(vpRecordMine);


    }

    @Override
    protected void initData() {
        super.initData();

        vpRecordMine.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
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



    }

    @OnClick(R.id.but_back_record)
    public void onViewClicked() {
        finish();
    }
}
