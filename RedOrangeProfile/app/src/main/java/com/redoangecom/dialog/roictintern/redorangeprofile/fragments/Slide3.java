package com.redoangecom.dialog.roictintern.redorangeprofile.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.squareup.picasso.Picasso;

/**
 * Created by roictintern on 13-Dec-16.
 */

public class Slide3 extends Fragment {

    private ImageView iv;
    private static final float SLIDE3_ASPECT_RATIO = 0.6505f;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View slideView = inflater.inflate(R.layout.slide3 , container , false);

        iv = (ImageView) slideView.findViewById(R.id.pg3img);
        Picasso.with(getActivity()).load("file:///android_asset/sliders/slide3.jpg").into(iv);
        //Picasso.with(getActivity()).load(R.drawable.slide3).into(iv);
        return slideView;
    }

    private void LoadImage(){

        ViewTreeObserver vto = iv.getViewTreeObserver();

        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                int h = iv.getHeight();
                int w = (int) Math.ceil(1118 * SLIDE3_ASPECT_RATIO);

                Log.d("Before Try","Height "+h);
                Log.d("Before Try","Width "+w);

                Picasso.with(getActivity()).load("file:///android_asset/sliders/slide3_c.jpg").resize(Math.abs(w) , Math.abs(h)).into(iv);

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    iv.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    iv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
    }
}
