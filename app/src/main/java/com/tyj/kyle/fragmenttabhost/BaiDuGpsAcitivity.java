package com.tyj.kyle.fragmenttabhost;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

import java.util.Iterator;

public class BaiDuGpsAcitivity extends Activity {

    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();
    private TextView addresss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidugps);
        addresss = findViewById(R.id.address);
        initViewOption();
    }

    private void initViewOption() {
        mLocationClient = new LocationClient(getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        //注册监听函数
        LocationClientOption option = new LocationClientOption();

        option.setIsNeedAddress(true);
//可选，是否需要地址信息，默认为不需要，即参数为false
//如果开发者需要获得当前点的地址信息，此处必须为true

        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
//可选，设置定位模式，默认高精度
//LocationMode.Hight_Accuracy：高精度；
//LocationMode. Battery_Saving：低功耗；
//LocationMode. Device_Sensors：仅使用设备；

        option.setCoorType("bd09ll");
//可选，设置返回经纬度坐标类型，默认GCJ02
//GCJ02：国测局坐标；
//BD09ll：百度经纬度坐标；
//BD09：百度墨卡托坐标；
//海外地区定位，无需设置坐标类型，统一返回WGS84类型坐标

        option.setScanSpan(1000);
//可选，设置发起定位请求的间隔，int类型，单位ms
//如果设置为0，则代表单次定位，即仅定位一次，默认为0
//如果设置非0，需设置1000ms以上才有效

        option.setOpenGps(true);
//可选，设置是否使用gps，默认false
//使用高精度和仅用设备两种定位模式的，参数必须设置为true

        option.setLocationNotify(true);
//可选，设置是否当GPS有效时按照1S/1次频率输出GPS结果，默认false

        option.setIgnoreKillProcess(false);
//可选，定位SDK内部是一个service，并放到了独立进程。
//设置是否在stop的时候杀死这个进程，默认（建议）不杀死，即setIgnoreKillProcess(true)

        option.SetIgnoreCacheException(false);
//可选，设置是否收集Crash信息，默认收集，即参数为false

        option.setWifiCacheTimeOut(5 * 60 * 1000);
//可选，V7.2版本新增能力
//如果设置了该接口，首次启动定位时，会先判断当前Wi-Fi是否超出有效期，若超出有效期，会先重新扫描Wi-Fi，然后定位

        option.setEnableSimulateGps(false);
//可选，设置是否需要过滤GPS仿真结果，默认需要，即参数为false

//mLocationClient为第二步初始化过的LocationClient对象
//需将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
//更多LocationClientOption的配置，请参照类参考中LocationClientOption类的详细说明

        mLocationClient.setLocOption(option);
        mLocationClient.start();
    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            //以下只列举部分获取地址相关的结果信息
            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明
            double latitude = location.getLatitude();    //获取纬度信息
            double longitude = location.getLongitude();    //获取经度信息
            String addr = location.getAddrStr();    //获取详细地址信息
            addresss.setText(addr+"\n"+"纬度"+latitude+"\n"+"经度:"+longitude);
            String country = location.getCountry();    //获取国家
            String province = location.getProvince();    //获取省份
            String city = location.getCity();    //获取城市
            String district = location.getDistrict();    //获取区县
            String street = location.getStreet();    //获取街道信息
//            Toast.makeText(getApplicationContext(),"DSFDF"+""+longitude+latitude+addr+country+province+city+district+street,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.stop();
    }

    private LocationManager locationManager;
    private GpsStatus gpsstatus;

    @SuppressLint("MissingPermission")
    private void initView() {
        //获取到LocationManager对象
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        //根据设置的Criteria对象，获取最符合此标准的provider对象
        String currentProvider = locationManager.getProvider(LocationManager.GPS_PROVIDER).getName();

        //根据当前provider对象获取最后一次位置信息
        Location currentLocation = locationManager.getLastKnownLocation(currentProvider);
        //如果位置信息为null，则请求更新位置信息
        if (currentLocation == null) {
            locationManager.requestLocationUpdates(currentProvider, 0, 0, locationListener);
        }
        //增加GPS状态监听器
        locationManager.addGpsStatusListener(gpsListener);

        //直到获得最后一次位置信息为止，如果未获得最后一次位置信息，则显示默认经纬度
        //每隔10秒获取一次位置信息
        while (true) {
            currentLocation = locationManager.getLastKnownLocation(currentProvider);
            if (currentLocation != null) {
                Log.d("Location", "Latitude: " + currentLocation.getLatitude());
                Log.d("Location", "location: " + currentLocation.getLongitude());
                break;
            } else {
                Log.d("Location", "Latitude: " + 0);
                Log.d("Location", "location: " + 0);
            }
            try {
                Thread.sleep(1000*10);
            } catch (InterruptedException e) {
                Log.e("Location", e.getMessage());
            }
        }
    }

    private GpsStatus.Listener gpsListener = new GpsStatus.Listener() {
        //GPS状态发生变化时触发
        @SuppressLint("MissingPermission")
        @Override
        public void onGpsStatusChanged(int event) {
            //获取当前状态
            gpsstatus = locationManager.getGpsStatus(null);
            switch (event) {
                //第一次定位时的事件
                case GpsStatus.GPS_EVENT_FIRST_FIX:
                    break;
                //开始定位的事件
                case GpsStatus.GPS_EVENT_STARTED:
                    break;
                //发送GPS卫星状态事件
                case GpsStatus.GPS_EVENT_SATELLITE_STATUS:
                    Toast.makeText(getApplicationContext(), "GPS_EVENT_SATELLITE_STATUS", Toast.LENGTH_SHORT).show();
                    Iterable<GpsSatellite> allSatellites = gpsstatus.getSatellites();
                    Iterator<GpsSatellite> it = allSatellites.iterator();
                    int count = 0;
                    while (it.hasNext()) {
                        count++;
                    }
                    Toast.makeText(getApplicationContext(), "Satellite Count:" + count, Toast.LENGTH_SHORT).show();
                    break;
                //停止定位事件
                case GpsStatus.GPS_EVENT_STOPPED:
                    Log.d("Location", "GPS_EVENT_STOPPED");
                    break;
            }
        }
    };


    //创建位置监听器
    private LocationListener locationListener = new LocationListener() {
        //位置发生改变时调用
        @Override
        public void onLocationChanged(Location location) {
            Log.d("Location", "onLocationChanged");
        }

        //provider失效时调用
        @Override
        public void onProviderDisabled(String provider) {
            Log.d("Location", "onProviderDisabled");
        }

        //provider启用时调用
        @Override
        public void onProviderEnabled(String provider) {
            Log.d("Location", "onProviderEnabled");
        }

        //状态改变时调用
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Log.d("Location", "onStatusChanged");
        }
    };

//    /Latitude: 纬度Latitude: 30.287938
//             /Location: 经度location: 120.1076
}
