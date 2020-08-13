package com.bw.movie.view.adapter.movie_details;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.DetailMovieBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-17
 * INTRODUCE：$
 */
public class MyPersonAdapter extends RecyclerView.Adapter {

    private Context context;

    public MyPersonAdapter(Context context) {
        this.context = context;
    }

    private List<DetailMovieBean.ResultBean.MovieActorBean> list=null;

    public void setList(List<DetailMovieBean.ResultBean.MovieActorBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.person_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;


            DetailMovieBean.ResultBean.MovieActorBean bean = list.get(position);

            viewHolder.pic.setImageURI(Uri.parse(bean.getPhoto()));
            viewHolder.name.setText(bean.getName());
            if (bean.getRole()!=null){
                viewHolder.fakername.setVisibility(View.VISIBLE);
                viewHolder.fakername.setText("饰:\n"+bean.getRole());
            }

    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();
        }else{
            return 0;
        }


    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView pic;
        private TextView name,fakername;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic=itemView.findViewById(R.id.sdv_pic_person );
            name=itemView.findViewById(R.id.tv_name_person);
            fakername=itemView.findViewById(R.id.tv_fakername_person );
        }
    }

}
