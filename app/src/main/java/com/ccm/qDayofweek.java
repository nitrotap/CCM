package com.ccm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class qDayofweek extends Fragment {

    Button firstButton;


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

        firstButton = view.findViewById(R.id.button);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // q3questions.newInstance();
                FragmentManager fm1 = getParentFragmentManager();
                FragmentTransaction ft1 = fm1.beginTransaction();
                ft1.replace(R.id.fragmentContainerView, q3questions.class, null);
                ft1.commit();

            }
        });
        //todo add toast
        return view;
    }


    public void loadFragment(Fragment fragment) {
        FragmentManager fm = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment);

    }



}