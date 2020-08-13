package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.SeekContract;
import com.bw.movie.model.bean.SeekMovieBean;
import com.bw.movie.model.bean.cinema_bean.FindCinemaBean;
import com.bw.movie.presenter.SeekPresenter;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.adapter.MySeekCinemaAdapter;
import com.bw.movie.view.adapter.MySeekMovieAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 点击放大镜跳转到搜索页面
 * 搜索电影和影院
 * 点击箭头返回原页面
 */
public class SeekActivity extends BaseActivity<SeekPresenter> implements SeekContract.ISeekView {

    @BindView(R.id.but_back_seek)
    Button butBackSeek;
    @BindView(R.id.seek_rl)
    RelativeLayout seekRl;
    @BindView(R.id.iv_notseek)
    ImageView ivNotseek;
    @BindView(R.id.tv_notseek)
    TextView tvNotseek;
    @BindView(R.id.rl_seek)
    RecyclerView rlSeek;
    @BindView(R.id.tv_seeksum)
    TextView tvSeeksum;
    @BindView(R.id.et_seek)
    EditText etSeek;
    @BindView(R.id.scrollview_seek)
    ScrollView scrollviewSeek;

    private int isM;

    private MySeekMovieAdapter mySeekMovieAdapter;
    private MySeekCinemaAdapter mySeekCinemaAdapter;
    private int size;
    private List<SeekMovieBean.ResultBean> mResult;
    private List<FindCinemaBean.ResultBean> mResultCinema;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_seek;
    }

    @Override
    protected SeekPresenter setPresenter() {
        return new SeekPresenter();
    }

    @Override
    protected void initView() {
        super.initView();

        mySeekMovieAdapter = new MySeekMovieAdapter(this);
        mySeekCinemaAdapter = new MySeekCinemaAdapter(this);

        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(10);
        rlSeek.addItemDecoration(spacesItemDecoration);

        Intent intent = getIntent();
        isM = intent.getIntExtra("isM", 0);
    }

    @Override
    protected void initData() {
        super.initData();

        ivNotseek.setVisibility(View.INVISIBLE);
        tvNotseek.setVisibility(View.INVISIBLE);
        scrollviewSeek.setVisibility(View.INVISIBLE);
        tvSeeksum.setVisibility(View.GONE);


        if (!hasNetWork()) {
            showNoNetTip();
        } else {
        }

        if (isM == 1) {
            mPresenter.getMoviewSeek("", 1, 100);
            rlSeek.setAdapter(mySeekMovieAdapter);
            rlSeek.setLayoutManager(new LinearLayoutManager(SeekActivity.this, RecyclerView.VERTICAL, false));

        } else {
            mPresenter.getSeekCinema("",1,100);
            rlSeek.setAdapter(mySeekCinemaAdapter);
            rlSeek.setLayoutManager(new LinearLayoutManager(SeekActivity.this, RecyclerView.VERTICAL, false));

            mySeekCinemaAdapter.setCallBack(new MySeekCinemaAdapter.OnClickCinemaInfo() {
                @Override
                public void onCinema(int id) {
                    Intent intent = new Intent(SeekActivity.this, CinemaInfoActivity.class);
                    intent.putExtra("cinemaId",id);
                    startActivity(intent);
                }
            });
        }

        etSeek.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (isM == 1 && !s.toString().equals("")) {

                    mPresenter.getMoviewSeek(s.toString(), 1, 100);

                } else if (isM == 2) {

                    mPresenter.getSeekCinema(s.toString(),1,100);

                } else if (s.toString().equals("")) {
                    ivNotseek.setVisibility(View.INVISIBLE);
                    tvNotseek.setVisibility(View.INVISIBLE);
                    scrollviewSeek.setVisibility(View.INVISIBLE);
                    tvSeeksum.setVisibility(View.GONE);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    public void onMoviewSuccess(SeekMovieBean seekMovieBean) {
        Log.i("seekmovie_err",seekMovieBean.getMessage());

        //当未查到相关电影时展示控件
        if (seekMovieBean.getMessage().equals("未查到相关电影")) {
            ivNotseek.setVisibility(View.VISIBLE);
            tvNotseek.setVisibility(View.VISIBLE);
            scrollviewSeek.setVisibility(View.INVISIBLE);
            tvSeeksum.setVisibility(View.GONE);
        } else {
            ivNotseek.setVisibility(View.INVISIBLE);
            tvNotseek.setVisibility(View.INVISIBLE);


            List<SeekMovieBean.ResultBean> result = seekMovieBean.getResult();

            if (etSeek.getText().toString().equals("")) {
                mResult = result;
                size = result.size();
                tvSeeksum.setText("查看全部的" + size + "部影片");
            } else {
                scrollviewSeek.setVisibility(View.VISIBLE);
                tvSeeksum.setVisibility(View.VISIBLE);
            }
            mySeekMovieAdapter.setList(result);
        }
    }

    @Override
    public void onFindCinemaSuccess(FindCinemaBean findCinemaBean) {
        Log.i("seekcinema_success",findCinemaBean.getMessage());

        List<FindCinemaBean.ResultBean> result = findCinemaBean.getResult();
        Log.i("seekcinema_success",result.size()+"");
        if (result.size()==0){
            Log.i("seekcinema_success",result.size()+"");
            ivNotseek.setVisibility(View.VISIBLE);
            tvNotseek.setVisibility(View.VISIBLE);
            scrollviewSeek.setVisibility(View.INVISIBLE);
            tvSeeksum.setVisibility(View.GONE);
        }else{
            ivNotseek.setVisibility(View.INVISIBLE);
            tvNotseek.setVisibility(View.INVISIBLE);

            if (etSeek.getText().toString().equals("")) {
                mResultCinema = result;
                size = result.size();
                tvSeeksum.setText("查看全部的" + size + "个影院");
            } else {
                scrollviewSeek.setVisibility(View.VISIBLE);
                tvSeeksum.setVisibility(View.VISIBLE);
            }

            mySeekCinemaAdapter.setList(result);
        }



    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("seek_err",e.getMessage());
    }


    @OnClick({R.id.but_back_seek, R.id.tv_seeksum})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_back_seek:
                finish();
                break;
            case R.id.tv_seeksum:
                //隐藏控件
                tvSeeksum.setVisibility(View.GONE);
                etSeek.setText(null);
                scrollviewSeek.setVisibility(View.VISIBLE);
                mySeekMovieAdapter.setList(mResult);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
