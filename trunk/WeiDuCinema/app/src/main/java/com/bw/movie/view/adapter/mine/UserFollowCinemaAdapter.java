package com.bw.movie.view.adapter.mine;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.cinema_bean.NearbyCinemasBean;
import com.bw.movie.model.bean.mine.UserFollowCinemaBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-2
 * INTRODUCE：$
 */
public class UserFollowCinemaAdapter extends RecyclerView.Adapter {

    private Context context;

    public UserFollowCinemaAdapter(Context context) {
        this.context = context;
    }

    private List<UserFollowCinemaBean.ResultBean> list;

    public void setList(List<UserFollowCinemaBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.cinema_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        UserFollowCinemaBean.ResultBean bean = list.get(position);

        viewHolder.pic.setImageURI(Uri.parse(bean.getLogo()));
        viewHolder.name.setText(bean.getName());
        viewHolder.add.setText(bean.getAddress());

        viewHolder.juli.setVisibility(View.GONE);

        viewHolder.off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.getCinemaId(bean.getCinemaId(),v);
                }
            }
        });

        viewHolder.rl_cinema.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (viewHolder.off.getVisibility() == View.GONE){
                    viewHolder.off.setVisibility(View.VISIBLE);
                }else{
                    viewHolder.off.setVisibility(View.GONE);
                }

                return true;
            }
        });

        viewHolder.rl_cinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.getCinemaId(bean.getCinemaId(),v);
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
        private TextView name,add,juli;
        private RelativeLayout rl_cinema;
        private ImageView off;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic=itemView.findViewById(R.id.sdv_cinema_pic);
            name=itemView.findViewById(R.id.tv_cinema_name);
            add=itemView.findViewById(R.id.tv_cinema_add);
            juli=itemView.findViewById(R.id.tv_cinema_juli);
            rl_cinema=itemView.findViewById(R.id.rl_cinema);
            off=itemView.findViewById(R.id.iv_seekcinema_off);
        }
    }

    private OnCinemaCallBack callBack;

    public void setCallBack(OnCinemaCallBack callBack) {
        this.callBack = callBack;
    }

    public interface OnCinemaCallBack{
        void  getCinemaId(int cinemaId,View view);
    }


}
