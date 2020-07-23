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

import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {//  <>表示泛型
    //@NonNull

    private Context mcontext;
    private OnItemClickListener mlistener;

    //private List<String> list;//实际应用

    public LinearAdapter(Context context,OnItemClickListener listener) {
        this.mcontext = context;
        this.mlistener=listener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0)
            return new LinearViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.layout_linear_item,parent,false));
        else
            return new LinearViewHolder2(LayoutInflater.from(mcontext).inflate(R.layout.layout_linear_item2,parent,false));
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2==0)
            return 0;
        return 1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position)==0){
            ((LinearViewHolder)holder).textView.setText("hello world");
        }else{
            ((LinearViewHolder2)holder).textView.setText("gogogo");
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

        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_title);
        }
    }

    class LinearViewHolder2 extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public LinearViewHolder2(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_title);
            imageView=itemView.findViewById(R.id.iv_image);
        }
    }

    public interface OnItemClickListener{//定义了一个点击事件的接口（监听器）
        void OnClick(int pos);
        void OnLongClick(int pos);
    }
}
