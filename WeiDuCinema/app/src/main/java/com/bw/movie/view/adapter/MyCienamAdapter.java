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
import com.bw.movie.model.bean.cinema_bean.NearbyCinemasBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-2
 * INTRODUCE：$
 */
public class MyCienamAdapter extends RecyclerView.Adapter {

    private Context context;

    public MyCienamAdapter(Context context) {
        this.context = context;
    }

    private List<NearbyCinemasBean.ResultBean> list;

    public void setList(List<NearbyCinemasBean.ResultBean> list) {
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
        NearbyCinemasBean.ResultBean bean = list.get(position);

        viewHolder.pic.setImageURI(Uri.parse(bean.getLogo()));
        viewHolder.name.setText(bean.getName());
        viewHolder.add.setText(bean.getAddress());

        if (bean.getDistance()!=0){
            viewHolder.juli.setText((bean.getDistance()/1000.0)+"公里");

        }else{
            viewHolder.juli.setVisibility(View.GONE);
        }

        viewHolder.rl_cinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.getCinemaId(bean.getId());
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic=itemView.findViewById(R.id.sdv_cinema_pic);
            name=itemView.findViewById(R.id.tv_cinema_name);
            add=itemView.findViewById(R.id.tv_cinema_add);
            juli=itemView.findViewById(R.id.tv_cinema_juli);
            rl_cinema=itemView.findViewById(R.id.rl_cinema);
        }
    }

    private OnCinemaCallBack callBack;

    public void setCallBack(OnCinemaCallBack callBack) {
        this.callBack = callBack;
    }

    public interface OnCinemaCallBack{
        void  getCinemaId(int cinemaId);
    }


}
