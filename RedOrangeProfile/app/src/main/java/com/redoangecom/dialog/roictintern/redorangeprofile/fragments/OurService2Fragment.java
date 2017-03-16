package com.redoangecom.dialog.roictintern.redorangeprofile.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.LinkagePager;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.redoangecom.dialog.roictintern.redorangeprofile.adapters.ServicePagerAdapter;
import com.redoangecom.dialog.roictintern.redorangeprofile.models.MyPageTransformer;

import java.util.ArrayList;

import me.crosswall.lib.coverflow.core.LinkageCoverTransformer;
import me.crosswall.lib.coverflow.core.LinkagePagerContainer;
import me.crosswall.lib.coverflow.core.PageItemClickListener;

/**
 * Created by Nutrino on 12/17/2016.
 */

public class OurService2Fragment extends Fragment {

    private TextView serviceHeader;
    private Typeface customFont;
    private RelativeLayout srvcPgrContainer;
    private ViewPager srvcPager;
    private ServicePagerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View srvcView = inflater.inflate(R.layout.fragment_our_service2 , container , false);

        serviceHeader = (TextView) srvcView.findViewById(R.id.serviceHeader);
        customFont = Typeface.createFromAsset(getActivity().getAssets() , getActivity().getResources().getString(R.string.myFont));
        serviceHeader.setTypeface(customFont , Typeface.BOLD);

        srvcPgrContainer = (RelativeLayout) srvcView.findViewById(R.id.srvcPgrContainer);
        srvcPager = (ViewPager) srvcView.findViewById(R.id.srvcPgr);
        adapter = new ServicePagerAdapter(getFragmentManager() , getPage());

        srvcPgrContainer.setClipChildren(false);
        srvcPager.setAdapter(adapter);
        srvcPager.setOffscreenPageLimit(adapter.getCount());
        srvcPager.setPageTransformer(false , new MyPageTransformer());


        return srvcView;
    }

    private ArrayList<Fragment> getPage(){

        ArrayList<Fragment> pageSource = new ArrayList<>();

        pageSource.add(new ServicePage1());
        pageSource.add(new ServicePage2());
        pageSource.add(new ServicePage3());
        pageSource.add(new ServicePage4());

        return pageSource;
    }
}
