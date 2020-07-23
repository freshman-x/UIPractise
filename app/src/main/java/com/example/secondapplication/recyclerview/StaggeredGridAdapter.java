package com.example.secondapplication.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondapplication.R;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {//  <>表示泛型
    //@NonNull

    private Context mcontext;
    private OnItemClickListener mlistener;

    //private List<String> list;//实际应用

    public StaggeredGridAdapter(Context context, OnItemClickListener listener) {
        this.mcontext = context;
        this.mlistener=listener;
    }

    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.layout_staggered_grid_recycler_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredGridAdapter.LinearViewHolder holder, final int position) {
        if(position%2!=0)
        {
            holder.imageView.setImageResource(R.drawable.image1);
        }
        else
        {
            holder.imageView.setImageResource(R.drawable.image2);
        }

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
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public LinearViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView=itemView.findViewById(R.id.iv_pu);
        }
    }

    public interface OnItemClickListener{//定义了一个点击事件的接口（监听器）
        void OnClick(int pos);
        void OnLongClick(int pos);
    }
}
