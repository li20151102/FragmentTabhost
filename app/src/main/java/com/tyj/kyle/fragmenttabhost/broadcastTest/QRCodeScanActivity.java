package com.tyj.kyle.fragmenttabhost.broadcastTest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;

import com.tyj.kyle.fragmenttabhost.R;

import cn.bingoogolapple.qrcode.core.QRCodeView;

/**
 * @author create by kyle_2019 on 2019/3/6 15:59
 * @package com.tyj.kyle.fragmenttabhost
 * @fileName QRCodeScanActivity
 */
public class QRCodeScanActivity extends Activity implements QRCodeView.Delegate{
    QRCodeView mQRCodeView;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_scan);
        mQRCodeView = findViewById(R.id.zxingview);
        mQRCodeView.setDelegate(this);
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        //扫码成功的回调
        vibrate();
        Log.e("TAG", "onScanQRCodeSuccess: " + result);
        // Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
        mQRCodeView.startSpot(); // 延迟0.5秒后开始识别

        //扫码结果请求
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
    //打开相机失败的回调
        Log.e("TAG", "onScanQRCodeOpenCameraError: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mQRCodeView.startCamera();//打开相机
        mQRCodeView.showScanRect();//显示扫描框
        mQRCodeView.startSpot();//开始扫描
    }

    @Override
    protected void onStop() {
        mQRCodeView.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mQRCodeView.onDestroy();
        super.onDestroy();
    }

    //震动
    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }
}
