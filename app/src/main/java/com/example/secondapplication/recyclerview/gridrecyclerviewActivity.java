package com.example.secondapplication.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.secondapplication.R;

public class gridrecyclerviewActivity extends AppCompatActivity {

    private RecyclerView mrvgrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridrecyclerview);
        mrvgrid=findViewById(R.id.rv_grid);
        mrvgrid.setLayoutManager(new GridLayoutManager(gridrecyclerviewActivity.this,3));
        mrvgrid.setAdapter(new GridAdapter(gridrecyclerviewActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public void OnClick(int pos) {
                Toast.makeText(gridrecyclerviewActivity.this, "click."+pos, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnLongClick(int pos) {
                Toast.makeText(gridrecyclerviewActivity.this, "longclick."+pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
