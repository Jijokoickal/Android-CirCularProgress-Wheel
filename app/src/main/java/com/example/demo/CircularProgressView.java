package com.example.demo;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Jijo on 18-02-2015.
 */
public class CircularProgressView extends LinearLayout {


    private Context mContext;
    private ProgressBar mProgressBar;
    private TextView mTextPercentage;
    private static int percentageCompleted = 0;

    //10 MINUTES
    private static final float TOTAL_TIME = 10 * 60 * 1000;

    public CircularProgressView(Context context) {
        super(context);
        mContext = context;
        iniView();
    }

    public CircularProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mContext = context;
        iniView();
    }


    private void iniView() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_progress, this, true);
        mProgressBar = (ProgressBar) view.findViewById(R.id.circle_progress_bar);
        mProgressBar.setProgress(0);
        mTextPercentage = (TextView) findViewById(R.id.compliance_percentage);


    }

    public void initTimer() {

        new CountDownTimer((long) TOTAL_TIME, 1000) {

            public void onTick(long millisUntilFinished) {
                long secondsRemaining = millisUntilFinished / 1000;
                long secondsCompleted = (long) (TOTAL_TIME / 1000 - secondsRemaining);
                percentageCompleted = (int) ((secondsCompleted / (TOTAL_TIME / 1000)) * 100);
                mProgressBar.setProgress(percentageCompleted);
                mTextPercentage.setText(percentageCompleted + "%");

            }

            public void onFinish() {
                mProgressBar.setProgress(100);
                mTextPercentage.setText(percentageCompleted + "%");
            }
        }.start();


    }
}
