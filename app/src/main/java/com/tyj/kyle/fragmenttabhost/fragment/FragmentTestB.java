package com.tyj.kyle.fragmenttabhost.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.tyj.kyle.fragmenttabhost.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author create by kyle_2019 on 2019/3/12 9:17
 * @package com.example.testapplication
 * @fileName FragmentTest
 */
public class FragmentTestB extends Fragment {

    @InjectView(R.id.news_tab)
    TabLayout newTab;
    @InjectView(R.id.news_vp)
    ViewPager newVp;
    private FindTabAdapter adapter;
    private List<String> tabTitle = new ArrayList<>();
    //    private List<Integer> tabImg = new ArrayList<>();
    private List<Fragment> tabFragments = new ArrayList<>();

    private FragmentTestBA fragmentTest21 = new FragmentTestBA();
    private FragmentTestBB fragmentTest22 = new FragmentTestBB();
//    private FragmentTestBB fragmentTest23 = new FragmentTestBB();
//    private FragmentTestBB fragmentTest24 = new FragmentTestBB();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_b, container, false);
        ButterKnife.inject(this, root);
        initValue();
        return root;
    }

    private void initValue() {
        tabTitle.clear();
        tabTitle.add("测试1");
        tabTitle.add("测试2");
//        tabTitle.add("测试3");
//        tabTitle.add("测试4");
        tabFragments.clear();
        tabFragments.add(fragmentTest21);
        tabFragments.add(fragmentTest22);
//        tabFragments.add(fragmentTest23);
//        tabFragments.add(fragmentTest24);
        adapter = new FindTabAdapter(getChildFragmentManager(), tabFragments, tabTitle);
        newVp.setAdapter(adapter);
        newTab.setupWithViewPager(newVp);
        newTab.getTabAt(0).setCustomView(getTabView(0));
        newTab.getTabAt(1).setCustomView(getTabView(1));
//        newTab.getTabAt(2).setCustomView(getTabView(2));
//        newTab.getTabAt(3).setCustomView(getTabView(3));
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.tab_view, null);
        TextView txt_title = (TextView) view.findViewById(R.id.tab_view_tv);
        txt_title.setText(tabTitle.get(position));
//        ImageView img_title = (ImageView) view.findViewById(R.id.tab_view_img);
//        img_title.setImageResource(tabImg.get(position));
        return view;
    }

    public class FindTabAdapter extends FragmentPagerAdapter {

        private List<Fragment> listFragment; //fragment
        private List<String> listTitle;

        public FindTabAdapter(FragmentManager fm, List<Fragment> list_fragment, List<String> list_title) {
            super(fm);
            this.listFragment = list_fragment;
            this.listTitle = list_title;
        }


        @Override
        public Fragment getItem(int position) {
            return listFragment.get(position);
        }

        @Override
        public int getCount() {
            return listFragment.size();
        }

        //此方法用来显示tab上的名字
        @Override
        public CharSequence getPageTitle(int position) {

            return listTitle.get(position);
        }
    }
}
