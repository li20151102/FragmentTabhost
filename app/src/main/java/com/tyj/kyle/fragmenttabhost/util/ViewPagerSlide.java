package com.tyj.kyle.fragmenttabhost.util;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @author create by kyle_2019 on 2019/9/29 15:16
 * @package com.tyj.kyle.fragmenttabhost.uitl
 * @fileName ViewPagerSlide
 * 阻止ViewPager 左右滑动
 */
public class ViewPagerSlide extends ViewPager {
    //是否可以进行滑动

    private boolean isSlide = false;



    public void setSlide(boolean slide) {

        isSlide = slide;

    }

    public ViewPagerSlide(Context context) {

        super(context);

    }



    public ViewPagerSlide(Context context, AttributeSet attrs) {

        super(context, attrs);

    }

    @Override

    public boolean onInterceptTouchEvent(MotionEvent ev) {

        return isSlide;

    }
}
