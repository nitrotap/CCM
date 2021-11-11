package com.ccm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSurveyButton(View view) {
        startTime = System.currentTimeMillis();
        // Intent intent = new Intent(this, qYear.class);
        // startActivity(intent);

    }


}