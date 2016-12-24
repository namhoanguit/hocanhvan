package com.example.votuan.learningenglish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class dongvat1 extends BaseAdapter{
    private Context context;
    private final String[] list;

    public dongvat1(Context context, String[] danhsach) {
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
        if (vitri.equals("Dolphin")) {
            imageView.setImageResource(R.drawable.caheo);
        } else if (vitri.equals("Butterfly")) {
            imageView.setImageResource(R.drawable.conbuom);
        } else if (vitri.equals("Elephant")) {
            imageView.setImageResource(R.drawable.convoi);
        } else if (vitri.equals("Panda")) {
            imageView.setImageResource(R.drawable.gautruc);
        } else if (vitri.equals("Hippopotamus")) {
            imageView.setImageResource(R.drawable.hama);
        } else if (vitri.equals("Cat")) {
            imageView.setImageResource(R.drawable.meo);
        } else if (vitri.equals("Turtle")) {
            imageView.setImageResource(R.drawable.rua);
        } else if (vitri.equals("Rabbit")) {
            imageView.setImageResource(R.drawable.tho);
        }
         else if (vitri.equals("Dog")) {
            imageView.setImageResource(R.drawable.concho);
        }
        else if (vitri.equals("Bee")) {
            imageView.setImageResource(R.drawable.conong);
        }
        else if (vitri.equals("Tiger")) {
            imageView.setImageResource(R.drawable.conho);
        }
        else if (vitri.equals("Lion")) {
            imageView.setImageResource(R.drawable.consutu);
        }
        else if (vitri.equals("Duck")) {
            imageView.setImageResource(R.drawable.convit);
        }
        else if (vitri.equals("Chicken")) {
            imageView.setImageResource(R.drawable.conga);
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
