package com.example.votuan.learningenglish;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class sodemAdapter extends BaseAdapter {
    private Context context;
    private final String[] list;

    public sodemAdapter(Context context, String[] danhsach) {
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
            gridView = inflater.inflate(R.layout.layout_sodemdetail, null);
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

        if (vitri.equals("Zero")) {
            imageView.setImageResource(R.drawable.i_0);
        } else if (vitri.equals("One")) {
            imageView.setImageResource(R.drawable.i_1);
        } else if (vitri.equals("Two")) {
            imageView.setImageResource(R.drawable.i_2);
        } else if (vitri.equals("Three")) {
            imageView.setImageResource(R.drawable.i_3);
        } else if (vitri.equals("Four")) {
            imageView.setImageResource(R.drawable.i_4);
        } else if (vitri.equals("Five")) {
            imageView.setImageResource(R.drawable.i_5);
        } else if (vitri.equals("Six")) {
            imageView.setImageResource(R.drawable.i_6);
        } else if (vitri.equals("Seven")) {
            imageView.setImageResource(R.drawable.i_7);
        } else if (vitri.equals("Eight")) {
            imageView.setImageResource(R.drawable.i_8);
        } else {
            imageView.setImageResource(R.drawable.i_9);
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
