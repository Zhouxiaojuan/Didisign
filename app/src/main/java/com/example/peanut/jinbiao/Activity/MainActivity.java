package com.example.peanut.jinbiao.Activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.peanut.jinbiao.Pagers.Fragment_pager1;
import com.example.peanut.jinbiao.Pagers.Fragment_pager_2;
import com.example.peanut.jinbiao.R;
import com.example.peanut.jinbiao.test.Helper;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    private Fragment_pager1 fragment_pager1=new Fragment_pager1();

    private Fragment_pager_2 fragmentPager2=new Fragment_pager_2();

    private View navheadview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(fragment_pager1);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.icon_menu32_white);
        }


        NavigationView navigationView= (NavigationView) findViewById(R.id.nav_view);
        drawerLayout= (DrawerLayout) findViewById(R.id.activity_main);
        navheadview=navigationView.inflateHeaderView(R.layout.nav_header);

        CircleImageView circleImageView= (CircleImageView) navheadview.findViewById(R.id.user_image);

        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this,UserCenter.class);
                intent1.putExtra(UserCenter.IMAGE_top,R.drawable.tx);
                startActivity(intent1);
            }
        });

        //设置默认点击第一个
        navigationView.setCheckedItem(R.id.today);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.today:
                        replaceFragment(fragment_pager1);
                        Log.d("sd", "onNavigationItemSelected: 112313");
                        break;
                    case R.id.yestoday:
                        replaceFragment(fragmentPager2);
                        break;
                    case R.id.task:
                        break;
                    case R.id.settting:
                        break;
                    case R.id.out:
                        Intent intent6 = new Intent(MainActivity.this, LoginPager.class);
                        intent6.putExtra("isbcak",true);
                        getHelper().setIsauto(false);
                        startActivity(intent6);
                        finish();
                        break;
                    default:break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }


    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.pager_content,fragment).commit();
    }

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
            case R.id.search:
                Toast.makeText(MainActivity.this,"search what?",Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
        return true;
    }

    public Helper getHelper(){
        return ((Helper)getApplicationContext());
    }
}
