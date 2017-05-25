package com.example.peanut.jinbiao.test;

import android.app.Application;

import com.example.peanut.jinbiao.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Peanut on 2017/5/7.
 */

public class Helper extends Application{

    private boolean isauto=true;

    private int[] images={R.drawable.tx,R.drawable.tx1,R.drawable.tx2,R.drawable.tx3,R.drawable.tx4,R.drawable.tx6,R.drawable.tx7,R.drawable.tx8};

    public void setIsauto(boolean auto){
        isauto=auto;
    }

    public boolean getIsauto(){
        return isauto;
    }


    public int[] getimageids(){
        return images;
    }

}
