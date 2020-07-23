package com.example.secondapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.secondapplication.util.Toastutil;


//使用AlertDialog的界面

//AlertDialog的builder是一种构建dialog或者说构建对象的方式
public class dialogActivity extends AppCompatActivity {


    private Button mbtdialog1, mbtdialog2, mbtdialog3, mbtdialog4,mbtdialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mbtdialog1 = findViewById(R.id.bt_dialog1);
        mbtdialog2 = findViewById(R.id.bt_dialog2);
        mbtdialog3 = findViewById(R.id.bt_dialog3);
        mbtdialog4 = findViewById(R.id.bt_dialog4);
        mbtdialog5 = findViewById(R.id.bt_dialog5);
        Onclick onclick=new Onclick();
        mbtdialog1.setOnClickListener(onclick);
        mbtdialog2.setOnClickListener(onclick);
        mbtdialog3.setOnClickListener(onclick);
        mbtdialog4.setOnClickListener(onclick);
        mbtdialog5.setOnClickListener(onclick);
    }

    class Onclick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt_dialog1:
                    AlertDialog.Builder builder1=new AlertDialog.Builder(dialogActivity.this);
                    builder1.setTitle("请回答")
                            .setIcon(R.drawable.icon)
                            .setMessage("你觉得app如何")
                            .setPositiveButton("棒", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toastutil.showmessage(dialogActivity.this,"good");
                        }
                    }).setNeutralButton("海星", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toastutil.showmessage(dialogActivity.this,"?");
                        }
                    }).setNegativeButton("shit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toastutil.showmessage(dialogActivity.this,"sb");
                        }
                    }).show();
                    break;
                case R.id.bt_dialog2:
                    final String[] array2=new String[]{"男","女"};
                    AlertDialog.Builder builder2=new AlertDialog.Builder(dialogActivity.this);
                    builder2.setTitle("选择性别").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toastutil.showmessage(dialogActivity.this,array2[which]);
                        }
                    }).show();
                    break;
                case R.id.bt_dialog3:
                    final String[] array3=new String[]{"男","女"};
                    AlertDialog.Builder builder3=new AlertDialog.Builder(dialogActivity.this);
                    builder3.setTitle("选择性别").setSingleChoiceItems(array3,1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toastutil.showmessage(dialogActivity.this,array3[which]);
                            dialog.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.bt_dialog4:
                    final String[] array4=new String[]{"唱歌","跳舞","coding"};
                    boolean[] isSelected=new boolean[]{false,false,true};//设置初始状态
                    AlertDialog.Builder builder4=new AlertDialog.Builder(dialogActivity.this);
                    builder4.setTitle("兴趣").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            Toastutil.showmessage(dialogActivity.this,array4[which]+":"+"is checked");
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
                    break;
                case R.id.bt_dialog5:
                    AlertDialog.Builder builder5=new AlertDialog.Builder(dialogActivity.this);
                    View view=LayoutInflater.from(dialogActivity.this).inflate(R.layout.layout_dialog,null);
                    EditText etusername=view.findViewById(R.id.et_dialog1);//控件在那个视图里就用那个视图.findviewbyid
                    EditText etpassword=view.findViewById(R.id.et_dialog2);
                    Button btlogin=view.findViewById(R.id.bt_login);
                    btlogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //
                        }
                    });
                    builder5.setTitle("请登陆").setView(view).show();
                    break;
            }
        }
    }
}
