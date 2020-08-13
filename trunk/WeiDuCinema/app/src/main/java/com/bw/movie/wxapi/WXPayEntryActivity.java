package com.bw.movie.wxapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.application.App;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler {

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_wxpay_entry;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        super.initView();
        App.mWxApi.handleIntent(getIntent(),this);

    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {

        String mess=null;

        if(baseResp.getType()== ConstantsAPI.COMMAND_PAY_BY_WX){

            Log.e("===", "onPayFinish, errCode = " + baseResp.errCode);
            if (baseResp.errCode == 0) {//支付成功
                mess="支付成功";
            }else if (baseResp.errCode == -1) {//支付失败
                mess="支付失败";
            }else {//取消
                mess="支付取消";

            }
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("支付结果");
            builder.setPositiveButton("好的", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setMessage(mess);
            builder.show();

        }
    }

}
