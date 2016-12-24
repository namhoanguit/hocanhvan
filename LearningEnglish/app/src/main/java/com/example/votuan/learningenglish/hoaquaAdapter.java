package com.example.votuan.learningenglish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class hoaquaAdapter extends BaseAdapter {
    private Context context;
    private final String[] list;

    public hoaquaAdapter(Context context, String[] danhsach) {
        this.context = context;
        this.list = danhsach;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout
            gridView = inflater.inflate(R.layout.layout_phatamhoaqua, null);

        } else
            gridView = (View) convertView;

        // set value into textview
        TextView textView = (TextView) gridView
                .findViewById(R.id.grid_item_label);
        textView.setText(list[position]);

        // set image based on selected text
        ImageView imageView = (ImageView) gridView
                .findViewById(R.id.grid_item_image);

        String vitri = list[position];
        switch (vitri)
        {
            case "Oranges": imageView.setImageResource(R.drawable.cam); break;
            case "Banana": imageView.setImageResource(R.drawable.banana); break;
            case "Strawberry": imageView.setImageResource(R.drawable.dautay); break;
            case "Pineapple": imageView.setImageResource(R.drawable.dua); break;
            case "Watermelon": imageView.setImageResource(R.drawable.duahau); break;
            case "Pear": imageView.setImageResource(R.drawable.le); break;
            case "Grapes": imageView.setImageResource(R.drawable.nho); break;
            case "Guava": imageView.setImageResource(R.drawable.oi); break;
            case "Apple": imageView.setImageResource(R.drawable.tao); break;
            case "Mango": imageView.setImageResource(R.drawable.mango); break;
            case "Avocado": imageView.setImageResource(R.drawable.avocado); break;
            case "Grapefruit": imageView.setImageResource(R.drawable.grapefruit); break;
            case "Potato": imageView.setImageResource(R.drawable.potato); break;
            case "Onion": imageView.setImageResource(R.drawable.onion); break;
            case "Pumpkin": imageView.setImageResource(R.drawable.pumpkin); break;
            case "Tomato": imageView.setImageResource(R.drawable.tomato); break;

            case "Corn": imageView.setImageResource(R.drawable.corn); break;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
