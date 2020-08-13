package com.bw.movie.view.adapter.movie_details;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.cinema_bean.CinemaCommentBean;
import com.bw.movie.model.bean.detail_movie.ReplyCommentBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-5
 * INTRODUCE：$
 */
public class MyReplyAdapter extends RecyclerView.Adapter {

    private Context context;

    public MyReplyAdapter(Context context) {
        this.context = context;
    }

    private List<ReplyCommentBean.ResultBean> list;

    public void setList(List<ReplyCommentBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.comment_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;

        ReplyCommentBean.ResultBean bean = list.get(position);

        viewHolder.comment_pic.setImageURI(Uri.parse(bean.getReplyHeadPic()));
        viewHolder.comment_name.setText(bean.getReplyUserName());
        //viewHolder.comment_time.setText(bean.getCommentTime()+"");

        Date date = new Date(bean.getReplyTime());
        SimpleDateFormat df = new SimpleDateFormat("MM-dd  HH:mm");
        viewHolder.comment_time.setText(df.format(date));

        viewHolder.comment_content.setText(bean.getReplyContent());

        viewHolder.dianz.setVisibility(View.GONE);
        viewHolder.hot_comment.setVisibility(View.GONE);
        viewHolder.comment_num.setVisibility(View.GONE);
    }


    @Override
    public int getItemCount() {
        if (list!=null)
            return list.size();
        return 0;
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView comment_pic;
        private TextView comment_name,comment_time,comment_content,hot_comment,comment_num;
        private CheckBox dianz;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            comment_pic=itemView.findViewById(R.id.sdv_comment_pic);
            comment_name=itemView.findViewById(R.id.tv_comment_name);
            comment_time=itemView.findViewById(R.id.tv_comment_time);
            comment_content=itemView.findViewById(R.id.tv_comment_content);
            hot_comment=itemView.findViewById(R.id.tv_hot_comment);
            comment_num=itemView.findViewById(R.id.tv_comment_num);
            dianz=itemView.findViewById(R.id.cb_comment_great);
        }
    }


}
