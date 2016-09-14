package com.sample.jagdeepsingh.sampleapp.HandlerThread;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.sample.jagdeepsingh.sampleapp.R;

/**
 * Created by JagdeepSingh on 24-07-2016.
 */
public class HandlerMainActivity extends Activity {

    private static final String TAG = HandlerMainActivity.class.getSimpleName();
    Button post_task_id;
    int NUMBER_OF_CORES;
    MyHandlerThread myHandlerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_main_screen);

        NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

        Log.i(TAG, "onCreate: " + NUMBER_OF_CORES);

        post_task_id = (Button) findViewById(R.id.post_task_id);
        myHandlerThread = new MyHandlerThread("MyHandlerThread");
        myHandlerThread.start();
        myHandlerThread.prepareHanldler();

        post_task_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myHandlerThread.executeRunnable();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myHandlerThread.quit();
    }
}
