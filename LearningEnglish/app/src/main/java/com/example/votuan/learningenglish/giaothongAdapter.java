package com.example.votuan.learningenglish;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class giaothongAdapter extends BaseAdapter {
    private Context context;
    private final String[] list;

    public giaothongAdapter(Context context, String[] danhsach) {
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
            case "Bus": imageView.setImageResource(R.drawable.bus); break;
            case "Canoe": imageView.setImageResource(R.drawable.cano); break;
            case "Ambulance": imageView.setImageResource(R.drawable.capcuu); break;
            case "Fire truck": imageView.setImageResource(R.drawable.cuuhoa); break;
            case "Planes": imageView.setImageResource(R.drawable.maybay); break;
            case "Motorcycles": imageView.setImageResource(R.drawable.moto); break;
            case "Car": imageView.setImageResource(R.drawable.oto); break;
            case "Train": imageView.setImageResource(R.drawable.tauhoa); break;
            case "Taxi": imageView.setImageResource(R.drawable.taxi); break;
            case "Helicopter": imageView.setImageResource(R.drawable.tructhang); break;
            case "Bicycle": imageView.setImageResource(R.drawable.xedap); break;
            case "Crame-truck": imageView.setImageResource(R.drawable.crametruck); break;
            case "Bulldozers": imageView.setImageResource(R.drawable.bulldozers); break;
            case "Ship": imageView.setImageResource(R.drawable.ship); break;
            case "Subway": imageView.setImageResource(R.drawable.subway); break;
            case "Cargo ship": imageView.setImageResource(R.drawable.cargoship); break;

            case "Truck": imageView.setImageResource(R.drawable.truck); break;
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
