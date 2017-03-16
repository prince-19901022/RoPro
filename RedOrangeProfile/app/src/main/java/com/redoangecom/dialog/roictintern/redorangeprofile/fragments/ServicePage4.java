package com.redoangecom.dialog.roictintern.redorangeprofile.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.redoangecom.dialog.roictintern.redorangeprofile.SplashScreen;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.AppConstant;

/**
 * Created by Nutrino on 12/17/2016.
 */

public class ServicePage4 extends Fragment {
    private TextView srvcName;
    private TextView srvcDesc;
    private TextView srvcImg;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View pageView = inflater.inflate(R.layout.service_page , container , false);

        srvcName = (TextView) pageView.findViewById(R.id.srvcName);
        srvcDesc = (TextView) pageView.findViewById(R.id.srvcDesc);
        srvcImg  = (TextView) pageView.findViewById(R.id.srvcImg);

        setData();

        return pageView;
    }

    private void setData(){


        String iconCode = getString(R.string.it_icon);
        String name = getString(R.string.service4);
        String desc = getString(R.string.it);

        srvcName.setText(name);
        AppConstant.setCustomFontToSrvc(srvcImg , iconCode , srvcDesc , desc , getActivity() , "fonts/fontawesome_webfont.ttf" , "fonts/roboto_light.ttf");
    }
}
