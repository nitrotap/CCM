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

public class qBrainfog extends Fragment {
    public static String answer_qbrainfog;

    public qBrainfog() {
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
        View v = inflater.inflate(R.layout.fragment_q_brainfog, container, false);

        Button button = v.findViewById(R.id.button_qbrainfog);
        button.setOnClickListener(view1 -> {
            radioGroupCheckedYesNo(view1);
            try {
                Toast.makeText(getActivity(),
                        "Answer Saved: " + answer_qbrainfog,
                        Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
            }

            FragmentManager fm1 = getParentFragmentManager();
            FragmentTransaction ft1 = fm1.beginTransaction();
            ft1.replace(R.id.fragmentContainerView, q3questions_repeat.class, null);
            ft1.commit();
        });

        return v;
    }

    public void radioGroupCheckedYesNo(View view) {
        RadioGroup radioGroup = getActivity().findViewById(R.id.radioGroup_yesno1);
        int checked = radioGroup.getCheckedRadioButtonId();
        if (checked == R.id.radioButton_qbrainfogyes) {
            answer_qbrainfog = "Yes";
        } else if (checked == R.id.radioButton_qbrainno) {
            answer_qbrainfog = "No";
        } else {
            answer_qbrainfog = "Not Answered";
        }
    }
}