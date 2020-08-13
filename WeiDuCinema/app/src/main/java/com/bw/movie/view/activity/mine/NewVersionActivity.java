package com.bw.movie.view.activity.mine;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.application.App;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.utils.ConfigurationUtil;
import com.bw.movie.utils.Utils;
import com.bw.movie.utils.VersionUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewVersionActivity extends BaseActivity {


    @BindView(R.id.but_back_loign)
    Button butBackLoign;
    @BindView(R.id.but_nwe_version)
    Button butNweVersion;
    @BindView(R.id.tv_new_name)
    TextView tvNewName;
    private String downloadUrl;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_new_version;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();

        tvNewName.setText("当前版本V"+VersionUtils.getVersionName(App.mContext));

        butNweVersion.setText("立即体验最新版本");

        Intent intent = getIntent();
        downloadUrl = intent.getStringExtra("downloadUrl");

    }

    //下载apk
    public void downloadApk(String apkUrl) throws PackageManager.NameNotFoundException {
        Utils.deleteLocal(new File(ConfigurationUtil.APK_PATH_ABSOULT + "GTLXKJ.apk"));//删除旧的apk
        Uri uri = Uri.parse(apkUrl);
        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        // 设置允许使用的网络类型，这里是移动网络和wifi都可以
        request.setAllowedNetworkTypes(request.NETWORK_MOBILE | request.NETWORK_WIFI);
        //设置是否允许漫游
        request.setAllowedOverRoaming(true);
        //设置文件类型
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        String mimeString = mimeTypeMap.getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(apkUrl));
        request.setMimeType(mimeString);
        //在通知栏中显示
        request.setNotificationVisibility(request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setTitle("正在下载");
        request.setVisibleInDownloadsUi(true);
        //sdcard目录下的download文件夹
        request.setDestinationInExternalPublicDir(ConfigurationUtil.APK_PATH, "GTLXKJ.apk");
        // 将下载请求放入队列
        downloadManager.enqueue(request);
    }


    @OnClick({R.id.but_back_loign, R.id.but_nwe_version})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_back_loign:
                finish();
                break;
            case R.id.but_nwe_version:

                Toast.makeText(this, "已开始下载更新", Toast.LENGTH_SHORT).show();

                if (downloadUrl != null) {
                    try {
                        downloadApk(downloadUrl);
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

}
