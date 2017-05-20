package com.example.peanut.jinbiao.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

/**
 * Created by Peanut on 2017/5/15.
 */

public class FragmentAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragmentList;

    public FragmentAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        fragmentList=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
