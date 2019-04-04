package com.tyj.kyle.fragmenttabhost.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tyj.kyle.fragmenttabhost.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * @author create by kyle_2019 on 2019/3/12 9:19
 * @package com.example.testapplication
 * @fileName FragmentActivity
 */
public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {
    @InjectView(R.id.frame_content)
    FrameLayout frameLayout;

    @InjectView(R.id.ll_btn_page1)
    LinearLayout llPage1;
    @InjectView(R.id.iv_btn_page1)
    ImageView ivPage1;
    @InjectView(R.id.tv_btn_page1)
    TextView tvPage1;

    @InjectView(R.id.ll_btn_page2)
    LinearLayout llPage2;
    @InjectView(R.id.iv_btn_page2)
    ImageView ivPage2;
    @InjectView(R.id.tv_btn_page2)
    TextView tvPage2;

    @InjectView(R.id.ll_btn_page3)
    LinearLayout llPage3;
    @InjectView(R.id.iv_btn_page3)
    ImageView ivPage3;
    @InjectView(R.id.tv_btn_page3)
    TextView tvPage3;

    private FragmentManager fm;
    private FragmentTransaction ft;

    private FragmentTestA fragmentTest1;
    private FragmentTestB fragmentTest2;
    private FragmentTestC fragmentTest3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_layout);
        ButterKnife.inject(this);
        llPage1.setOnClickListener(this);
        llPage2.setOnClickListener(this);
        llPage3.setOnClickListener(this);
        defaultImgTvData();
    }

    @Override
    public void onClick(View v) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (v.getId()){
            case R.id.ll_btn_page1:
                if(fragmentTest1==null){
                    fragmentTest1 = new FragmentTestA();
                }
                if(!fragmentTest1.isAdded()){
                    ft.add(R.id.frame_content,fragmentTest1);
                }
                if(fragmentTest2!=null&&fragmentTest2.isAdded()){
                    ft.hide(fragmentTest2);
                }
                if(fragmentTest3!=null&&fragmentTest3.isAdded()){
                    ft.hide(fragmentTest3);
                }
                ft.show(fragmentTest1);
                resetImg();
                resetTv();
                ivPage1.setImageResource(R.mipmap.ic_launcher_round);
                tvPage1.setTextColor(Color.rgb(247,0,5));
                ft.commit();
                break;
            case R.id.ll_btn_page2:
                if(fragmentTest2==null){
                    fragmentTest2 = new FragmentTestB();
                }
                if(!fragmentTest2.isAdded()){
                    ft.add(R.id.frame_content,fragmentTest2);
                }
                if(fragmentTest1!=null&&fragmentTest1.isAdded()){
                    ft.hide(fragmentTest1);
                }
                if(fragmentTest3!=null&&fragmentTest3.isAdded()){
                    ft.hide(fragmentTest3);
                }
                ft.show(fragmentTest2);
                resetImg();
                resetTv();
                ivPage2.setImageResource(R.mipmap.ic_launcher_round);
                tvPage2.setTextColor(Color.rgb(247,0,5));
                ft.commit();
                break;
            case R.id.ll_btn_page3:
                if(fragmentTest3==null){
                    fragmentTest3 = new FragmentTestC();
                }
                if(!fragmentTest3.isAdded()){
                    ft.add(R.id.frame_content,fragmentTest3);
                }
                if(fragmentTest1!=null&&fragmentTest1.isAdded()){
                    ft.hide(fragmentTest1);
                }
                if(fragmentTest2!=null&&fragmentTest2.isAdded()){
                    ft.hide(fragmentTest2);
                }
                ft.show(fragmentTest3);
                resetImg();
                resetTv();
                ivPage3.setImageResource(R.mipmap.ic_launcher_round);
                tvPage3.setTextColor(Color.rgb(247,0,5));
                ft.commit();
                break;

        }

    }

    private void defaultImgTvData(){
        ivPage1.setImageResource(R.mipmap.ic_launcher_round);
        ivPage2.setImageResource(R.mipmap.ic_launcher);
        ivPage3.setImageResource(R.mipmap.ic_launcher);
        tvPage1.setText("测试1");
        tvPage2.setText("测试2");
        tvPage3.setText("测试3");
        resetTv();
        tvPage1.setTextColor(Color.rgb(247,0,5));

        //初始化fm
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        if(fragmentTest1==null){
            fragmentTest1 = new FragmentTestA();
        }
        ft.add(R.id.frame_content,fragmentTest1);
        ft.show(fragmentTest1);
        ft.commit();
    }
    private void resetImg() {
        ivPage1.setImageResource(R.mipmap.ic_launcher);
        ivPage2.setImageResource(R.mipmap.ic_launcher);
        ivPage3.setImageResource(R.mipmap.ic_launcher);
    }

    private void resetTv(){
        tvPage1.setTextColor(Color.rgb(157,144,144));
        tvPage2.setTextColor(Color.rgb(157,144,144));
        tvPage3.setTextColor(Color.rgb(157,144,144));
    }
}
