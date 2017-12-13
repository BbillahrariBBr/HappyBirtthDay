package com.example.bakibillah.happybirtthday;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    MediaPlayer hbd;
    Intent intent;
    //Button factsheet;
    //SliderLayout sliderLayout;
    ViewPager viewPager;
    SlideShowAdapter slideShowAdapter;
    //CircleIndicator circleIndicator;
    SecretTextView secretTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer);

        SetUpUiMain();
        hbd = MediaPlayer.create(HomeActivity.this,R.raw.hbd);
        secretTextView.setDuration(3000);
        secretTextView.setIsVisible(false);
        secretTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secretTextView.toggle();
                hbd.start();
            }
        });
        setSupportActionBar(toolbar);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 3000, 4000);
        toggle = new ActionBarDrawerToggle(HomeActivity.this,drawerLayout,toolbar,
                R.string.open_drawer,R.string.close_drawer);
        navigationView.setNavigationItemSelectedListener(HomeActivity.this);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    protected void onPause() {
        super.onPause();
        hbd.release();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.home:
                intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
                break;

            case R.id.about:
                intent = new Intent(HomeActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
//
            case R.id.gift:
                intent = new Intent(HomeActivity.this, GiftActivity.class);
                startActivity(intent);
                break;
//
           case R.id.clebrity:
                intent = new Intent(HomeActivity.this, CelebrirtyWishesActivity.class);
                startActivity(intent);
                break;


            case R.id.burak:
                intent = new Intent(HomeActivity.this, BurakWishActivity.class);
                startActivity(intent);
                break;
//
//            case R.id.friends:
//                intent = new Intent(MainActivity.this, BRAPrimarySchoolActivity.class);
////                startActivity(intent);
//                break;
//
//            case R.id.family:
//                intent = new Intent(MainActivity.this, StudentInfoActivity.class);
//                startActivity(intent);
//                break;


//            case R.id.previous:
//                intent = new Intent(MainActivity.this, AdministratorActivity.class);
//                startActivity(intent);
//                break;
//
//            case R.id.atlast:
////                intent = new Intent(MainActivity.this, BRAPrimarySchoolActivity.class);
////                startActivity(intent);
//                break;
//
//            case R.id.admin:
//                intent = new Intent(MainActivity.this, StudentInfoActivity.class);
//                startActivity(intent);
//                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();

        }
    }

    public  void SetUpUiMain(){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);
       viewPager = (ViewPager)findViewById(R.id.viewPager_id);
        slideShowAdapter = new SlideShowAdapter(HomeActivity.this);
        viewPager.setAdapter(slideShowAdapter);
        secretTextView =(SecretTextView)findViewById(R.id.secretTextView);

    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);
                    }
                    else if (viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                    }
                    else if (viewPager.getCurrentItem()==2){
                        viewPager.setCurrentItem(3);
                    }
                    else if (viewPager.getCurrentItem()==3){
                        viewPager.setCurrentItem(4);
                    }
                    else if (viewPager.getCurrentItem()==4){
                        viewPager.setCurrentItem(5);
                    }
                    else if (viewPager.getCurrentItem()==5){
                        viewPager.setCurrentItem(6);
                    }
                    else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });
        }
    }
}
