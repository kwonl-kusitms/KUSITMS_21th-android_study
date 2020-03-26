package com.example.instagramfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox likeButton1 = findViewById(R.id.likeButton1);
        likeButton1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView likeTextView1 = findViewById(R.id.likeTextView1);
                if (isChecked)
                    likeTextView1.setText("좋아요 101개");
                else
                    likeTextView1.setText("좋아요 100개");
            }
        });
    }
}
