package com.example.instagramnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        ((TextView) findViewById(R.id.contentView)).setText(intent.getStringExtra("content"));
        ((ImageView) findViewById(R.id.imageView)).setImageResource(intent.getIntExtra("imageId", 0));
        ((TextView) findViewById(R.id.likeTextView)).setText(String.format("좋아요 %d개", intent.getIntExtra("like", 0)));
        findViewById(R.id.detailButton).setVisibility(View.INVISIBLE);

        TextView commentView = findViewById(R.id.commentView);
    }
}
