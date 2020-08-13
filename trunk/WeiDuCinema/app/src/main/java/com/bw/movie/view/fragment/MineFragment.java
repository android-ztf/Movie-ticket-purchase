package com.bw.movie.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.bean.UserInFoBean;
import com.bw.movie.model.bean.mine.UnreadMsgCountBean;
import com.bw.movie.presenter.MinePresenter;
import com.bw.movie.view.activity.NotNetActivity;
import com.bw.movie.view.activity.mine.FeedBackActivity;
import com.bw.movie.view.activity.mine.MineCommentActivity;
import com.bw.movie.view.activity.mine.MineFollowActivity;
import com.bw.movie.view.activity.mine.MineInfoActivity;
import com.bw.movie.view.activity.mine.MineReserveActivity;
import com.bw.movie.view.activity.mine.MineTicketActivity;
import com.bw.movie.view.activity.mine.MineTicketRecordActivity;
import com.bw.movie.view.activity.mine.SysMsgAllActivity;
import com.bw.movie.view.activity.mine.UserSeenActivity;
import com.bw.movie.view.activity.mine.UserSetActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-16
 * INTRODUCE：我的页面$
 */
public class MineFragment extends BaseFragment<MinePresenter> implements MineContract.IMineView {
    @BindView(R.id.sdv_mine_pic)
    SimpleDraweeView sdvMinePic;
    @BindView(R.id.but_xinxi)
    Button butXinxi;
    @BindView(R.id.tv_mine_name)
    TextView tvMineName;
    @BindView(R.id.but_mine_more)
    Button butMineMore;
    @BindView(R.id.tv_dyp)
    TextView tvDyp;
    @BindView(R.id.but_dyp)
    Button butDyp;
    @BindView(R.id.but_mine_gz)
    Button butMineGz;
    @BindView(R.id.but_mine_oldmovie)
    Button butMineOldmovie;
    @BindView(R.id.but_mine_sz)
    Button butMineSz;
    @BindView(R.id.but_mine_yuyu)
    Button butMineYuyu;
    @BindView(R.id.but_mine_pl)
    Button butMinePl;
    @BindView(R.id.but_mine_gopiao)
    Button butMineGopiao;
    @BindView(R.id.but_mine_yjian)
    Button butMineYjian;
    @BindView(R.id.tv_unread_num)
    TextView tvUnreadNum;
    @BindView(R.id.srl_mine)
    SwipeRefreshLayout srlMine;
    @BindView(R.id.sv_mine)
    ScrollView svMine;

    private boolean isRefresh = false;//是否刷新中

    @Override
    public int provideLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected MinePresenter setPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void inintView() {
        super.inintView();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initData() {
        super.initData();
        if (!hasNetWrok()) {
            //无网吐司 并跳转到无网页面
            showNoNetTip();
            startActivity(new Intent(getActivity(), NotNetActivity.class));
        } else {
            mPresenter.getUserInFo();
            mPresenter.getUnreadMsgCount();
        }

        //设置下拉颜色
        srlMine.setColorSchemeColors(Color.RED);

        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        srlMine.setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        srlMine.setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        srlMine.setSize(SwipeRefreshLayout.LARGE);

        srlMine.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getUserInFo();
                mPresenter.getUnreadMsgCount();

                //检查是否处于刷新状态
                if (!isRefresh) {
                    isRefresh = true;
                    //模拟加载网络数据，这里设置4秒，正好能看到4色进度条
                    new Handler().postDelayed(new Runnable() {
                        public void run() {

                            //显示或隐藏刷新进度条
                            srlMine.setRefreshing(false);
                            isRefresh = false;
                        }
                    }, 2000);
                }

            }
        });


    }

    @Override
    public void onUserInFoSuccess(UserInFoBean userInFoBean) {
        Log.i("userinfo_mine", userInFoBean.getMessage());
        UserInFoBean.ResultBean result = userInFoBean.getResult();
        //设置信息
        sdvMinePic.setImageURI(Uri.parse(result.getHeadPic()));
        tvMineName.setText(result.getNickName());

    }

    @Override
    public void onUnreadMsgCount(UnreadMsgCountBean unreadMsgCountBean) {

        if (unreadMsgCountBean.getCount() != 0) {
            tvUnreadNum.setVisibility(View.VISIBLE);
            tvUnreadNum.setText(unreadMsgCountBean.getCount() + "");

        } else {
            tvUnreadNum.setVisibility(View.GONE);
        }

    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err_mine", e.getMessage());
    }

    @OnClick({R.id.but_xinxi, R.id.sdv_mine_pic, R.id.tv_mine_name, R.id.wd_rl, R.id.tv_dyp, R.id.but_dyp, R.id.but_mine_gz, R.id.but_mine_oldmovie, R.id.but_mine_sz, R.id.but_mine_yuyu, R.id.but_mine_pl, R.id.but_mine_gopiao, R.id.but_mine_yjian})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_xinxi:
                startActivity(new Intent(getActivity(), SysMsgAllActivity.class));
                break;
            case R.id.sdv_mine_pic:
            case R.id.tv_mine_name:
            case R.id.wd_rl:
                startActivity(new Intent(getActivity(), MineInfoActivity.class));
                break;
            case R.id.tv_dyp:
            case R.id.but_dyp:
                startActivity(new Intent(getActivity(), MineTicketActivity.class));
                break;
            case R.id.but_mine_gz:
                startActivity(new Intent(getActivity(), MineFollowActivity.class));
                break;
            case R.id.but_mine_oldmovie:
                startActivity(new Intent(getActivity(), UserSeenActivity.class));
                break;
            case R.id.but_mine_sz:
                startActivity(new Intent(getActivity(), UserSetActivity.class));
                break;
            case R.id.but_mine_yuyu:
                startActivity(new Intent(getActivity(), MineReserveActivity.class));
                break;
            case R.id.but_mine_pl:
                startActivity(new Intent(getActivity(), MineCommentActivity.class));
                break;
            case R.id.but_mine_gopiao:
                startActivity(new Intent(getActivity(), MineTicketRecordActivity.class));
                break;
            case R.id.but_mine_yjian:
                startActivity(new Intent(getActivity(), FeedBackActivity.class));
                break;
        }
    }
}
