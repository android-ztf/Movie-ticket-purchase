package com.bw.movie.view.fragment.movie_details;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.model.bean.DetailMovieBean;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.adapter.movie_details.MyYgpAdapter;
import com.google.gson.Gson;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-17
 * INTRODUCE：$
 */
public class ShortFragmnet extends BaseFragment {
    @BindView(R.id.rv_more)
    RecyclerView rvMore;
    private MyYgpAdapter myYgpAdapter;
    private JCVideoPlayerStandard view1;

    @Override
    public int provideLayoutId() {
        return R.layout.fragment_more;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();

        myYgpAdapter = new MyYgpAdapter(getActivity());

        SharedPreferences data = SharedPreferencesUtils.getInstance().getData();
        String detaiMovie = data.getString("detaiMovie", "");
        DetailMovieBean detailMovieBean1 = new Gson().fromJson(detaiMovie, DetailMovieBean.class);
        DetailMovieBean.ResultBean bean = detailMovieBean1.getResult();


        rvMore.setAdapter(myYgpAdapter);
        rvMore.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        SpacesItemDecoration decoration = new SpacesItemDecoration(10);
        rvMore.addItemDecoration(decoration);
        myYgpAdapter.setList(bean.getShortFilmList());

        myYgpAdapter.setOnPauseVider(new MyYgpAdapter.onPauseVider() {
            @Override
            public void onClickPause(View view) {
                view1 = (JCVideoPlayerStandard) view;

            }
        });

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){
            Log.i("vider_pause","暂停");
            view1.releaseAllVideos();
        }else{

        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            Log.i("vider_pause","暂停");
            view1.releaseAllVideos();
        }else{

        }
    }
}
