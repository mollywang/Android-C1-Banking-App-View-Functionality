package com.mollywang.c1_hack_android;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import com.mollywang.c1_hack_android.adapters.BudgetMonthNavBarAdapter;
import com.mollywang.c1_hack_android.com.sliding.tabs.SlidingTabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class BudgetFragment extends Fragment {


    private String[] mMonthTitles = {
            "Jan 2015",
            "Feb 2015",
            "Mar 2015",
            "April 2015",
            "May 2015",
            "June 2015",
            "July 2015",
            "Sept 2015",
            "Oct 2015",
            "Nov 2015",
            "Dec 2015"
    };

    public BudgetFragment() {
        // Required empty public constructor
    }



    /*
    * BUNDLES: bunch of stuff you want to access later
    * basically like a hashmap
    *
    * */

     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_budget, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initialize(view);
    }

    private void initialize(View view) {
        //Set up view pager
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        BudgetMonthNavBarAdapter adapter = new BudgetMonthNavBarAdapter(getActivity().
                getSupportFragmentManager(), mMonthTitles);
        viewPager.setAdapter(adapter);

        //Set up sliding tab layout
        SlidingTabLayout mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        //mSlidingTabLayout.setCustomTabView(R.layout.session_tab, R.id.tv_title);
        //mSlidingTabLayout.setDividerColors(getResources().getColor(R.color.medium_white));
        //mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.medium_white));
        mSlidingTabLayout.setViewPager(viewPager);
    }

    public static Fragment newInstance(int i) {
        BudgetFragment fragment = new BudgetFragment();
        return fragment;

    }


}
