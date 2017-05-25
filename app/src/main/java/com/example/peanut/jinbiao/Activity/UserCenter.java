package com.example.peanut.jinbiao.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.peanut.jinbiao.R;

public class UserCenter extends AppCompatActivity{

    public static final String UserCenter="UserCenter";

    public static final String IMAGE_top="imag_top";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private ImageView touxiang;

    private Button nicheng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_center);
        init();
//        Intent intent=getIntent();
//        int imageid=intent.getIntExtra(IMAGE_top,0);
        touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserCenter.this,"touciang",Toast.LENGTH_SHORT).show();
            }
        });
        nicheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(UserCenter.this,Editactivity.class);
                intent1.putExtra("nicheng","小卷");
                startActivity(intent1);
            }
        });
    }

    private void init(){
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor=preferences.edit();
        Toolbar toolbar= (Toolbar) findViewById(R.id.user_center_toobar);
        CollapsingToolbarLayout collapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.user_center_collapsing);
        ImageView image= (ImageView) findViewById(R.id.user_center_topimage);
        touxiang= (ImageView) findViewById(R.id.user_center_touxiang);
        nicheng= (Button) findViewById(R.id.user_center_nicheng);

        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(UserCenter);
        image.setImageResource(R.drawable.tx3);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
