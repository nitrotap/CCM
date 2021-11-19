package com.ccm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ccm.qDayofweek.*;

import org.w3c.dom.Text;


public class surveyEnd extends Fragment {



    public surveyEnd() {
        // Required empty public constructor
    }

    public static surveyEnd newInstance(String param1, String param2) {
        surveyEnd fragment = new surveyEnd();
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
        View view = inflater.inflate(R.layout.fragment_survey_end, container, false);


        TextView textView = view.findViewById(R.id.textView_surveyanswers);

        String surveyAnswers = "Day of week: " + qDayofweek.answer_dayofweek +
                "\n Grandiose Thoughts: " + qGrandthoughts.answer_qgrand +
                "\n Happy Speed of Thoughts: " + qSpeedofthought.answer_qthoughtshappy +
                "\n Sad Speed of Thoughts: " + qSpeedofthought.answer_qthoughtssad +
                "\n Year: " + qYear.answer_qyear;



        textView.setText(surveyAnswers);

        return view;
    }
}