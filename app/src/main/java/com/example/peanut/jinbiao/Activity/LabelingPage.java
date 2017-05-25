package com.example.peanut.jinbiao.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.peanut.jinbiao.Adapters.LabelImageAdapter;
import com.example.peanut.jinbiao.R;
import com.example.peanut.jinbiao.test.Helper;
import com.example.peanut.jinbiao.test.Images;

import java.util.List;
import java.util.Random;

public class LabelingPage extends AppCompatActivity {

    private LabelImageAdapter labelImageAdapter;

    private ViewPager viewPager;

    private ImageView[] imageViews;

    private int[] Imageids=getHelper().getimageids();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labeling_page);

        Intent intent=getIntent();
        int postion=intent.getIntExtra("postion",0);
        viewPager= (ViewPager) findViewById(R.id.labeling_viewpage);
        imageViews=new ImageView[50];
        for (int i=0;i<50;i++){
            Random random=new Random();
            int index=random.nextInt(Imageids.length);
            imageViews[index].setImageResource(Imageids[index]);
        }

        labelImageAdapter=new LabelImageAdapter(imageViews);
        viewPager.setAdapter(labelImageAdapter);
        viewPager.setCurrentItem(postion);
    }

    public Helper getHelper(){
        return ((Helper)getApplicationContext());
    }
}
