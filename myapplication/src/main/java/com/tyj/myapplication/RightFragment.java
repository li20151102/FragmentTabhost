package com.tyj.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RightFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inintView();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.right_fragment, container, false);
    }

    public static void inintView() {

    }


}
