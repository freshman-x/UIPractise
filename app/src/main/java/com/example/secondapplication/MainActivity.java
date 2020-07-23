package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.secondapplication.fragment.containerActivity;
import com.example.secondapplication.jump.AActivity;

public class MainActivity extends AppCompatActivity {


    private Button mbtui,mbtlifecycle,mbtjunmp,mbtfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtui=findViewById(R.id.bt_ui);
        mbtlifecycle=findViewById(R.id.bt_lifecycle);
        mbtjunmp=findViewById(R.id.bt_jump);
        mbtfragment=findViewById(R.id.bt_fragment);
        Onclick onclick=new Onclick();
        mbtui.setOnClickListener(onclick);
        mbtlifecycle.setOnClickListener(onclick);
        mbtjunmp.setOnClickListener(onclick);
        mbtfragment.setOnClickListener(onclick);
    }

    class Onclick implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Intent intent=null;
            switch (v.getId())
            {
                case R.id.bt_ui:
                    intent =new Intent(MainActivity.this, uiActivity.class);
                    break;
                case R.id.bt_lifecycle:
                    intent =new Intent(MainActivity.this, LifecycleActivity.class);
                    break;
                case R.id.bt_jump:
                    intent =new Intent(MainActivity.this, AActivity.class);
                    break;
                case R.id.bt_fragment:
                    intent =new Intent(MainActivity.this, containerActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
