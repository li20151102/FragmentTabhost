package com.tyj.myapplication;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import static android.content.Context.MODE_PRIVATE;

/**
 * 识别图中二维码操作
 */

public class AnotherUpFragment3 extends Fragment {
    String mess = null;
    ImageView ivErwm;
    private File currentFile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.another_up_fragment3, container, false);
        ivErwm = view.findViewById(R.id.iv_ewm);
        ivErwm.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Bitmap obmp = ((BitmapDrawable) (ivErwm).getDrawable()).getBitmap();
                int width = obmp.getWidth();
                int height = obmp.getHeight();
                int[] data = new int[width * height];
                obmp.getPixels(data, 0, width, 0, 0, width, height);
                RGBLuminanceSource source = new RGBLuminanceSource(width, height, data);
                BinaryBitmap bitmap1 = new BinaryBitmap(new HybridBinarizer(source));
                QRCodeReader reader = new QRCodeReader();
                Result re = null;
                try {
                    re = reader.decode(bitmap1);
                } catch (NotFoundException e) {
                    e.printStackTrace();
                } catch (ChecksumException e) {
                    e.printStackTrace();
                } catch (FormatException e) {
                    e.printStackTrace();
                }
                if (re == null) {
                    showAlert(obmp);//图片未识别到二维码弹框
                } else {
                    showSelectAlert(obmp, re.getText()); //图片识别到二维码弹框
                }

                return false;
            }
        });
//        TextView tv3 = view.findViewById(R.id.tv_anothers3);
//        Bundle bundle =this.getArguments();//得到从Activity传来的数据
//         if(bundle!=null){
//             mess = bundle.getString("data");
//         }
//        tv3.setText(mess);

        return view;
    }

    private void showAlert(final Bitmap bitmap) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("保存图片")
                .setCancelable(false)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterfacem, int i) {
                        saveImageToGallery(getActivity(), bitmap);
                        Log.e("保存", bitmap.toString());
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterfacem, int i) {
                    }
                });
        builder.show();
    }

    private void showSelectAlert(final Bitmap bitmap, final String url) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("              请选择");
        String str[] = {"保存图片", "识别图中二维码"};
        builder.setItems(str, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterfacem, int i) {
                switch (i) {
                    case 0: {
                        saveImageToGallery(getActivity(), bitmap);
                        Log.e("保存", bitmap.toString());
                    }
                    break;
                    case 1: {
                        Toast.makeText(getActivity(), "识别二维码结果：" + url, Toast.LENGTH_LONG).show();
                        Log.e("BURL", url);

//                        Intent n = new Intent(getActivity(), DetailActivity.class);
//                        n.putExtra(DetailActivity.BUNDLE_KEY_DISPLAY_TYPE, DetailActivity.WEBVIEW_DETAIL);
//                        n.putExtra(DetailwebFragment.WEB_URL, url);
//                        startActivity(n);
                    }
                    break;
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterfacem, int i) {

            }
        });
        builder.show();
    }

    public static void saveImageToGallery(Context context, Bitmap bmp) {     // 首先保存图片
        File appDir = new File(context.getFilesDir().getAbsolutePath(), "MyImg");
        String fileName = System.currentTimeMillis() + ".jpg";
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
            Log.i("picc", "" + file);
            Toast.makeText(context, "图片已保存", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    file.getPath(), fileName, null);
            Log.i("系统库", "" + file.getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + file.getPath())));
        Log.i("图库", "" + file.getPath());
    }

}
