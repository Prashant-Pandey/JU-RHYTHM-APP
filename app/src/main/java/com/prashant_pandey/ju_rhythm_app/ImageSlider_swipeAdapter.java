package com.yoavi.materialtest1;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Chikki on 1/16/2017.
 */

public class ImageSlider_swipeAdapter extends PagerAdapter {

    private int[] imageContainer={R.drawable.ju,R.drawable.jecrcuniversity};


    @Override
    public int getCount() {
        return imageContainer.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
