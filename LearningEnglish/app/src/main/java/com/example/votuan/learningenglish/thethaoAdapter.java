package com.example.votuan.learningenglish;

/**
 * Created by VoTuan on 12/23/2016.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class thethaoAdapter extends BaseAdapter{
    private Context context;
    private final String[] list;

    public thethaoAdapter(Context context, String[] danhsach) {
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
            case "Badminton": imageView.setImageResource(R.drawable.badminton); break;
            case "Baseball": imageView.setImageResource(R.drawable.baseball); break;
            case "Basketball": imageView.setImageResource(R.drawable.basketball); break;
            case "Boxing": imageView.setImageResource(R.drawable.boxing); break;
            case "Climbing": imageView.setImageResource(R.drawable.climbing); break;
            case "Cycling": imageView.setImageResource(R.drawable.cycling); break;
            case "Fencing": imageView.setImageResource(R.drawable.fencing); break;
            case "Fishing": imageView.setImageResource(R.drawable.fishing); break;
            case "Golf": imageView.setImageResource(R.drawable.golf); break;
            case "Ice-skating": imageView.setImageResource(R.drawable.iceskating); break;
            case "Karate": imageView.setImageResource(R.drawable.karate); break;
            case "Motor-racing": imageView.setImageResource(R.drawable.motorracing); break;
            case "Skiing": imageView.setImageResource(R.drawable.skiing); break;
            case "Soccer": imageView.setImageResource(R.drawable.soccer); break;
            case "Surfing": imageView.setImageResource(R.drawable.surfing); break;
            case "Swimming": imageView.setImageResource(R.drawable.swimming); break;
            case "Tennis": imageView.setImageResource(R.drawable.tennis); break;
            case "Yoga": imageView.setImageResource(R.drawable.yoga); break;
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
