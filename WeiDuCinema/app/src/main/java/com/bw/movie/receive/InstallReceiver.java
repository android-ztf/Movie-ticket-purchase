package com.bw.movie.receive;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.bw.movie.utils.ConfigurationUtil;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-8-4
 * INTRODUCE：$
 */
public class InstallReceiver extends BroadcastReceiver {

    // 安装下载接收器
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
            installApk(context);
        }
    }

    // 安装Apk
    private void installApk(Context context) {
        try {
            Intent i = new Intent(Intent.ACTION_VIEW);
            String filePath = ConfigurationUtil.APK_PATH_ABSOULT+"GTLXKJ.apk";
            System.out.println(filePath);
            i.setDataAndType(Uri.parse("file://" + filePath), "application/vnd.android.package-archive");
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

