package com.example.peanut.jinbiao.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.peanut.jinbiao.R;
import com.example.peanut.jinbiao.test.Helper;

public class UserCenter extends AppCompatActivity{

    public static final String UserCenter=" ";

    public static final String IMAGE_top="imag_top";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private ImageView touxiang;
    private String TAG="Main";

    private Button nicheng;
    private Button mail;
    private Button QQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_center);
        init();
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
                intent1.putExtra(Editactivity.TEXT_ID,nicheng.getText());
                startActivityForResult(intent1,1);
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(UserCenter.this,Editactivity.class);
                intent2.putExtra(Editactivity.TEXT_ID,mail.getText());
                startActivityForResult(intent2,2);
            }
        });
        QQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(UserCenter.this,Editactivity.class);
                intent3.putExtra(Editactivity.TEXT_ID,QQ.getText());
                startActivityForResult(intent3,3);
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
        mail= (Button) findViewById(R.id.user_center_mail);
        QQ= (Button) findViewById(R.id.user_center_qq);


        nicheng.setText(preferences.getString("nicheng",null));
        mail.setText(preferences.getString("mail",null));
        QQ.setText(preferences.getString("QQ",null));
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
                Intent back=new Intent(UserCenter.this,MainActivity.class);
                back.putExtra("nicheng",nicheng.getText().toString());
                back.putExtra("touxiang",R.drawable.tx);
                setResult(RESULT_OK,back);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK){
                    String nID=data.getStringExtra(Editactivity.TEXT_ID);
                    editor.putString("nicheng",nID).apply();
                    nicheng.setText(nID);
                }
                break;
            case 2:
                if (resultCode==RESULT_OK){
                    String m=data.getStringExtra(Editactivity.TEXT_ID);
                    editor.putString("mail",m).apply();
                    mail.setText(m);
                }
                break;
            case 3:
                if (resultCode==RESULT_OK){
                    String qq=data.getStringExtra(Editactivity.TEXT_ID);
                    editor.putString("QQ",qq).apply();
                    QQ.setText(qq);
                }
                break;

        }
    }


}
