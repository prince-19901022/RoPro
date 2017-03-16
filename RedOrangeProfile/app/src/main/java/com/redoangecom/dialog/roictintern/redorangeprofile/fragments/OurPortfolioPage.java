package com.redoangecom.dialog.roictintern.redorangeprofile.fragments;


import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.redoangecom.dialog.roictintern.redorangeprofile.activities.VideoActivity;
import com.redoangecom.dialog.roictintern.redorangeprofile.models.PortFolio;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.AlertMessage;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.AppConstant;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.ProportionalImageView;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class OurPortfolioPage extends Fragment {

    private ProportionalImageView banner;
    private TextView header;
    private TextView desc;
    private Button link;
    private Button play;
    private PortFolio portFolio;
    private Resources res;
    private AlertMessage am;
    private Typeface robotoLight;
    public static OurPortfolioPage newInstance(PortFolio portFolio){

        OurPortfolioPage opf = new OurPortfolioPage();
        opf.portFolio = portFolio;

        return opf;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View opfView = inflater.inflate(R.layout.fragment_our_portfolio_page, container, false);

        banner = (ProportionalImageView) opfView.findViewById(R.id.banner);
        header = (TextView) opfView.findViewById(R.id.portfolio_header);
        desc   = (TextView) opfView.findViewById(R.id.portfolio_desc);
        link   = (Button) opfView.findViewById(R.id.visitLink);
        play = (Button) opfView.findViewById(R.id.play);
        res    = getResources();

        setData();
        initAction();
        return opfView;
    }

    private void setData(){

        if(portFolio.getThumbnailPath().equals("-1")){
            Picasso.with(getActivity()).load(portFolio.getBannerPath()).into(banner);
        }else{
            Picasso.with(getActivity()).load(portFolio.getThumbnailPath()).into(banner);
        }

        if(portFolio.getHeader() >= 0){

            header.setText(res.getString(portFolio.getHeader()));
        }

        /*if(portFolio.getTag() != null && portFolio.getTag().equals(AppConstant.CONSULTANCY_TAG)){
            //desc.setText(Html.fromHtml(getString(portFolio.getDesc())));
            AppConstant.setCustomFont(desc , getActivity() , "fonts/roboto_light.ttf" , portFolio.getDesc());
        }else{

            desc.setText(getString(portFolio.getDesc()));
        }*/

        AppConstant.setCustomFont(desc , getActivity() , "fonts/roboto_light.ttf" , portFolio.getDesc());

        if(portFolio.getSiteURL() < 0 ){

            link.setVisibility(View.INVISIBLE);
            banner.setClickable(false);
        }

        if(portFolio.getVideoURL() < 0){

            play.setVisibility(View.INVISIBLE);
        }


    }

    private void initAction(){

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isNetworkAvailable()){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW , Uri.parse(getString(portFolio.getSiteURL())));
                    startActivity(browserIntent);
                }else{

                    am = new AlertMessage("You Are Not Connected To Internet" , "Network Alert" , -1 ,getActivity());
                    am.ShowAlertDialog();
                }
            }
        });

        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(portFolio.getVideoURL() < 0){

                    return;
                }

                if(isNetworkAvailable()){
                    Intent playerIntent = new Intent(getActivity() , VideoActivity.class);
                    playerIntent.putExtra("video",getString(portFolio.getVideoURL()));
                    startActivity(playerIntent);
                }else{

                    am = new AlertMessage("You Are Not Connected To Internet" , "Network Alert" , -1 ,getActivity());
                    am.ShowAlertDialog();
                }
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isNetworkAvailable()){

                    Intent playerIntent = new Intent(getActivity() , VideoActivity.class);
                    playerIntent.putExtra("video",getString(portFolio.getVideoURL()));
                    startActivity(playerIntent);
                }else{

                    am = new AlertMessage("You Are Not Connected To Internet" , "Network Alert" , -1 ,getActivity());
                    am.ShowAlertDialog();
                }
            }
        });
    }

    private boolean isNetworkAvailable(){
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cm.getActiveNetworkInfo();
        return nInfo != null && nInfo.isConnectedOrConnecting();
    }

}
