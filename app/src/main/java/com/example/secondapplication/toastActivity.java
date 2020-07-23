package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.secondapplication.util.*;

public class toastActivity extends AppCompatActivity {

    private Button mbttoast1,mbttoast2,mbttoast3,mbttoast4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mbttoast1=findViewById(R.id.bt_toast1);
        mbttoast2=findViewById(R.id.bt_toast2);
        mbttoast3=findViewById(R.id.bt_toast3);
        mbttoast4=findViewById(R.id.bt_toast4);
        OnClick onClick=new OnClick();
        mbttoast1.setOnClickListener(onClick);
        mbttoast2.setOnClickListener(onClick);
        mbttoast3.setOnClickListener(onClick);
        mbttoast4.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            switch(v.getId())
            {
                case R.id.bt_toast1:
                    Toast.makeText(toastActivity.this, "Toast", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bt_toast2:
                    Toast toastcenter=Toast.makeText(getApplicationContext(),"居中",Toast.LENGTH_SHORT);
                    toastcenter.setGravity(Gravity.CENTER,0,0);
                    toastcenter.show();
                    break;
                case R.id.bt_toast3:
                    Toast toastpicture=new Toast(getApplicationContext());
                    LayoutInflater inflater= LayoutInflater.from(toastActivity.this);
                    View view=inflater.inflate(R.layout.layout_toast,null);
                    ImageView imageview=view.findViewById(R.id.iv_toast);
                    TextView textview=view.findViewById(R.id.tv_toast);
                    imageview.setImageResource(R.drawable.icon);
                    textview.setText("自定义");
                    toastpicture.setView(view);
                    toastpicture.setDuration(Toast.LENGTH_LONG);
                    toastpicture.show();
                    break;
                case R.id.bt_toast4:
                    Toastutil.showmessage(getApplicationContext(),"包装过的Toast");
                    break;
            }
        }
    }
}
