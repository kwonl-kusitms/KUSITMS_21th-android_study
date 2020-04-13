package com.example.instagramnavigation;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class FeedFragment extends Fragment {

    private Context activity;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_feed, container, false);

        ListView feedView = rootView.findViewById(R.id.feedView);
        ArrayList<FeedItemData> items = new ArrayList<>();
        FeedItemAdapter feedItemAdapter = new FeedItemAdapter(activity, items);
        feedView.setAdapter(feedItemAdapter);

        items.add(new FeedItemData(R.drawable.sample1, 3, "첫 번째 피드!"));
        items.add(new FeedItemData(R.drawable.sample2, 4, "두 번째 피드!"));
        items.add(new FeedItemData(R.drawable.sample3, 5, "세 번째 피드!"));

        feedItemAdapter.notifyDataSetChanged();

        return rootView;
    }
}
