package com.bw.movie.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.bw.movie.utils.NetUtils;

import butterknife.ButterKnife;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-5-27
 * INTRODUCE：$
 * Activity作为android最经常使用的,因为使用的非常频繁,这个时候我们需要将
 * 一些重复的代码抽取到BaseActivty中实现,写成抽象类,将必须实现的方法.写成
 * 抽象方法,以致于减少代码的重复性,提高开发效率,减少内存
 *
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    //写成protected 方便子类中使用
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayoutId());
        ButterKnife.bind(this);//绑定页面 父类中绑定,子类中可直接使用
        mPresenter=setPresenter();//初始化
        if (mPresenter!=null){
            mPresenter.attachView(this);//绑定页面
        }
        initView();
        initData();
    }
    //绑定页面
    protected abstract int provideLayoutId();
    //设置p层
    protected abstract P setPresenter();
    /**
     * 空实现，子类需要用的时候，可以选择重写
     * 初始化控件
     */
    protected void initView(){

    }
    /**
     * 空实现，子类需要用的时候，可以选择重写
     * 初始化数据
     */
    protected void initData(){

    }
    //判断是否有网 true 有网   false 无网
    public boolean hasNetWork(){
        return NetUtils.hasNetWork(this);
    }
    /**
     * 无网提醒
     */
    public void showNoNetTip() {
        Toast.makeText(BaseActivity.this, "无网，请检查网络", Toast.LENGTH_SHORT).show();
    }

    /**
     * 在页面销毁时,解除绑定,减少内存
     * ps:在父类中写的话,子类不必写,减少代码的重复书写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
