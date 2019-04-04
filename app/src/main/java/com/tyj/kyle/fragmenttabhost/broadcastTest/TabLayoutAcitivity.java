package com.tyj.kyle.fragmenttabhost.broadcastTest;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tyj.kyle.fragmenttabhost.MyApplication;
import com.tyj.kyle.fragmenttabhost.R;
import com.umeng.message.PushAgent;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class TabLayoutAcitivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks{
    private TabLayout tabLayout = null;
    private ViewPager viewPager;
    private Fragment[] mFragmentArrays = new Fragment[2];
    private String[] mTabTitles = new String[2];

    private static final int REQUEST_CODE_QRCODE_PERMISSIONS = 1;
    private static final int REQUEST_CODE_LOC_PERMISSIONS = 2;
    ImageView mScan;
    TextView title;
    LocalBroadcastManager localBroadcastManager;
    IntentFilter intentFilter = new IntentFilter("broad");
    TabFragmentB.MyBroadCastTest myBroadCastTest = new TabFragmentB.MyBroadCastTest();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        MyApplication.setStatusBar(this);//延申状态栏
        MyApplication.setStatusBarLightModes(this,true);//改变状态栏字体颜色
        PushAgent.getInstance(this).onAppStart();//友盟推送
        localBroadcastManager = LocalBroadcastManager.getInstance(getApplicationContext());
        localBroadcastManager.registerReceiver(myBroadCastTest,intentFilter);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.tab_viewpager);
        mScan = (ImageView) findViewById(R.id.scan);
        title = (TextView) findViewById(R.id.tv_actionbar_title);
        initView();
        setOnClick();
    }

    private void initView() {
        mTabTitles[0] = "推荐";
        mTabTitles[1] = "热点";
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);
        mFragmentArrays[0] = new TabFragmentA();
        mFragmentArrays[1] = new TabFragmentB();
        PagerAdapter pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFragmentArrays[i];
            }

            @Override
            public int getCount() {
                return mFragmentArrays.length;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTabTitles[position];
            }
        };
        viewPager.setAdapter(pagerAdapter);
        //将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setOnClick() {
        mScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestCodeQRCodePermissions();
            }
        });
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("broad");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    @AfterPermissionGranted(REQUEST_CODE_QRCODE_PERMISSIONS)
    private void requestCodeQRCodePermissions() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            //跳转到扫描界面
            startActivity(new Intent(TabLayoutAcitivity.this, QRCodeScanActivity.class));
        } else {
            EasyPermissions.requestPermissions(this, "扫描二维码需要打开相机和散光灯的权限", REQUEST_CODE_QRCODE_PERMISSIONS, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (requestCode == REQUEST_CODE_QRCODE_PERMISSIONS) {
            Toast.makeText(this, "您拒绝了「扫描」所需要的相关权限!", Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST_CODE_LOC_PERMISSIONS) {
            Toast.makeText(this, "您拒绝了定位所需要的相关权限!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(myBroadCastTest);
    }
}
