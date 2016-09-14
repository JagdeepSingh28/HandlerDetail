package com.sample.jagdeepsingh.sampleapp.HandlerThread;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

/**
 * Created by JagdeepSingh on 24-07-2016.
 */
public class MyHandlerThread extends HandlerThread {

    private static final String TAG = HandlerMainActivity.class.getSimpleName();
    Handler handlerThread;

    public MyHandlerThread(String name) {
        super(name);
    }

    public MyHandlerThread(String name, int priority) {
        super(name, priority);
    }

    public void prepareHanldler(){
        handlerThread = new Handler(getLooper());
    }

    public void executeRunnable(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                    Log.i(TAG, "run: " + Math.random());
                }catch(InterruptedException e){
                    
                }
            }
        };

        handlerThread.post(runnable);
    }

}
