package com.sample.jagdeepsingh.sampleapp.executor;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.sample.jagdeepsingh.sampleapp.R;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by JagdeepSingh on 25-07-2016.
 */
public class ExecutorActivity extends Activity {

    private static final String TAG = ExecutorActivity.class.getSimpleName();
    ExecutorService executorService;
    private int MAX_CORE_AVAILABLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MAX_CORE_AVAILABLE = 8;// Runtime.getRuntime().availableProcessors();

        executorService = Executors.newScheduledThreadPool(MAX_CORE_AVAILABLE);

        for (int i = 0; i < 10; i++) {
            executorService.execute(new ExecutorRunnable(" Thread "+i));
        }
        executorService.shutdown();
//        while(!executorService.isTerminated()){
//            Log.i(TAG, "onCreate: executorService not terminated yet");
//        }

        Log.i(TAG, "onCreate: Finished all thread");
    }
}
