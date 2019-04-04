package com.tyj.kyle.fragmenttabhost.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tyj.kyle.fragmenttabhost.R;

import java.util.ArrayList;
import java.util.List;


/**
 * @author create by kyle_2019 on 2019/3/21 9:17
 * @package com.example.testapplication
 * @fileName FragmentTest
 */
public class FragmentTestC extends Fragment {
    RecyclerView rv1, rv2, rv3, rv4;
    private List<String> mDatas1,mDatas2,mDatas3,mDatas4;
    private HomeAdapter1 mAdapter1 = new HomeAdapter1();
    private HomeAdapter2 mAdapter2 = new HomeAdapter2();
    private HomeAdapter3 mAdapter3 = new HomeAdapter3();
    private HomeAdapter4 mAdapter4 = new HomeAdapter4();
    View root;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_c, container, false);
        mDatas1 = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas1.add("" + (char) i + "fsfsdfsdfsd");
        }

        rv1 = root.findViewById(R.id.rv_linkage_r1);
        rv1.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv1.setAdapter(mAdapter1);
        rv1.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        rv2 = root.findViewById(R.id.rv_linkage_r2);
        rv2.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        rv3 = root.findViewById(R.id.rv_linkage_r3);
        rv3.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        rv4 = root.findViewById(R.id.rv_linkage_r4);
        rv4.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        rv2.setVisibility(View.INVISIBLE);
        rv3.setVisibility(View.INVISIBLE);
        rv4.setVisibility(View.INVISIBLE);

        return root;
    }

    class HomeAdapter1 extends RecyclerView.Adapter<HomeAdapter1.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(getActivity())
                    .inflate(R.layout.fragment_c_itemrv, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.tv.setText(mDatas1.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // 点击事件
                    Log.e("TAG", "EE" + position+"  "+mDatas1.get(position));
                    switch (position){
                        case 0:
                            rv2.setVisibility(View.VISIBLE);
                            rv3.setVisibility(View.INVISIBLE);
                            rv4.setVisibility(View.INVISIBLE);
                            mDatas2 = new ArrayList<String>();
                            for (int i = 0; i < 20; i++) {
                                mDatas2.add("" + (char) i + "呵呵2");
                            }
                            rv2.setLayoutManager(new LinearLayoutManager(getActivity()));
                            rv2.setAdapter(mAdapter2);
                            mAdapter2.notifyDataSetChanged();
                            break;
                        case 1:
                            rv2.setVisibility(View.VISIBLE);
                            rv3.setVisibility(View.INVISIBLE);
                            rv4.setVisibility(View.INVISIBLE);
                            mDatas2 = new ArrayList<String>();
                            for (int i = 0; i < 9; i++) {
                                mDatas2.add("" + (char) i + "didir");
                            }
                            rv2.setLayoutManager(new LinearLayoutManager(getActivity()));
                            rv2.setAdapter(mAdapter2);
                            mAdapter2.notifyDataSetChanged();
                            break;
                        case 2:
                            rv2.setVisibility(View.VISIBLE);
                            rv3.setVisibility(View.INVISIBLE);
                            rv4.setVisibility(View.INVISIBLE);
                            mDatas2 = new ArrayList<String>();
                            for (int i = 0; i < 6; i++) {
                                mDatas2.add("" + (char) i + "sssd");
                            }
                            rv2.setLayoutManager(new LinearLayoutManager(getActivity()));
                            rv2.setAdapter(mAdapter2);
                            mAdapter2.notifyDataSetChanged();
                            break;
                    }

                }
            });

        }

        @Override
        public int getItemCount() {
            return mDatas1.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }
    class HomeAdapter2 extends RecyclerView.Adapter<HomeAdapter2.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(getActivity())
                    .inflate(R.layout.fragment_c_itemrv, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.tv.setText(mDatas2.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    // 点击事件
                    Log.e("TAG", "EE" + position);
                    switch (position){
                        case 0:
                            rv3.setVisibility(View.VISIBLE);
                            rv4.setVisibility(View.INVISIBLE);
                            mDatas3 = new ArrayList<String>();
                            for (int i = 0; i < 7; i++) {
                                mDatas3.add("" + (char) i + "呵呵2");
                            }
                            rv3.setLayoutManager(new LinearLayoutManager(getActivity()));
                            rv3.setAdapter(mAdapter3);
                            mAdapter3.notifyDataSetChanged();
                            break;
                        case 1:
                            rv3.setVisibility(View.VISIBLE);
                            rv4.setVisibility(View.INVISIBLE);
                            mDatas3 = new ArrayList<String>();
                            for (int i = 0; i < 9; i++) {
                                mDatas3.add("" + (char) i + "didir");
                            }
                            rv3.setLayoutManager(new LinearLayoutManager(getActivity()));
                            rv3.setAdapter(mAdapter3);
                            mAdapter3.notifyDataSetChanged();
                            break;
                        case 2:
                            rv3.setVisibility(View.VISIBLE);
                            rv4.setVisibility(View.INVISIBLE);
                            mDatas3 = new ArrayList<String>();
                            for (int i = 0; i < 6; i++) {
                                mDatas3.add("" + (char) i + "sssd");
                            }
                            rv3.setLayoutManager(new LinearLayoutManager(getActivity()));
                            rv3.setAdapter(mAdapter3);
                            mAdapter3.notifyDataSetChanged();
                            break;
                    }

                }
            });

        }

        @Override
        public int getItemCount() {
            return mDatas2.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }

    class HomeAdapter3 extends RecyclerView.Adapter<HomeAdapter3.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(getActivity())
                    .inflate(R.layout.fragment_c_itemrv, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.tv.setText(mDatas3.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    // 点击事件
                    Log.e("TAG", "EE" + position);

                    switch (position){
                        case 0:
                            rv4.setVisibility(View.VISIBLE);
                            mDatas4 = new ArrayList<String>();
                            for (int i = 0; i < 7; i++) {
                                mDatas4.add("" + (char) i + "呵呵2");
                            }
                            rv4.setLayoutManager(new LinearLayoutManager(getActivity()));
                            rv4.setAdapter(mAdapter4);
                            mAdapter4.notifyDataSetChanged();
                            break;
                        case 1:
                            rv4.setVisibility(View.VISIBLE);
                            mDatas4 = new ArrayList<String>();
                            for (int i = 0; i < 9; i++) {
                                mDatas4.add("" + (char) i + "didir");
                            }
                            rv4.setLayoutManager(new LinearLayoutManager(getActivity()));
                            rv4.setAdapter(mAdapter4);
                            mAdapter4.notifyDataSetChanged();
                            break;
                        case 2:
                            rv4.setVisibility(View.VISIBLE);
                            mDatas4 = new ArrayList<String>();
                            for (int i = 0; i < 6; i++) {
                                mDatas4.add("" + (char) i + "sssd");
                            }
                            rv4.setLayoutManager(new LinearLayoutManager(getActivity()));
                            rv4.setAdapter(mAdapter4);
                            mAdapter4.notifyDataSetChanged();
                            break;
                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            return mDatas3.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }

    class HomeAdapter4 extends RecyclerView.Adapter<HomeAdapter4.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(getActivity())
                    .inflate(R.layout.fragment_c_itemrv, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.tv.setText(mDatas4.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    // 点击事件
                    Log.e("TAG", "EE" + position);
                }
            });

        }

        @Override
        public int getItemCount() {
            return mDatas4.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }

}
