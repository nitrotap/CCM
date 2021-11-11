package com.ccm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static long startTime;
    public static ArrayList<String> answers; // todo remove maybe?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void qYear(View view) {
        // Intent intent = new Intent(this, qYear.class);
        startTime = System.currentTimeMillis();
    }
}