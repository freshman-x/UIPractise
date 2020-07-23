package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class textviewActivity extends AppCompatActivity {

    private TextView tv1,tv2,tv3,tv4,tv5,tv6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);

        tv1=findViewById(R.id.tv1);
        tv1.setSelected(true);

        tv2=findViewById(R.id.tv2);
        tv2.setSelected(true);

        tv3=findViewById(R.id.tv3);
        tv3.setSelected(true);

        tv4=findViewById(R.id.tv4);
        tv4.setSelected(true);

        tv5=findViewById(R.id.tv5);
        tv5.setSelected(true);

        tv6=findViewById(R.id.tv6);
        tv6.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}
