package com.example.instagramnavigation;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FeedItemAdapter extends BaseAdapter {
    private static final String TAG = FeedItemAdapter.class.getSimpleName();
    Context context;
    ArrayList<FeedItemData> items;

    public FeedItemAdapter(Context context, ArrayList<FeedItemData> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.feed_item, parent, false);

        final FeedItemData feedItem = (FeedItemData) getItem(position);

        final TextView likeTextView = view.findViewById(R.id.likeTextView);
        likeTextView.setText(String.format("좋아요 %d개", feedItem.getLike()));

        TextView contentView = view.findViewById(R.id.contentView);
        contentView.setText(feedItem.getContent());

        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageBitmap(feedItem.getImage());

        CheckBox likeButton = view.findViewById(R.id.likeButton);
        likeButton.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    feedItem.setLike(feedItem.getLike() + 1);
                    likeTextView.setText(String.format("좋아요 %d개", feedItem.getLike()));

                    Toast.makeText(context, "좋아요를 눌렀습니다!", Toast.LENGTH_SHORT).show();
                } else {
                    feedItem.setLike(feedItem.getLike() - 1);
                    likeTextView.setText(String.format("좋아요 %d개", feedItem.getLike()));

                    Toast.makeText(context, "좋아요를 취소했습니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView largeView = view.findViewById(R.id.detailButton);
        largeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("imageId", feedItem.getImage());
                intent.putExtra("content", feedItem.getContent());
                intent.putExtra("like", feedItem.getLike());

                context.startActivity(intent);
            }
        });

        return view;
    }
}
