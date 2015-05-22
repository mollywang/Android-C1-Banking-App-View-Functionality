package com.mollywang.c1_hack_android;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mollywang.c1_hack_android.DummyData.DummyDataDetails;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonthDetailFragment extends Fragment {

    View view;
    LinearLayout janView;
    LinearLayout marView;
    LinearLayout mayView;
    int rangeDiff;
    int counter = 0;
    int min;
    int max;

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
        final RangeSeekBar<Integer> rangeSeekBar = new RangeSeekBar<Integer>(getActivity());
        // Set the range
        rangeSeekBar.setRangeValues(1, 31);
        //rangeSeekBar.setSelectedMinValue(1);
        //rangeSeekBar.setSelectedMaxValue(31);



        view = inflater.inflate(R.layout.fragment_month_detail, container, false);

        janView = (LinearLayout) view.findViewById(R.id.janView);
        janView.setVisibility(View.INVISIBLE);

        marView = (LinearLayout) view.findViewById(R.id.marView);
        marView.setVisibility(View.INVISIBLE);

        mayView = (LinearLayout) view.findViewById(R.id.mayView);
        mayView.setVisibility(View.INVISIBLE);

        Button button = (Button) view.findViewById(R.id.enterButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                rangeSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
                    @Override
                    public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                        // handle changed range values
                        //Log.i(TAG, "User selected new range values: MIN=" + minValue + ", MAX=" + maxValue);
                        min = minValue;
                        max = maxValue;
                    }
                });

                view.invalidate();
                janView.setVisibility(View.INVISIBLE);
                marView.setVisibility(View.INVISIBLE);
                mayView.setVisibility(View.INVISIBLE);

                //int min = rangeSeekBar.getSelectedMinValue(); //ERROR: val fixed at 1
                //int max = rangeSeekBar.getSelectedMaxValue(); //ERROR: val fixed at 31

                //rangeDiff = max - min;

                if (counter == 0) {
                    janView.setVisibility(View.VISIBLE);
                    counter++;
                }
                else if (counter == 1) {
                    janView.setVisibility(View.INVISIBLE);

                    marView.setVisibility(View.VISIBLE);
                    counter++;
                }
                else {
                    marView.setVisibility(View.INVISIBLE);

                    mayView.setVisibility(View.VISIBLE);
                    counter++;
                }




                // Perform action on click
            }

        });

        TextView entry1 = (TextView) view.findViewById(R.id.entry1);
        entry1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentJanView = new Intent(MonthDetailFragment.this.getActivity(),
                        DummyDataDetails.class);
                startActivity(intentJanView);
            }
        });

        TextView entry51 = (TextView) view.findViewById(R.id.entry51);
        entry51.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentJanView = new Intent(MonthDetailFragment.this.getActivity(),
                        DummyDataDetails.class);
                startActivity(intentJanView);
            }
        });

        return view;
        //return inflater.inflate(R.layout.fragment_month_detail, container, false);
    }


}

