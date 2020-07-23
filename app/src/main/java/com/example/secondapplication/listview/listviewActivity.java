package com.example.secondapplication.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.secondapplication.R;

public class listviewActivity extends Activity {

    private ListView mlv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        mlv1=findViewById(R.id.lv_1);
        mlv1.setAdapter(new MyListAdapter(listviewActivity.this));
        mlv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(listviewActivity.this, "pos:"+position,Toast.LENGTH_SHORT).show();
            }
        });
        
        mlv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(listviewActivity.this, "长按 pos:"+position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
