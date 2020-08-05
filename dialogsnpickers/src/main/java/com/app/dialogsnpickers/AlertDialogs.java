package com.app.dialogsnpickers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
public class AlertDialogs
{



//    private void getData()
//    {
//        alertDialog(, "", "", "", "", new DialogCallBacks() {
//            @Override
//            public void getDialogEvent( String buttonPressed)
//            {
//
//            }
//        });
//    }



    public void alertDialog(AppCompatActivity appCompatActivity, String title, String message, final String positiveButton, final String negativeButton, final DialogCallBacks callBacks)
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(appCompatActivity);
        builder1.setTitle(title);
        builder1.setMessage(message);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                positiveButton,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        callBacks.getDialogEvent(positiveButton);
                    }
                });

        builder1.setNegativeButton(
                negativeButton,
                new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        dialog.cancel();
                        callBacks.getDialogEvent(negativeButton);
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }








}
