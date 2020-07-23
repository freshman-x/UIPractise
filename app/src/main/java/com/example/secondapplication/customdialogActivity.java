package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.secondapplication.util.Toastutil;
import com.example.secondapplication.widget.CustomDialog;

//使用customdialog的界面
public class customdialogActivity extends AppCompatActivity {

    private Button mbtdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customdialog);
        mbtdialog=findViewById(R.id.bt_customdialog);
        mbtdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customdialog=new CustomDialog(customdialogActivity.this);
                customdialog.setTitle("提示").setMessage("确认删除？").setCancel("取消", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {
                        Toastutil.showmessage(customdialogActivity.this,"cancel..");
                        //按压效果使用selector
                    }
                }).setConfirm("确定", new CustomDialog.IOnConfirmListener() {
                    @Override
                    public void onConfirm(CustomDialog dialog) {
                        Toastutil.showmessage(customdialogActivity.this,"confirm..");
                    }
                }).show();
            }
        });
    }
}
