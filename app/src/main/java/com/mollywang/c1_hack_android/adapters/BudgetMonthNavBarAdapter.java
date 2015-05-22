package com.mollywang.c1_hack_android.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mollywang.c1_hack_android.MonthDetailFragment;

/**
 * Created by MollyWang on 5/21/15.
 */
public class BudgetMonthNavBarAdapter extends FragmentStatePagerAdapter {

    private String[] mMonthTitles;

    public BudgetMonthNavBarAdapter(FragmentManager fm, String[] months) {
        super(fm);
        mMonthTitles = months;
    }

    @Override
    public Fragment getItem(int position) { //returns a view
        return MonthDetailFragment.newInstance(mMonthTitles[position]);

    }

    @Override
    public int getCount() { //how many pages you want to have
        return mMonthTitles.length; //overview + budget
    }

    //POPULATES VIEW PAGER'S TAB HEADERS
    public CharSequence getPageTitle(int position) {
        return mMonthTitles[position]; //return text val
    }
}
