package com.tyj.kyle.fragmenttabhost.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.tyj.kyle.fragmenttabhost.R;

import java.util.List;

/**
 * @author create by kyle_2019 on 2019/3/22 15:43
 * @package com.tyj.kyle.fragmenttabhost.adpter
 * @fileName MyRecylerViewAdapter
 */
public class MyRecylerViewAdapter extends RecyclerView.Adapter<MyRecylerViewAdapter.MyViewHolders> {
    private Context mContext;
    private List<String> mDatas;
    private AdapterView.OnItemClickListener mClickListener;

    public MyRecylerViewAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
    class MyViewHolders extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolders(View view, AdapterView.OnItemClickListener mClickListener) {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolders arg0, int arg1) {
        final int pos = arg1;
        arg0.tv.setText(mDatas.get(arg1));

    }

    @Override
    public MyViewHolders onCreateViewHolder(ViewGroup arg0, int arg1) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_c_itemrv, arg0, false);
        MyViewHolders holder = new MyViewHolders(view,mClickListener);
        return holder;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        this.mClickListener = listener;
    }
}
