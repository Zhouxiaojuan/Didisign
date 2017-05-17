package com.example.peanut.jinbiao;

import android.app.Application;

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

    private Images[] Images={
            new Images("1",R.drawable.tx),
            new Images("2",R.drawable.tx2),
            new Images("3",R.drawable.tx3),
            new Images("4",R.drawable.tx4),
            new Images("5",R.drawable.tx5),
            new Images("6",R.drawable.tx6),
            new Images("7",R.drawable.tx7),
            new Images("8",R.drawable.tx8),};


    private List<Images> ImagesList=new ArrayList<>();

    public void initTx(){
        ImagesList.clear();
        for (int i=0;i<50;i++){
            Random random=new Random();
            int index=random.nextInt(Images.length);
            ImagesList.add(Images[index]);
        }
    }

    public List<Images> getImageList(){
        initTx();
        return ImagesList;
    }

}
