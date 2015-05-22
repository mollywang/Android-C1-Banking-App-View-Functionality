package com.mollywang.c1_hack_android;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Date;

import com.mollywang.c1_hack_android.RangeSeekBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonthDetailFragment extends Fragment {

    private static final String MONTH_NUM = "month_num";

    public MonthDetailFragment() {
        // Required empty public constructor
    }

    //on all methods, gives access to month
    //call get MONTH_NUM (key)
    public static MonthDetailFragment newInstance(String month) {
        MonthDetailFragment fragment = new MonthDetailFragment();
        Bundle args = new Bundle(); //like hashmap
        args.putString(MONTH_NUM, month); //set key,val
        fragment.setArguments(args); //store in mem
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // Setup the new range seek bar
        RangeSeekBar<Integer> rangeSeekBar = new RangeSeekBar<Integer>(getActivity());
        // Set the range
        rangeSeekBar.setRangeValues(1, 31);
        rangeSeekBar.setSelectedMinValue(1);
        rangeSeekBar.setSelectedMaxValue(31);
        return inflater.inflate(R.layout.fragment_month_detail, container, false);

    }

    public void onEnterButtonClick() {

    }

    /*
    private void initialize(View view) {

        Button button = (Button) view.findViewById(R.id.enterButton);
        button.setOnClickListener(new View.onClickListener() {
            public void onClick(View v) {

            }

        }
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {
        initialize(view);
    }
    */
}

