package com.tyj.myapplication;

import android.app.Dialog;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class AnotherUpFragment5 extends Fragment {
    LinearLayout lladd;
    RecyclerView rcview;
    List<String> blist = new ArrayList<>();
    F5Adapter adapter = new F5Adapter();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.another_up_fragment5, container, false);
        rcview = view.findViewById(R.id.rc_rcViews);
        lladd = view.findViewById(R.id.ll_add_widge);
        Button btn = new Button(getActivity());
        btn.setText("自动添加");
        lladd.addView(btn);
        for(int i=0;i<20;i++){
            blist.add("ddr");
        }
        rcview.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcview.setAdapter(adapter);
        rcview.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        return view;
    }

    class F5Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public int getItemViewType(int position) {
            for (int i = 0; i < blist.size(); i++) {
                if (i == position) {
                    return i;
                }
            }
            return 0;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            RecyclerView.ViewHolder viewHolder = null;
            if (i == 0) {
                viewHolder = new F5mViewHolder2(LayoutInflater.from(getActivity()).inflate(R.layout.fragment_c_itemrv2, viewGroup, false));
            } else {
                viewHolder = new F5mViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.fragment_c_itemrv, viewGroup, false));
            }
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            if (i == 0) {
                F5mViewHolder2 f5mViewHolder2 = (F5mViewHolder2) viewHolder;
//                f5mViewHolder2.vv.setText(blist.get(i));
                viewHolder.itemView.setTag(f5mViewHolder2);
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button btn = new Button(getActivity());
                        Drawable drawable= getResources().getDrawable(R.mipmap.xiayibu);
                        drawable.setBounds(0, 0, 25, 25);  /// 这一步必须要做,否则不会显示.//setBounds (int left, int top, int right, int bottom) ,Specify a bounding rectangle for the Drawable, 开始绘制drawable
                        btn.setCompoundDrawables(null,null,drawable,null);
                        btn.setText("自动添加");
                        lladd.addView(btn);

                    }
                });
                viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                        final Dialog dialog = new Dialog(getActivity());
                        dialog.setContentView(R.layout.dialog_custom_item);
                        TextView tv = dialog.findViewById(R.id.tv_title);
                        dialog.show();
                        tv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        return false;
                    }
                });
            } else {
                F5mViewHolder f5mViewHolder = (F5mViewHolder) viewHolder;
                f5mViewHolder.vv.setText(blist.get(i));
                viewHolder.itemView.setTag(f5mViewHolder);
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "vivie"+i, Toast.LENGTH_LONG).show();
//                        SysApplication.getInstance().exit();  //退出所以界面

                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return blist.size();
        }


    }
    class F5mViewHolder extends RecyclerView.ViewHolder{
        TextView vv;
        public F5mViewHolder(@NonNull View itemView) {
            super(itemView);
            vv = itemView.findViewById(R.id.id_num);
        }
    }

    class F5mViewHolder2 extends RecyclerView.ViewHolder{
        TextView vv;
        public F5mViewHolder2(@NonNull View itemView) {
            super(itemView);
            vv = itemView.findViewById(R.id.id_num);
        }
    }

}
