package com.tyj.kyle.fragmenttabhost.broadcastTest;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tyj.kyle.fragmenttabhost.R;

/**
 * @author create by kyle_2019 on 2019/2/22 19:59
 * @package com.tyj.kyle.fragmenttabhost
 * @fileName TabFragmentA
 */
@SuppressLint("ValidFragment")
class TabFragmentA extends Fragment {

//    public static Fragment newInstance() {
//        TabFragmentA fragment = new TabFragmentA();
//        return fragment;
//    }
    private TextView address;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_baidugps, container, false);
        address = rootView.findViewById(R.id.address);

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),BroadCastActivity.class));
            }
        });
        return rootView;
    }

    static class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ( "my".equals( action )){
//                Log.d( "tttt 消息：" + intent.getStringExtra( "data" )  , "线程： " + Thread.currentThread().getName() ) ;
                String dat = intent.getStringExtra("data");
                Log.e("TAG","广播接收到了消息,"+dat);
            }else {
                Log.e("EEE","广播错误接收到了消息");
            }
        }
    }


}
