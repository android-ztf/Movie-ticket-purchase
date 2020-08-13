package com.bw.movie.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.bean.DetailMovieBean;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.presenter.DetailPresenter;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WriteCommentActivity extends BaseActivity<DetailPresenter> implements HomeContract.IDetailView {

    @BindView(R.id.but_back_write)
    Button butBackWrite;
    @BindView(R.id.tv_name_write)
    TextView tvNameWrite;
    @BindView(R.id.tv_score_write)
    TextView tvScoreWrite;
    @BindView(R.id.rb_scorestar_write)
    RatingBar rbScorestarWrite;
    @BindView(R.id.et_comment_write)
    EditText etCommentWrite;
    @BindView(R.id.but_commit_write)
    Button butCommitWrite;
    private DetailMovieBean detailMovieBean;
    private float score;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_write_comment;
    }

    @Override
    protected DetailPresenter setPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();

        SharedPreferences data = SharedPreferencesUtils.getInstance().getData();
        String detaiMovie = data.getString("detaiMovie", "");
        detailMovieBean = new Gson().fromJson(detaiMovie, DetailMovieBean.class);
        if (detailMovieBean!=null){
            DetailMovieBean.ResultBean result = detailMovieBean.getResult();
            tvNameWrite.setText(result.getName());
        }

        rbScorestarWrite.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    score = rating*2;
                    tvScoreWrite.setText("我的评分 ("+score+")");
            }
        });

    }

    @Override
    public void onWriteMovieComment(LoginBean loginBean) {
        Log.i("write_suc",loginBean.getMessage());
        Toast.makeText(WriteCommentActivity.this,loginBean.getMessage(),Toast.LENGTH_SHORT).show();
        if (loginBean.getStatus().equals("0000")){
            initDelog(loginBean.getMessage());
        }

    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err",e.getMessage());
    }



    @OnClick({R.id.but_back_write, R.id.but_commit_write})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_back_write:
                finish();
                break;
            case R.id.but_commit_write:
                //先判断是否为空,在判断是否有网
                if (detailMovieBean!=null){
                    if (!hasNetWork()) {
                        showNoNetTip();
                    } else {
                        if (etCommentWrite.getText().toString()!=null && !etCommentWrite.getText().toString().equals("") && score!=0.0f){
                            Log.i("write",detailMovieBean.getResult().getMovieId()+etCommentWrite.getText().toString()+score);
                            mPresenter.postWriteMovieComment(detailMovieBean.getResult().getMovieId(),etCommentWrite.getText().toString(),score);
                        }
                    }
                }else{
                    Toast.makeText(this,"评论提交错误",Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    private void initDelog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(WriteCommentActivity.this);
        builder.setTitle(message);
        builder.setMessage("感谢您的评论,请选择以下操作");

        builder.setPositiveButton("查看当前评论", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent();
                setResult(101,intent);
                finish();
            }
        });

        builder.setNegativeButton("返回上一层", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNeutralButton("再写一条评论", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                refresh();
            }
        });

        builder.show();
    }

    public void refresh() {
        startActivity(getIntent());
    }
}
