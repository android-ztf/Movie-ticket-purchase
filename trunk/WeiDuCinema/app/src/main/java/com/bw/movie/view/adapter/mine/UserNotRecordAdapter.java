package com.bw.movie.view.adapter.mine;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.mine.TicketRecordBean;
import com.bw.movie.model.bean.mine.UserSeenBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-17
 * INTRODUCE：$
 */
public class UserNotRecordAdapter extends RecyclerView.Adapter {

    private Context context;

    public UserNotRecordAdapter(Context context) {
        this.context = context;
    }

    private List<TicketRecordBean.ResultBean> list;

    private int i;

    public void setList(List<TicketRecordBean.ResultBean> list,int a) {
        this.list = list;
        i = a;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.record_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        TicketRecordBean.ResultBean bean = list.get(position);

        viewHolder.pic.setImageURI(Uri.parse(bean.getImageUrl()));
        viewHolder.name.setText(bean.getMovieName());

        viewHolder.order.setText("订单号:\t" + bean.getOrderId());

        Date date = new Date(bean.getCreateTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        viewHolder.time.setText("创建时间:\t" + format.format(date));

        if (i==2){
            viewHolder.detail.setVisibility(View.VISIBLE);
            viewHolder.but.setVisibility(View.GONE);
        }else {
            viewHolder.detail.setVisibility(View.GONE);
            viewHolder.but.setVisibility(View.VISIBLE);
        }

        viewHolder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.onDetailMovieId(bean.getOrderId(),bean.getImageUrl(),v,bean.getPrice());
                }
            }
        });

        viewHolder.but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.onDetailMovieId(bean.getOrderId(),bean.getImageUrl(),v,bean.getPrice());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        if (list==null){
            return 0;
        }
        return list.size();

    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        private SimpleDraweeView pic;
        private TextView order,name,time,detail;
        private RelativeLayout rl;
        private Button but;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic=itemView.findViewById(R.id.sdv_not_record );
            name=itemView.findViewById(R.id.tv_name_notrecord);
            order=itemView.findViewById(R.id.tv_order_notrecord);
            time=itemView.findViewById(R.id.tv_time_notrecord);
            detail=itemView.findViewById(R.id.tv_detail_notrecord);
            rl=itemView.findViewById(R.id.rl_notrecord);
            but=itemView.findViewById(R.id.but_buy_notrecord);

        }

    }

    private INotRecordCallBack callBack;

    public void setCallBack(INotRecordCallBack callBack) {
        this.callBack = callBack;
    }

    public interface INotRecordCallBack{
        void onDetailMovieId(String orderid,String imageUrl,View v,double price);
    }


}
