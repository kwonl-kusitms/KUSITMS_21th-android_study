package com.example.threadasynctask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();
    TextView progressTextView;
    Handler valueHandler = new ValueHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressTextView = findViewById(R.id.progressTextView);

        // Thread 연습
        /*
        Thread thread = new ValueThread();
        thread.start();
        */

        // AsyncTask
        ProgressTask progressTask = new ProgressTask();
        progressTask.execute("시작");
    }

    class ValueThread extends Thread {
        int value = 0;
        boolean running = false;

        @Override
        public void run() {
            running = true;

            while (running) {
                value += 1;

                // UI 변경은 main thread에서만

                // Handler 방식
                /*
                Message msg = new Message();
                Bundle bundle = new Bundle();
                bundle.putInt("value", value);
                msg.setData(bundle);
                valueHandler.sendMessage(msg);
                */

                // post 방식
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressTextView.setText(Integer.toString(value));
                    }
                });

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class ValueHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            Bundle bundle =  msg.getData();
            int value = bundle.getInt("value", 0);
            progressTextView.setText(Integer.toString(value));
        }
    }

    class ProgressTask extends AsyncTask<String, Integer, Integer> {

        int value = 0;

        @Override
        protected Integer doInBackground(String... strings) {
            while (value < 10) {
                value++;
                publishProgress(value);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return value;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressTextView.setText(Integer.toString(value));
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            progressTextView.setText("완료");
        }
    }
}
