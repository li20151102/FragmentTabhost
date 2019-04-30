package com.tyj.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class AnotherUpFragment4 extends Fragment {

    RecyclerView rcviews;
    List<F4ItemDataBean> listData = new ArrayList<>();
    MAdapter adapter =new MAdapter();
    F4ItemDataBean fdb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.another_up_fragment4, container, false);
        rcviews = view.findViewById(R.id.rcviews);
        for(int i=0;i<10;i++){
            fdb= new F4ItemDataBean();
            if(i==0){
                fdb.setTitle("F4标题1");
                fdb.setContent("F4内容1。。。。");
            }else if(i==1){
                fdb.setTitle("F4标题2");
                fdb.setContent("F4内容2。。。。");
            }else if(i==2){
                fdb.setTitle("F4标题3");
                fdb.setContent("F4内容3。。。。");
            }else {
                fdb.setTitle("F4标题");
                fdb.setContent("F4内容。。。。");
            }
            listData.add(fdb);

        }
        rcviews.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcviews.setAdapter(adapter);
        rcviews.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        return view;
    }

    class MAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{  //多布局适配

        @Override
        public int getItemViewType(int position) { //最重要的方法返回viewType的值，把position赋值给viewType
            for (int i = 0; i < listData.size(); i++) {
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
            if(i%2==0){
                View mvh1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frg_f4_layout_item,viewGroup,false);
                viewHolder = new mViewHolder(mvh1);
            }else if(i%2==1){
                View mvh2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frg_f4_layout_item2,viewGroup,false);
                viewHolder = new mViewHolder2(mvh2);
            }else {
                View mvh1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frg_f4_layout_item,viewGroup,false);
                viewHolder = new mViewHolder(mvh1);
            }
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            if(i%2==0){
                mViewHolder viewHolder1 = (mViewHolder) viewHolder;
                viewHolder1.title.setText(listData.get(i).getTitle());
                viewHolder1.content.setText(listData.get(i).getContent());
                viewHolder1.itemView.setTag(i);
            }
            else if(i%2==1){
                mViewHolder2 viewHolder2 = (mViewHolder2) viewHolder;
                viewHolder2.title2.setText(listData.get(i).getTitle());
                viewHolder2.content2.setText(listData.get(i).getContent());
                viewHolder2.itemView.setTag(i);
            }else {
                mViewHolder viewHolder1 = (mViewHolder) viewHolder;
                viewHolder1.title.setText(listData.get(i).getTitle());
                viewHolder1.content.setText(listData.get(i).getContent());
                viewHolder1.itemView.setTag(i);
            }

        }

        @Override
        public int getItemCount() {
            return listData.size();
        }
    }

//    class MAdapter extends RecyclerView.Adapter<mViewHolder>{ //单布局适配
//
//        @NonNull
//        @Override
//        public mViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//
//            mViewHolder mvh = new mViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.frg_f4_layout_item,viewGroup,false));
//            return mvh;
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull mViewHolder mViewHolder, int i) {
//            mViewHolder.title.setText(listData.get(i).getTitle());
//            mViewHolder.content.setText(listData.get(i).getContent());
//        }
//
//        @Override
//        public int getItemCount() {
//            return listData.size();
//        }
//    }

    public class mViewHolder extends RecyclerView.ViewHolder{

        TextView title,content;
        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_f4_title);
            content = itemView.findViewById(R.id.tv_f4_content);
        }
    }
    public class mViewHolder2 extends RecyclerView.ViewHolder{

        TextView title2,content2;
        public mViewHolder2(@NonNull View itemView) {
            super(itemView);
            title2 = itemView.findViewById(R.id.tv_f4_title2);
            content2 = itemView.findViewById(R.id.tv_f4_content2);
        }
    }

    class F4ItemDataBean{
        String title;
        String content;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}
