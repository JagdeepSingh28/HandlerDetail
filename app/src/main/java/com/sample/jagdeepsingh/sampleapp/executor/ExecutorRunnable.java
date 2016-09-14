package com.sample.jagdeepsingh.sampleapp.executor;

import android.util.Log;

import static java.lang.Thread.sleep;

/**
 * Created by JagdeepSingh on 25-07-2016.
 */
public class ExecutorRunnable implements Runnable {

    private static final String TAG = ExecutorRunnable.class.getSimpleName();
    String threadName;

    ExecutorRunnable(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            Log.i(TAG, "run: "+ Thread.currentThread().getName() + "Start Command" + threadName);
            sleep(5000);
            Log.i(TAG, "run: "+ Thread.currentThread().getName() + "End Command");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return threadName.toString();
    }
}
