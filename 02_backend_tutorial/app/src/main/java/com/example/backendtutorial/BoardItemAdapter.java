package com.example.backendtutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BoardItemAdapter extends BaseAdapter {
    Context context;
    ArrayList<BoardItemData> items;

    public BoardItemAdapter(Context context, ArrayList<BoardItemData> items) {
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View board_item = inflater.inflate(R.layout.board_item, parent, false);

        TextView title = board_item.findViewById(R.id.titleView);
        TextView content = board_item.findViewById(R.id.contentView);
        title.setText(items.get(position).title);
        content.setText(items.get(position).content);

        return board_item;
    }
}
