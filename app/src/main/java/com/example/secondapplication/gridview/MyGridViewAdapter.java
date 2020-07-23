package com.example.secondapplication.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.secondapplication.R;

public class MyGridViewAdapter extends BaseAdapter {

    private Context mcontext;
    private LayoutInflater mlayoutinflater;

    MyGridViewAdapter(Context context)
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
        public ImageView imageview;
        public TextView textview;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder =null;
        if (convertView==null)
        {
            convertView=mlayoutinflater.inflate(R.layout.layout_grid_item,null);
            holder=new ViewHolder();
            holder.imageview=convertView.findViewById(R.id.iv_grid);
            holder.textview=convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }
        else
        {
            holder= (ViewHolder)convertView.getTag();
        }
        holder.textview.setText("花");
        Glide.with(mcontext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589306952131&di=c5d4f7c33ac09cb832acbdd695e7804f&imgtype=0&src=http%3A%2F%2Fb.zol-img.com.cn%2Fsoft%2F5%2F80%2FcesuhibGW7S6Q.jpg").into(holder.imageview);
        return convertView;
    }
}
