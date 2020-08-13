package com.bw.movie.view.activity.mine;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.view.fragment.mine.UserCinemaCommentFragment;
import com.bw.movie.view.fragment.mine.UserMovieCommentFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineCommentActivity extends BaseActivity {

    @BindView(R.id.but_back_loign)
    Button butBackLoign;
    @BindView(R.id.tl_mine_comment)
    TabLayout tlMineComment;
    @BindView(R.id.vp_mine_comment)
    ViewPager vpMineComment;
    private List<String> title =new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_mine_comment;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();

        fragments.add(new UserMovieCommentFragment());
        fragments.add(new UserCinemaCommentFragment());
        title.add("电影");
        title.add("影院");

        tlMineComment.setupWithViewPager(vpMineComment);

        vpMineComment.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
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

    @OnClick(R.id.but_back_loign)
    public void onViewClicked() {
        finish();
    }
}
