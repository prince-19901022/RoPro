package com.redoangecom.dialog.roictintern.redorangeprofile.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by roictintern on 01-Jan-17.
 */

public class PortfolioPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> pageSource;

    public PortfolioPagerAdapter(FragmentManager fm, ArrayList<Fragment> pageSource) {
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
