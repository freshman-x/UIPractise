package com.example.secondapplication.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondapplication.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.LinearViewHolder> {//  <>表示泛型
    //@NonNull

    private Context mcontext;
    private OnItemClickListener mlistener;

    //private List<String> list;//实际应用

    public GridAdapter(Context context, OnItemClickListener listener) {
        this.mcontext = context;
        this.mlistener=listener;
    }

    @Override
    public GridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.layout_grid_recycler_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("hello world");
        holder.itemView.setOnClickListener(new View.OnClickListener() {//设置点击事件
            @Override
            public void onClick(View v) {
                mlistener.OnClick(position);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mlistener.OnLongClick(position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return 80;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {

            super(itemView);
            textView=itemView.findViewById(R.id.tv_title);
        }

    }

    public interface OnItemClickListener{//定义了一个点击事件的接口（监听器）
        void OnClick(int pos);
        void OnLongClick(int pos);
    }
}
