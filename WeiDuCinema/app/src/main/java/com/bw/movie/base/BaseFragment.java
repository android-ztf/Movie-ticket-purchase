package com.bw.movie.base;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.bw.movie.application.App;
import com.bw.movie.utils.NetUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Fragment 是在 Android 3.0 中引入，用于解决不同屏幕分辨率的设备上 UI 显示、交互的问题
 * BaseFargment的作用与baseActivity的作用类似
 * @param <P>
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {
    //写成protected 方便子类中使用
    protected P mPresenter;
    private Unbinder mUnbinder;

    /**
     * 当activity要得到fragment的layout时，调用此方法，fragment在其中创建自己的layout(界面)。
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getActivity(), provideLayoutId(), null);
        mUnbinder=ButterKnife.bind(this,inflate);
        return inflate;
    }

    /**
     *在Activity.onCreate方法调用后会立刻调用此方法，表示窗口已经初始化完毕，此时可以调用控件了
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter=setPresenter();
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }
        inintView();
        initData();
    }

    public abstract int provideLayoutId();//子类传递的视图

    //初始化View
    protected void inintView(){

    }

    //初始化数据
    protected  void initData(){

    }
    //设置p层
    protected abstract P setPresenter();

    //释放资源
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
        mUnbinder.unbind();
    }
    //判断是否有网
    public boolean hasNetWrok(){
        return NetUtils.hasNetWork(App.mContext);
    }

    //无网提醒
    public void showNoNetTip() {
        Toast.makeText(App.mContext, "无网，请检查网络", Toast.LENGTH_SHORT).show();
    }

}
