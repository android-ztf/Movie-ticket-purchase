package com.bw.movie.view.adapter.movie_details;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.bean.DetailMovieBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-20
 * INTRODUCE：$
 */
public class MyPosterAdapter extends RecyclerView.Adapter {

    private Context context;

    public MyPosterAdapter(Context context) {
        this.context = context;
    }

    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.poster_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        String s = list.get(position);

        viewHolder.poster.setImageURI(Uri.parse(s));

    }

    @Override
    public int getItemCount() {
        if (list!=null)
            return list.size();
        return 0;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView poster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poster=itemView.findViewById(R.id.sdv_poster);

        }
    }

}
