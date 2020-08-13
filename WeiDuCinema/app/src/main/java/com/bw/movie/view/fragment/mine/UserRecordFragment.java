package com.bw.movie.view.fragment.mine;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.bean.mine.TicketRecordBean;
import com.bw.movie.model.bean.pay_movie.PayMoneyBean;
import com.bw.movie.presenter.MinePresenter;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.activity.mine.RecordDetailActivity;
import com.bw.movie.view.adapter.mine.UserNotRecordAdapter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-29
 * INTRODUCE：$
 * 未付款
 */
public class UserRecordFragment extends BaseFragment<MinePresenter> implements MineContract.IMineView {
    @BindView(R.id.xrl_not_record)
    XRecyclerView xrlNotRecord;
    @BindView(R.id.tv_nnotfollow)
    TextView tvNnotfollow;
    @BindView(R.id.rl_not_follow)
    RelativeLayout rlNotFollow;


    private UserNotRecordAdapter userNotRecordAdapter;


    private int page = 1;
    //1 是代付款 2是已付款
    private int status = 2;

    @Override
    public int provideLayoutId() {
        return R.layout.fragment_not_record;
    }

    @Override
    protected MinePresenter setPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void inintView() {
        super.inintView();
        userNotRecordAdapter = new UserNotRecordAdapter(getActivity());
    }

    @Override
    protected void initData() {
        super.initData();

        tvNnotfollow.setText("暂时没有未付款电影");

        if (!hasNetWrok()) {
            showNoNetTip();
        } else {
            mPresenter.getBuyTicketRecord(page, 5, status);
        }

        xrlNotRecord.setLayoutManager(new LinearLayoutManager(getActivity()));
        xrlNotRecord.addItemDecoration(new SpacesItemDecoration(10));

        xrlNotRecord.setAdapter(userNotRecordAdapter);

        xrlNotRecord.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xrlNotRecord.setLoadingMoreProgressStyle(ProgressStyle.SquareSpin);


        xrlNotRecord.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //下拉刷新
                page = 1;
                mPresenter.getBuyTicketRecord(page, 5, status);
            }

            @Override
            public void onLoadMore() {
                //上拉加载
                page++;
                mPresenter.getBuyTicketRecord(page, 5, status);
            }
        });

        userNotRecordAdapter.setCallBack(new UserNotRecordAdapter.INotRecordCallBack() {
            @Override
            public void onDetailMovieId(String orderid, String imageUrl, View v ,double price) {
                if (v instanceof RelativeLayout) {
                    Intent intent = new Intent(getActivity(), RecordDetailActivity.class);
                    intent.putExtra("orderid", orderid);
                    intent.putExtra("imageUrl", imageUrl);
                    startActivity(intent);
                } else {

                }
            }
        });

    }

    @Override
    public void onTicketRecord(TicketRecordBean ticketRecordBean) {
        Log.i("record_suc", ticketRecordBean.getMessage());
        //停止刷新
        xrlNotRecord.refreshComplete();
        List<TicketRecordBean.ResultBean> result = ticketRecordBean.getResult();
        if (result.size() != 0) {
            xrlNotRecord.setVisibility(View.VISIBLE);
            Collections.reverse(result);
            userNotRecordAdapter.setList(result, status);
            rlNotFollow.setVisibility(View.GONE);
        } else {
            rlNotFollow.setVisibility(View.VISIBLE);
            xrlNotRecord.setVisibility(View.GONE);
        }
    }



    @Override
    public void onFailure(Throwable e) {
        Log.i("err", e.getMessage());
    }


}
