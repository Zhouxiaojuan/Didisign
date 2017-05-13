package com.example.peanut.jinbiao;

/**
 * Created by Peanut on 2017/5/12.
 */

public class Images {

    private String num;
    private int imgID;

    public Images(String i, int n){
        this.num=i;
        this.imgID=n;
    }

    public String getNum(){
        return num;
    }

    public int getImgID(){
        return imgID;
    }
}
