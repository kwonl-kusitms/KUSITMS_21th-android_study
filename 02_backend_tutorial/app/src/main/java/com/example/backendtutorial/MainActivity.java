package com.example.backendtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<BoardItemData> items = new ArrayList<>();
    BoardItemAdapter itemAdapter = new BoardItemAdapter(this, items);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.boardList);
        listView.setAdapter(itemAdapter);

        items.add(new BoardItemData("테스트 제목1", "테스트 콘텐츠"));
        items.add(new BoardItemData("테스트 제목2", "테스트 콘텐츠"));
        items.add(new BoardItemData("테스트 제목3", "테스트 콘텐츠"));
        items.add(new BoardItemData("테스트 제목4", "테스트 콘텐츠"));

        itemAdapter.notifyDataSetChanged();
    }
}
