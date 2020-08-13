package com.bw.movie.view.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.CinemaContract;
import com.bw.movie.event.AddEvent;
import com.bw.movie.model.bean.cinema_bean.NearbyCinemasBean;
import com.bw.movie.presenter.CinemaPresenter;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.activity.CinemaInfoActivity;
import com.bw.movie.view.adapter.MyCienamAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-2
 * INTRODUCE：$
 */
public class NearbyFragment extends BaseFragment<CinemaPresenter> implements CinemaContract.ICinemaView {

    @BindView(R.id.rv_more)
    RecyclerView rvMore;
    private double latitude;
    private double longitude;
    private MyCienamAdapter myCienamAdapter;
    private String jinwei;

    @Override
    public int provideLayoutId() {
        return R.layout.fragment_more;
    }

    @Override
    protected CinemaPresenter setPresenter() {
        return new CinemaPresenter();
    }

    @Override
    protected void inintView() {
        super.inintView();
        myCienamAdapter = new MyCienamAdapter(getActivity());

        SharedPreferences data = SharedPreferencesUtils.getInstance().getData();
        jinwei = data.getString("jinwei", "");
    }

    @Override
    protected void initData() {
        super.initData();

        rvMore.setAdapter(myCienamAdapter);
        rvMore.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));

        SpacesItemDecoration decoration = new SpacesItemDecoration(10);
        rvMore.addItemDecoration(decoration);

        if (jinwei!=null&&!jinwei.equals("")){
            String[] jinwei = this.jinwei.split(",");
            Log.i("jinwei",jinwei[0]+jinwei[1]+"猴子");
            mPresenter.getNearbyCinemas(1, 4, jinwei[1], jinwei[0]);
        }




        myCienamAdapter.setCallBack(new MyCienamAdapter.OnCinemaCallBack() {
            @Override
            public void getCinemaId(int cinemaId) {
                Intent intent = new Intent(getActivity(), CinemaInfoActivity.class);
                intent.putExtra("cinemaId",cinemaId);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onSuccess(NearbyCinemasBean nearbyCinemasBean) {
        Log.i("cinema", nearbyCinemasBean.getMessage());
        List<NearbyCinemasBean.ResultBean> result = nearbyCinemasBean.getResult();
        myCienamAdapter.setList(result);
    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("cinema", e.getMessage());
    }


}
