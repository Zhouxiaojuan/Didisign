package com.example.peanut.jinbiao.Adapters;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.peanut.jinbiao.test.Images;

import java.util.List;

/**
 * Created by Peanut on 2017/5/21.
 */

public class LabelImageAdapter extends PagerAdapter {


    private ImageView[] imageviews;

    public LabelImageAdapter(ImageView[] imageview){
        imageviews=imageview;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

}
