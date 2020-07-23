package com.example.secondapplication.util;

import android.content.Context;
import android.widget.Toast;

public class Toastutil {//包装过后只有一个Toast了，mtoast是类的静态成员，所以多次点击可以只显示最新的
    public static Toast mtoast;
    public static void showmessage(Context context,String msg)
    {
        if(mtoast==null)
            mtoast=Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        else
            mtoast.setText(msg);
        mtoast.show();
    }
}
