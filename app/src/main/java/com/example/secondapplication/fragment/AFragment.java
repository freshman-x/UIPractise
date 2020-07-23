package com.example.secondapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.secondapplication.R;

public class AFragment extends Fragment {

    private TextView mtvtitle;
    private Button mbtchange,mbtreset,mbtmessage;
    private BFragment bFragment;
    private Ionmessageclick listener;

    public static AFragment newInstance(String title)//向AFragment传参的函数
    {
        AFragment fragment=new AFragment();
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        fragment.setArguments(bundle);
        return fragment;
    }

    public interface Ionmessageclick{
        void onClick(String text);
    }

    @Override
    public void onAttach(@NonNull Context context) {//context即该fragment依附的activity？
        super.onAttach(context);
        try {
            listener=(Ionmessageclick)context;//强制转换为接口
        }catch(ClassCastException e){//如果转化失败，说明这个activity没有实现这个接口
            throw new ClassCastException("activity 必须实现 Ionmessageclick 接口");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_a,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mtvtitle=view.findViewById(R.id.tv_title);
        mbtchange=view.findViewById(R.id.bt_change);
        mbtreset=view.findViewById(R.id.bt_reset);
        mbtmessage=view.findViewById(R.id.bt_message);
        mbtmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((containerActivity)getActivity()).setdata("你好");
                listener.onClick("你好");//通过回调接口的方式实现了fragment何个activity之间的通讯
            }
        });
        mbtchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null) {
                    bFragment = new BFragment();
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if (fragment != null) {
                    //先隐藏aFragment，以免回退回来时重新刷新aFragment
                    //入栈是为了逐级向后退出
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                } else {
                    //入栈是为了逐级向后退出
                    //直接replace会导致：尽管fragment保留了，但是其视图内容重新创建了
                    getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });
        mbtreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtvtitle.setText("新文字");
            }
        });
        if (getArguments()!=null){
            mtvtitle.setText(getArguments().getString("title"));
        }
    }

}
