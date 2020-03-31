package com.example.screennavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ImageFragment extends Fragment {
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_image, container, false);
        return rootView;
    }

    public void setImage(int index) {
        ImageView imageView = rootView.findViewById(R.id.imageView);

        switch (index) {
            case 1:
                imageView.setImageResource(R.drawable.sample1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.sample2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.sample3);
                break;
        }
    }
}
