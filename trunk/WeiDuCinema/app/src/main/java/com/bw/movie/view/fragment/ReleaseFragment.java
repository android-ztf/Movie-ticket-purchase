package com.bw.movie.view.fragment;

import android.content.Intent;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.bean.ReleaseMovieBean;
import com.bw.movie.presenter.HomePresenter;
import com.bw.movie.presenter.MorePresenter;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.activity.DetailMovieActivity;
import com.bw.movie.view.adapter.MoreReleaseAdapter;
import com.bw.movie.view.adapter.MyReleaseAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-22
 * INTRODUCE：$
 */
public class ReleaseFragment extends BaseFragment<MorePresenter> implements HomeContract.IMoreView {

    @BindView(R.id.rv_more)
    RecyclerView rvMore;
    private MoreReleaseAdapter moreReleaseAdapter;

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
        moreReleaseAdapter = new MoreReleaseAdapter(getActivity());

    }

    @Override
    protected void initData() {
        super.initData();
        rvMore.setAdapter(moreReleaseAdapter);
        rvMore.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        //设置item间距
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(10);
        rvMore.addItemDecoration(spacesItemDecoration);


        if (!hasNetWrok()){
            showNoNetTip();
        }else{
            mPresenter.getRelease(1,100);
        }

        moreReleaseAdapter.setCallBack(new MoreReleaseAdapter.IMoreReleaseCallBack() {
            @Override
            public void onDetailMovieId(int movieId) {
                if (movieId!=0) {
                    Intent intent = new Intent(getActivity(), DetailMovieActivity.class);
                    intent.putExtra("movieId",movieId);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onReleaseSuccess(ReleaseMovieBean releaseMovieBean) {
        Log.i("release_more", releaseMovieBean.getMessage());
        List<ReleaseMovieBean.ResultBean> result = releaseMovieBean.getResult();
        moreReleaseAdapter.setList(result);
    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err_more", e.getMessage());

    }
}
