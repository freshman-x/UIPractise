package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class radiobuttonActivity extends AppCompatActivity {

    private RadioGroup mrg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton);
        mrg1=findViewById(R.id.rg_1);

        mrg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {           //监听事件
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radiobutton =group.findViewById(checkedId);
                Toast.makeText(radiobuttonActivity.this,radiobutton.getText(),Toast.LENGTH_SHORT).show();;
            }
        });
    }
}
