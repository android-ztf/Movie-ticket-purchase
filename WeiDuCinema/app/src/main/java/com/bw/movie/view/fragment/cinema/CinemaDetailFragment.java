package com.bw.movie.view.fragment.cinema;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.event.CinemaInfoEvent;
import com.bw.movie.model.bean.cinema_bean.CinemaInfoBean;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-3
 * INTRODUCE：$
 */
public class CinemaDetailFragment extends BaseFragment {
    @BindView(R.id.tv_location_cinemadtail)
    TextView tvLocationCinemadtail;
    @BindView(R.id.tv_tel_cinemadtail)
    TextView tvTelCinemadtail;
    @BindView(R.id.tv_vehicleroute_cinemadatil)
    TextView tvVehiclerouteCinemadatil;

    @Override
    public int provideLayoutId() {
        return R.layout.fragment_cinemadetail;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getCinemaInfo(CinemaInfoEvent cinemaInfoEvent) {
        Log.i("cinemadetail", cinemaInfoEvent.getJson());


        CinemaInfoBean bean = new Gson().fromJson(cinemaInfoEvent.getJson(), CinemaInfoBean.class);

        tvLocationCinemadtail.setText(bean.getResult().getAddress() + "");
        tvTelCinemadtail.setText(bean.getResult().getPhone() + "");
        String[] split = bean.getResult().getVehicleRoute().split("；");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            builder.append(split[i] + "\n");
        }
        tvVehiclerouteCinemadatil.setText(builder.toString());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @OnClick(R.id.tv_tel_cinemadtail)
    public void onViewClicked() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+tvTelCinemadtail.getText().toString()));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
