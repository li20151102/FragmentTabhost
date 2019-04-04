package com.tyj.kyle.fragmenttabhost.serviceTest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tyj.kyle.fragmenttabhost.R;

/**
 * @author create by kyle_2019 on 2019/3/8 9:26
 * @package com.tyj.kyle.fragmenttabhost
 * @fileName MyServiceActivity
 */
public class MyServiceActivity extends Activity implements View.OnClickListener {
    private boolean isRemove=false;//是否需要移除
    Button btnStart,btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myservice_test);
        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);
        btnStart.setOnClickListener(this);
        assert btnStop!=null;
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,MyServiceTest.class);
        switch (v.getId()){
            case R.id.btn_start:
                intent.putExtra("cmd",0);//0,开启前台服务,1,关闭前台服务
                startService(intent);
                break;
            case R.id.btn_stop:
                intent.putExtra("cmd",1);//0,开启前台服务,1,关闭前台服务
                startService(intent);
                stopService(intent);//停止服务
                break;

        }
    }
}
