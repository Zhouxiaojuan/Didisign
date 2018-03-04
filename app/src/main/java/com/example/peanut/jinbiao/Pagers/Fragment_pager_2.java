package com.example.peanut.jinbiao.Pagers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.peanut.jinbiao.Adapters.ImageAdapter;
import com.example.peanut.jinbiao.R;
import com.example.peanut.jinbiao.test.Images;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Peanut on 2017/5/19.
 */

public class Fragment_pager_2 extends Fragment {

    private ImageAdapter imgadapter;

    private List<Images> ImagesList = new ArrayList<>();

    private com.example.peanut.jinbiao.test.Images[] Images = {
            new Images("1", R.drawable.tx),
            new Images("2", R.drawable.tx1),
            new Images("3", R.drawable.tx2),
            new Images("4", R.drawable.tx3),
            new Images("5", R.drawable.tx4),
            new Images("6", R.drawable.tx6),
            new Images("7", R.drawable.tx7),
            new Images("8", R.drawable.tx8),};

    private RecyclerView recyclerView;

    public Fragment_pager_2(){
        initTx();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager_fragment_2, container, false);



        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_history);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        imgadapter = new ImageAdapter(ImagesList);
        recyclerView.setAdapter(imgadapter);
        return view;
    }


    public void initTx(){
        ImagesList.clear();
        for (int i=0;i<50;i++){
            Random random=new Random();
            int index=random.nextInt(Images.length);
            ImagesList.add(Images[index]);
        }
    }
}
