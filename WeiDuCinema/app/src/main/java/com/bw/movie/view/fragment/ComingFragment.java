package com.bw.movie.view.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.bean.ComingMovieBean;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.presenter.MorePresenter;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.activity.DetailMovieActivity;
import com.bw.movie.view.adapter.MyComingAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-22
 * INTRODUCE：$
 */
public class ComingFragment extends BaseFragment<MorePresenter> implements HomeContract.IMoreView {

    @BindView(R.id.rv_more)
    RecyclerView rvMore;
    private MyComingAdapter myComingAdapter;

    @Override
    public int provideLayoutId() {
        return R.layout.fragment_more;
    }

    @Override
    protected MorePresenter setPresenter() {
        return new MorePresenter();
    }

    @Override
    protected void inintView() {
        super.inintView();
        myComingAdapter = new MyComingAdapter(getActivity());
    }

    @Override
    protected void initData() {
        super.initData();

        rvMore.setAdapter(myComingAdapter);
        rvMore.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        //设置item间距
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(10);
        rvMore.addItemDecoration(spacesItemDecoration);


        if (!hasNetWrok()){
            showNoNetTip();
        }else{
            mPresenter.getComing(1,100);

            //点击预约
            myComingAdapter.setCallBack(new MyComingAdapter.ComingCallBack() {
                @Override
                public void onResereve(int movieId, View v) {
                    if (v instanceof CheckBox) {
                        CheckBox box = (CheckBox) v;
                        box.setText("已预约");
                        box.setChecked(true);
                        mPresenter.postReserve(movieId);
                    }else{
                        if (movieId!=0) {
                            Intent intent = new Intent(getActivity(), DetailMovieActivity.class);
                            intent.putExtra("movieId",movieId);
                            startActivity(intent);
                        }
                    }
                }
            });


        }
    }

    @Override
    public void onComingSuccess(ComingMovieBean comingMovieBean) {
        Log.i("coming_more", comingMovieBean.getMessage());
        List<ComingMovieBean.ResultBean> result = comingMovieBean.getResult();
        myComingAdapter.setList(result);
    }

    @Override
    public void onReserveSuccess(LoginBean loginBean) {
        Log.i("release_log", loginBean.getMessage());
        Toast.makeText(getActivity(),loginBean.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err_more", e.getMessage());
    }
}
