package com.example.peanut.jinbiao.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


/**
 * Created by Peanut on 2017/5/25.
 */

public class User{

    private int Touxiang;

    private String id;

    private String Nichen;

    private int Integral;

    private String birthday;

    private String mail;

    private String qq;

    public String getQq(){
        return qq;
    }

    public void setQQ(String nums){
        qq=nums;
    }

    public String getMail(){
        return mail;
    }

    public void setMail(String add){
        mail=add;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setBirthday(String data){
        birthday=data;
    }

    public int getIntegral(){
        return Integral;
    }

    public void setIntegral(int n){
        Integral=n;
    }

    public void setTouxiang(int image){
        Touxiang=image;
    }

    public int getTouxiang(){
        return Touxiang;
    }

    public void setuserId(String num){
        id=num;
    }

    public String getuserId(){
        return id;
    }

    public void setNichen(String name){
        Nichen=name;
    }

    public String getNichen(){
        return Nichen;
    }


}
