package com.bw.movie.view.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.CinemaContract;
import com.bw.movie.model.bean.cinema_bean.CinemaRegionBean;
import com.bw.movie.model.bean.cinema_bean.RegionListBean;
import com.bw.movie.presenter.CinemaPresenter;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.activity.CinemaInfoActivity;
import com.bw.movie.view.adapter.cinema.CinemaRegionAdapter;
import com.bw.movie.view.adapter.cinema.MyRegionAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-2
 * INTRODUCE：$
 */
public class AddressFragment extends BaseFragment<CinemaPresenter> implements CinemaContract.ICinemaView {

    @BindView(R.id.rl_region_address)
    RecyclerView rlRegionAddress;
    @BindView(R.id.rl_cinema_address)
    RecyclerView rlCinemaAddress;
    private MyRegionAdapter regionAdapter;
    private CinemaRegionAdapter cinemaRegionAdapter;

    @Override
    public int provideLayoutId() {
        return R.layout.fragment_recommend;
    }


    @Override
    protected CinemaPresenter setPresenter() {
        return new CinemaPresenter();
    }


    @Override
    protected void inintView() {
        super.inintView();
        regionAdapter = new MyRegionAdapter(getActivity());
        cinemaRegionAdapter = new CinemaRegionAdapter(getActivity());
    }

    @Override
    protected void initData() {
        super.initData();

        rlRegionAddress.setAdapter(regionAdapter);
        rlRegionAddress.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        SpacesItemDecoration decoration = new SpacesItemDecoration(20);
        rlRegionAddress.addItemDecoration(decoration);

        rlCinemaAddress.setAdapter(cinemaRegionAdapter);
        rlCinemaAddress.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        rlCinemaAddress.addItemDecoration(decoration);

        regionAdapter.setCallBack(new MyRegionAdapter.OnClickAddress() {
            @Override
            public void onData(int id,View view) {
                CheckBox box = (CheckBox) view;
                if (box.isChecked()) {
                    mPresenter.getCinemaRegion(id);
                }
            }
        });

        cinemaRegionAdapter.setCallBack(new CinemaRegionAdapter.OnClickAddress() {
            @Override
            public void onData(int id,View view) {
                Intent intent = new Intent(getActivity(), CinemaInfoActivity.class);
                intent.putExtra("cinemaId",id);
                startActivity(intent);
            }
        });

        mPresenter.getRegionList();

    }

    //查询区域内电影院
    @Override
    public void onCinemaRegionSuccess(CinemaRegionBean cinemaRegionBean) {
        Log.i("cinema_region",cinemaRegionBean.getMessage());
        List<CinemaRegionBean.ResultBean> result = cinemaRegionBean.getResult();
        cinemaRegionAdapter.setList(result);
    }

    //查询区域
    @Override
    public void onRegionListSuccess(RegionListBean regionListBean) {
        Log.i("region",regionListBean.getMessage());

        List<RegionListBean.ResultBean> result = regionListBean.getResult();
        regionAdapter.setList(result);

    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("region_err",e.getMessage());

    }
}
