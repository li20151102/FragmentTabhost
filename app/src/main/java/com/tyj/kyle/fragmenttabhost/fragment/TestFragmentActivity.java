package com.tyj.kyle.fragmenttabhost.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.tyj.kyle.fragmenttabhost.R;

/**
 * @author create by kyle_2019 on 2019/9/27 10:27
 * @package com.tyj.kyle.fragmenttabhost.fragment
 * @fileName TestFragmentActivity
 * 用activity展示fragment中的fragment
 */
public class TestFragmentActivity extends FragmentActivity  {

    private FragmentTestB fragmentTestB;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testfrg_activity);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTestB = new FragmentTestB();
        fragmentTransaction.add(R.id.frg,fragmentTestB);
        fragmentTransaction.commit();
    }
}
