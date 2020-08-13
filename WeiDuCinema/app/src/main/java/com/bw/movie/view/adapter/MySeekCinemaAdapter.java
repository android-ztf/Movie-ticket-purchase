package com.bw.movie.view.adapter;

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
import com.bw.movie.model.bean.SeekMovieBean;
import com.bw.movie.model.bean.cinema_bean.FindCinemaBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-17
 * INTRODUCE：$
 */
public class MySeekCinemaAdapter extends RecyclerView.Adapter {

    private Context context;

    public MySeekCinemaAdapter(Context context) {
        this.context = context;
    }

    private List<FindCinemaBean.ResultBean> list;

    public void setList(List<FindCinemaBean.ResultBean> list) {
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
        FindCinemaBean.ResultBean bean = list.get(position);

        viewHolder.pic.setImageURI(Uri.parse(bean.getLogo()));
        viewHolder.name.setText(bean.getName());
        viewHolder.score.setVisibility(View.GONE);
        viewHolder.daoyan.setVisibility(View.GONE);
        viewHolder.zhuyan.setText("主演"+bean.getAddress());
        viewHolder.but.setVisibility(View.GONE);

        viewHolder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.onCinema(bean.getId());
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
        private RelativeLayout rl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic=itemView.findViewById(R.id.sdv_pic_seekmovie );
            score=itemView.findViewById(R.id.tv_seekmovie_score );
            name=itemView.findViewById(R.id.tv_seekmovie_name);
            daoyan=itemView.findViewById(R.id.tv_seekmovie_daoyan);
            zhuyan=itemView.findViewById(R.id.tv_seekmovie_zhuyan);
            but=itemView.findViewById(R.id.but_seekmovie_gpiao);
            rl=itemView.findViewById(R.id.rl_more);
        }

    }

    private OnClickCinemaInfo callBack;

    public void setCallBack(OnClickCinemaInfo callBack) {
        this.callBack = callBack;
    }

    public interface OnClickCinemaInfo{
        void onCinema(int id);
    }


}
