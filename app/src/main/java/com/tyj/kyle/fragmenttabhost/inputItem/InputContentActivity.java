package com.tyj.kyle.fragmenttabhost.inputItem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tyj.kyle.fragmenttabhost.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author create by kyle_2019 on 2019/3/14 14:29
 * @package com.tyj.kyle.fragmenttabhost.inputItem
 * @fileName InputActivity
 */
public class InputContentActivity extends AppCompatActivity implements View.OnClickListener {

    @InjectView(R.id.iv_actionBar_back)
    ImageView ivBack;
    @InjectView(R.id.tv_actionBar_titles)
    TextView tvTitle;
    @InjectView(R.id.tv_actionBar_rightMenu)
    TextView tvSave;
    @InjectView(R.id.et_input_content)
    EditText etContent;
    private String mContent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_item);
        ButterKnife.inject(this);
        String getData =getIntent().getStringExtra("key");
        int types = getIntent().getIntExtra("type",-1);
        tvTitle.setText("修改信息");
        etContent.setText(getData);
        if(types==2){//输入限制纯数字
            etContent.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);
        }
        ivBack.setOnClickListener(this);
        tvSave.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_actionBar_back:
                finish();
                break;
            case R.id.tv_actionBar_rightMenu:
                mContent = etContent.getText().toString().trim();
                if(!TextUtils.isEmpty(mContent)){
                    Intent intent = new Intent();
                    intent.putExtra("data",mContent);
                    setResult(RESULT_OK,intent);
                    finish();
                }else {
                    Toast.makeText(this,"修改内容不能为空！",Toast.LENGTH_LONG).show();
                }
                break;
        }
    }


}
