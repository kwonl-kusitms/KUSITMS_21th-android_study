package com.example.networkpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String TAG = MainActivity.class.getSimpleName();
    EditText urlText;
    TextView contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlText = findViewById(R.id.urlText);
        contentView = findViewById(R.id.contentView);

        Button fetchButton = findViewById(R.id.fetchButton);
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 웹 페이지 불러오기
                /*
                String url = urlText.getText().toString();
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                StringRequest request = new StringRequest(
                        Request.Method.GET,
                        url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                contentView.setText(response);
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
                */

                // REST API 불러오기
                String url = "https://jsonplaceholder.typicode.com/users";
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                JsonArrayRequest request = new JsonArrayRequest(
                        Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                contentView.setText("");
                                for (int i = 0; i < response.length(); i++) {
                                    try {
                                        JSONObject object = (JSONObject) response.get(i);
                                        contentView.append(object.getString("name") + "\n\n");
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
            }
        });
    }
}
