package com.bw.movie.view.fragment.cinema;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.CinemaContract;
import com.bw.movie.event.CinemaInfoEvent;
import com.bw.movie.model.bean.cinema_bean.CinemaCommentBean;
import com.bw.movie.model.bean.cinema_bean.CinemaInfoBean;
import com.bw.movie.presenter.CinemaPresenter;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.bw.movie.view.adapter.MyCommentAdapter;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-3
 * INTRODUCE：$
 */
public class CinemaCommentFragment extends BaseFragment<CinemaPresenter> implements CinemaContract.ICinemaView {
    @BindView(R.id.ptrlv_cinemacomment)
    PullToRefreshListView ptrlvCinemacomment;
    private MyCommentAdapter myCommentAdapter;
    private int page=1;
    private List<CinemaCommentBean.ResultBean> result = new ArrayList<>();
    private int id;

    @Override
    public int provideLayoutId() {
        return R.layout.fragment_cinemacomment;
    }

    @Override
    protected CinemaPresenter setPresenter() {
        return new CinemaPresenter();
    }

    @Override
    protected void inintView() {
        super.inintView();
        myCommentAdapter = new MyCommentAdapter(getActivity());
        ptrlvCinemacomment.setAdapter(myCommentAdapter);


    }

    protected void initMData() {
        super.initData();
        if (!hasNetWrok()){
            showNoNetTip();
        }else{
            mPresenter.getFindCommentCinema(id,page,5);
            //设置模式
            ptrlvCinemacomment.setMode(PullToRefreshBase.Mode.BOTH);
            //上拉和下拉监听
            ptrlvCinemacomment.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                @Override
                public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                    //下拉刷新
                    page=1;
                    if (id!=0)
                        mPresenter.getFindCommentCinema(id,page,5);
                }

                @Override
                public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                    //上拉加载
                    page++;
                    if (id!=0)
                        mPresenter.getFindCommentCinema(id,page,5);
                }
            });

            myCommentAdapter.setCallBack(new MyCommentAdapter.OnDianzCallBack() {
                @Override
                public void onDianz(View v,int id) {
                    CheckBox box = (CheckBox) v;
                    box.setChecked(true);
                    mPresenter.postCommentGreat(id);
                }
            });

        }
    }

    @Override
    public void onFindCommentSuccess(CinemaCommentBean cinemaCommentBean) {
        Log.i("commentfind",cinemaCommentBean.getMessage());
        ptrlvCinemacomment.onRefreshComplete();
        for (int i = 0; i < cinemaCommentBean.getResult().size(); i++) {
            result.add(cinemaCommentBean.getResult().get(i));
        }
        myCommentAdapter.setList(result);
    }

    @Override
    public void onCommentGreatSuccess(CinemaCommentBean cinemaCommentBean) {
        Log.i("commentfind",cinemaCommentBean.getMessage());
        Toast.makeText(getActivity(),cinemaCommentBean.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("commentfind",e.getMessage());
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getCinemaInfo(CinemaInfoEvent cinemaInfoEvent) {
        Log.i("cinemadetail",cinemaInfoEvent.getJson());

        CinemaInfoBean bean = new Gson().fromJson(cinemaInfoEvent.getJson(), CinemaInfoBean.class);
        id=bean.getResult().getId();
        initMData();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}
