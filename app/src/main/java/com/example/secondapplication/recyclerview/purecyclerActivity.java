package com.example.secondapplication.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.secondapplication.R;

public class purecyclerActivity extends AppCompatActivity {

    private RecyclerView mrvpu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purecycler);
        mrvpu=findViewById(R.id.rv_pu);
        mrvpu.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mrvpu.addItemDecoration(new mydecoration());
        mrvpu.setAdapter(new StaggeredGridAdapter(purecyclerActivity.this, new StaggeredGridAdapter.OnItemClickListener() {
            @Override
            public void OnClick(int pos) {
                Toast.makeText(purecyclerActivity.this, "click."+pos, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnLongClick(int pos) {
                Toast.makeText(purecyclerActivity.this, "longclick."+pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class mydecoration extends RecyclerView.ItemDecoration//控制图片间隔
    {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap=getResources().getDimensionPixelSize(R.dimen.dividerHeight5);
            outRect.set(gap,gap,gap,gap);
        }
    }

}
