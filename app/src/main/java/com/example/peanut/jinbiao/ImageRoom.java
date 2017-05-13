package com.example.peanut.jinbiao;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImageRoom extends AppCompatActivity {

    public static final String IMAGE_NUM="image_num";

    public static final String IMAGE_ID="imag_id";

    private Button addbtn;

    private EditText addtext;

    private SignAdapter adapter;

    private List<Sign> signList=new ArrayList<>();

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_room);

        Intent intent=getIntent();
        String imagenum=intent.getStringExtra(IMAGE_NUM);
        int imageid=intent.getIntExtra(IMAGE_ID,0);
        Toolbar toolbar= (Toolbar) findViewById(R.id.imageroom_toobar);
        CollapsingToolbarLayout collapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.imageroom_collapsing);
        ImageView image= (ImageView) findViewById(R.id.imageroom_image);
        addbtn= (Button) findViewById(R.id.imageroom_addbtn);
        addtext= (EditText) findViewById(R.id.imageroom_addtip);

        recyclerView= (RecyclerView) findViewById(R.id.imageroom_signlist);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter=new SignAdapter(signList);
        recyclerView.setAdapter(adapter);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String add=addtext.getText().toString();
                Sign s=new Sign(add);
                signList.add(s);
                InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(recyclerView.getWindowToken(),0);
                addtext.setText("");
            }
        });

        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(imagenum);
        image.setImageResource(imageid);
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

