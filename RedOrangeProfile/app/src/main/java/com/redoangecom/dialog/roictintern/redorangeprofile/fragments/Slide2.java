package com.redoangecom.dialog.roictintern.redorangeprofile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.squareup.picasso.Picasso;

/**
 * Created by roictintern on 13-Dec-16.
 */

public class Slide2 extends Fragment {

    private ImageView iv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View slideView = inflater.inflate(R.layout.slide2 , container , false);

        iv = (ImageView) slideView.findViewById(R.id.pg2img);
        Picasso.with(getActivity()).load("file:///android_asset/sliders/slide2.jpg").into(iv);
        return slideView;
    }
}
