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

public class qGrandthoughts extends Fragment {

    public static String answer_qgrand;

    public qGrandthoughts() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static qGrandthoughts newInstance() {
        qGrandthoughts fragment = new qGrandthoughts();
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
        View view = inflater.inflate(R.layout.fragment_q_grandthoughts, container, false);

        Button button = view.findViewById(R.id.button_qgrand);
        button.setOnClickListener(view1 -> {
            radioGroupCheckedYesNo(view1);

            try {
                Toast.makeText(getActivity(),
                        "Answer Saved: " + answer_qgrand,
                        Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
            }

            FragmentManager fm1 = getParentFragmentManager();
            FragmentTransaction ft1 = fm1.beginTransaction();
            ft1.replace(R.id.fragmentContainerView, qSpeedofthought.class, null);
            ft1.commit();

        });


        return view;
    }

    public void radioGroupCheckedYesNo(View view) {
        RadioGroup radioGroup = getActivity().findViewById(R.id.radioGroup_yesno);
        int checked = radioGroup.getCheckedRadioButtonId();
        if (checked == R.id.radioButton_grandyes) {
            answer_qgrand = "Yes";
        } else if (checked == R.id.radioButton_grandno) {
            answer_qgrand = "No";
        } else {
            answer_qgrand = "Not Answered";
        }
    }
}