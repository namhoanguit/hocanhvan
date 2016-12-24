
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

public class cotheAdapter extends BaseAdapter{
    private Context context;
    private final String[] list;

    public cotheAdapter(Context context, String[] danhsach) {
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
        if (vitri.equals("Arm")) {
            imageView.setImageResource(R.drawable.cuitro);
        } else if (vitri.equals("Calf")) {
            imageView.setImageResource(R.drawable.chan);
        } else if (vitri.equals("Chin")) {
            imageView.setImageResource(R.drawable.camnguoi);
        } else if (vitri.equals("Cheeks")) {
            imageView.setImageResource(R.drawable.ma);
        } else if (vitri.equals("Ear")) {
            imageView.setImageResource(R.drawable.tai);
        } else if (vitri.equals("Elbow")) {
            imageView.setImageResource(R.drawable.cuitro);
        } else if (vitri.equals("Eye")) {
            imageView.setImageResource(R.drawable.mat);
        } else if (vitri.equals("Eyebrow")) {
            imageView.setImageResource(R.drawable.longmay);
        } else if(vitri.equals("Eyelashes"))
        {
            imageView.setImageResource(R.drawable.longmy);
        } else  if(vitri.equals("Finger")){
            imageView.setImageResource(R.drawable.ngontay);
        } else if (vitri.equals("Fist")) {
            imageView.setImageResource(R.drawable.namdam);
        } else if (vitri.equals("Foot")) {
            imageView.setImageResource(R.drawable.chan);
        } else if (vitri.equals("Forehead")) {
            imageView.setImageResource(R.drawable.tran);
        } else if (vitri.equals("Gums")) {
            imageView.setImageResource(R.drawable.moi);
        } else if (vitri.equals("Hair")) {
            imageView.setImageResource(R.drawable.toc);
        } else if (vitri.equals("Hand")) {
            imageView.setImageResource(R.drawable.canhtay);
        } else if (vitri.equals("Head")) {
            imageView.setImageResource(R.drawable.dau);
        } else if(vitri.equals("Heel"))
        {
            imageView.setImageResource(R.drawable.got);
        } else  if(vitri.equals("Index Finger")){
            imageView.setImageResource(R.drawable.ngontro);
        } else  if(vitri.equals("Iris")){
            imageView.setImageResource(R.drawable.mat);
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


