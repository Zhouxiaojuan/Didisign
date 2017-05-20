package com.example.peanut.jinbiao.Pagers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.peanut.jinbiao.Adapters.FragmentAdapter;
import com.example.peanut.jinbiao.R;
import com.example.peanut.jinbiao.RecycleView_fragment.Fragment_all;
import com.example.peanut.jinbiao.RecycleView_fragment.Fragment_kind1;
import com.example.peanut.jinbiao.RecycleView_fragment.Fragment_like;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peanut on 2017/5/19.
 */

public class Fragment_pager1 extends Fragment{

    private ViewPager viewPager;

    private List<Fragment> fragments=new ArrayList<>();

    private FragmentAdapter fragmentAdapter;

    private Fragment_like fragment_like=new Fragment_like();

    public Fragment_pager1(){
        initFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.pager_fragment_1,container,false);

        viewPager= (ViewPager) view.findViewById(R.id.viewpager_like);
        fragmentAdapter=new FragmentAdapter(getChildFragmentManager(),fragments);
        viewPager.setAdapter(fragmentAdapter);
        return view;
    }


    public void initFragment(){
        fragments.add(fragment_like);
        fragments.add(new Fragment_all());
        fragments.add(new Fragment_kind1());
    }
}
