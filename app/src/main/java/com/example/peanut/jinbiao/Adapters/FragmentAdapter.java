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

    private List<String> titlelist;

    public FragmentAdapter(FragmentManager fm,List<Fragment> fragments,List<String> titles) {
        super(fm);
        fragmentList=fragments;
        titlelist=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int postion){
        return titlelist.get(postion);
    }
}
