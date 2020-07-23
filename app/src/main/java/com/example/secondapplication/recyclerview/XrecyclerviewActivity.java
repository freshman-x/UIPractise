package com.example.secondapplication.recyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondapplication.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

public class XrecyclerviewActivity extends AppCompatActivity {

    private XRecyclerView mxrecyclerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xrecyclerview);

        mxrecyclerview=findViewById(R.id.xrv);
        LinearLayoutManager xlinearlayoutmanager=new LinearLayoutManager(this);
        xlinearlayoutmanager.setOrientation(RecyclerView.VERTICAL);
        mxrecyclerview.setLayoutManager(xlinearlayoutmanager);
        mxrecyclerview.setAdapter(new LinearAdapter(XrecyclerviewActivity.this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void OnClick(int pos) {
                Toast.makeText(XrecyclerviewActivity.this, "click."+pos, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnLongClick(int pos) {
                Toast.makeText(XrecyclerviewActivity.this, "longclick."+pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }

}
