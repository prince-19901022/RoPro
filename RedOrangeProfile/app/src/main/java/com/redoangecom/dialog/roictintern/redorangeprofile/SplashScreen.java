package com.redoangecom.dialog.roictintern.redorangeprofile;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.redoangecom.dialog.roictintern.redorangeprofile.activities.MainActivity;

public class SplashScreen extends AppCompatActivity {

    public static Typeface fa;
    public static Typeface rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler timeHandler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                fa = Typeface.createFromAsset(getAssets() , "fonts/fontawesome_webfont.ttf");
                rl = Typeface.createFromAsset(getAssets() , "fonts/roboto_light.ttf");
                startActivity(new Intent(SplashScreen.this , MainActivity.class));
                finish();
            }
        };

        timeHandler.postDelayed(runnable , 2000);
    }
}
