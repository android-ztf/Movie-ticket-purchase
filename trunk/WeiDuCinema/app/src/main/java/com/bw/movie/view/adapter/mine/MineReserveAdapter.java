package com.bw.movie.view.adapter.mine;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.ComingMovieBean;
import com.bw.movie.model.bean.mine.UserReserveBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-17
 * INTRODUCE：$
 */
public class MineReserveAdapter extends RecyclerView.Adapter {

    private Context context;

    public MineReserveAdapter(Context context) {
        this.context = context;
    }

    private List<UserReserveBean.ResultBean> list;

    public void setList(List<UserReserveBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.movie_item2, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        UserReserveBean.ResultBean bean = list.get(position);

        viewHolder.pic.setImageURI(Uri.parse(bean.getImageUrl()));
        viewHolder.name.setText(bean.getName());
        viewHolder.num.setText(bean.getWantSeeNum()+"");

        viewHolder.reserve.setVisibility(View.GONE);

        Date date = new Date(bean.getReleaseTime());
        SimpleDateFormat df = new SimpleDateFormat("MM月dd日");
        viewHolder.time.setText(df.format(date)+"上映");



        viewHolder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.onResereve(bean.getMovieId(),v);
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();
        }
        return 0;
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView pic;
        private TextView name,time,num;
        private CheckBox reserve;
        private RelativeLayout rl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic=itemView.findViewById(R.id.sdv_pic_shui);
            name=itemView.findViewById(R.id.tv_movie2_name);
            time=itemView.findViewById(R.id.tv_movie_time);
            num=itemView.findViewById(R.id.tv_movie_num);
            reserve=itemView.findViewById(R.id.cb_reserve);
            rl=itemView.findViewById(R.id.rl_movie_h);
        }
    }

    private ComingCallBack callBack;

    public void setCallBack(ComingCallBack callBack) {
        this.callBack = callBack;
    }

    public interface ComingCallBack{
        void onResereve(int movieId, View v);
    }


}
