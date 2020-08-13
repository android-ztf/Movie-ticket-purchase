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
public class MyPersondaoAdapter extends RecyclerView.Adapter {

    private Context context;

    public MyPersondaoAdapter(Context context) {
        this.context = context;
    }

    private List<DetailMovieBean.ResultBean.MovieDirectorBean> list1=null;

    public void setList1(List<DetailMovieBean.ResultBean.MovieDirectorBean> list) {
        this.list1 = list;
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

            DetailMovieBean.ResultBean.MovieDirectorBean bean = list1.get(position);

            viewHolder.pic.setImageURI(Uri.parse(bean.getPhoto()));
            viewHolder.name.setText(bean.getName());





    }

    @Override
    public int getItemCount() {
        if (list1!=null){

            return list1.size();

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
