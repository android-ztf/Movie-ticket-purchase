package com.bw.movie.view.adapter.mine;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.ReleaseMovieBean;
import com.bw.movie.model.bean.mine.UserFollowMovieBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-17
 * INTRODUCE：$
 */
public class UserFollowMovieAdapter extends RecyclerView.Adapter {

    private Context context;

    public UserFollowMovieAdapter(Context context) {
        this.context = context;
    }

    private List<UserFollowMovieBean.ResultBean> list;

    public void setList(List<UserFollowMovieBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.seek_movie_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        UserFollowMovieBean.ResultBean bean = list.get(position);

        viewHolder.pic.setImageURI(Uri.parse(bean.getImageUrl()));
        viewHolder.name.setText(bean.getName());
        viewHolder.score.setText(bean.getScore()+"分");
        viewHolder.daoyan.setText("导演:"+bean.getDirector());
        viewHolder.zhuyan.setText("主演"+bean.getStarring());


        viewHolder.but.setVisibility(View.GONE);



        viewHolder.rl.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (viewHolder.off.getVisibility()==View.VISIBLE){
                    viewHolder.off.setVisibility(View.GONE);
                }else{
                    viewHolder.off.setVisibility(View.VISIBLE);
                }
                return true;
            }
        });

        viewHolder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.onDetailMovieId(bean.getMovieId(),v);
                }
            }
        });

        viewHolder.off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.onDetailMovieId(bean.getMovieId(),v);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        if (list==null){
            return 0;
        }
        return list.size();

    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        private SimpleDraweeView pic;
        private TextView score,name,daoyan,zhuyan;
        private Button but;
        private ImageView off;
        private RelativeLayout rl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic=itemView.findViewById(R.id.sdv_pic_seekmovie );
            score=itemView.findViewById(R.id.tv_seekmovie_score );
            name=itemView.findViewById(R.id.tv_seekmovie_name);
            daoyan=itemView.findViewById(R.id.tv_seekmovie_daoyan);
            zhuyan=itemView.findViewById(R.id.tv_seekmovie_zhuyan);
            but=itemView.findViewById(R.id.but_seekmovie_gpiao);
            off=itemView.findViewById(R.id.iv_seekmovie_off);
            rl=itemView.findViewById(R.id.rl_more);
        }

    }

    private IMoreReleaseCallBack callBack;

    public void setCallBack(IMoreReleaseCallBack callBack) {
        this.callBack = callBack;
    }

    public interface IMoreReleaseCallBack{
        void onDetailMovieId(int movieId,View view);
    }

}
