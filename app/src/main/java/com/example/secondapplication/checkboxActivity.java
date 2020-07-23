package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class checkboxActivity extends AppCompatActivity {

    private CheckBox mcb5,mcb6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        mcb5=findViewById(R.id.cb_5);
        mcb6=findViewById(R.id.cb_6);

        mcb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(checkboxActivity.this,isChecked?"5选中":"5未选中",Toast.LENGTH_SHORT).show();
            }
        });
        
        mcb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(checkboxActivity.this, isChecked?"6选中":"6未选中", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
