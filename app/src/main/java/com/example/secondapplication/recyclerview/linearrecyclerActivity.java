package com.example.secondapplication.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.secondapplication.R;

public class linearrecyclerActivity extends AppCompatActivity {

    private RecyclerView mrvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linearrecycler);
        mrvMain=findViewById(R.id.rv_main);
        mrvMain.setLayoutManager(new LinearLayoutManager(linearrecyclerActivity.this));
        mrvMain.addItemDecoration(new MyDecoration());//分隔线
        mrvMain.setAdapter(new LinearAdapter(linearrecyclerActivity.this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void OnClick(int pos) {
                Toast.makeText(linearrecyclerActivity.this, "click."+pos, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnLongClick(int pos) {
                Toast.makeText(linearrecyclerActivity.this, "长按."+pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration{//设置分割线
        @Override//RecyclerView.ItemDecoration有三个方法
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}
