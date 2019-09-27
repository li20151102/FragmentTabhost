package com.tyj.kyle.fragmenttabhost.fragmentTest;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tyj.kyle.fragmenttabhost.BaiDuGpsAcitivity;
import com.tyj.kyle.fragmenttabhost.R;

import org.angmarch.views.NiceSpinner;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * com.tyj.kyle.fragmenttabhost
 * kyle_2019
 * 2019/2/11
 */
public class HomePageFragment extends Fragment implements View.OnClickListener {


//    public static HomePageFragment newInstance(String text){
//
//        HomePageFragment fragmentCommon=new HomePageFragment();
//
//        Bundle bundle=new Bundle();
//
//        bundle.putString("text",text);
//
//        fragmentCommon.setArguments(bundle);
//
//        return fragmentCommon;
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_homepage,container,false);
        Button btn1 = view.findViewById(R.id.btn1);
        Button btn2 = view.findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        NiceSpinner niceSpinner = view.findViewById(R.id.nice_spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("超级管理员", "Two", "Three", "Four", "Five"));
        niceSpinner.attachDataSource(dataset);
        for (int i = 0; i < dataset.size(); i++) {
            if ("Two".equals(dataset.get(i).toString())) {
                niceSpinner.setSelectedIndex(i);
                break;
            }
        }
        niceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
//                showDeleteDialog();
                break;
            case R.id.btn2:
                startActivity(new Intent(getActivity(), BaiDuGpsAcitivity.class));
                break;
        }
    }

//    private void showDeleteDialog() {
//        final Dialog dialog = new Dialog(getActivity(), R.style.Theme_AppCompat_Dialog);
//        View inflate = LayoutInflater.from(getActivity()).inflate(R.item_mytest_layout.deletebatch_dialog_layout, null);
//        final TextView contents = inflate.findViewById(R.id.contents);
//        long differTime = 8 * 60 * 60 * 1000;
//        Date curDate = new Date(System.currentTimeMillis()+differTime);//获取当前时间
//        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd \nHH:mm:ss ");
//        String str = formatter.format(curDate);
//        contents.setText(str);
//        final TextView mConfirm = inflate.findViewById(R.id.confirm);
//        TextView mCancel = inflate.findViewById(R.id.cancel);
//        dialog.getWindow().setBackgroundDrawableResource(R.mipmap.ic_launcher);//弹框靠左右边设置
//        dialog.getWindow().setGravity(Gravity.BOTTOM|Gravity.FILL_HORIZONTAL);//弹框靠左右边设置
//        dialog.setContentView(inflate);
//        dialog.show();
//        mConfirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(),contents.getText().toString(),Toast.LENGTH_LONG).show();
//            }
//        });
//        mCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//    }


}
