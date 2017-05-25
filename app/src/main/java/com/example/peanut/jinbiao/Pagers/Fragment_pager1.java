package com.example.peanut.jinbiao.Pagers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TabLayout;

import com.example.peanut.jinbiao.Adapters.FragmentAdapter;
import com.example.peanut.jinbiao.R;
import com.example.peanut.jinbiao.RecycleView_fragment.Fragment_all;
import com.example.peanut.jinbiao.RecycleView_fragment.Fragment_dongwu;
import com.example.peanut.jinbiao.RecycleView_fragment.Fragment_fengjing;
import com.example.peanut.jinbiao.RecycleView_fragment.Fragment_jianzhu;
import com.example.peanut.jinbiao.RecycleView_fragment.Fragment_like;
import com.example.peanut.jinbiao.RecycleView_fragment.Fragment_zhiwu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peanut on 2017/5/19.
 */

public class Fragment_pager1 extends Fragment{

    private ViewPager viewPager;

    private List<Fragment> fragments=new ArrayList<>();
    private List<String> titles=new ArrayList<>();

    private FragmentAdapter fragmentAdapter;

    private TabLayout toptab;

    private Fragment_like fragment_like=new Fragment_like();
    private Fragment_all fragment_all=new Fragment_all();
    private Fragment_fengjing fragment_fengjing =new Fragment_fengjing();
    private Fragment_jianzhu fragment_jianzhu=new Fragment_jianzhu();
    private Fragment_dongwu fragment_dongwu=new Fragment_dongwu();
    private Fragment_zhiwu fragment_zhiwu=new Fragment_zhiwu();



    public Fragment_pager1(){
        initFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.pager_fragment_1,container,false);

        viewPager= (ViewPager) view.findViewById(R.id.viewpager);
        toptab= (TabLayout) view.findViewById(R.id.toptab);

        for (int i=0;i<titles.size();i++){
            toptab.addTab(toptab.newTab().setText(titles.get(i)));
        }

        toptab.setupWithViewPager(viewPager);

        fragmentAdapter=new FragmentAdapter(getChildFragmentManager(),fragments,titles);
        viewPager.setAdapter(fragmentAdapter);

        return view;
    }


    public void initFragment(){
        fragments.add(fragment_like);
        fragments.add(fragment_all);
        fragments.add(fragment_fengjing);
        fragments.add(fragment_jianzhu);
        fragments.add(fragment_dongwu);
        fragments.add(fragment_zhiwu);

        titles.add("我喜欢的");
        titles.add("全部");
        titles.add("风景");
        titles.add("建筑");
        titles.add("动物");
        titles.add("植物");

    }

}
