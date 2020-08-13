package com.bw.movie.view.adapter.mine;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.bean.mine.UserSeenBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-17
 * INTRODUCE：$
 */
public class UserSeenAdapter extends RecyclerView.Adapter {

    private Context context;

    public UserSeenAdapter(Context context) {
        this.context = context;
    }

    private List<UserSeenBean.ResultBean> list;

    public void setList(List<UserSeenBean.ResultBean> list) {
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
        UserSeenBean.ResultBean bean = list.get(position);

        viewHolder.pic.setImageURI(Uri.parse(bean.getImageUrl()));
        viewHolder.name.setText(bean.getMovieName());

        viewHolder.score.setVisibility(View.GONE);
        viewHolder.zhuyan.setVisibility(View.GONE);

        Date date = new Date(bean.getEndTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        viewHolder.daoyan.setText(format.format(date)+"观影");

        viewHolder.but.setVisibility(View.GONE);

        if (bean.getWhetherComment()==1){
            viewHolder.but_seecomment.setText("评价");
        }else{
            viewHolder.but_seecomment.setText("查看评论");
        }
        viewHolder.but_seecomment.setVisibility(View.VISIBLE);

        viewHolder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.onDetailMovieId(bean.getMovieId(),v);
                }
            }
        });
        viewHolder.but_seecomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.onDetailMovieId(bean.getRecordId(),v);
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
        private RelativeLayout rl;
        private Button but,but_seecomment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic=itemView.findViewById(R.id.sdv_pic_seekmovie );
            score=itemView.findViewById(R.id.tv_seekmovie_score );
            name=itemView.findViewById(R.id.tv_seekmovie_name);
            daoyan=itemView.findViewById(R.id.tv_seekmovie_daoyan);
            zhuyan=itemView.findViewById(R.id.tv_seekmovie_zhuyan);
            rl=itemView.findViewById(R.id.rl_more);
            but=itemView.findViewById(R.id.but_seekmovie_gpiao);
            but_seecomment=itemView.findViewById(R.id.but_seecomment);

        }

    }

    private ISeeMovieCallBack callBack;

    public void setCallBack(ISeeMovieCallBack callBack) {
        this.callBack = callBack;
    }

    public interface ISeeMovieCallBack{
        void onDetailMovieId(int movieId,View v);
    }


}
