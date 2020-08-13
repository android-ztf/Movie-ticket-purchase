package com.bw.movie.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.HotMovieBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-17
 * INTRODUCE：$
 */
public class MyLabelAdapter extends RecyclerView.Adapter {

    private Context context;

    public MyLabelAdapter(Context context) {
        this.context = context;
    }

    private String lable[];

    public void setLable(String[] lable) {
        this.lable = lable;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.lable_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        String s = lable[position];
        viewHolder.lable.setText(s);
    }

    @Override
    public int getItemCount() {
        if (lable==null){
            return 0;
        }
        return lable.length;

    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        private TextView lable;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lable=itemView.findViewById(R.id.tv_cinfo_label );
        }

    }

}
