package com.example.intentpractice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SimpleService extends Service {
    private static String TAG = "SimpleService";

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: called");

        Log.d(TAG, "onStartCommand: command is " + intent.getStringExtra("command"));
        Log.d(TAG, "onStartCommand: command is " + intent.getStringExtra("none"));

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: called");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // 잘 사용하지 않습니다. 보통 main worker에서 IPC로 소통할 때 사용.
        return null;
    }
}
