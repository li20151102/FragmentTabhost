package com.tyj.kyle.fragmenttabhost.inputItem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tyj.kyle.fragmenttabhost.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author create by kyle_2019 on 2019/3/14 14:29
 * @package com.tyj.kyle.fragmenttabhost.inputItem
 * @fileName InputActivity
 */
public class InputActivity extends AppCompatActivity implements View.OnClickListener {

    @InjectView(R.id.ll_input_name)
    LinearLayout llNmae;
    @InjectView(R.id.tv_input_name)
    TextView tvNmae;
    @InjectView(R.id.ll_input_age)
    LinearLayout llAge;
    @InjectView(R.id.tv_input_age)
    TextView tvAge;
    private String mName;
    private String mAge;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        ButterKnife.inject(this);
        llNmae.setOnClickListener(this);
        llAge.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_input_name:
                Intent intent = new Intent(this,InputContentActivity.class);
                intent.putExtra("key",mName);
                startActivityForResult(intent,0x1001);
                break;
            case R.id.ll_input_age:
                Intent intents = new Intent(this,InputContentActivity.class);
                intents.putExtra("key",mAge);
                intents.putExtra("type",2);
                startActivityForResult(intents,0x1002);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("TAG","update");
        if(resultCode==RESULT_OK){
            switch (requestCode){
                case 0x1001:
                    mName = data.getStringExtra("data");
                    tvNmae.setText(mName);
                    break;
                case 0x1002:
                    mAge = data.getStringExtra("data");
                    tvAge.setText(mAge);
                    break;
            }

        }
    }
}
