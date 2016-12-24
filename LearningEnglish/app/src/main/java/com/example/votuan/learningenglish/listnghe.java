package com.example.votuan.learningenglish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class listnghe extends Activity {
    String itemValue;
    String tieudeanh[] = { "ABC", "If you are happy", "You are sleeping",
            "Baa baa black sheep", "Cuckoo clock","Ding dong bell","Day of the week","Five little ducks" };
    custom_listview customlv;
    Intent i1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_danhsachnghe);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add(tieudeanh[0]);
        arrayList.add(tieudeanh[1]);
        arrayList.add(tieudeanh[2]);
        arrayList.add(tieudeanh[3]);
        arrayList.add(tieudeanh[4]);
        arrayList.add(tieudeanh[5]);
        arrayList.add(tieudeanh[6]);
        arrayList.add(tieudeanh[7]);
        final ListView lv = (ListView) findViewById(R.id.lv_dialog);
        customlv = new custom_listview(this,R.layout.custom_listview2, arrayList);
        lv.setAdapter(customlv);
        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {

                Intent i = new Intent(listnghe.this, hocnghe2.class);
                i.putExtra("position", position);
                startActivity(i);

            }
        });

    }
}