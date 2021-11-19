package com.ccm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;


public class qDayofweek extends Fragment {

    String answer_dayofweek;


    public qDayofweek() {
        // Required empty public constructor
    }


    public static qDayofweek newInstance() {
        qDayofweek fragment = new qDayofweek();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_q_dayofweek, container, false);

        Button firstButton = view.findViewById(R.id.button_qDayofweek);
        firstButton.setOnClickListener(view1 -> {
            radioGroupCheckedWeek(view1);

            try {
                Toast.makeText(getActivity(), "Answer Saved: " + answer_dayofweek, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
            }

            FragmentManager fm1 = getParentFragmentManager();
            FragmentTransaction ft1 = fm1.beginTransaction();
            ft1.replace(R.id.fragmentContainerView, q3questions.class, null);
            ft1.commit();

        });

        return view;
    }

    private void radioGroupCheckedWeek(View view) {
        RadioGroup radioGroup = getActivity().findViewById(R.id.radioGroupWeek);
        int checked = radioGroup.getCheckedRadioButtonId();
        if (checked == R.id.radioButton_sunday) {
            answer_dayofweek = "Sunday";
        } else if (checked == R.id.radioButton_monday) {
            answer_dayofweek = "Monday";
        } else if (checked == R.id.radioButton_tuesday) {
            answer_dayofweek = "Tuesday";
        } else if (checked == R.id.radioButton_wednesday) {
            answer_dayofweek = "Wednesday";
        } else if (checked == R.id.radioButton_thursday) {
            answer_dayofweek = "Thursday";
        } else if (checked == R.id.radioButton_friday) {
            answer_dayofweek = "Friday";
        } else if (checked == R.id.radioButton_saturday) {
            answer_dayofweek = "Saturday";
        } else {
            answer_dayofweek = "Not Answered";
        }


    }






}