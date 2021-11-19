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

public class qSpeedofthought extends Fragment {

    public static String answer_qthoughtshappy;
    public static String answer_qthoughtssad;

    public qSpeedofthought() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_q_speedofthought, container, false);

        Button button = view.findViewById(R.id.button_qspeedofthought);
        button.setOnClickListener(view1 -> {
            radioGroupHappyCheckedYesNo(view);
            radioGroupSadCheckedYesNo(view);

            try {
                Toast.makeText(getActivity(),
                        "Answer Saved: " + answer_qthoughtshappy + ", " + answer_qthoughtssad,
                        Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
            }

            FragmentManager fm1 = getParentFragmentManager();
            FragmentTransaction ft1 = fm1.beginTransaction();
            ft1.replace(R.id.fragmentContainerView, qSpeedofthought.class, null); // todo update
            ft1.commit();

        });


            return view;
    }

    private void radioGroupHappyCheckedYesNo(View view) {
        RadioGroup radioGroup = getActivity().findViewById(R.id.radioGroup_happyyesno);
        int checked = radioGroup.getCheckedRadioButtonId();
        if (checked == R.id.radioButton_thoughthappyyes) {
            answer_qthoughtshappy = "Yes";
        } else if (checked == R.id.radioButton_thoughthappyno) {
            answer_qthoughtshappy = "No";
        } else {
            answer_qthoughtshappy = "Not Answered";
        }
    }

    private void radioGroupSadCheckedYesNo(View view) {
        RadioGroup radioGroup = getActivity().findViewById(R.id.radioGroup_sadyesno);
        int checked = radioGroup.getCheckedRadioButtonId();
        if (checked == R.id.radioButton_thoughtsadyes) {
            answer_qthoughtssad = "Yes";
        } else if (checked == R.id.radioButton_thoughtsadno) {
            answer_qthoughtssad = "No";
        } else {
            answer_qthoughtssad = "Not Answered";
        }
    }
}