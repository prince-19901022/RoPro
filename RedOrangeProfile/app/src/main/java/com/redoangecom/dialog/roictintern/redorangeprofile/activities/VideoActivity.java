package com.redoangecom.dialog.roictintern.redorangeprofile.activities;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.Toast;

import com.redoangecom.dialog.roictintern.redorangeprofile.utils.HTML5WebView;

import java.util.Timer;
import java.util.TimerTask;

public class VideoActivity extends AppCompatActivity {

    private HTML5WebView myWebView;
    private  String VIDEO_URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myWebView = new HTML5WebView(this);

        Bundle args;

        try{
            args = getIntent().getExtras();
            VIDEO_URL = args.getString("video");
        }catch(NullPointerException ex){}

        if(savedInstanceState != null){
            //Toast.makeText(this , "web view Restored" , Toast.LENGTH_SHORT).show();
            myWebView.restoreState(savedInstanceState);
        }else{

            myWebView.loadUrl(VIDEO_URL);
        }

        setContentView(myWebView.getLayout());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        myWebView.saveState(outState);

    }

    @Override
    public void onStop() {
        super.onStop();
        myWebView.stopLoading();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (myWebView.inCustomView()) {
                myWebView.hideCustomView();
                myWebView.goBack();
                myWebView.goBack();
                return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        long timeout = ViewConfiguration.getZoomControlsTimeout();

        Runnable run = new Runnable() {
            @Override
            public void run() {
                myWebView.destroy();
            }
        };

        Handler h = new Handler();
        h.postDelayed(run , timeout);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
