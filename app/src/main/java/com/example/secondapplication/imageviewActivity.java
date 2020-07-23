package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class imageviewActivity extends AppCompatActivity {

    private ImageView miv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);
        miv1=findViewById(R.id.iv_4);
        Glide.with(this).load("https://iknow-pic.cdn.bcebos.com/a686c9177f3e6709e81deb1a3ac79f3df8dc5531").into(miv1);
    }
}
