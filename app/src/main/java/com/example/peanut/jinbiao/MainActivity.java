package com.example.peanut.jinbiao;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

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

    private ImageAdapter imgadapter;

    private DrawerLayout drawerLayout;

    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView= (NavigationView) findViewById(R.id.nav_view);
        drawerLayout= (DrawerLayout) findViewById(R.id.activity_main);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_slideshow);
        }


        initTx();
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        imgadapter = new ImageAdapter(ImagesList);
        recyclerView.setAdapter(imgadapter);

        //设置默认点击第一个
        navigationView.setCheckedItem(R.id.camera);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.camera) {
                } else if (id==R.id.share){
                }
                else if (id == R.id.out) {
                    Intent intent = new Intent(MainActivity.this, LoginPager.class);
                    getHelper().setIsauto(false);
                    startActivity(intent);
                    finish();
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });

        swipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.listrefresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshList();
            }
        });

    }

    //设置菜单监听事件
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.setting:
                Toast.makeText(MainActivity.this,"setting",Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
        return true;
    }

    public void initTx(){
        ImagesList.clear();
        for (int i=0;i<50;i++){
            Random random=new Random();
            int index=random.nextInt(Images.length);
            ImagesList.add(Images[index]);
        }
    }

    private void refreshList(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initTx();
                        imgadapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    public Helper getHelper(){
        return ((Helper)getApplicationContext());
    }
}
