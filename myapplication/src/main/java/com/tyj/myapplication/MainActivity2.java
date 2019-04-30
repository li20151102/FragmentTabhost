package com.tyj.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements AnotherRightFragment1.FramentCallBack {
    Button button,button2,button3,button4,button5;
    FragmentManager fm;
    FragmentTransaction transac;
    AnotherRightFragment1 arFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SysApplication.getInstance().addActivity(this);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        button5.setVisibility(View.VISIBLE);
        fm = getFragmentManager();
        transac = fm.beginTransaction();
        arFragment = new AnotherRightFragment1();
        transac.replace(R.id.right_layout,arFragment);
        transac.addToBackStack(null);
        transac.show(arFragment);
        transac.commit();

//        final LinearLayout bg  = findViewById(R.id.ddr);
//        TextView fss  = findViewById(R.id.tv_anothersddd);
//        AnotherRightFragment1 arFragments = (AnotherRightFragment1) getFragmentManager().findFragmentById(R.id.right_layout);
//        final LinearLayout bg  = arFragments.getActivity().findViewById(R.id.ddr);
//        final TextView fss  = arFragment.getActivity().findViewById(R.id.tv_anothersddd);
//
//        fss.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bg.setBackgroundColor(Color.parseColor("#6495ED"));
//            }
//        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnotherRightFragment1 arFragment = new AnotherRightFragment1();
                FragmentTransaction transac = getFragmentManager().beginTransaction();
                transac.replace(R.id.right_layout,arFragment);
                transac.addToBackStack(null);
                transac.commit();

            }
        });
//
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnotherUpFragment2 arFragment2 = new AnotherUpFragment2();
                FragmentTransaction transac = getFragmentManager().beginTransaction();
                transac.replace(R.id.right_layout,arFragment2);
                transac.addToBackStack(null);
                transac.commit();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnotherUpFragment3 arFragment3 = new AnotherUpFragment3();
                Bundle bundle = new Bundle();
                bundle.putString("data","从activity传递到的数据");
                arFragment3.setArguments(bundle);//数据传递到fragment中
                FragmentTransaction transac = getFragmentManager().beginTransaction();
                transac.replace(R.id.right_layout,arFragment3);
                transac.addToBackStack(null);
                transac.commit();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnotherUpFragment4 arFragment4 = new AnotherUpFragment4();
                FragmentTransaction transac = getFragmentManager().beginTransaction();
                transac.replace(R.id.right_layout,arFragment4);
                transac.addToBackStack(null);
                transac.commit();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transac = getFragmentManager().beginTransaction();
                AnotherUpFragment5 arFragment5 = new AnotherUpFragment5();
                transac.replace(R.id.right_layout,arFragment5);
                transac.addToBackStack(null);
                transac.commit();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        View ss = arFragment.getView();
        final LinearLayout bg  = ss.findViewById(R.id.anthserddd);
        RecyclerView fss  = ss.findViewById(R.id.rv_rclview);
        fss.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        transac = getFragmentManager().beginTransaction();
                        AnotherUpFragment5 arFragment5 = new AnotherUpFragment5();
                        transac.replace(R.id.right_layout,arFragment5);
                        transac.addToBackStack(null);
                        transac.commit();
                        bg.setBackgroundColor(Color.parseColor("#6495ED"));
                        Toast.makeText(getApplicationContext(),"sdfsdf",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
    @Override
    public void setValue(final String dd) {
        Log.e("BBBB",dd+"");
//        fm = getFragmentManager();
//        transac = fm.beginTransaction();
//        hideFragment(transac);
//        arFragment5 = new AnotherUpFragment5();
//        transac.replace(R.id.right_layout,arFragment5);
//        transac.addToBackStack(null);
//        transac.commit();
    }

    /*
     * 去除（隐藏）所有的Fragment
     * */
    private void hideFragment(FragmentTransaction transaction) {
//        if (arFragment != null) {
//            //transaction.hide(f1);隐藏方法也可以实现同样的效果，不过我一般使用去除
//            transaction.remove(arFragment);
//        }



    }


}
