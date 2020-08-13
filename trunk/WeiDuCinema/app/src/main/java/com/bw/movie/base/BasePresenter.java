package com.bw.movie.base;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-5-27
 * INTRODUCE：$
 * 处理业务逻辑
 */
public class BasePresenter<V extends IBaseView> {

    private V iView;

    //绑定
    public void attachView(V view){
        this.iView=view;
    }
    //获取
    public V getView(){
        return iView;
    }
    //解绑
    public void detachView(){
        this.iView=null;
    }

}
