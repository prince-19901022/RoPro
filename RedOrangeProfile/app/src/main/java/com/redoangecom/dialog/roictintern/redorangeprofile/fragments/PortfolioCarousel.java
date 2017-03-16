package com.redoangecom.dialog.roictintern.redorangeprofile.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.redoangecom.dialog.roictintern.redorangeprofile.activities.PortFolioActivity;
import com.redoangecom.dialog.roictintern.redorangeprofile.models.PortFolio;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.AppConstant;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.CatagoryListener;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.ProportionalImageView;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class PortfolioCarousel extends Fragment implements CatagoryListener{

    private ProportionalImageView banner;
    private TextView generalDesc;
    private PortFolio portFolio;

    public static PortfolioCarousel newInstance(PortFolio portFolio){

        PortfolioCarousel pfc = new PortfolioCarousel();
        pfc.portFolio = portFolio;

        return pfc;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View pfcView = inflater.inflate(R.layout.fragment_portfolio_carousel, container, false);

        initViewsActions(pfcView);

        return pfcView;
    }

    private void initViewsActions(View view){

        banner = (ProportionalImageView) view.findViewById(R.id.pfcBanner);

        generalDesc = (TextView) view.findViewById(R.id.generalHdr);

        AppConstant.setCustomFont(generalDesc , getActivity() , "fonts/roboto_light.ttf" , portFolio.getGeneralDesc());
        Picasso.with(getActivity()).load(portFolio.getBannerPath()).into(banner);


        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickHandler();
            }
        });
        generalDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickHandler();
            }
        });
    }

    private void clickHandler(){

        if(portFolio.getTag() != null && portFolio.getTag().equals(AppConstant.CONSULTANCY_TAG)) {

            Intent intent = new Intent(getActivity() , PortFolioActivity.class);
            intent.putExtra("constId" , portFolio.getHeader());
            intent.putExtra("tag" , portFolio.getTag());
            intent.putExtra("productionCatagory" , "null");
            startActivityForResult(intent , 0);
        }else{

            CatagoryDialog cd = CatagoryDialog.newInstance(portFolio.getTag() , this);
            cd.show(getFragmentManager() , "Catagory Dialog");
        }
    }

    @Override
    public void onCatagorySelected(String catagory) {
        Intent intent = new Intent(getActivity() , PortFolioActivity.class);
        intent.putExtra("constId" , portFolio.getHeader());
        intent.putExtra("tag" , portFolio.getTag());
        intent.putExtra("productionCatagory" , catagory);
        startActivityForResult(intent , 0);
    }
}
