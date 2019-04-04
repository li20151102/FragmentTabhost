package com.tyj.kyle.fragmenttabhost.viewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.tyj.kyle.fragmenttabhost.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author create by kyle_2019 on 2019/3/13 14:48
 * @package com.tyj.kyle.fragmenttabhost.viewPager
 * @fileName ViewPagerActivity
 */
public class ViewPagerActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;
    private LinearLayout mLinearLayout;
    private MyAdapter mAdapter;
    int mNum=0;
    //ImageView动态数组
    private List<ImageView> mImageList = new ArrayList<ImageView>();
    //图片数组
    private int[] mPics = new int[]{R.mipmap.tu1, R.mipmap.tu2, R.mipmap.tu3,R.mipmap.tu1, R.mipmap.tu2, R.mipmap.tu3};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        mViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        mLinearLayout = (LinearLayout) findViewById(R.id.main_linear);
        getData();

        //注册
        mViewPager.addOnPageChangeListener(this);
        //第一次显示小白点
        mLinearLayout.getChildAt(mNum).setEnabled(true);
    }
    /**
     * 获取数据
     */
    private void getData() {
        //设置图片
        ImageView imageView;
        View view;
        for (int pic : mPics) {
            imageView = new ImageView(getApplicationContext());
            imageView.setBackgroundResource(pic);
            //添加到数组
            mImageList.add(imageView);
            //创建底部指示器(小圆点)
            view = new View(getApplicationContext());
            view.setBackgroundResource(R.drawable.background);
            view.setEnabled(false);
            //设置宽高
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(30, 30);
            //设置间隔
            layoutParams.leftMargin = 10;
            //添加到LinearLayout
            mLinearLayout.addView(view, layoutParams);
        }
        mAdapter = new MyAdapter();
        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {

        mLinearLayout.getChildAt(mNum).setEnabled(false);
        mLinearLayout.getChildAt(position).setEnabled(true);
        mNum = position;

    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    /**
     * 适配器
     */
    private class MyAdapter extends PagerAdapter {

        //大小
        @Override
        public int getCount() {
            return mImageList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mImageList.get(position), 0);//添加页卡
            return mImageList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //从容器中删除
            container.removeView(mImageList.get(position));
        }
    }
}
