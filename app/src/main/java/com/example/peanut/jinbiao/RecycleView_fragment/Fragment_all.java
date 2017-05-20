package com.example.peanut.jinbiao.RecycleView_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.peanut.jinbiao.R;

/**
 * Created by Peanut on 2017/5/15.
 */

public class Fragment_all extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_all,container,false);
        return view;
    }
}
