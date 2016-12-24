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
public class viecnhaAdapter extends BaseAdapter{
    private Context context;
    private final String[] list;

    public viecnhaAdapter(Context context, String[] danhsach) {
        this.context = context;
        this.list = danhsach;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);


            gridView = inflater.inflate(R.layout.layout_viecnha, null);

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

            case "clean the window": imageView.setImageResource(R.drawable.cleanthewindow); break;
            case "do the cooking": imageView.setImageResource(R.drawable.dothecooking); break;
            case "do the laundry": imageView.setImageResource(R.drawable.dothelaundry); break;
            case "dust the furniture": imageView.setImageResource(R.drawable.dustthefurniture); break;
            case "feed the dog": imageView.setImageResource(R.drawable.feedthedog); break;
            case "fold the laundry": imageView.setImageResource(R.drawable.foldthelaundy); break;
            case "hang up the laundry": imageView.setImageResource(R.drawable.hangupthelaundy); break;
            case "iron the clothes": imageView.setImageResource(R.drawable.irontheclothes); break;
            case "mop the floor": imageView.setImageResource(R.drawable.mopthefloor); break;
            case "mown the lawn": imageView.setImageResource(R.drawable.mownthelawn); break;
            case "paint the fence": imageView.setImageResource(R.drawable.paintthefence); break;
            case "rake the leaves": imageView.setImageResource(R.drawable.raketheleaves); break;
            case "sweep the floor": imageView.setImageResource(R.drawable.sweepthefloor); break;
            case "take out the rubbish": imageView.setImageResource(R.drawable.takeouttherubbish); break;
            case "tidy up the room": imageView.setImageResource(R.drawable.tidyuptheroom); break;
            case "vacuum the floor": imageView.setImageResource(R.drawable.vacuumthefloor); break;
            case "wash the car": imageView.setImageResource(R.drawable.washthecar); break;
            case "wash the dishes": imageView.setImageResource(R.drawable.washthedishes); break;
            case "water the plants": imageView.setImageResource(R.drawable.watertheplants); break;

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
