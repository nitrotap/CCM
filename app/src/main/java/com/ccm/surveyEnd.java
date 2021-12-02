package com.ccm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class surveyEnd extends Fragment {

    public static String surveyUserAnswers;
    public static long surveyEndTime = System.currentTimeMillis();

    public static ArrayList<String> surveyAnswers;

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

        long surveyTime = (surveyEndTime - SurveyActivity.surveyStartTime) / 1000;

        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        String dayOfWeek = String.valueOf(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()));




        surveyUserAnswers = "Day of week: " + qDayofweek.answer_dayofweek + "Correct Answer: " + dayOfWeek +
                "\nGrandiose Thoughts: " + qGrandthoughts.answer_qgrand +
                "\nHappy Speed of Thoughts: " + qSpeedofthought.answer_qthoughtshappy +
                "\nSad Speed of Thoughts: " + qSpeedofthought.answer_qthoughtssad +
                "\nYear: " + qYear.answer_qyear + "Correct Answer: " + year +
                "\nTime Taken: " + surveyTime + " seconds";
        textView.setText(surveyUserAnswers);

        return view;
    }

    public static void surveyGrader() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        String dayOfWeek = String.valueOf(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()));

        // month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        // monthNum = calendar.get(Calendar.MONTH) + 1;
        // dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        // rightDate = String.format(Locale.US, "%02d", monthNum) + String.format(Locale.US, "%02d", dayOfMonth) + year;

    }
    




}