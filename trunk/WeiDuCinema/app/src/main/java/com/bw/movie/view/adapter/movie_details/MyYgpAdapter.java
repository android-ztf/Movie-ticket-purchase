package com.bw.movie.view.adapter.movie_details;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.bean.DetailMovieBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-20
 * INTRODUCE：$
 */
public class MyYgpAdapter extends RecyclerView.Adapter {

    private Context context;

    public MyYgpAdapter(Context context) {
        this.context = context;
    }

    private List<DetailMovieBean.ResultBean.ShortFilmListBean> list;

    public void setList(List<DetailMovieBean.ResultBean.ShortFilmListBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.ygp_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        DetailMovieBean.ResultBean.ShortFilmListBean bean = list.get(position);

        viewHolder.ygp.setUp(bean.getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL, "");
      //  if (b){
            Glide.with(context)
                    .load(bean.getImageUrl())
                    .error(R.mipmap.failure)
                    .placeholder(R.mipmap.cshi)
                    .into(viewHolder.ygp.thumbImageView);
       // }

        onPauseVider.onClickPause(viewHolder.ygp);



    }

    @Override
    public int getItemCount() {
        if (list!=null)
            return list.size();
        return 0;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private JCVideoPlayerStandard ygp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ygp=itemView.findViewById(R.id.jcvps_ygp);

        }
    }

    private onPauseVider onPauseVider;

    public void setOnPauseVider(MyYgpAdapter.onPauseVider onPauseVider) {
        this.onPauseVider = onPauseVider;
    }

    public interface onPauseVider{
        void onClickPause(View view);
    }

}
