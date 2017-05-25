package com.example.peanut.jinbiao.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.peanut.jinbiao.Adapters.SignAdapter;
import com.example.peanut.jinbiao.R;
import com.example.peanut.jinbiao.test.Sign;

import java.util.ArrayList;
import java.util.List;

public class ImageRoom extends AppCompatActivity {

    public static final String IMAGE_NUM="image_num";

    public static final String IMAGE_ID="imag_id";

//    private Button addbtn;
//
//    private EditText addtext;

    private SignAdapter adapter;

    private List<Sign> signList=new ArrayList<>();

    private RecyclerView recyclerView;
    private int counts=0;

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
//        addbtn= (Button) findViewById(R.id.imageroom_addbtn);
//        addtext= (EditText) findViewById(R.id.imageroom_addtip);
//        addtext.clearFocus();

        recyclerView= (RecyclerView) findViewById(R.id.imageroom_signlist);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter=new SignAdapter(signList);
        recyclerView.setAdapter(adapter);

//        addbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String add=addtext.getText().toString();
//                if (add!=null&&counts<6){
//                    Sign s=new Sign(add);
//                    signList.add(s);
//                    counts++;
//                    InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.hideSoftInputFromWindow(recyclerView.getWindowToken(),0);
//                    addtext.setText("");
//                }else if (counts==6){
//                    Toast.makeText(ImageRoom.this,"不能再加了！",Toast.LENGTH_SHORT).show();
//                    addtext.setText("");
//                }
//                else if (add.equals("")){
//                    Toast.makeText(ImageRoom.this,"不能加入空标签！",Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });

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

