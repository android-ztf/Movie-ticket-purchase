package com.bw.movie.view.activity.mine;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.mine.SysMsgAllBean;
import com.bw.movie.model.bean.mine.UnreadMsgCountBean;
import com.bw.movie.presenter.MinePresenter;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.adapter.mine.SysMsgAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SysMsgAllActivity extends BaseActivity<MinePresenter> implements MineContract.IMineView {

    @BindView(R.id.but_back_loign)
    Button butBackLoign;
    @BindView(R.id.xrl_sys_msg)
    XRecyclerView xrlSysMsg;

    int page = 1;
    int count = 100;
    @BindView(R.id.rl_not_follow)
    RelativeLayout rlNotFollow;

    private SysMsgAdapter sysMsgAdapter;

    List<SysMsgAllBean.ResultBean> unRead = new ArrayList<>();
    List<SysMsgAllBean.ResultBean> read = new ArrayList<>();
    List<SysMsgAllBean.ResultBean> msgAll = new ArrayList<>();


    @Override
    protected int provideLayoutId() {
        return R.layout.activity_sys_msg_all;
    }

    @Override
    protected MinePresenter setPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void initView() {
        super.initView();

        sysMsgAdapter = new SysMsgAdapter(this);

    }

    @Override
    protected void initData() {
        super.initData();

        xrlSysMsg.setAdapter(sysMsgAdapter);
        xrlSysMsg.setLayoutManager(new LinearLayoutManager(this));
        xrlSysMsg.addItemDecoration(new SpacesItemDecoration(10));

        mPresenter.getSysMsgAll(page, count);


//        xrlSysMsg.setLoadingListener(new XRecyclerView.LoadingListener() {
//            @Override
//            public void onRefresh() {
//                //下拉
//                count = 7;
//                mPresenter.getSysMsgAll(page, count);
//            }
//
//            @Override
//            public void onLoadMore() {
//                count += 7;
//                mPresenter.getSysMsgAll(page, count);
//            }
//        });

        sysMsgAdapter.setCallBack(new SysMsgAdapter.SysMsgCallBack() {
            @Override
            public void onResereve(int id, View v, String title, String content) {
                v.setVisibility(View.GONE);
                if (id != 0 && v != null && title != null && content != null) {
                    initAlert(id, v, title, content);
                } else {
                    Toast.makeText(SysMsgAllActivity.this, "检查网络,刷新试试", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void onSysMsgAll(SysMsgAllBean sysMsgAllBean) {

        Log.e("sys_suc", sysMsgAllBean.getMessage());

        xrlSysMsg.refreshComplete();
        if (sysMsgAllBean.getStatus().equals("0000")) {
            List<SysMsgAllBean.ResultBean> result = sysMsgAllBean.getResult();
            if (result.size()!=0){


                for (int i = 0; i < result.size(); i++) {
                    if (result.get(i).getStatus()==0){
                        unRead.add(result.get(i));
                    }else{
                        read.add(result.get(i));
                    }
                }
                msgAll.addAll(unRead);
                msgAll.addAll(read);

                sysMsgAdapter.setList(result);
                rlNotFollow.setVisibility(View.GONE);
            }else{
                rlNotFollow.setVisibility(View.VISIBLE);
                xrlSysMsg.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onChangeSysMsg(LoginBean loginBean) {
        Log.e("change_suc", loginBean.getMessage());

    }

    @Override
    public void onFailure(Throwable e) {
        Log.e("err", e.getMessage());
    }

    @OnClick(R.id.but_back_loign)
    public void onViewClicked() {
        finish();
    }

    private void initAlert(int id, View v, String title, String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(content);
        builder.setPositiveButton("已读", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mPresenter.getChangeSysMsg(id);
            }
        });
        builder.show();

    }

}
