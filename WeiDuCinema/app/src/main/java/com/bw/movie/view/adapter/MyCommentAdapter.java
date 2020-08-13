package com.bw.movie.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.model.bean.cinema_bean.CinemaCommentBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-5
 * INTRODUCE：$
 */
public class MyCommentAdapter extends BaseAdapter {

    private Context context;

    public MyCommentAdapter(Context context) {
        this.context = context;
    }

    private List<CinemaCommentBean.ResultBean> list;

    public void setList(List<CinemaCommentBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (list!=null)
            return list.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder =null;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.comment_item,null);
            viewHolder = new ViewHolder();
            viewHolder.comment_pic=convertView.findViewById(R.id.sdv_comment_pic);
            viewHolder.comment_name=convertView.findViewById(R.id.tv_comment_name);
            viewHolder.comment_time=convertView.findViewById(R.id.tv_comment_time);
            viewHolder.comment_content=convertView.findViewById(R.id.tv_comment_content);
            viewHolder.hot_comment=convertView.findViewById(R.id.tv_hot_comment);
            viewHolder.comment_num=convertView.findViewById(R.id.tv_comment_num);
            viewHolder.dianz=convertView.findViewById(R.id.cb_comment_great);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }

        CinemaCommentBean.ResultBean bean = list.get(position);

        viewHolder.comment_pic.setImageURI(Uri.parse(bean.getCommentHeadPic()));
        viewHolder.comment_name.setText(bean.getCommentUserName());
        //viewHolder.comment_time.setText(bean.getCommentTime()+"");

        Date date = new Date(bean.getCommentTime());
        SimpleDateFormat df = new SimpleDateFormat("MM-dd  HH:mm");
        viewHolder.comment_time.setText(df.format(date));

        viewHolder.comment_content.setText(bean.getCommentContent());
        if (bean.getIsGreat()==1){
            viewHolder.dianz.setChecked(true);
        }
        if (bean.getHotComment()==1){
            viewHolder.hot_comment.setVisibility(View.VISIBLE);
        }

        viewHolder.dianz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null)
                    callBack.onDianz(v,bean.getCommentId());
            }
        });

        return convertView;
    }

    private class ViewHolder{
        private SimpleDraweeView comment_pic;
        private TextView comment_name,comment_time,comment_content,hot_comment,comment_num;
        private CheckBox dianz;
    }

    private OnDianzCallBack callBack;

    public void setCallBack(OnDianzCallBack callBack) {
        this.callBack = callBack;
    }

    public interface OnDianzCallBack{
        void onDianz(View v,int id);
    }

}
