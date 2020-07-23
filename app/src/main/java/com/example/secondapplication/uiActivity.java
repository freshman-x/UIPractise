package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.secondapplication.gridview.gridviewActivity;
import com.example.secondapplication.listview.listviewActivity;
import com.example.secondapplication.recyclerview.recyclerviewActivity;

public class uiActivity extends AppCompatActivity {

    private Button mbttextview;
    private Button mbtbutton;
    private Button mbtedittext;
    private Button mbtradiobutton;
    private Button mbtcheckbox;
    private Button mbtimageview;
    private Button mbtlistview;
    private Button mbtgridview;
    private Button mbtrecyclerview;
    private Button mbtwebview;
    private Button mbttoast;
    private Button mbtdialog;
    private Button mbtprogress;
    private Button mbtcustom_dialog;
    private Button mbtpopup_window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        mbttextview=findViewById(R.id.bt_tv1);
//        mbttextview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, textviewActivity.class);
//                startActivity(intent);
//            }
//        });
        mbtbutton=findViewById(R.id.bt_button);
        mbtedittext=findViewById(R.id.bt_eidttext);
        mbtradiobutton=findViewById(R.id.bt_radiobutton);
        mbtcheckbox=findViewById(R.id.bt_checkbox);
        mbtimageview=findViewById(R.id.bt_imageview);
        mbtlistview=findViewById(R.id.bt_listview);
        mbtgridview=findViewById(R.id.bt_gridview);
        mbtrecyclerview=findViewById(R.id.bt_recyclerview);
        mbtwebview=findViewById(R.id.bt_webview);
        mbttoast=findViewById(R.id.bt_toast);
        mbtdialog=findViewById(R.id.bt_dialog);
        mbtprogress=findViewById(R.id.bt_progress);
        mbtcustom_dialog=findViewById(R.id.bt_customdialog);
        mbtpopup_window=findViewById(R.id.bt_popupwindow);
        setlisteners();
    }
    private void setlisteners(){
        OnClick onClick =new OnClick();
        mbttextview.setOnClickListener(onClick);
        mbtbutton.setOnClickListener(onClick);
        mbtedittext.setOnClickListener(onClick);
        mbtradiobutton.setOnClickListener(onClick);
        mbtcheckbox.setOnClickListener(onClick);
        mbtimageview.setOnClickListener(onClick);
        mbtlistview.setOnClickListener(onClick);
        mbtgridview.setOnClickListener(onClick);
        mbtrecyclerview.setOnClickListener(onClick);
        mbtwebview.setOnClickListener(onClick);
        mbttoast.setOnClickListener(onClick);
        mbtdialog.setOnClickListener(onClick);
        mbtprogress.setOnClickListener(onClick);
        mbtcustom_dialog.setOnClickListener(onClick);
        mbtpopup_window.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=null;
            switch (v.getId())
            {
                case R.id.bt_tv1:
                    //跳转到textview界面
                    intent =new Intent(uiActivity.this,textviewActivity.class);
                    break;
                case R.id.bt_button:
                    //跳转到button界面
                    intent =new Intent(uiActivity.this,buttonActivity.class);
                    break;
                case R.id.bt_eidttext:
                    //跳转到edittext界面
                    intent =new Intent(uiActivity.this,edittextActivity.class);
                    break;
                case R.id.bt_radiobutton:
                    //跳转到radiobutton界面
                    intent =new Intent(uiActivity.this,radiobuttonActivity.class);
                    break;
                case R.id.bt_checkbox:
                    //跳转到checkbox界面
                    intent =new Intent(uiActivity.this,checkboxActivity .class);
                    break;
                case R.id.bt_imageview:
                    //跳转到imageview界面
                    intent=new Intent(uiActivity.this,imageviewActivity.class);
                    break;
                case R.id.bt_listview:
                    //跳转到listview
                    intent =new Intent(uiActivity.this, listviewActivity.class);
                    break;
                case R.id.bt_gridview:
                    //跳转到gridview界面
                    intent=new Intent(uiActivity.this, gridviewActivity.class);
                    break;
                case R.id.bt_recyclerview:
                    //跳转到recyclerview界面
                    intent=new Intent(uiActivity.this, recyclerviewActivity.class);
                    break;
                case R.id.bt_webview:
                    //跳转到webview界面
                    intent= new Intent(uiActivity.this,webviewActivity.class);
                    break;
                case R.id.bt_toast:
                    intent= new Intent(uiActivity.this,toastActivity.class);
                    break;
                case R.id.bt_dialog:
                    intent= new Intent(uiActivity.this,dialogActivity.class);
                    break;
                case R.id.bt_progress:
                    intent= new Intent(uiActivity.this,progressActivity.class);
                    break;
                case R.id.bt_customdialog:
                    intent= new Intent(uiActivity.this,customdialogActivity.class);
                    break;
                case R.id.bt_popupwindow:
                    intent= new Intent(uiActivity.this,popupwindowActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}