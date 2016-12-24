package com.example.votuan.learningenglish;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class bangchucaiAdapter extends BaseAdapter {
    private Context context;
    private final String[] list;

    public bangchucaiAdapter(Context context, String[] danhsach) {
        this.context = context;
        this.list = danhsach;
    }

    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // Lấy về layout
            gridView = inflater.inflate(R.layout.layout_bangchucaidetail, null);

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

        if (vitri.equals("A")) {
            imageView.setImageResource(R.drawable.a);
        } else if (vitri.equals("B")) {
            imageView.setImageResource(R.drawable.b);
        } else if (vitri.equals("C")) {
            imageView.setImageResource(R.drawable.c);
        } else if (vitri.equals("D")) {
            imageView.setImageResource(R.drawable.d);
        } else if (vitri.equals("E")) {
            imageView.setImageResource(R.drawable.e);
        } else if (vitri.equals("F")) {
            imageView.setImageResource(R.drawable.f);
        } else if (vitri.equals("G")) {
            imageView.setImageResource(R.drawable.g);
        } else if (vitri.equals("H")) {
            imageView.setImageResource(R.drawable.h);
        }else if (vitri.equals("I")) {
            imageView.setImageResource(R.drawable.i);
        } else if (vitri.equals("J")) {
            imageView.setImageResource(R.drawable.j);
        } else if (vitri.equals("K")) {
            imageView.setImageResource(R.drawable.k);
        } else if (vitri.equals("L")) {
            imageView.setImageResource(R.drawable.l);
        } else if (vitri.equals("M")) {
            imageView.setImageResource(R.drawable.m);
        } else if (vitri.equals("N")) {
            imageView.setImageResource(R.drawable.n);
        } else if (vitri.equals("O")) {
            imageView.setImageResource(R.drawable.o);
        } else if (vitri.equals("P")) {
            imageView.setImageResource(R.drawable.p);
        } else if (vitri.equals("Q")) {
            imageView.setImageResource(R.drawable.q);
        } else if (vitri.equals("R")) {
            imageView.setImageResource(R.drawable.r);
        } else if (vitri.equals("S")) {
            imageView.setImageResource(R.drawable.s);
        } else if (vitri.equals("T")) {
            imageView.setImageResource(R.drawable.t);
        } else if (vitri.equals("U")) {
            imageView.setImageResource(R.drawable.u);
        } else if (vitri.equals("V")) {
            imageView.setImageResource(R.drawable.v);
        } else if (vitri.equals("W")) {
            imageView.setImageResource(R.drawable.w);
        } else if (vitri.equals("X")) {
            imageView.setImageResource(R.drawable.x);
        } else if (vitri.equals("Y")) {
            imageView.setImageResource(R.drawable.y);
        } else {
            imageView.setImageResource(R.drawable.z);
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
