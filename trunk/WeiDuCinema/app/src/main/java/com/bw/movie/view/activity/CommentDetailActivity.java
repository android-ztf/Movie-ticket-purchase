package com.bw.movie.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.detail_movie.MovieCommentBean;
import com.bw.movie.model.bean.detail_movie.ReplyCommentBean;
import com.bw.movie.presenter.DetailPresenter;
import com.bw.movie.utils.SpacesItemDecoration;
import com.bw.movie.view.adapter.movie_details.MyReplyAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommentDetailActivity extends BaseActivity<DetailPresenter> implements HomeContract.IDetailView {

    @BindView(R.id.but_back_commentdetail)
    Button butBackCommentdetail;
    @BindView(R.id.sdv_commentdetail_pic)
    SimpleDraweeView sdvCommentdetailPic;
    @BindView(R.id.tv_commentdetail_name)
    TextView tvCommentdetailName;
    @BindView(R.id.rb_commentdetail_star)
    RatingBar rbCommentdetailStar;
    @BindView(R.id.tv_commentdetail_score)
    TextView tvCommentdetailScore;
    @BindView(R.id.tv_commentdetail_time)
    TextView tvCommentdetailTime;
    @BindView(R.id.tv_commentdetail_content)
    TextView tvCommentdetailContent;
    @BindView(R.id.tv_commentdetail_num)
    TextView tvCommentdetailNum;
    @BindView(R.id.rv_reply_commentdetail)
    RecyclerView rvReplyCommentdetail;
    @BindView(R.id.et_commentdetail_reply)
    EditText etCommentdetailReply;
    @BindView(R.id.but_commentdetai_commit)
    Button butCommentdetaiCommit;
    private String comment;

    private MyReplyAdapter myReplyAdapter;
    private int commentId;
    private int movieId;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_comment_detai;
    }

    @Override
    protected DetailPresenter setPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected void initView() {
        super.initView();

        Intent intent = getIntent();
        comment = intent.getStringExtra("comment");
        movieId = intent.getIntExtra("movieId", 0);
        Log.i("json", comment);

        myReplyAdapter = new MyReplyAdapter(this);

    }

    @Override
    protected void initData() {
        super.initData();

        if (comment!=null){
            MovieCommentBean.ResultBean json = new Gson().fromJson(comment, MovieCommentBean.ResultBean.class);
            sdvCommentdetailPic.setImageURI(Uri.parse(json.getCommentHeadPic()));
            tvCommentdetailName.setText(json.getCommentUserName());
            tvCommentdetailContent.setText(json.getCommentContent());
            tvCommentdetailScore.setText(json.getScore()+"分");
            tvCommentdetailNum.setText(json.getReplyNum()+"条回复");
            Date date = new Date(json.getCommentTime());
            SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
            tvCommentdetailTime.setText(format.format(date));
            rbCommentdetailStar.setRating((float)json.getScore()/2);
            commentId = json.getCommentId();
            if (!hasNetWork()){
                showNoNetTip();
            }else{
                if (commentId!=0){
                    rvReplyCommentdetail.setAdapter(myReplyAdapter);
                    rvReplyCommentdetail.setLayoutManager(new LinearLayoutManager(CommentDetailActivity.this,RecyclerView.VERTICAL,false));
                    rvReplyCommentdetail.addItemDecoration(new SpacesItemDecoration(10));

                    mPresenter.getCommentReplyAll(commentId,1,100);
                }
            }
        }

    }
    //查询所有评论回复
    @Override
    public void onCommentReplyAll(ReplyCommentBean replyCommentBean) {

        Log.i("replyall_suc",replyCommentBean.getMessage());

        List<ReplyCommentBean.ResultBean> result = replyCommentBean.getResult();

        if (result!=null){
            Log.i("replyall_suc",result.size()+"");

            myReplyAdapter.setList(result);
        }

    }

    //评论回复
    @Override
    public void onReplyComment(LoginBean loginBean) {
        Log.i("repl_suc",loginBean.getMessage());
        Toast.makeText(CommentDetailActivity.this,loginBean.getMessage(),Toast.LENGTH_SHORT).show();
        if (loginBean.getStatus().equals("0000")){
            mPresenter.getCommentReplyAll(commentId,1,100);
        }
    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err",e.getMessage());
    }


    @OnClick({R.id.but_back_commentdetail, R.id.but_commentdetai_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_back_commentdetail:
                if (movieId!=0){
                    Intent intent = new Intent(CommentDetailActivity.this, DetailMovieActivity.class);
                    intent.putExtra("movieId",movieId);
                    startActivity(intent);
                }else{
                    Toast.makeText(CommentDetailActivity.this,"出现未知异常,返回主页",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(CommentDetailActivity.this,HomeActivity.class));
                }

                break;
            case R.id.but_commentdetai_commit:
                if (commentId!=0){
                    if (etCommentdetailReply.getText().toString()!=null && !etCommentdetailReply.getText().toString().equals("")){
                        mPresenter.postReplyComment(commentId,etCommentdetailReply.getText().toString());
                    }
                }
                break;
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {//如果返回键按下
            //此处写退向后台的处理
            if (movieId!=0){
                Intent intent = new Intent(CommentDetailActivity.this, DetailMovieActivity.class);
                intent.putExtra("movieId",movieId);
                startActivity(intent);
            }else{
                Toast.makeText(CommentDetailActivity.this,"出现未知异常,返回主页",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CommentDetailActivity.this,HomeActivity.class));
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
