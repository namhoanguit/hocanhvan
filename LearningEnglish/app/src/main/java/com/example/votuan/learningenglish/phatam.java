package com.example.votuan.learningenglish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
public class phatam extends Activity{
    GridView gridView;

    static final String[] list = new String[] { "Số đếm", "Bảng chữ cái",
            "Hoa quả", "Động vật", "Màu sắc","Gia Đình","Cơ Thể"
            ,"Thể thao","Giao thông","Nghề nghiệp","Việc nhà"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_phatam);

        gridView = (GridView) findViewById(R.id.gridView1);

        gridView.setAdapter(new phatamAdapter(this, list));

        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent;

                if (position == 0) {
                    intent = new Intent(phatam.this, sodem.class);
                    startActivity(intent);
                }

                if (position == 1) {
                    intent = new Intent(phatam.this, bangchucai.class);
                    startActivity(intent);
                }

                if (position == 2) {
                    intent = new Intent(phatam.this, hoaqua.class);
                    startActivity(intent);
                }

                if (position == 3) {
                    intent = new Intent(phatam.this, dongvat.class);
                    startActivity(intent);
                }
                if (position == 4) {
                    intent = new Intent(phatam.this, mausac.class);
                    startActivity(intent);
                }
                if(position == 5){
                    intent = new Intent(phatam.this ,giadinh.class);
                    startActivity(intent);
                }
                if(position == 6){
                    intent = new Intent(phatam.this ,cothe.class);
                    startActivity(intent);
                }
                if (position == 7) {
                    intent = new Intent(phatam.this, thethao.class);
                    startActivity(intent);
                }
                if (position == 8) {
                    intent = new Intent(phatam.this, giaothong.class);
                    startActivity(intent);
                }
                if (position == 9) {
                    intent = new Intent(phatam.this, nghenghiep.class);
                    startActivity(intent);
                }
                if (position == 10) {
                    intent = new Intent(phatam.this, viecnha.class);
                    startActivity(intent);
                }


            }

        });
    }
}
