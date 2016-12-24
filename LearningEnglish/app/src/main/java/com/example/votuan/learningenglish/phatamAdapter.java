package com.example.votuan.learningenglish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class phatamAdapter extends BaseAdapter{
    private Context context;
    private final String[] list;

    public phatamAdapter(Context context, String[] danhsach) {
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
            gridView = inflater.inflate(R.layout.layout_phatam2, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);
            textView.setText(list[position]);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);

            String vitri = list[position];

            if (vitri.equals("Bảng chữ cái")) {
                imageView.setImageResource(R.drawable.anphabet);
            } else if (vitri.equals("Số đếm")) {
                imageView.setImageResource(R.drawable.number);
            } else if (vitri.equals("Hoa quả")) {
                imageView.setImageResource(R.drawable.food);
            } else if (vitri.equals("Màu sắc")) {
                imageView.setImageResource(R.drawable.color);
            }else if (vitri.equals("Động vật")) {
                imageView.setImageResource(R.drawable.animal);
            }else  if(vitri.equals("Gia Đình")) {
                imageView.setImageResource(R.drawable.giadinh);
            } else if(vitri.equals("Cơ Thể")){
                imageView.setImageResource(R.drawable.body);
            }else if (vitri.equals("Thể thao")) {
                imageView.setImageResource(R.drawable.thethao);
            }else if (vitri.equals("Giao thông")) {
                imageView.setImageResource(R.drawable.giaothong);
            }else if (vitri.equals("Nghề nghiệp")) {
                imageView.setImageResource(R.drawable.nghenghiep);
            }
            else {
                imageView.setImageResource(R.drawable.clearnthehouse);
            }

        } else {
            gridView = (View) convertView;
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
