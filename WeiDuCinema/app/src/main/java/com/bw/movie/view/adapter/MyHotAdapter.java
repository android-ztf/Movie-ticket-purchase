package com.bw.movie.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.bean.ReleaseMovieBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-17
 * INTRODUCE：$
 */
public class MyHotAdapter extends RecyclerView.Adapter {

    private Context context;

    public MyHotAdapter(Context context) {
        this.context = context;
    }

    private List<HotMovieBean.ResultBean> list;

    public void setList(List<HotMovieBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(context, R.layout.movie_item, null);
            return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HotMovieBean.ResultBean bean = list.get(position+1);
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.pic.setImageURI(Uri.parse(bean.getImageUrl()));
            viewHolder.name.setText(bean.getName());
            viewHolder.score.setText(bean.getScore()+"分");

        viewHolder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.onDetailMovieId(bean.getMovieId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list==null){
            return 0;
        }
        return list.size()-1;

    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        private SimpleDraweeView pic;
        private TextView score,name;
        private RelativeLayout rl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic=itemView.findViewById(R.id.sdv_pic_chui );
            score=itemView.findViewById(R.id.tv_movie_score );
            name=itemView.findViewById(R.id.tv_movie_name);
            rl=itemView.findViewById(R.id.rl_movie_v);
        }
    }

    private MyReleaseAdapter.IReleaseCallBack callBack;

    public void setCallBack(MyReleaseAdapter.IReleaseCallBack callBack) {
        this.callBack = callBack;
    }
}
