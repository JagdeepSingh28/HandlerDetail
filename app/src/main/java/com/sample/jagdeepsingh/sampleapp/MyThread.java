package com.sample.jagdeepsingh.sampleapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by JagdeepSingh on 23-07-2016.
 */
public class MyThread extends Thread {

    private static final String TAG = MyThread.class.getSimpleName();
    private Activity activity;
    public static final String DATA = "DATA";
    Messenger messenger;

    MyThread(Activity activity, Messenger messenger){
        this.activity   = activity;
        this.messenger  = messenger;
    }

    @Override
    public void run() {
//        Handler handler = new Handler(Looper.getMainLooper());

        Looper.prepare();

//        for (int i = 0; i < 10; i++)
        {
            try {
                sleep(5000);

                // showing toast on the main thread
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
                        Toast.makeText(activity, "In the run method", Toast.LENGTH_SHORT).show();
//                        Log.i(TAG,"In the Run Method");
//                    }
//                });

                Looper.loop();
                // sending message data to the main thread

//                double rand = Math.random();
//                Log.i(TAG,"In the Run Method"+rand);
//
//                Bundle bundle = new Bundle();
//                bundle.putString(DATA,rand +"");
//
//                Message message = new Message();
//                message.setData(bundle);
//
//                messenger.send(message);
//              ((MainActivity)activity).handler.sendMessage(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
//            } catch (RemoteException e) {
//                e.printStackTrace();
            }
        }
    }
}
