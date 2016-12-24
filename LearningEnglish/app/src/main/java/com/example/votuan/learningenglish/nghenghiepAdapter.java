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
public class nghenghiepAdapter extends BaseAdapter{
    private Context context;
    private final String[] list;

    public nghenghiepAdapter(Context context, String[] danhsach) {
        this.context = context;
        this.list = danhsach;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);


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

            case "actor": imageView.setImageResource(R.drawable.actor); break;
            case "baker": imageView.setImageResource(R.drawable.baker); break;
            case "builder": imageView.setImageResource(R.drawable.builder); break;
            case "businessman": imageView.setImageResource(R.drawable.businessman); break;
            case "carpenter": imageView.setImageResource(R.drawable.carpenter); break;
            case "cashier": imageView.setImageResource(R.drawable.cashier); break;
            case "cook": imageView.setImageResource(R.drawable.cook); break;
            case "dancer": imageView.setImageResource(R.drawable.dancer); break;
            case "dentist": imageView.setImageResource(R.drawable.dentist); break;
            case "doctor": imageView.setImageResource(R.drawable.doctor); break;
            case "farmer": imageView.setImageResource(R.drawable.farmer); break;
            case "gardenner": imageView.setImageResource(R.drawable.gardenner); break;
            case "hairdresser": imageView.setImageResource(R.drawable.hairdresser); break;
            case "nurse": imageView.setImageResource(R.drawable.nurse); break;
            case "painter": imageView.setImageResource(R.drawable.painter); break;
            case "policeman": imageView.setImageResource(R.drawable.policeman); break;
            case "secretary": imageView.setImageResource(R.drawable.secretary); break;
            case "singer": imageView.setImageResource(R.drawable.singer); break;
            case "teacher": imageView.setImageResource(R.drawable.teacher); break;
            case "waiter": imageView.setImageResource(R.drawable.waiter); break;
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
