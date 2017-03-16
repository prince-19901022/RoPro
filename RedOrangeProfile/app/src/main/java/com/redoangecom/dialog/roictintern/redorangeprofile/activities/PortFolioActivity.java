package com.redoangecom.dialog.roictintern.redorangeprofile.activities;

import android.graphics.Typeface;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.redoangecom.dialog.roictintern.redorangeprofile.adapters.PortfolioPagerAdapter;
import com.redoangecom.dialog.roictintern.redorangeprofile.fragments.OurPortfolioPage;
import com.redoangecom.dialog.roictintern.redorangeprofile.models.PortFolio;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.AppConstant;

import java.util.ArrayList;
import java.util.Map;

public class PortFolioActivity extends AppCompatActivity {

    private ViewPager vpgr;
    private PortfolioPagerAdapter adapter;
    private ArrayList<Fragment> pageSource;
    private Button back;
    private TextView activityTitle;
    private int catagory;
    private String tag;
    private String productionCatagory;

    private Map<Integer , PortFolio> constData;
    private ArrayList<PortFolio> filmData;
    private ArrayList<PortFolio> graphicsData;
    private ArrayList<PortFolio> contentsData;
    private ArrayList<PortFolio> ictsData;

    private Typeface fontAwesome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_port_folio);

        activityTitle = (TextView) findViewById(R.id.activityTitle);
        try{
            Bundle args = getIntent().getExtras();
            catagory = args.getInt("constId");
            tag      = args.getString("tag");
            productionCatagory = args.getString("productionCatagory");// Like Branding , animation etc;
            activityTitle.setText(productionCatagory);
        }catch(NullPointerException ex){
        }

        initPageSource();

        vpgr = (ViewPager) findViewById(R.id.portfolio_pager);
        adapter = new PortfolioPagerAdapter(getSupportFragmentManager() , pageSource);
        vpgr.setAdapter(adapter);


        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SetCustomFont();
    }

    private void initPageSource(){

        OurPortfolioPage page;

        pageSource = new ArrayList<>();

        if(tag.equals(AppConstant.CONSULTANCY_TAG)){

            constData = AppConstant.getConsultancyData();
            PortFolio portFolio = constData.get(catagory);
            page = OurPortfolioPage.newInstance(portFolio);
            activityTitle.setText(portFolio.getHeader());
            pageSource.add(page);
        }

        if(tag.equals(AppConstant.CONTENT_TAG)){

            contentsData = AppConstant.getContentData(productionCatagory);

            for(PortFolio pf : contentsData ){

                page = OurPortfolioPage.newInstance(pf);
                pageSource.add(page);
            }
        }

        if(tag.equals(AppConstant.FILM_TAG)){

            filmData = AppConstant.getFilmData(productionCatagory);

            for(PortFolio pf : filmData ){

                page = OurPortfolioPage.newInstance(pf);
                pageSource.add(page);
            }
        }

        if(tag.equals(AppConstant.GRAPHICS_TAG)){

            graphicsData = AppConstant.getGraphicsData(productionCatagory);

            for(PortFolio pf : graphicsData ){
                page = OurPortfolioPage.newInstance(pf);
                pageSource.add(page);
            }
        }

        if(tag.equals(AppConstant.ICT_TAG)){

            ictsData = AppConstant.getICTData(productionCatagory);

            for(PortFolio pf : ictsData ){
                page = OurPortfolioPage.newInstance(pf);
                pageSource.add(page);
            }
        }

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void SetCustomFont(){

        Handler h = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                fontAwesome= Typeface.createFromAsset(getAssets() , "fonts/fontawesome_webfont.ttf");
                back.setTypeface(fontAwesome);
            }
        };

        h.postDelayed(r , 500);
    }
}
