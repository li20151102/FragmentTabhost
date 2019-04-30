package com.tyj.myapplication;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AnotherUpFragment2 extends Fragment {

//    public FramentCallBack framentCallBack;
//    public interface FramentCallBack{
//        void setValue(String dd);
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.another_up_fragment, container, false);
        TextView tv = view.findViewById(R.id.tv_anothers);
//        final MainActivity2 mainActivity2 = new MainActivity2();
//        mainActivity2.setValue("frament向activity传值成功");
//        AnotherUpFragment3 afrm3 = new AnotherUpFragment3();
//        afrm3.setValue("frament2向frament3传值成功");


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }



//    @Override
//    public void onAttach(Context context) {
//        framentCallBack = (FramentCallBack) context;
//        super.onAttach(context);
//    }
}
