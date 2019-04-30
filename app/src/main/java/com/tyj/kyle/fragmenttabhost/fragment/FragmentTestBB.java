package com.tyj.kyle.fragmenttabhost.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Person;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tyj.kyle.fragmenttabhost.R;

import java.util.ArrayList;
import java.util.List;


/**
 * @author create by kyle_2019 on 2019/3/12 9:17
 * @package com.example.testapplication
 * @fileName FragmentTest
 */
public class FragmentTestBB extends Fragment {
    HorizontalScrollView hlscrollview;
    LinearLayout linlayout;
    RecyclerView rclview;
//    TextView tv1,tv2,tv3;
    private int offset = 0;// 动画图片偏移量
    private int bmpW;// 动画图片宽度
    private int currIndex = 0;// 当前页卡编号
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    String tvdat1,tvdat2,tvdat3,tvdat4,tvdat5,tvdat6;
    private int record =1;
    private List<String> mDatas1;
    private HomeAdapter mAdapter1 = new HomeAdapter();
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_bb, container, false);
        hlscrollview = root.findViewById(R.id.hlsv_hlscrollview);
        linlayout = root.findViewById(R.id.ll_linlayout);
        rclview = root.findViewById(R.id.rv_rclview);
        btn1 = root.findViewById(R.id.btn_butt1);
        btn2 = root.findViewById(R.id.btn_butt2);
        btn3 = root.findViewById(R.id.btn_butt3);
        btn4 = root.findViewById(R.id.btn_butt4);
        btn5 = root.findViewById(R.id.btn_butt5);
        btn6 = root.findViewById(R.id.btn_butt6);

        btn1.setText("天与佳测试0");

        mDatas1 = new ArrayList<String>();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.setVisibility(View.GONE);
                btn3.setVisibility(View.GONE);
                btn4.setVisibility(View.GONE);
                btn1.setTextColor(getResources().getColor(R.color.colorSkyBlue));
                record=1;
                mDatas1.clear();
                for (int i = 'A'; i < 'z'; i++) {
                    mDatas1.add("" + (char) i + "天与佳项目1");
                }

                rclview.setLayoutManager(new LinearLayoutManager(getActivity()));
                rclview.setAdapter(mAdapter1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn3.setVisibility(View.GONE);
                btn4.setVisibility(View.GONE);
                btn2.setTextColor(getResources().getColor(R.color.colorSkyBlue));
                record=2;
                mDatas1.clear();
                for (int i = 0; i < 5; i++) {
                    mDatas1.add(""  + "天与佳项目2"+ i);
                }

                rclview.setLayoutManager(new LinearLayoutManager(getActivity()));
                rclview.setAdapter(mAdapter1);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn4.setVisibility(View.GONE);
                btn3.setTextColor(getResources().getColor(R.color.colorSkyBlue));
                record=3;
                mDatas1.clear();
                for (int i = 0; i < 3; i++) {
                    mDatas1.add(""  + "天与佳项目3"+ i);
                }

                rclview.setLayoutManager(new LinearLayoutManager(getActivity()));
                rclview.setAdapter(mAdapter1);
            }
        });

        for (int i = 'A'; i < 'z'; i++) {
            mDatas1.add("" + (char) i + "天与佳项目1");
        }

        rclview.setLayoutManager(new LinearLayoutManager(getActivity()));
        rclview.setAdapter(mAdapter1);
        rclview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        return root;
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolders> {

        @Override
        public HomeAdapter.MyViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
            HomeAdapter.MyViewHolders holder = new HomeAdapter.MyViewHolders(LayoutInflater.from(getActivity())
                    .inflate(R.layout.fragment_c_itemrv, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final HomeAdapter.MyViewHolders holder, final int position) {
            holder.tv.setText(mDatas1.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvdat1 = btn1.getText().toString();
                    // 点击事件
                    Log.e("TAG", "position" + tvdat1+"  "+mDatas1.get(position));

                    if(record==1){
                        btn2.setVisibility(View.VISIBLE);
                        btn2.setText(mDatas1.get(position)+"");
                        btn1.setTextColor(getResources().getColor(R.color.colorJet));
                        btn2.setTextColor(getResources().getColor(R.color.colorSkyBlue));
                        tvdat2= btn2.getText().toString();

                        mDatas1.clear();
                        mDatas1 = new ArrayList<String>();
                        for (int i = 0; i < 5; i++) {
                            mDatas1.add(""  + "天与佳项目2"+ i);
                        }
                        rclview.setLayoutManager(new LinearLayoutManager(getActivity()));
                        rclview.setAdapter(mAdapter1);
                        record++;
                        Log.e("TAG2",tvdat1+" "+tvdat2+" "+mDatas1.get(position)+"");

                    }else if(record==2){
                        btn3.setVisibility(View.VISIBLE);
                        btn3.setText(mDatas1.get(position)+"");
                        btn1.setTextColor(getResources().getColor(R.color.colorJet));
                        btn2.setTextColor(getResources().getColor(R.color.colorJet));
                        btn3.setTextColor(getResources().getColor(R.color.colorSkyBlue));
                        tvdat3= btn3.getText().toString();

                        mDatas1.clear();
                        mDatas1 = new ArrayList<String>();
                        for (int i = 0; i < 7; i++) {
                            mDatas1.add(""  + "天与佳项目3"+ i);
                        }
                        rclview.setLayoutManager(new LinearLayoutManager(getActivity()));
                        rclview.setAdapter(mAdapter1);
                        record++;

                        Log.e("TAG3",tvdat1+" "+tvdat2+" "+tvdat3+" "+mDatas1.get(position)+"");
                    }else if(record==3){
                        btn4.setVisibility(View.VISIBLE);
                        btn4.setText(mDatas1.get(position)+"");
                        btn1.setTextColor(getResources().getColor(R.color.colorJet));
                        btn2.setTextColor(getResources().getColor(R.color.colorJet));
                        btn3.setTextColor(getResources().getColor(R.color.colorJet));
                        btn4.setTextColor(getResources().getColor(R.color.colorSkyBlue));
                        tvdat4= btn4.getText().toString();

                        mDatas1.clear();
                        mDatas1 = new ArrayList<String>();
                        for (int i = 0; i < 3; i++) {
                            mDatas1.add(""  + "天与佳项目4"+ i);
                        }
                        rclview.setLayoutManager(new LinearLayoutManager(getActivity()));
                        rclview.setAdapter(mAdapter1);
                        record++;

                        Log.e("TAG4",tvdat1+" "+tvdat2+" "+tvdat3+" "+tvdat4+" "+mDatas1.get(position)+"");
                    }



                }
            });

        }

        @Override
        public int getItemCount() {
            return mDatas1.size();
        }

        class MyViewHolders extends RecyclerView.ViewHolder {
            TextView tv;

            public MyViewHolders(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }




}
