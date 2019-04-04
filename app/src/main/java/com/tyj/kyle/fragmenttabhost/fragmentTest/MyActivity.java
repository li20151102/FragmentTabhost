package com.tyj.kyle.fragmenttabhost.fragmentTest;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.heima.tabview.library.TabView;
import com.heima.tabview.library.TabViewChild;
import com.tyj.kyle.fragmenttabhost.R;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends FragmentActivity {
    TabView tabView;
    List<TabViewChild> tabViewChildList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        tabView= (TabView) findViewById(R.id.tabView);

        TabViewChild tabViewChild01=new TabViewChild(R.drawable.dw_home_2,R.drawable.dw_home_1,"主页",  new HomePageFragment());
        TabViewChild tabViewChild02=new TabViewChild(R.drawable.dw_mine_2,R.drawable.dw_mine_1,"我的",  new HomePageFragment());

        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild02);

        tabView.setTabViewChild(tabViewChildList,getSupportFragmentManager());
        tabView.setOnTabChildClickListener(new TabView.OnTabChildClickListener() {

            @Override

            public void onTabChildClick(int  position, ImageView currentImageIcon, TextView currentTextView) {

//                 Toast.makeText(getApplicationContext(),"position:"+position,Toast.LENGTH_SHORT).show();

            }

        });

    }

}
