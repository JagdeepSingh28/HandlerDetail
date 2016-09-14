package com.sample.jagdeepsingh.sampleapp;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView sampleBtn;
    private TextView sampleBtnQuit;

    public Handler handler;
    Messenger messenger;
    Handler uiHandler = new Handler();

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Log.i(TAG, "handleMessage: ");
                Bundle bundle = msg.getData();
                sampleBtn.setText(bundle.getString(MyThread.DATA)+"");
            }
        };
        messenger = new Messenger(handler);

        final MyThread myThread = new MyThread(MainActivity.this, messenger);
        sampleBtn = (TextView) findViewById(R.id.sampleBtn);
        sampleBtnQuit = (TextView) findViewById(R.id.sampleBtnQuit);


        MessageQueue messageQueue = Looper.getMainLooper().getQueue();
        messageQueue.addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                // queueIdle() will be called when the message queue has run out of messages and has to wait for more
                /*
                * If you return true from the method then your handler will be active and
                * keep on getting called for further successive idle time slots.
                * If false is returned then it becomes inactive and gets removed (same as calling removeIdleHandler()).
                * */
                return false;
            }
        });
//        myThread.start();

//        Looper.getMainLooper().setMessageLogging(new LogPrinter(Log.DEBUG, TAG));

//        uiHandler.post(new MyRunnableThread(MainActivity.this));
//        uiHandler.post(new MyRunnableThread(MainActivity.this));

        final MyLooperThread myLooperThread = new MyLooperThread();
        myLooperThread.start();

        sampleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("data","data");

                Message message = new Message();
                message.setData(bundle);

                myLooperThread.handler.sendMessage(message);
//                myThread.start();
            }
        });

        sampleBtnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myLooperThread.onDestroyActivity();
            }
        });



    }
}
