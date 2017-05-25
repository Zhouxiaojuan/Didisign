package com.example.peanut.jinbiao.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.peanut.jinbiao.R;

public class Editactivity extends AppCompatActivity {

    private EditText editText;

    private ImageButton back;

    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editactivity);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.icon_menu32_white);
        }
        Intent intent=getIntent();
        String hint=intent.getStringExtra("nicheng");
        back= (ImageButton) findViewById(R.id.edit_back);
        save= (Button) findViewById(R.id.edit_save);
        editText= (EditText) findViewById(R.id.edit_text);
        editText.setHint(hint);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Editactivity.this,"asd",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
