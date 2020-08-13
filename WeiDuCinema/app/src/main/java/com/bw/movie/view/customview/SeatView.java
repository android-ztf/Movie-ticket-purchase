package com.bw.movie.view.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.application.App;
import com.bw.movie.model.bean.pay_movie.SeatInfoBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-17
 * INTRODUCE：$
 */
public class SeatView extends ViewGroup {
    public SeatView(Context context) {
        super(context);
    }

    public SeatView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SeatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    private List<SeatInfoBean.ResultBean> mList;



    public void setmList(List<SeatInfoBean.ResultBean> mList) {
        this.mList = mList;
        postInvalidate();//重新绘制

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(mList!=null && mList.size() >0) {

            BitmapDrawable yellow_yuan = (BitmapDrawable) getResources().getDrawable(R.mipmap.yellow_yuan);
            BitmapDrawable while_yuan = (BitmapDrawable) getResources().getDrawable(R.mipmap.white_yuan);
            BitmapDrawable red_yuan = (BitmapDrawable) getResources().getDrawable(R.mipmap.red_yuan);

            int width = while_yuan.getBitmap().getWidth();
            int height = while_yuan.getBitmap().getHeight();

            int colum_max=0;

            for (int i = 0; i < mList.size(); i++) {
                Log.i("---",mList.size()+"");
                SeatInfoBean.ResultBean bean = mList.get(i);

                int row = Integer.parseInt(bean.getRow());//排距
                int colum = Integer.parseInt(bean.getSeat());//列距
                if (colum>colum_max){
                    colum_max=colum;
                }
                row=row *70;

                if (colum_max>8){
                    colum = colum * 70;
                }else{
                    colum = (colum+1) * 70;
                }



                if (bean.getStatus()==2){
                    //已售
                    canvas.drawBitmap(yellow_yuan.getBitmap(),colum,row,new Paint());
                }else if(bean.getStatus()==1){
                    //未选中
                    canvas.drawBitmap(while_yuan.getBitmap(),colum,row,new Paint());
                    bean.setLeft(colum);
                    bean.setTop(row);
                    bean.setRight(colum+width);
                    bean.setBottom(row+height);

                }else{
                    //已选中
                    canvas.drawBitmap(red_yuan.getBitmap(),colum,row,new Paint());
                    bean.setLeft(colum);
                    bean.setTop(row);
                    bean.setRight(colum+width);
                    bean.setBottom(row+height);

                }

            }
        }
    }


    private OnSeatCallBack callBack;

    public void setCallBack(OnSeatCallBack callBack) {
        this.callBack = callBack;
    }

    public interface OnSeatCallBack{
        void onClickSeat(String seat);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_DOWN:
                //获取屏幕上点击的坐标
                 float x=event.getX();
                 float y = event.getY();
                 completeByXY(x,y);
             break;
             case MotionEvent.ACTION_UP:
             //点击抬起后，回复初始位置。
             invalidate();//更新视图
             return true;
        }
        //这句话不要修改
        return super.onTouchEvent(event);
    }

    public void completeByXY(float x,float y){
        if (mList!=null && mList.size()!=0) {
            //循环所有图标 判断点击的图标
            for (int i = 0; i < mList.size(); i++) {

                SeatInfoBean.ResultBean bean = mList.get(i);

                if (x >= bean.getLeft() && x <= bean.getRight() && y >= bean.getTop() && y <= bean.getBottom()) {
                    if (bean.getStatus() == 1) {
                        bean.setStatus(3);
                        String seat = callBackSeat();
                        if (callBack != null) {

                            callBack.onClickSeat(seat);
                        }
                        invalidate();
                    } else if (bean.getStatus() == 3) {
                        bean.setStatus(1);
                        String seat = callBackSeat();
                        if (callBack != null) {

                            callBack.onClickSeat(seat);
                        }
                        invalidate();
                    } else {
                        String seat = callBackSeat();
                        if (callBack != null) {

                            callBack.onClickSeat(seat);
                        }
                        invalidate();
                    }
                }
            }
        }
    }

    //将所有选中的座位进行返回
    public String callBackSeat(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < mList.size(); i++) {
            SeatInfoBean.ResultBean bean = mList.get(i);
            if (bean.getStatus()==3){
                builder.append(bean.getRow()+"-"+bean.getSeat()+",");
            }
        }
        return builder.toString();
    }

}
