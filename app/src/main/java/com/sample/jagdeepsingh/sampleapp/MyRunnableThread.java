package com.sample.jagdeepsingh.sampleapp;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by JagdeepSingh on 23-07-2016.
 */
public class MyRunnableThread implements Runnable {

    private static final String TAG = MyRunnableThread.class.getSimpleName();
    private final Activity activity;

    MyRunnableThread(Activity activity){
        this.activity = activity;
    }

    @Override
    public void run() {
        Log.i(TAG,"In the Run Method");
        Toast.makeText(activity, "In the run method", Toast.LENGTH_SHORT).show();
    }
}
