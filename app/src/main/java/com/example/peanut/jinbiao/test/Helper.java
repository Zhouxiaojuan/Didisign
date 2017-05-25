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

    public void setIsauto(boolean auto){
        isauto=auto;
    }

    public boolean getIsauto(){
        return isauto;
    }

}
