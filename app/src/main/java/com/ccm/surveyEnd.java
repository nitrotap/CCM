package com.ccm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class surveyEnd extends Fragment {

    public static String surveyUserAnswers;
    public static long surveyEndTime = System.currentTimeMillis();
    public static long surveyTime;
    public static int score;

    public static ArrayList<String> surveyAnswers;

    public surveyEnd() {
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
        View view = inflater.inflate(R.layout.fragment_survey_end, container, false);

        TextView textView = view.findViewById(R.id.textView_surveyanswers);

        surveyTime = (surveyEndTime - SurveyActivity.surveyStartTime) / 1000;

        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        String dayOfWeek = String.valueOf(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()));

        surveyUserAnswers = "Day of week: " + qDayofweek.answer_dayofweek +
                "\nCorrect Answer: " + dayOfWeek + "\n" +
                "\nGrandiose Thoughts: " + qGrandthoughts.answer_qgrand +
                "\nHappy Speed of Thoughts: " + qSpeedofthought.answer_qthoughtshappy +
                "\nSad Speed of Thoughts: " + qSpeedofthought.answer_qthoughtssad +
                "\nBrain Fog: " + qBrainfog.answer_qbrainfog + "\n" +
                "\nYear: " + qYear.answer_qyear + "\nCorrect Answer: " + year + "\n" +
                "\nTime Taken: " + surveyTime + " seconds" + "\n\n" +
                "\n3 Objects Question" +
                "\nYour First Answers: \n" + q3questions.q3questionsanswer1 + " " + q3questions.q3questionsanswer2 + " " + q3questions.q3questionsanswer3 +
                "\n\nYour Second Answers: \n" + q3questions_repeat.q3repeatanswer1 + " " + q3questions_repeat.q3repeatanswer2 + " " + q3questions_repeat.q3repeatanswer3
        ;
        textView.setText(surveyUserAnswers);

        score = 0;
        if (qDayofweek.answer_dayofweek.equals(dayOfWeek)) {
            score++;
        }
        if (qGrandthoughts.answer_qgrand.equals("No")) {
            score++;
        }
        if (qSpeedofthought.answer_qthoughtssad.equals("No")) {
            score++;
        }
        if (qSpeedofthought.answer_qthoughtshappy.equals("No")) {
            score++;
        }
        if (qBrainfog.answer_qbrainfog.equals("No")) {
            score++;
        }
        if (surveyTime < 60) {
            score++;
        }
        if (q3questions.q3questionsanswer1.equals(q3questions_repeat.q3repeatanswer1) || q3questions.q3questionsanswer1.equals(q3questions_repeat.q3repeatanswer2) || q3questions.q3questionsanswer1.equals(q3questions_repeat.q3repeatanswer3)) {
            score++;
        }
        if (q3questions.q3questionsanswer2.equals(q3questions_repeat.q3repeatanswer1) || q3questions.q3questionsanswer2.equals(q3questions_repeat.q3repeatanswer2) || q3questions.q3questionsanswer2.equals(q3questions_repeat.q3repeatanswer3)) {
            score++;
        }
        if (q3questions.q3questionsanswer3.equals(q3questions_repeat.q3repeatanswer1) || q3questions.q3questionsanswer3.equals(q3questions_repeat.q3repeatanswer2) || q3questions.q3questionsanswer3.equals(q3questions_repeat.q3repeatanswer3)) {
            score++;
        }


        String grade;
        if (score >= 6) {
            grade = "No Cognitive Impairment" + "\nScore: " + score;
        } else if (score >= 3) {
            grade = "Mild Cognitive Impairment" + "\nScore: " + score;
        } else {
            grade = "Sever Cognitive Impairment" + "\nScore: " + score;
        }

        TextView textView1 = view.findViewById(R.id.textView_surveygrade);
        textView1.setText(grade);

        try {
            setJson();
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

        Button button = view.findViewById(R.id.button_surveyend);
        button.setOnClickListener(view1 -> {


            try {
                getActivity().onBackPressed();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });


        return view;
    }

    public void setJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Year", qYear.answer_qyear);
            jsonObject.put("Day of Week", qDayofweek.answer_dayofweek);
            jsonObject.put("Grandiose Thoughts", qGrandthoughts.answer_qgrand);
            jsonObject.put("HappySpeed", qSpeedofthought.answer_qthoughtshappy);
            jsonObject.put("SadSpeed", qSpeedofthought.answer_qthoughtssad);
            jsonObject.put("q3objects", q3questions.q3questionsanswer1 + " " + q3questions.q3questionsanswer2 + " " + q3questions.q3questionsanswer3);
            jsonObject.put("q3objects_repeat", q3questions_repeat.q3repeatanswer1 + " " + q3questions_repeat.q3repeatanswer2 + " " + q3questions_repeat.q3repeatanswer3);
            jsonObject.put("Score Answer", score);
            jsonObject.put("Time Taken", surveyTime);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter fos = new BufferedWriter(new FileWriter(getActivity().getExternalFilesDir(null) + "/" + "answerDatabase.txt", true));
            fos.write(String.valueOf(jsonObject));
            fos.newLine();
            fos.close();
            Toast.makeText(getActivity(), "Saved: All Answers", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }






}


