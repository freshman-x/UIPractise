package com.example.secondapplication.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.secondapplication.R;

public class horizontalrecyclerActivity extends AppCompatActivity {


    private RecyclerView mrvhorizontal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontalrecycler);
        mrvhorizontal=findViewById(R.id.rv_horizontal);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(horizontalrecyclerActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//和竖直方向的区别
        mrvhorizontal.setLayoutManager(linearLayoutManager);
        mrvhorizontal.addItemDecoration(new MyDecoration());//分割线
        mrvhorizontal.setAdapter(new HorizontalAdapter(horizontalrecyclerActivity.this, new HorizontalAdapter.OnItemClickListener() {
            @Override
            public void OnClick(int pos) {
                Toast.makeText(horizontalrecyclerActivity.this, "click."+pos, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnLongClick(int pos) {
                Toast.makeText(horizontalrecyclerActivity.this, "longclick."+pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration{//设置分割线，本身没颜色，只是撑开一段距离，现实的颜色是底色，即rv_horizontal的颜色
        //可通过调整layout_horizontal_item中的padding调整间距
        @Override//RecyclerView.ItemDecoration有三个方法
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight),0);
        }
    }
}
