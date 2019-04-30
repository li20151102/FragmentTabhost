package com.tyj.myapplication;

import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class AnotherRightFragment1 extends Fragment{
    private List<String> mDatas1;
    private HomeAdapters mAdapter1 = new HomeAdapters();
    RecyclerView rclview;
    public AnotherRightFragment1.FramentCallBack framentCallBack;
    public interface FramentCallBack{
        void setValue(String dd);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.another_right_fragment, container, false);
        rclview = view.findViewById(R.id.rv_rclview);
        mDatas1 = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas1.add("" + (char) i + "天与佳项目1");
        }

        rclview.setLayoutManager(new LinearLayoutManager(getActivity()));
        rclview.setAdapter(mAdapter1);
        rclview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        return view;
    }

    class HomeAdapters extends RecyclerView.Adapter<HomeAdapters.MyViewHolder>{

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.fragment_c_itemrv, viewGroup, false));
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            myViewHolder.tv.setText(mDatas1.get(i));
//            Log.e("TAG", "position"+"  "+mDatas1.get(i));
//            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    Toast.makeText(getActivity(),"   sfsdf",Toast.LENGTH_LONG).show();
//                    final MainActivity2 mainActivity2 = new MainActivity2();
//                    mainActivity2.setValue("frament向activity传值成功");
//                }
//            });
        }

        @Override
        public int getItemCount() {
            return mDatas1.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{

            TextView tv;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.id_num);
            }
        }

    }

//    @Override
//    public void onAttach(Context context) {
//        framentCallBack = (AnotherRightFragment1.FramentCallBack) context;
//        super.onAttach(context);
//    }
}
