package com.bw.movie.view.adapter.mine;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.mine.UserCommentCinema;
import com.bw.movie.model.bean.mine.UserCommentMovie;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-2
 * INTRODUCE：$
 */
public class UserCinemaCommentAdapter extends RecyclerView.Adapter {

    private Context context;

    public UserCinemaCommentAdapter(Context context) {
        this.context = context;
    }

    private List<UserCommentCinema.ResultBean> list;

    public void setList(List<UserCommentCinema.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.mine_cinema_comment_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        UserCommentCinema.ResultBean bean = list.get(position);

        viewHolder.pic.setImageURI(Uri.parse(bean.getLogo()));

        viewHolder.name.setText(bean.getCinemaName());

        viewHolder.add.setText(bean.getAddress());

        viewHolder.juli.setText(bean.getDistance()/1000.0f+"km");


        viewHolder.conte.setText(bean.getMyCommentContent());



        Date date = new Date(bean.getCommentTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        viewHolder.time.setText(format.format(date));



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
        private TextView name,add,juli,conte,time;
        private RelativeLayout rl_cinema;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic=itemView.findViewById(R.id.sdv_mine_cinemacomment_pic);

            name=itemView.findViewById(R.id.tv_mine_cinemacomment_name);

            add=itemView.findViewById(R.id.tv_mine_cinemacomment_add);

            juli=itemView.findViewById(R.id.tv_mine_cinemacomment_juli);

            conte=itemView.findViewById(R.id.tv_mine_cinemacomment_context);

            time=itemView.findViewById(R.id.tv_mine_cinemacomment_time);

            rl_cinema=itemView.findViewById(R.id.rl_cinema_comment);
        }
    }

    private OnCinemaCallBack callBack;

    public void setCallBack(OnCinemaCallBack callBack) {
        this.callBack = callBack;
    }

    public interface OnCinemaCallBack{
        void  getCinemaId(int cinemaId, View view);
    }


}
