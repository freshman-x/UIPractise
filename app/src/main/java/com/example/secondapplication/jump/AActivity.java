package com.example.secondapplication.jump;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.secondapplication.R;

public class AActivity extends AppCompatActivity {

    private Button mbtjump;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mbtjump=findViewById(R.id.jump);
        mbtjump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式跳转1
                Intent intent =new Intent(AActivity.this,BActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("name","张三");
                bundle.putInt("number",13);
                intent.putExtras(bundle);
                //startActivity(intent);
                startActivityForResult(intent,0);
                //requestCode用来区分，返回值的对象，以免其他intent
                //使用startActivityForResult时造成混乱


                //显式2
//                Intent intent = new Intent();
//                intent. setClass(AActivity. this, BActivity. class);
//                startActivity(intent);

                //显式跳转3
//                Intent intent = new Intent();
//                intent. setClassName(AActivity. this, "com.example.secondapplication.jump.BActivity");
//                startActivity(intent);

                //隐式
                //需要在manifest中加入intent-filter
//                Intent intent =new Intent();
//                intent.setAction("jumptoBActivity");
//                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, data.getExtras().getString("title"), Toast.LENGTH_SHORT).show();
    }
}
