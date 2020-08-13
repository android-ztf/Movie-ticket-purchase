package com.bw.movie.view.adapter.buy_movie;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.pay_movie.MovieScheduleBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-17
 * INTRODUCE：$
 */
public class MyMovieScheduleAdapter extends RecyclerView.Adapter {

    private Context context;

    public MyMovieScheduleAdapter(Context context) {
        this.context = context;
    }

    private List<MovieScheduleBean.ResultBean> list;

    public void setList(List<MovieScheduleBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.movieschedlue_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;

        MovieScheduleBean.ResultBean bean = list.get(position);
        //影厅名称
        viewHolder.name.setText(bean.getScreeningHall());
        viewHolder.begintime.setText(bean.getBeginTime().substring(0,5));
        viewHolder.endtime.setText(bean.getEndTime().substring(0,5));
        viewHolder.price.setText("¥"+bean.getFare());
        viewHolder.cb.setChecked(bean.isChecked());

        viewHolder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (callBack!=null){
                    callBack.onClick(bean.getHallId(),bean.getFare(),bean.getId());
                }
                slect(bean.getId(),position,true);
            }
        });


    }

    private void slect(int id,int p,boolean bb){

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setChecked(false);
        }
        if (list.get(p).getId()==id){
            list.get(p).setChecked(bb);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();
        }
        return 0;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox cb;
        private TextView name,begintime,endtime,price;
        private RelativeLayout rl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cb=itemView.findViewById(R.id.cb_selecehall);
            name=itemView.findViewById(R.id.tv_hallname);
            begintime=itemView.findViewById(R.id.tv_begintime);
            endtime=itemView.findViewById(R.id.tv_endtime);
            price=itemView.findViewById(R.id.tv_hallprice);
            rl=itemView.findViewById(R.id.rl_movieschedlue);
        }
    }

    private OnClickMovieSchedlue callBack;

    public void setCallBack(OnClickMovieSchedlue callBack) {
        this.callBack = callBack;
    }

    public interface OnClickMovieSchedlue{
        void onClick(int hallId,double money,int id);
    }

}
