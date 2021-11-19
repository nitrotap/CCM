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

public class qYear extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static String answer_qyear;


    public qYear() {
        // Required empty public constructor
    }

    public static qYear newInstance() {
        qYear fragment = new qYear();
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
        View view = inflater.inflate(R.layout.fragment_q_year, container, false);

        Button button = view.findViewById(R.id.button_qyear);
        button.setOnClickListener(view1 -> {

            EditText editText = view.findViewById(R.id.editTextNumber_qyearanswer);
            answer_qyear = editText.getText().toString();

            try {
                Toast.makeText(getActivity(),
                        "Answer Saved: " + answer_qyear,
                        Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
            }

            FragmentManager fm1 = getParentFragmentManager();
            FragmentTransaction ft1 = fm1.beginTransaction();
            ft1.replace(R.id.fragmentContainerView, qGrandthoughts.class, null); // todo update with next fragment
            ft1.commit();

        });

        return view;
    }
}