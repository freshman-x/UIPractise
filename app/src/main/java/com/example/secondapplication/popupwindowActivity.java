package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.secondapplication.util.Toastutil;

public class popupwindowActivity extends AppCompatActivity {

    private Button mbtpop;
    private PopupWindow mpop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupwindow);
        mbtpop=findViewById(R.id.bt_pop);
        mbtpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=getLayoutInflater().inflate(R.layout.layout_pop,null);

                TextView textview=view.findViewById(R.id.tv_good);
                textview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toastutil.showmessage(popupwindowActivity.this,"click");
                        mpop.dismiss();
                    }
                });
                mpop=new PopupWindow(view ,mbtpop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                mpop.setOutsideTouchable(true);//点击空白处消失，dialog是cancelable属性
                mpop.setFocusable(true);
                mpop.showAsDropDown(mbtpop);
            }
        });
    }
}
