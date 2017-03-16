package com.redoangecom.dialog.roictintern.redorangeprofile.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;

import java.util.List;

/**
 * Created by roictintern on 03-Dec-16.
 */

public class AlertMessage {

    private String message;
    private String title;
    private int icon;
    private Context context;

    private AlertDialog.Builder dialog;


    public AlertMessage(String message, String title, int icon, Context context) {
        this.message = message;
        this.title = title;
        this.icon = icon;
        this.context = context;
    }

    public void ShowAlertDialog(){

        dialog = new AlertDialog.Builder(context);
        dialog.setTitle(title);
        dialog.setMessage(message);

        if(icon >= 0){
            dialog.setIcon(icon);
        }

        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void showPermissionSeekerDialog(){

        dialog = new AlertDialog.Builder(context);
        dialog.setTitle(title);
        dialog.setMessage(message);

        if(icon >= 0){
            dialog.setIcon(icon);
        }

        dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.parse("package:"+context.getPackageName()));
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);

                List activities = context.getPackageManager().queryIntentActivities(intent , PackageManager.MATCH_DEFAULT_ONLY);
                if(activities.size() > 0){
                    context.startActivity(intent);
                    dialog.dismiss();
                }
            }
        });

        dialog.show();
    }
}
