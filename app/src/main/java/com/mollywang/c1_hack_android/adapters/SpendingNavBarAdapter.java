package com.mollywang.c1_hack_android.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by MollyWang on 5/21/15.
 */

public class SpendingNavBarAdapter extends FragmentStatePagerAdapter {

    public SpendingNavBarAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) { //returns a view
        switch(position) {
            case 0: //Overview
                return null; //need either return or break

            case 1: //Budget
                return null;

            //NEED AS MANY PAGES
            //create a fragment for every page

        }
        return null;
    }

    @Override
    public int getCount() { //how many pages you want to have
        return 2; //overview + budget
    }
}
