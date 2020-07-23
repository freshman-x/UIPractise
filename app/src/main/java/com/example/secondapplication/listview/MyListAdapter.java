package com.example.secondapplication.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.secondapplication.R;

public class MyListAdapter extends BaseAdapter {              //继承BaseAdapter  需要重写以下方法
    private Context mcontext;
    private LayoutInflater mlayoutinflater;                     //inflate就相当于将一个xml中定义的布局找出来?

    public MyListAdapter(Context context)
    {
        this.mcontext=context;
        mlayoutinflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder
    {
        public ImageView imageView;
        public TextView tv_title,tv_time,tv_content;
    }
    //A ViewHolder keeps references to children views to avoid unneccessary calls
    //to findViewById() on each row.
    //提升效率

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {   //每一行（item）的布局和内容
        ViewHolder holder =null;

        if(convertView == null){
            convertView=mlayoutinflater.inflate(R.layout.layout_list_item,null);
            holder=new ViewHolder();
            holder.imageView=convertView.findViewById(R.id.iv);
            holder.tv_title=convertView.findViewById(R.id.tv_title);
            holder.tv_time=convertView.findViewById(R.id.tv_time);
            holder.tv_content=convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        }else{
            // Get the ViewHolder back to get fast access to the TextView
            // and the ImageView.
            holder =(ViewHolder) convertView.getTag();
        }
        //给控件赋值
        holder.tv_title.setText("这是标题");
        holder.tv_time.setText("2088.1.1");
        holder.tv_content.setText("新内容");
        Glide.with(mcontext).load("https://cdn.cnbj1.fds.api.mi-img.com/middle.community.vip.bkt/1abcb1505a84e894a6fb1fc2c3a0f7cb").into(holder.imageView);
        return convertView;
    }
}
