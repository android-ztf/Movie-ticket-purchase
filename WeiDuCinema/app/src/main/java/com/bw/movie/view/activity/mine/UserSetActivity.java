package com.bw.movie.view.activity.mine;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.application.App;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.bean.mine.NewVersionBean;
import com.bw.movie.model.realm.UserInfoRealm;
import com.bw.movie.presenter.MinePresenter;
import com.bw.movie.utils.DataCleanManager;
import com.bw.movie.utils.VersionUtils;
import com.bw.movie.view.activity.ForgetPwdActivity;
import com.bw.movie.view.activity.HomeActivity;
import com.bw.movie.view.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmResults;

public class UserSetActivity extends BaseActivity<MinePresenter> implements MineContract.IMineView {

    @BindView(R.id.but_back_mineset)
    Button butBackMineset;
    @BindView(R.id.but_clear_mineset)
    Button butClearMineset;
    @BindView(R.id.but_newversion_mineset)
    Button butNewversionMineset;
    @BindView(R.id.but_pwd_mineset)
    Button butPwdMineset;
    @BindView(R.id.but_relogin_mineset)
    Button butReloginMineset;
    @BindView(R.id.tv_clearsize_mineset)
    TextView tvClearsizeMineset;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_user_set;
    }

    @Override
    protected MinePresenter setPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        String totalCacheSize=null;
        try {
            totalCacheSize = DataCleanManager.getTotalCacheSize(App.mContext);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tvClearsizeMineset.setText(totalCacheSize);
        }

    }

    @OnClick({R.id.but_back_mineset, R.id.but_clear_mineset, R.id.but_newversion_mineset, R.id.but_pwd_mineset, R.id.but_relogin_mineset})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_back_mineset:
                finish();
                break;
            case R.id.but_clear_mineset:
                DataCleanManager.clearAllCache(App.mContext);
                String totalCacheSize=null;
                try {
                    totalCacheSize = DataCleanManager.getTotalCacheSize(App.mContext);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    tvClearsizeMineset.setText(totalCacheSize);
                }
                break;
            case R.id.but_newversion_mineset:
                String versionName = VersionUtils.getVersionName(App.mContext);
                if (versionName!=null){
                    mPresenter.getNewVersion(String.valueOf(versionName));
                }
                break;
            case R.id.but_pwd_mineset:
                Intent intent = new Intent(this, ForgetPwdActivity.class);
                startActivity(intent);
                break;
            case R.id.but_relogin_mineset:
                //删除userId和sessionId
                Realm realm = Realm.getDefaultInstance();

                RealmResults<UserInfoRealm> beans = realm.where(UserInfoRealm.class).findAll();

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        beans.deleteAllFromRealm();
                    }
                });


                Intent intent1 = new Intent();
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent1.setClass(this, LoginActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void onNewVersionSuccess(NewVersionBean newVersionBean) {
        Log.i("nweversion",newVersionBean.getMessage());
        if (newVersionBean.getFlag()!=1){
            Toast.makeText(this,"已是最新版本",Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, NewVersionActivity.class);
            intent.putExtra("downloadUrl",newVersionBean.getDownloadUrl());
            startActivity(intent);
        }

    }

    @Override
    public void onFailure(Throwable e) {
        Log.i("err",e.getMessage());
    }


}
