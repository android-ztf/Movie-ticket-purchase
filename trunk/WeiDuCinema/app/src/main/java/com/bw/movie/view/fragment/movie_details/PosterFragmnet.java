package com.bw.movie.view.fragment.movie_details;

import android.content.SharedPreferences;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.model.bean.DetailMovieBean;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.adapter.movie_details.MyPosterAdapter;
import com.google.gson.Gson;

import butterknife.BindView;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-17
 * INTRODUCE：$
 */
public class PosterFragmnet extends BaseFragment {
    @BindView(R.id.rv_more)
    RecyclerView rvMore;
    private MyPosterAdapter myPosterAdapter;

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
        myPosterAdapter = new MyPosterAdapter(getActivity());

        SharedPreferences data = SharedPreferencesUtils.getInstance().getData();
        String detaiMovie = data.getString("detaiMovie", "");
        DetailMovieBean detailMovieBean1 = new Gson().fromJson(detaiMovie, DetailMovieBean.class);
        DetailMovieBean.ResultBean bean = detailMovieBean1.getResult();

        rvMore.setAdapter(myPosterAdapter);
        rvMore.setLayoutManager(new GridLayoutManager(getActivity(),3));
        rvMore.addItemDecoration(new SpacesItemDecoration(10));

        myPosterAdapter.setList(bean.getPosterList());
    }
}
