package com.example.secondapplication.jump;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.secondapplication.R;

public class BActivity extends AppCompatActivity {

    private TextView mtvtitle;
    private Button mbtfinish;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        mtvtitle=findViewById(R.id.tv_title);
        mbtfinish=findViewById(R.id.bt_finish);
        final Bundle bundle=getIntent().getExtras();//得到一个bundle
        String name =bundle.getString("name");
        int number=bundle.getInt("number");
        mtvtitle.setText(name+" "+number);

        mbtfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                Bundle bundle1=new Bundle();
                bundle1.putString("title","我回来了");
                intent.putExtras(bundle1);
                setResult(Activity.RESULT_OK,intent);//向上一级传值
                finish();//关闭当前页面
            }
        });
    }
}
