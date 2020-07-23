package com.example.secondapplication.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.secondapplication.R;

//自己创建了一种dialog类，（与AlertDialog同级？）
// 然后在customdialogactivity里面创建对象，设置参数

//AlertDialog使用builder模式构建对象
//customdialog也可以使用builder模式（方式）
public class CustomDialog extends Dialog implements View.OnClickListener {
    private TextView mtvtitle,mtvmessage,mtvcancel,mtvconfirm;

    private String title,message,cancel,confirm;

    private IOnCancelListener cancellistener;
    private IOnConfirmListener confirmlistener;

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener listener) {
        this.cancel = cancel;
        cancellistener=listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmListener listener) {
        this.confirm = confirm;
        confirmlistener=listener;
        return this;
    }

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeid) {
        super(context,themeid);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);


        //虽然activity_customdialog的Linearlayout设置的是matchparent，但使用效果是wrapcontent
        // 所以需要这段代码设置宽度
        //设置宽度
        WindowManager m = getWindow().getWindowManager() ;
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow() .getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) (size.x*0.8);//设置dialog宽度为当前手机宽度*0.8
        getWindow().setAttributes (p);
        //设置宽度


        mtvtitle=findViewById(R.id.tv_title);
        mtvmessage=findViewById(R.id.tv_message);
        mtvconfirm=findViewById(R.id.tv_confirm);
        mtvcancel=findViewById(R.id.tv_cancel);
        if (!TextUtils.isEmpty(title))
            mtvtitle.setText(title);
        if (!TextUtils.isEmpty(message))
            mtvmessage.setText(message);
        if (!TextUtils.isEmpty(cancel))
            mtvcancel.setText(cancel);
        if (!TextUtils.isEmpty(confirm))
            mtvconfirm.setText(confirm);
        mtvconfirm.setOnClickListener(this);
        mtvcancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                if(cancellistener!=null)
                    cancellistener.onCancel(this);
                dismiss();//点击按钮后消失
                break;
            case R.id.tv_confirm:
                if (confirmlistener!=null)
                    confirmlistener.onConfirm(this);
                dismiss();
                break;
        }
    }

    public interface IOnCancelListener{
        void onCancel(CustomDialog dialog);
    }

    public interface IOnConfirmListener{
        void onConfirm(CustomDialog dialog);
    }
}
