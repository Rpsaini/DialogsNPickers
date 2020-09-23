package com.app.dialogsnpickers;


import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AppUpdateDialog
{
    //new ColorDrawable(android.graphics.Color.TRANSPARENT)       Dialog Color
    //WindowManager.LayoutParams.MATCH_PARENT                     Dialog Width
    //WindowManager.LayoutParams.MATCH_PARENT                     Dialog Hieght
    //
    private Dialog appUpdateDialog;
    public Dialog AppUpdateDialog(final AppCompatActivity appCompatActivity, int view,ColorDrawable colorDrawable,int dialogWidth,int dialogHeight,boolean setCancelable,int updatedVersion) {
        try {
            PackageInfo pInfo = appCompatActivity.getPackageManager().getPackageInfo(appCompatActivity.getPackageName(), 0);
            int currentversion = Integer.parseInt(pInfo.versionName);
            if (currentversion < updatedVersion)
            {
                if (appUpdateDialog != null && appUpdateDialog.isShowing()) {
                    appUpdateDialog.dismiss();
                }
                appUpdateDialog = new Dialog(appCompatActivity);
                appUpdateDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                appUpdateDialog.setContentView(view);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                Window window = appUpdateDialog.getWindow();
                lp.copyFrom(window.getAttributes());
                appUpdateDialog.setCancelable(setCancelable);
                lp.width = dialogWidth;
                lp.height = dialogHeight;
                window.setAttributes(lp);
                appUpdateDialog.getWindow().setBackgroundDrawable(colorDrawable);
                appUpdateDialog.show();

                appUpdateDialog.findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        appCompatActivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appCompatActivity.getPackageName())));
                    }
                });


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appUpdateDialog;
    }
}