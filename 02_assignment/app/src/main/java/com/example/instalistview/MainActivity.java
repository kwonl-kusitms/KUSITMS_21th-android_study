package com.example.instalistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.loadButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ListView feedView = findViewById(R.id.feedView);
                ArrayList<FeedItemData> items = new ArrayList<>();
                FeedItemAdapter feedItemAdapter = new FeedItemAdapter(MainActivity.this, items);
                feedView.setAdapter(feedItemAdapter);

                items.add(new FeedItemData(R.drawable.sample1, 3, "첫 번째 피드!"));
                items.add(new FeedItemData(R.drawable.sample2, 4, "두 번째 피드!"));
                items.add(new FeedItemData(R.drawable.sample3, 5, "세 번째 피드!"));

                feedItemAdapter.notifyDataSetChanged();
            }
        });
    }

    protected void loadData() {

    }
}
