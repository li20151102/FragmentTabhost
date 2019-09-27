package com.tyj.kyle.fragmenttabhost.fragment;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tyj.kyle.fragmenttabhost.R;
import com.tyj.kyle.fragmenttabhost.inputItem.InputActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * @author create by kyle_2019 on 2019/3/12 9:17
 * @package com.example.testapplication
 * @fileName FragmentTest
 */
public class FragmentTestBA extends Fragment {

    @InjectView(R.id.rv_ba_recyclerView)
    RecyclerView recyclerView;
    RecyViewAdapter adapter = new RecyViewAdapter();
    List<String> data1;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ba, container, false);
        ButterKnife.inject(this, root);
        data1 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data1.add(i + "ddd");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        return root;
    }

    class RecyViewAdapter extends RecyclerView.Adapter<RecyViewAdapter.MyViewHodle> {

        @Override
        public MyViewHodle onCreateViewHolder(ViewGroup viewGroup, int i) {
            MyViewHodle hodle = new MyViewHodle(LayoutInflater.from(getActivity())
                    .inflate(R.layout.fragment_c_itemrv, viewGroup, false));
            return hodle;
        }

        @Override
        public void onBindViewHolder(final MyViewHodle myViewHodle, int i) {
            myViewHodle.textView.setText(data1.get(i));
            myViewHodle.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), InputActivity.class));
                    getActivity().overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                }
            });
        }

        @Override
        public int getItemCount() {
            return data1.size();
        }

        class MyViewHodle extends RecyclerView.ViewHolder {

            TextView textView;

            public MyViewHodle(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.id_num);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
