package com.bw.movie.view.adapter.mine;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.mine.UserCommentMovie;
import com.bw.movie.model.bean.mine.UserFollowCinemaBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-2
 * INTRODUCE：$
 */
public class UserMovieCommentAdapter extends RecyclerView.Adapter {

    private Context context;

    public UserMovieCommentAdapter(Context context) {
        this.context = context;
    }

    private List<UserCommentMovie.ResultBean> list;

    public void setList(List<UserCommentMovie.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.mine_movie_comment_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        UserCommentMovie.ResultBean bean = list.get(position);

        viewHolder.pic.setImageURI(Uri.parse(bean.getImageUrl()));

        viewHolder.name.setText(bean.getMovieName());

        viewHolder.dao.setText("导演:"+bean.getDirector());

        viewHolder.zhu.setText("主演:"+bean.getStarring());

        viewHolder.score.setText("评分:"+bean.getMovieScore()+"分");

        viewHolder.conte.setText(bean.getMyCommentContent());

        viewHolder.star.setRating(bean.getMyCommentScore()/2.0f);

        viewHolder.mine_score.setText(bean.getMyCommentScore()+"分");

        Date date = new Date(bean.getCommentTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        viewHolder.time.setText(format.format(date));



        viewHolder.rl_cinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.getCinemaId(bean.getMovieId(),v);
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

    private class ViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView pic;
        private TextView name,dao,zhu,score,conte,mine_score,time;
        private RelativeLayout rl_cinema;
        private RatingBar star;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic=itemView.findViewById(R.id.sdv_pic_minemovie);
            name=itemView.findViewById(R.id.tv_minemovie_name);
            dao=itemView.findViewById(R.id.tv_minemovie_daoyan);
            zhu=itemView.findViewById(R.id.tv_minemovie_zhuyan);
            score=itemView.findViewById(R.id.tv_minemovie_score);
            conte=itemView.findViewById(R.id.tv_mine_moviecomment_context);
            star=itemView.findViewById(R.id.rb_mine_movie_comment_starnum);
            mine_score=itemView.findViewById(R.id.tv_mine_moviecomment_score);
            time=itemView.findViewById(R.id.tv_mine_moviecomment_time);
            rl_cinema=itemView.findViewById(R.id.rl_more);
        }
    }

    private OnCinemaCallBack callBack;

    public void setCallBack(OnCinemaCallBack callBack) {
        this.callBack = callBack;
    }

    public interface OnCinemaCallBack{
        void  getCinemaId(int cinemaId, View view);
    }


}
