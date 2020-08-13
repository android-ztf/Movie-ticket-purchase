package com.bw.movie.view.activity.mine;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bigkoo.pickerview.TimePickerView;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.MineContract;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.PutPicBean;
import com.bw.movie.model.bean.UserInFoBean;
import com.bw.movie.presenter.MinePresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MineInfoActivity extends BaseActivity<MinePresenter> implements MineContract.IMineView {

    @BindView(R.id.but_back_loign)
    Button butBackLoign;
    @BindView(R.id.sdv_pic_my)
    SimpleDraweeView sdvPicMy;
    @BindView(R.id.tv_name_my)
    TextView tvNameMy;
    @BindView(R.id.tv_sex_my)
    TextView tvSexMy;
    @BindView(R.id.tv_birth_my)
    TextView tvBirthMy;
    @BindView(R.id.tv_tel_my)
    TextView tvTelMy;
    @BindView(R.id.tv_email_my)
    TextView tvEmailMy;
    private View view;
    private PopupWindow window;
    private Button shooting;
    private Button take_phone;
    private Uri mUri;

    private TimePickerView pvTime;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_mine_info;
    }

    @Override
    protected MinePresenter setPresenter() {
        return new MinePresenter();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void initData() {
        super.initData();

        if (!hasNetWork()){
            showNoNetTip();
        }else{
            // android 7.0系统解决拍照的问题
            initPhotoError();

            mPresenter.getUserInFo();
        }

    }

    @Override
    public void onUserInFoSuccess(UserInFoBean userInFoBean) {
        if (userInFoBean.getStatus().equals("0000")){
            UserInFoBean.ResultBean result = userInFoBean.getResult();
            sdvPicMy.setImageURI(Uri.parse(result.getHeadPic()));
            tvNameMy.setText(result.getNickName());
            tvEmailMy.setText(result.getEmail());
            if (result.getSex()==1){
                tvSexMy.setText("男");
            }
            tvTelMy.setText(result.getPhone());
            Date date = new Date(result.getBirthday());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            tvBirthMy.setText(format.format(date));
        }


    }

    @Override
    public void onPutPicSuccess(PutPicBean putPicBean) {
        Toast.makeText(this,putPicBean.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpdatePhone(LoginBean loginBean) {
        Toast.makeText(this,loginBean.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPutBrithSuccess(LoginBean loginBean) {
        Toast.makeText(this,loginBean.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Throwable e) {

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick({R.id.but_back_loign, R.id.sdv_pic_my, R.id.tv_birth_my, R.id.tv_tel_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_back_loign:
                finish();
                break;
            case R.id.sdv_pic_my:
                initPopwindow();
                break;
            case R.id.tv_birth_my:
                initTimePicker(); //初始化时间选择器
                pvTime.show();//显示时间选择器
                break;
            case R.id.tv_tel_my:
                View view1 = View.inflate(this, R.layout.popwindow_phone, null);
                PopupWindow window1 = new PopupWindow(view1, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                window1.setBackgroundDrawable(new ColorDrawable());
                window1.setFocusable(true);
                //解决输入框和输入法冲突问题
                window1.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
                window1.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

                EditText phone = (EditText) view1.findViewById(R.id.et_phone_my);
                Button xiu = (Button) view1.findViewById(R.id.but_xiu_my);

                xiu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (phone.getText().toString()!=null && !phone.getText().toString().equals("")){
                            mPresenter.postUpdatePhone(phone.getText().toString());
                        }
                    }
                });

                window1.showAtLocation(view1,Gravity.BOTTOM,0,0);

                break;
        }
    }

    private void initPopwindow(){
        view = View.inflate(this, R.layout.pic_popwindow_item, null);

        window = new PopupWindow(view, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        window.setBackgroundDrawable(new ColorDrawable());

        window.setOutsideTouchable(true);

        window.showAtLocation(view, Gravity.BOTTOM,0,0);

        shooting = (Button) view.findViewById(R.id.but_shooting);
        take_phone = (Button) view.findViewById(R.id.but_phone_take);

        shooting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("shootng","点击了相机");
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                mUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory()+"/bai.png"));
                intent.putExtra(MediaStore.EXTRA_OUTPUT, mUri);
                startActivityForResult(intent,1000);

                window.dismiss();
            }
        });
        take_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                    List<ResolveInfo> resolveInfos = getPackageManager().queryIntentActivities(intent
                            , PackageManager.MATCH_DEFAULT_ONLY);
                    //判断用户设备是否有相册
                    if (resolveInfos.size()!=0){
                        startActivityForResult(intent, 2000);
                    }else{
                        Toast.makeText(MineInfoActivity.this,"没有相册",Toast.LENGTH_SHORT).show();
                    }
                    window.dismiss();
                }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000&&resultCode==this.RESULT_OK) {
            crop(mUri);
        }
        if (requestCode == 2000 && resultCode==this.RESULT_OK) {
            Uri uri = data.getData();
            crop(uri);
            window.dismiss();
        }
        if (requestCode == 3000 && resultCode==this.RESULT_OK) {
            Bitmap bitmap = data.getParcelableExtra("data");
            String crop = saveImage("crop", bitmap);
            Map<String, RequestBody> partMap=new HashMap<>();
            MultipartBody.Part body = null;
            if(crop!=null){
                File file=new File(crop);
                if(file.exists()) {
                    RequestBody requestFile = RequestBody.create(MediaType.parse("image/png"), file);
                    body = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
                }
            }
//            Map<String,String> map2=new HashMap<>();
//            map2.put("uid",""+23830);
//
//            myPresenter.postImage(Contrats.UPLOAD,UploadBean.class,map2,body);
//            icon.setImageBitmap(bitmap);

            mPresenter.postPutPicSuccess(body);
            sdvPicMy.setImageBitmap(bitmap);

        }

    }

    //裁剪
    private void crop(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        //裁减比例1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        //裁剪后图片大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);
        intent.putExtra("outputFormat", "JPEG");
        intent.putExtra("noFaceDatection", false);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3000);
    }

    //保存图片
    private String saveImage(String crop, Bitmap bitmap) {
        File appDir = new File(Environment.getExternalStorageDirectory().getPath());
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = crop + ".png";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void initPhotoError(){
        // android 7.0系统解决拍照的问题
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
    }

    //初始化时间选择器
    private void initTimePicker() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String s = format.format(date);

        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(Integer.valueOf(s)-150, 1, 1);//起始时间
        Calendar endDate = Calendar.getInstance();
        endDate.set(Integer.valueOf(s), 12, 31);//结束时间
        pvTime = new TimePickerView.Builder(this,
                new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        //选中事件回调
                        //mTvMyBirthday 这个组件就是个TextView用来显示日期 如2020-09-08
                        tvBirthMy.setText(getTimes(date));
                        mPresenter.postPutBrithSuccess(getTimes(date));
                    }
                })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("年", "月", "日", "时", "", "")
                .isCenterLabel(true)
                .setDividerColor(Color.DKGRAY)
                .setContentSize(21)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setDecorView(null)
                .build();
    }

    //格式化时间
    private String getTimes(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }


}
