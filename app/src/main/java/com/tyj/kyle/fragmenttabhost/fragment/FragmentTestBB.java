package com.tyj.kyle.fragmenttabhost.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tyj.kyle.fragmenttabhost.R;


/**
 * @author create by kyle_2019 on 2019/3/12 9:17
 * @package com.example.testapplication
 * @fileName FragmentTest
 */
public class FragmentTestBB extends Fragment {
    static TextView view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_bb, container, false);
        view = root.findViewById(R.id.text2);
        view.setText("dfsdfsd");
        return root;
    }

    @SuppressLint("HandlerLeak")
    static Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int  hh  =  msg.what;
            switch (hh){
                case 1:
                    view.setText("jieshou1");
                    break;
                case 2:
                    view.setText("jieshou2");
                    break;
            }
        }
    };
    static class MyBoradCast extends BroadcastReceiver{

        @Override
        public void onReceive(final Context context, final Intent intent) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                        final String dat = intent.getStringExtra("kk");

                        new Handler(context.getMainLooper()).post(new Runnable() {

                            @Override

                            public void run() {
                                // 在这里执行你要想的操作 比如直接在这里更新ui或者调用回调在 在回调中更新ui
                                Message message = handler.obtainMessage();
                                message.what=1;
                                handler.sendMessage(message);
                                Log.e("TAG","接收"+dat);
                            }

                        });


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
