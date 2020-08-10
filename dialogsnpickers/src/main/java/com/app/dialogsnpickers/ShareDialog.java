package com.app.dialogsnpickers;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class ShareDialog
{
   private ProgressDialog dialog ;

    public void shareDialog(AppCompatActivity appCompatActivity,String content,String url)
    {
        try
        {
            if(dialog!=null&&dialog.isShowing())
            {
                dialog.dismiss();
            }

            dialog=new ProgressDialog(appCompatActivity); // this = YourActivity
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setTitle("Loading");
            dialog.setMessage("Please wait...");
            dialog.setIndeterminate(true);
            dialog.setCanceledOnTouchOutside(false);

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, appCompatActivity.getString(R.string.app_name));
            String shareMessage= "\n"+content+"\n\n";
            shareMessage = shareMessage + url + BuildConfig.APPLICATION_ID +"\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            appCompatActivity.startActivity(Intent.createChooser(shareIntent, "choose one"));

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialog.dismiss();
                }
            },1000);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
