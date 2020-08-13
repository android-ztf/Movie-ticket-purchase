package com.bw.movie.view.adapter.movie_details;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.bean.DetailMovieBean;
import com.bw.movie.model.bean.detail_movie.MovieCommentBean;
import com.bw.movie.view.fragment.movie_details.MovieCommentFragmnet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-20
 * INTRODUCE：$
 */
public class MyMovieCommentAdapter extends RecyclerView.Adapter {

    private Context context;

    public MyMovieCommentAdapter(Context context) {
        this.context = context;
    }

    private List<MovieCommentBean.ResultBean> list;

    public void setList(List<MovieCommentBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.moviecomment_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        MovieCommentBean.ResultBean bean = list.get(position);

        //评论人头像
        viewHolder.pic.setImageURI(Uri.parse(bean.getCommentHeadPic()));
        //姓名
        viewHolder.name.setText(bean.getCommentUserName());
        // 星星和评分
        viewHolder.score.setText(bean.getScore()+"分");
        viewHolder.score_star.setRating((float)bean.getScore()/2);

        //时间
        Date date = new Date(bean.getCommentTime());
        SimpleDateFormat format = new SimpleDateFormat("MM-dd  HH:mm");
        viewHolder.date.setText(format.format(date));
        //内容
        viewHolder.content.setText(bean.getCommentContent());
        //点赞和点赞人数
        if (bean.getIsGreat()==1){
            viewHolder.great.setChecked(true);
        }
        viewHolder.great_num.setText(String.valueOf(bean.getGreatNum()));
        //回复人数
        if (bean.getReplyNum()>0){
            viewHolder.comment_num.setText("等"+bean.getReplyNum()+"人进行了回复");
        }else{
            viewHolder.comment_num.setText("暂无回复,成为她的第一人吧!");
        }

        viewHolder.great.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.ClickGreat(bean.getCommentId(),viewHolder.great_num,bean.getGreatNum(),v);
                }
            }
        });

        viewHolder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){

                    String json = new Gson().toJson(bean);
                    callBack.ClickComment(json);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        if (list!=null)
            return list.size();
        return 0;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout rl;
        private SimpleDraweeView pic;
        private TextView name,score,date,content,great_num,comment_num;
        private CheckBox great;
        private RatingBar score_star;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rl=itemView.findViewById(R.id.to_rl);
            pic=itemView.findViewById(R.id.sdv_moviecomment_pic);
            name=itemView.findViewById(R.id.tv_moviecomment_name);
            score=itemView.findViewById(R.id.tv_moviecomment_score);
            date=itemView.findViewById(R.id.tv_moviecomment_time);
            content=itemView.findViewById(R.id.tv_moviecomment_content);
            great_num=itemView.findViewById(R.id.tv_moviecomment_greatnum);
            great=itemView.findViewById(R.id.cb_moviecomment_great);
            score_star=itemView.findViewById(R.id.rb_moviecomment_star);
            comment_num=itemView.findViewById(R.id.tv_moviecomment_num);


        }
    }

    private OnCallBackComment callBack;

    public void setCallBack(OnCallBackComment callBack) {
        this.callBack = callBack;
    }

    public interface OnCallBackComment{
        void ClickGreat(int commentId,View view,int greate_num,View view1);
        void ClickComment(String comment);
    }


}
