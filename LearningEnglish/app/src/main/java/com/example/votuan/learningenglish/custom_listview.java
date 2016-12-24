package com.example.votuan.learningenglish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class custom_listview extends ArrayAdapter<String> {
    Context context;
    int layoutID;
    ArrayList<String> arrayList;
    public custom_listview(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        this.context=context;
        layoutID=resource;
        arrayList=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(layoutID,parent,false);
        TextView tv= (TextView) view.findViewById(R.id.tvcutom_list);
        tv.setText(arrayList.get(position));
        return  view;
    }
}
