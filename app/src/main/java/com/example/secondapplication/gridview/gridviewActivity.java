package com.example.secondapplication.gridview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.secondapplication.R;

public class gridviewActivity extends AppCompatActivity {


    private GridView mgv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        mgv=findViewById(R.id.gv);
        mgv.setAdapter(new MyGridViewAdapter(gridviewActivity.this));
        mgv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(gridviewActivity.this, "点击 pos:"+position, Toast.LENGTH_SHORT).show();
            }
        });
        mgv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(gridviewActivity.this, "长按 pos:"+position, Toast.LENGTH_LONG).show();
                return true;                                   //false的话单击也会被触发，true的话只会出发长按效果
            }
        });
    }
}
