package com.bw.movie.view.activity.mine;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.cinema_bean.CinemaInfoBean;
import com.bw.movie.model.bean.mine.UserFollowCinemaBean;
import com.bw.movie.model.bean.mine.UserFollowMovieBean;
import com.bw.movie.presenter.MinePresenter;
import com.bw.movie.view.fragment.mine.UserFollowCinemaFragment;
import com.bw.movie.view.fragment.mine.UserFollowMovieFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineFollowActivity extends BaseActivity<MinePresenter> implements MineContract.IMineView {

    @BindView(R.id.but_back_minefollow)
    Button butBackMinefollow;
    @BindView(R.id.tl_minefollow)
    TabLayout tlMinefollow;
    @BindView(R.id.vp_minefollow)
    ViewPager vpMinefollow;

    private List<String> title = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_mine_follow;
    }

    @Override
    protected MinePresenter setPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void initView() {
        super.initView();

        title.add("电影");
        title.add("影院");

        fragments.add(new UserFollowMovieFragment());
        fragments.add(new UserFollowCinemaFragment());

        tlMinefollow.setupWithViewPager(vpMinefollow);

    }

    @Override
    protected void initData() {
        super.initData();

        if (!hasNetWork()){
            showNoNetTip();
        }else{

        }



        vpMinefollow.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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

    @Override
    public void onFailure(Throwable e) {
        Log.i("err", e.getMessage());
    }


    @OnClick(R.id.but_back_minefollow)
    public void onViewClicked() {
        finish();
    }
}
