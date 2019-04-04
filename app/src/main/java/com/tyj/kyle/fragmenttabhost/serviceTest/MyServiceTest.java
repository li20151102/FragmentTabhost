package com.tyj.kyle.fragmenttabhost.serviceTest;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.tyj.kyle.fragmenttabhost.R;

/**
 * @author create by kyle_2019 on 2019/3/8 9:18
 * @package com.tyj.kyle.fragmenttabhost
 * @fileName MyServiceTest
 */
public class MyServiceTest extends Service {

    /**
     * id不可设置为0,否则不能设置为前台service
     */
    private boolean isRemove=false;//是否需要移除
    private static final int NOTIFICATION_DOWNLOAD_PROGRESS_ID = 0x0001;

    public void createNotification(){
        //使用兼容版本
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        //设置状态栏的通知图标
        builder.setSmallIcon(R.mipmap.ic_launcher);
        //设置通知栏横条的图标
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background));
        //禁止用户点击删除按钮删除
        builder.setAutoCancel(false);
        //禁止滑动删除
        builder.setOngoing(true);
        //右上角的时间显示
        builder.setShowWhen(true);
        //设置通知栏的标题内容
        builder.setContentTitle("I am Foreground Service!!!");
        //创建通知
        Notification notification = builder.build();
        //设置为前台服务
        startForeground(NOTIFICATION_DOWNLOAD_PROGRESS_ID,notification);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG","000000");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG","111111");

        int i=intent.getExtras().getInt("cmd");
        if(i==0){
            if(!isRemove) {
                createNotification();
            }
            isRemove=true;
        }else {
            //移除前台服务
            if (isRemove) {
                stopForeground(true);
            }
            isRemove=false;
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //移除前台服务
        if (isRemove) {
            stopForeground(true);
        }
        isRemove=false;
        Log.e("TAG","222222");
    }
}
