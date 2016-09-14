package com.sample.jagdeepsingh.sampleapp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 * Created by JagdeepSingh on 23-07-2016.
 */
public class MyLooperThread extends Thread {

    private static final String TAG = MyLooperThread.class.getSimpleName();
    public Handler handler;
    private Looper looper;

    @Override
    public void run() {
        looper = Looper.myLooper();
        Looper.prepare();

        Log.i(TAG, "run: ");
        
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Log.i(TAG, "handleMessage: ");
            }
        };

        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "run: from the runnable w");
            }
        });

        Looper.loop();
    }

    void onDestroyActivity(){
        handler.getLooper().quit();
    }
}
