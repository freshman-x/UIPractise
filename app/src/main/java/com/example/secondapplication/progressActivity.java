package com.example.secondapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;

public class progressActivity extends AppCompatActivity {


    private ProgressBar mpb3;
    private Button mbtstart,mbtprogressdialog1,mbtprogressdialog2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        mpb3=findViewById(R.id.pb_3);
        mpb3.setProgress(30);
        mbtstart=findViewById(R.id.start);
        mbtstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);//发送消息，程序进入handlemessage（）处理消息
            }
        });

        mbtprogressdialog1=findViewById(R.id.bt_progress_dialog1);
        mbtprogressdialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressdialog=new ProgressDialog(progressActivity.this);
                progressdialog.setTitle("提示");
                progressdialog.setMessage("正在加载");
                progressdialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(progressActivity.this, "canel...", Toast.LENGTH_SHORT).show();
                    }
                });
                progressdialog.show();
            }
        });

        mbtprogressdialog2=findViewById(R.id.bt_progress_dialog2);
        mbtprogressdialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressdialog=new ProgressDialog(progressActivity.this);
                progressdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressdialog.setTitle("提示");
                progressdialog.setMessage("正在下载...");
                progressdialog.setCancelable(false);
                progressdialog.setButton(DialogInterface.BUTTON_POSITIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        progressdialog.dismiss();
                    }
                });
                progressdialog.show();
            }
        });
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (mpb3.getProgress()<100)
                handler.postDelayed(runnable,500);//延迟500ms
            else
                Toast.makeText(progressActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
        }
    };

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            mpb3.setProgress(mpb3.getProgress()+5);
            handler.sendEmptyMessage(0);//处理完后再发送空消息，再次让handlemessage（）处理
        }
    };
}
