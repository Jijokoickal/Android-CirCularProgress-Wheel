package com.example.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.cardinalsolutions.android.arch.autowire.AndroidLayout;

@AndroidLayout(R.layout.layout_progress)
public class MainActivity extends Activity {

	private CircularProgressView mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgress = (CircularProgressView) findViewById(R.id.mProgressBar);
        mProgress.initTimer();



    }

}
