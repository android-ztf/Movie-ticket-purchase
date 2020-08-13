package com.bw.movie.view.adapter.mine;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.mine.SysMsgAllBean;
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
public class SysMsgAdapter extends RecyclerView.Adapter {

    private Context context;

    public SysMsgAdapter(Context context) {
        this.context = context;
    }

    private List<SysMsgAllBean.ResultBean> list;

    public void setList(List<SysMsgAllBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.sys_msg_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        SysMsgAllBean.ResultBean bean = list.get(position);

        viewHolder.cot.setText(bean.getContent());

        if (bean.getStatus()==1){
            viewHolder.iv.setVisibility(View.GONE);
        }

        viewHolder.title.setText(bean.getTitle());

        Date date = new Date(bean.getPushTime());
        SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm");
        viewHolder.time.setText(df.format(date));



        viewHolder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.onResereve(bean.getId(),viewHolder.iv,bean.getTitle(),bean.getContent());
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
        private TextView cot,time,title;
        private ImageView iv;
        private RelativeLayout rl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cot=itemView.findViewById(R.id.tv_sys_msg);
            title=itemView.findViewById(R.id.xxkk);
            iv=itemView.findViewById(R.id.iv_sta_read);
            time=itemView.findViewById(R.id.tv_sys_msg_time);
            rl=itemView.findViewById(R.id.rl_sys_msg);
        }
    }

    private SysMsgCallBack callBack;

    public void setCallBack(SysMsgCallBack callBack) {
        this.callBack = callBack;
    }

    public interface SysMsgCallBack{
        void onResereve(int id, View v,String title,String content);
    }


}
