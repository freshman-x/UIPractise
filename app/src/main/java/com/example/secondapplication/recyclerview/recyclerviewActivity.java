package com.example.secondapplication.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.secondapplication.R;

public class recyclerviewActivity extends AppCompatActivity {


    private Button mbtlinear;
    private Button mbthorizontal;
    private Button mbtgrid;
    private Button mbtpu;
    private Button mbtxrecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        mbtlinear=findViewById(R.id.bt_linear);
        mbtlinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(recyclerviewActivity.this,linearrecyclerActivity.class);
                startActivity(intent);
            }
        });
        mbthorizontal=findViewById(R.id.bt_horizontal);
        mbthorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(recyclerviewActivity.this,horizontalrecyclerActivity.class);
                startActivity(intent);
            }
        });
        mbtgrid=findViewById(R.id.bt_grid);
        mbtgrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(recyclerviewActivity.this,gridrecyclerviewActivity.class);
                startActivity(intent);
            }
        });
        mbtpu=findViewById(R.id.bt_pu);
        mbtpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(recyclerviewActivity.this,purecyclerActivity.class);
                startActivity(intent);
            }
        });
        mbtxrecyclerview=findViewById(R.id.bt_xrv);
        mbtxrecyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(recyclerviewActivity.this,XrecyclerviewActivity.class);
                startActivity(intent);
            }
        });
    }
}
