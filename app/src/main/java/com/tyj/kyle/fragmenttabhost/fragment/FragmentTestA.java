package com.tyj.kyle.fragmenttabhost.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tyj.kyle.fragmenttabhost.R;


/**
 * @author create by kyle_2019 on 2019/3/12 9:17
 * @package com.example.testapplication
 * @fileName FragmentTest
 */
public class FragmentTestA extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_a, container, false);
        TextView view = root.findViewById(R.id.text);
        view.setText("mParamA");
        return root;
    }

}
