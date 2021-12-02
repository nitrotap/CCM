package com.ccm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class SurveyActivity extends AppCompatActivity {

    FragmentManager fm;
    public static long surveyStartTime = System.currentTimeMillis();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        fm = getSupportFragmentManager();

    }












}