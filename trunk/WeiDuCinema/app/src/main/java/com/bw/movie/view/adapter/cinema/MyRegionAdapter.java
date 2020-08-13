package com.bw.movie.view.adapter.cinema;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.cinema_bean.RegionListBean;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-15
 * INTRODUCE：$
 */
public class MyRegionAdapter extends RecyclerView.Adapter {

    private Context context;

    public MyRegionAdapter(Context context) {
        this.context = context;
    }

    private List<RegionListBean.ResultBean> list ;

    public void setList(List<RegionListBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.address_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        RegionListBean.ResultBean bean = list.get(position);

        viewHolder.checkBox.setText(bean.getRegionName());


        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.onData(bean.getRegionId(),v);
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

        private CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.cb_address );
        }
    }

    private OnClickAddress callBack;

    public void setCallBack(OnClickAddress callBack) {
        this.callBack = callBack;
    }

    public interface OnClickAddress{
        void onData(int id,View view);
    }

}
