package com.example.instagramnavigation;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class FeedFragment extends Fragment {
    private String TAG = FeedFragment.class.getSimpleName();
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
        final ArrayList<FeedItemData> items = new ArrayList<>();
        final FeedItemAdapter feedItemAdapter = new FeedItemAdapter(activity, items);
        feedView.setAdapter(feedItemAdapter);

        final RequestQueue requestQueue = Volley.newRequestQueue(activity);

        String url = "https://raw.githubusercontent.com/kwonl-kusitms/api-for-assignment/master/feed.json";
        JsonArrayRequest request = new JsonArrayRequest(
                url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                final JSONObject object = (JSONObject) response.get(i);
                                ImageRequest imageRequest = new ImageRequest(
                                        object.getString("image"),
                                        new Response.Listener<Bitmap>() {
                                            @Override
                                            public void onResponse(Bitmap response) {
                                                try {
                                                    items.add(new FeedItemData(
                                                            response,
                                                            object.getInt("like"),
                                                            object.getString("content")
                                                    ));
                                                    feedItemAdapter.notifyDataSetChanged();
                                                } catch (JSONException e) {
                                                    Log.d(TAG, "onResponse: " + e.getMessage());
                                                }
                                            }
                                        }, 0, 0, null, Bitmap.Config.RGB_565,
                                        new Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                Log.d(TAG, "onErrorResponse: " + error.getMessage());
                                            }
                                        }
                                );
                                requestQueue.add(imageRequest);
                            } catch (JSONException e) {
                                Log.d(TAG, "onResponse: " + e.getMessage());
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse: " + error.getMessage());
                    }
                }
        );
        requestQueue.add(request);

        return rootView;
    }
}
