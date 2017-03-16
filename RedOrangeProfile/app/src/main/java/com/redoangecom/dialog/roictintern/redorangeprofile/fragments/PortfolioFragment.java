package com.redoangecom.dialog.roictintern.redorangeprofile.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.LinkagePager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.redoangecom.dialog.roictintern.redorangeprofile.adapters.PortfolioPagerAdapter;
import com.redoangecom.dialog.roictintern.redorangeprofile.models.MyPageTransformer;
import com.redoangecom.dialog.roictintern.redorangeprofile.models.PortFolio;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.AppConstant;

import java.util.ArrayList;
import java.util.Map;

import me.crosswall.lib.coverflow.core.LinkageCoverTransformer;
import me.crosswall.lib.coverflow.core.LinkagePagerContainer;

/**
 * A simple {@link Fragment} subclass.
 */
public class PortfolioFragment extends Fragment {

    private ViewPager pager;
    private RelativeLayout pagerContainer;
    private Button consultancy;
    private Button production;
    private PortfolioPagerAdapter adapter;
    private ArrayList<Fragment> pageSource;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View pffView = inflater.inflate(R.layout.fragment_portfolio, container, false);

        pageSource = new ArrayList<>();
        initPages();
        initConstPages();
        init(pffView);

        return pffView;
    }

    private void init(View view){

        consultancy = (Button) view.findViewById(R.id.btn_consultancy);
        production = (Button) view.findViewById(R.id.btn_production);

        pager = (ViewPager) view.findViewById(R.id.portfolio_pager);
        pagerContainer = (RelativeLayout) view.findViewById(R.id.pagerContainer);
        pagerContainer.setClipChildren(false);

        adapter = new PortfolioPagerAdapter(getFragmentManager() , pageSource);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(3);
        pager.setPageTransformer(false , new MyPageTransformer());

        consultancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pageSource.clear();
                initConstPages();
                adapter = new PortfolioPagerAdapter(getFragmentManager() , pageSource);
                pager.setAdapter(adapter);
            }
        });

        production.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pageSource.clear();
                initPages();
                adapter = new PortfolioPagerAdapter(getFragmentManager() , pageSource);
                pager.setAdapter(adapter);

            }
        });
    }

    private void initPages(){

        PortfolioCarousel pfc;

        PortFolio pf;

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/films/films.jpg");
        pf.setGeneralDesc(R.string.film_gen_text);
        pf.setTag(AppConstant.FILM_TAG );

        pfc = PortfolioCarousel.newInstance(pf);
        pageSource.add(pfc);

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/contents/content_writing.jpg");
        pf.setGeneralDesc(R.string.content_writing_gen_text);
        pf.setTag(AppConstant.CONTENT_TAG);

        pfc = PortfolioCarousel.newInstance(pf);
        pageSource.add(pfc);

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/graphics/graphic_design.jpg");
        pf.setGeneralDesc(R.string.graphics_gen_text );
        pf.setTag(AppConstant.GRAPHICS_TAG);

        pfc = PortfolioCarousel.newInstance(pf);
        pageSource.add(pfc);

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/ict/ict.jpg");
        pf.setGeneralDesc(R.string.ict_gen_text);
        pf.setTag(AppConstant.ICT_TAG);

        pfc = PortfolioCarousel.newInstance(pf);
        pageSource.add(pfc);

    }

    private void initConstPages(){

        Map<Integer , PortFolio> consData = AppConstant.getConsultancyData();
        PortfolioCarousel pfc;

        pfc = PortfolioCarousel.newInstance(consData.get(R.string.amartaka_hdr));
        pageSource.add(pfc);

        pfc = PortfolioCarousel.newInstance(consData.get(R.string.ritu_hdr));
        pageSource.add(pfc);

        pfc = PortfolioCarousel.newInstance(consData.get(R.string.image_hdr));
        pageSource.add(pfc);

        pfc = PortfolioCarousel.newInstance(consData.get(R.string.sharenet_hdr));
        pageSource.add(pfc);
    }


    @Override
    public void onDestroyView() {
        pageSource.clear();
        super.onDestroyView();
    }
}
