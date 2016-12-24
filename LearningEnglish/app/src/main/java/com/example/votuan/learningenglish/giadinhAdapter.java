
package com.example.votuan.learningenglish;

/**
 * Created by HOANGNAM-PC on 12/23/2016.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class giadinhAdapter extends BaseAdapter{
    private Context context;
    private final String[] list;

    public giadinhAdapter(Context context, String[] danhsach) {
        this.context = context;
        this.list = danhsach;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from start.xml
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
        if (vitri.equals("Farther")) {
            imageView.setImageResource(R.drawable.bo);
        } else if (vitri.equals("Mother")) {
            imageView.setImageResource(R.drawable.me);
        } else if (vitri.equals("Grandfather")) {
            imageView.setImageResource(R.drawable.ong);
        } else if (vitri.equals("Grandmother")) {
            imageView.setImageResource(R.drawable.ba);
        } else if (vitri.equals("Uncle")) {
            imageView.setImageResource(R.drawable.cau);
        } else if (vitri.equals("Aunt")) {
            imageView.setImageResource(R.drawable.co);
        } else if (vitri.equals("Sister")) {
            imageView.setImageResource(R.drawable.chi);
        } else if (vitri.equals("Brother")) {
            imageView.setImageResource(R.drawable.anhtrai);
        } else if(vitri.equals("Son"))
        {
            imageView.setImageResource(R.drawable.contrai);
        } else  if(vitri.equals("Daughter")){
            imageView.setImageResource(R.drawable.congai);
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


