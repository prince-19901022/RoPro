package com.redoangecom.dialog.roictintern.redorangeprofile.fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.redoangecom.dialog.roictintern.redorangeprofile.SplashScreen;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.MultipleTypeface;

/**
 * A simple {@link Fragment} subclass.
 */
public class OurContactFragment extends Fragment {

    private TextView contactHeader , countryname , homeBng , street , code , mailAdressBng , phnBng,
            country2 , house2 , street2 , code2 , mailAdress2 , phn2;

    private String iconHome;
    private String iconMail;
    private String iconPhone;

    private SpannableStringBuilder ssb;

    public OurContactFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View contactView = inflater.inflate(R.layout.fragment_our_contact, container, false);
        initStringValue();
        initView(contactView);

        return contactView;
    }

    private void initView(View v){

        contactHeader = (TextView) v.findViewById(R.id.contactHeader);
        countryname   = (TextView) v.findViewById(R.id.countryame);
        homeBng       = (TextView) v.findViewById(R.id.homeBng);
        street        = (TextView) v.findViewById(R.id.street);
        code          = (TextView) v.findViewById(R.id.code);
        mailAdressBng = (TextView) v.findViewById(R.id.mailAdressBng);
        phnBng        = (TextView) v.findViewById(R.id.phnBng);

        country2   = (TextView) v.findViewById(R.id.country2);
        house2     = (TextView) v.findViewById(R.id.house2);
        street2    = (TextView) v.findViewById(R.id.street2);
        code2      = (TextView) v.findViewById(R.id.code2);
        mailAdress2= (TextView) v.findViewById(R.id.mailAdress2);
        phn2       = (TextView) v.findViewById(R.id.phn2);


        contactHeader.setTypeface(SplashScreen.rl , Typeface.BOLD);
        countryname.setTypeface(SplashScreen.rl , Typeface.BOLD);
        country2.setTypeface(SplashScreen.rl , Typeface.BOLD);

        setMultipleTypeFace(iconHome , getResources().getString(R.string.house1));
        homeBng.setText(ssb);
        setMultipleTypeFace(iconHome , getResources().getString(R.string.house2));
        house2.setText(ssb);


        street.setTypeface(SplashScreen.rl);
        street2.setTypeface(SplashScreen.rl);
        code.setTypeface(SplashScreen.rl);
        code2.setTypeface(SplashScreen.rl);

        setMultipleTypeFace(iconMail , getResources().getString(R.string.email2));
        mailAdress2.setText(ssb);
        setMultipleTypeFace(iconMail , getResources().getString(R.string.email1));
        mailAdressBng.setText(ssb);

        setMultipleTypeFace(iconPhone , getResources().getString(R.string.phn1));
        phnBng.setText(ssb);
        setMultipleTypeFace(iconPhone , getResources().getString(R.string.phn2));
        phn2.setText(ssb);
    }

    private void initStringValue(){

        iconHome  = getResources().getString(R.string.house_icon);
        iconMail  = getResources().getString(R.string.email_icon);
        iconPhone = getResources().getString(R.string.phn_icon);
    }

    private void setMultipleTypeFace(String icon , String text){
        ssb = new SpannableStringBuilder(icon+" "+text);

        ssb.setSpan(new MultipleTypeface("" , SplashScreen.fa) , 0 , icon.length() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(new MultipleTypeface("" , SplashScreen.rl) , icon.length() , (icon+" "+text).length() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

}
