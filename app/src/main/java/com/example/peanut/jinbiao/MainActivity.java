package com.example.peanut.jinbiao;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    private ViewPager viewPager;

    private List<Fragment> fragments=new ArrayList<>();

    private List<Fragment> fragmentList=new ArrayList<>();

    private FragmentAdapter fragmentAdapter,fragmentAdapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager= (ViewPager) findViewById(R.id.viewpager_like);
        NavigationView navigationView= (NavigationView) findViewById(R.id.nav_view);
        drawerLayout= (DrawerLayout) findViewById(R.id.activity_main);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_slideshow);
        }
        initFragment();
        fragmentAdapter=new FragmentAdapter(getSupportFragmentManager(),fragments);
        fragmentAdapter2=new FragmentAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(fragmentAdapter);



        //设置默认点击第一个
        navigationView.setCheckedItem(R.id.camera);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.camera) {
                    viewPager.setAdapter(fragmentAdapter);
                } else if (id==R.id.share){
                    viewPager.setAdapter(fragmentAdapter2);
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


    }

    //设置菜单监听事件
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }


    public void initFragment(){
        fragments.add(new Fragment_like());
        fragments.add(new Fragment_all());
        fragments.add(new Fragment_kind1());
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



    public Helper getHelper(){
        return ((Helper)getApplicationContext());
    }
}
