package com.example.votuan.learningenglish;

/**
 * Created by HOANGNAM-PC on 12/21/2016.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class mausacAdapter extends BaseAdapter{
    private Context context;
    private final String[] list;

    public mausacAdapter(Context context, String[] danhsach) {
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
            gridView = inflater.inflate(R.layout.layout_mausac1, null);

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
        if (vitri.equals("Black")) {
            imageView.setImageResource(R.drawable.black);
        } else if (vitri.equals("Blue")) {
            imageView.setImageResource(R.drawable.blue);
        } else if (vitri.equals("Brown")) {
            imageView.setImageResource(R.drawable.brown);
        } else if (vitri.equals("Prink")) {
            imageView.setImageResource(R.drawable.prink);
        } else if (vitri.equals("Green")) {
            imageView.setImageResource(R.drawable.green);
        } else if (vitri.equals("Red")) {
            imageView.setImageResource(R.drawable.red);
        } else if (vitri.equals("White")) {
            imageView.setImageResource(R.drawable.white);
        } else if (vitri.equals("Yellow")) {
            imageView.setImageResource(R.drawable.yellow);
        } else if(vitri.equals("Purple"))
        {
            imageView.setImageResource(R.drawable.purple);
        } else  if(vitri.equals("Orange")){
            imageView.setImageResource(R.drawable.orange);
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
