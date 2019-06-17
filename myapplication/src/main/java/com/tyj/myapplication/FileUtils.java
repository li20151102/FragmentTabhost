package com.tyj.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author create by kyle_2019 on 2019/5/5 15:28
 * @package com.tyj.kyle.fragmenttabhost
 * @fileName FileUtils
 */
public class FileUtils {
    private static final String CACHE_DIR = Environment.getExternalStorageDirectory() + "/my_caches/images";// 缓存文件夹

    /**
     * 判断sdcard是否挂载
     *
     * @return
     */
    public static boolean isMounted() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取sdcard的根目录
     *
     * @return
     */
    public static String getSDCARDDir() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    /**
     * 存储图片一
     *
     * @param url  ： 图片的http网络地址
     * @param data
     * @throws IOException
     */
    public static void saveImage(String url, byte[] data) throws IOException {
        // 1. 判断是否有sdcard
        if (!isMounted()) {
            return;
        }
        // 2. 判断是否有缓存的文件夹
        File dir = new File(CACHE_DIR);
        if (!dir.exists()) {
            dir.mkdirs();// 多层文件夹
        }
        // 3. 存储图片到sdcard
        File file = new File(dir, getFilename(url));
        FileOutputStream fos = new FileOutputStream(file);

        fos.write(data);
        fos.close();
    }

    /**
     * 保存图片二
     *
     * @param url    : 图片的http网络地址
     * @param bitmap
     * @throws IOException
     */
    public static void saveImage(String url, Bitmap bitmap) throws IOException {
        // 1. 判断是否有sdcard
        if (!isMounted()) {
            return;
        }
        // 2. 判断是否有缓存的文件夹
        File dir = new File(CACHE_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 3. 存储图片到sdcard
        File file = new File(dir, getFilename(url));
        FileOutputStream fos = new FileOutputStream(file);

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
    }

    /**
     * 获取图片名
     *
     * @param url
     * @return
     */
    public static String getFilename(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }

    /**
     * 读图片
     *
     * @param url
     * @return
     */
    public static Bitmap readImage(String url) {
        // 判断是否有sdcard
        if (!isMounted()) {
            return null;
        }
        File file = new File(CACHE_DIR, getFilename(url));
        if (file.exists()) {
            // file->bitmap
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }
        return null;
    }

    /**
     * 清空缓存目录
     */
    public void clearCaches() {
        File dir = new File(CACHE_DIR);
        File[] allfiles = dir.listFiles();
        for (File file : allfiles) {
            file.delete();
        }
    }
}
