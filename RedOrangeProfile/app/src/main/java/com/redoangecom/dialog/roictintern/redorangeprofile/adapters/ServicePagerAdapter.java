package com.redoangecom.dialog.roictintern.redorangeprofile.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.redoangecom.dialog.roictintern.redorangeprofile.fragments.ServicePage1;

import java.util.ArrayList;

/**
 * Created by Nutrino on 12/17/2016.
 */

public class ServicePagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> pageSource;

    public ServicePagerAdapter(FragmentManager fm , ArrayList<Fragment> pageSource) {
        super(fm);
        this.pageSource = pageSource;
    }

    @Override
    public Fragment getItem(int position) {
        return pageSource.get(position);
    }

    @Override
    public int getCount() {
        return pageSource.size();
    }
}
