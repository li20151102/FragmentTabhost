package com.tyj.kyle.fragmenttabhost.broadcastTest;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.TextView;

import com.tyj.kyle.fragmenttabhost.R;


public class BroadCastActivity extends FragmentActivity {
    TextView fasong;

    private LocalBroadcastManager localBroadcastManager;
    private IntentFilter intentFilter = new IntentFilter("my");
    private TabFragmentA.MyBroadcastReceiver broadcastReceiver = new TabFragmentA.MyBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        fasong = findViewById(R.id.fasong);
        //注册广播接收器
        localBroadcastManager = LocalBroadcastManager.getInstance(getApplicationContext());
        localBroadcastManager.registerReceiver(broadcastReceiver, intentFilter);

        fasong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("my");
                intent.putExtra( "data" , "发送广播的消息" );
                localBroadcastManager.sendBroadcast(intent);

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册广播,防止内存泄漏
        localBroadcastManager.unregisterReceiver(broadcastReceiver);
    }


}
