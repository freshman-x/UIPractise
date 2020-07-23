package com.example.secondapplication.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.secondapplication.R;

public class containerActivity extends AppCompatActivity implements AFragment.Ionmessageclick{

    private AFragment aFragment;
    private TextView mtvtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        mtvtitle=findViewById(R.id.tv_title);
        //实例化AFragment
        aFragment =AFragment.newInstance("向AFragment传参");//向AFragment传参
        //把AFragment添加到Activity中，记得调用commit
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFragment,"a").commitAllowingStateLoss();
    }

    public void setdata(String text){
        mtvtitle.setText(text);
    }

    @Override
    public void onClick(String text) {
        mtvtitle.setText(text);
    }
}
