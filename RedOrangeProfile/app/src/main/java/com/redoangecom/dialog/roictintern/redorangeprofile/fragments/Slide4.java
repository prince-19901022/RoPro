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
 * Created by roictintern on 28-Dec-16.
 */

public class Slide4 extends Fragment {

    private ImageView iv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View slideView = inflater.inflate(R.layout.slide4 , container , false);

        iv = (ImageView) slideView.findViewById(R.id.pg4img);
        Picasso.with(getActivity()).load("file:///android_asset/sliders/slide4.jpg").into(iv);
        //Picasso.with(getActivity()).load(R.drawable.slide4).into(iv);
        return slideView;
    }
}
