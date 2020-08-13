package com.bw.movie.view.adapter.mine;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.application.App;
import com.bw.movie.model.bean.mine.MyMovieTicketBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-17
 * INTRODUCE：$
 */
public class MyMovieTicketAdapter extends RecyclerView.Adapter {

    private Context context;

    public MyMovieTicketAdapter(Context context) {
        this.context = context;
    }

    private List<MyMovieTicketBean.ResultBean> list;

    public void setList(List<MyMovieTicketBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.mine_ticket_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        MyMovieTicketBean.ResultBean bean = list.get(position);

        viewHolder.name.setText(bean.getMovieName());

        viewHolder.cinema_name.setText(bean.getCinemaName());

        viewHolder.hall.setText(bean.getScreeningHall());

        Date date = new Date(bean.getCreateTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        viewHolder.date.setText(df.format(date)+"上映");

//        //获取字体
//        Typeface typeFace = Typeface.createFromAsset(App.getInstance().getAssets(), "fonts/tpo.ttf");
//        //设置字体
//        viewHolder.time.setTypeface(typeFace);
        String be = bean.getBeginTime().substring(0, bean.getBeginTime().length() - 3);
        String en = bean.getEndTime().substring(0, bean.getEndTime().length() - 3);
        viewHolder.time.setText(be+"～"+en);

        String replace = bean.getSeat().replace(",", "\n");
        String s = replace.replace("-", "排");
        viewHolder.seat.setText(s);

        viewHolder.but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.onResereve(bean.getId());
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

        private TextView name,time,date,hall,seat,cinema_name;
        private RelativeLayout rl;
        private Button but;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.tv_name_mine_ticket);
            cinema_name=itemView.findViewById(R.id.tv_cinema_name_mine_ticket);
            time=itemView.findViewById(R.id.tv_time_mine_ticket);
            date=itemView.findViewById(R.id.tv_date_mine_ticket);
            hall=itemView.findViewById(R.id.tv_hall_mine_ticket);
            seat=itemView.findViewById(R.id.tv_seat_mine_ticket);
            rl=itemView.findViewById(R.id.rl_my_ticket);
            but=itemView.findViewById(R.id.but_see_erwm_mine_ticket);
        }
    }

    private MyMovieCallBack callBack;

    public void setCallBack(MyMovieCallBack callBack) {
        this.callBack = callBack;
    }

    public interface MyMovieCallBack{
        void onResereve(int recordId);
    }


}
