package com.ccm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class q3questions_repeat extends Fragment {

    public static String q3repeatanswer1;
    public static String q3repeatanswer2;
    public static String q3repeatanswer3;


    public q3questions_repeat() {
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
        View v = inflater.inflate(R.layout.fragment_q3questions_repeat, container, false);


        Button button = v.findViewById(R.id.button_q3questions_repeat);
        button.setOnClickListener(view1 -> {
            EditText editText = getActivity().findViewById(R.id.q3answer1_repeat);
            q3repeatanswer1 = editText.getText().toString();

            EditText editText1 = getActivity().findViewById(R.id.q3answer2_repeat);
            q3repeatanswer2 = editText1.getText().toString();

            EditText editText2 = getActivity().findViewById(R.id.q3answer3_repeat);
            q3repeatanswer3 = editText2.getText().toString();
            try {
                Toast.makeText(getActivity(),
                        "Answer Saved: " + q3repeatanswer1 + ", " + q3repeatanswer2 + ", " + q3repeatanswer3,
                        Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
            }

            FragmentManager fm1 = getParentFragmentManager();
            FragmentTransaction ft1 = fm1.beginTransaction();
            ft1.replace(R.id.fragmentContainerView, surveyEnd.class, null);
            ft1.commit();
        });

        return v;
    }
}