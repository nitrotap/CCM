package com.ccm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class qGrandthoughts extends Fragment {


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




        return view;
    }
}