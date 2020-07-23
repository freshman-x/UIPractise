package com.example.secondapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LifecycleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Log.d("Lifecycle","--onCreate--");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle","--onStart--");
    }

    //每次进入该activity刷新，比较常用
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle","--onResume--");
    }

    //放入后台暂停，比如说电影暂停
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle","--onPause--");
    }

    //退到后台会先pause再stop
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle","--onStop--");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle","--onRestart--");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle","--onDestroy--");
    }
}
