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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link q3questions#newInstance} factory method to
 * create an instance of this fragment.
 */
public class q3questions extends Fragment {

    public static String q3questionsanswer1;
    public static String q3questionsanswer2;
    public static String q3questionsanswer3;

    public q3questions() {
        // Required empty public constructor
    }

    public static q3questions newInstance() {
        q3questions fragment = new q3questions();
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
        View view = inflater.inflate(R.layout.fragment_q3questions, container, false);

        Button secondButton = view.findViewById(R.id.button_q3questions);
        secondButton.setOnClickListener(v -> {
            EditText editText = getActivity().findViewById(R.id.q3answer1);
            q3questionsanswer1 = editText.getText().toString();

            EditText editText1 = getActivity().findViewById(R.id.q3answer2);
            q3questionsanswer2 = editText1.getText().toString();

            EditText editText2 = getActivity().findViewById(R.id.q3answer3);
            q3questionsanswer3 = editText2.getText().toString();




            try {
                Toast.makeText(getActivity(),
                        "Answer Saved: " + q3questionsanswer1 + ", " + q3questionsanswer2 + ", " + q3questionsanswer3,
                        Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
            }

            FragmentManager fm1 = getParentFragmentManager();
            FragmentTransaction ft1 = fm1.beginTransaction();
            ft1.replace(R.id.fragmentContainerView, q3questions.class, null); // todo update with next fragment
            ft1.commit();
        });

        return view;
    }
}