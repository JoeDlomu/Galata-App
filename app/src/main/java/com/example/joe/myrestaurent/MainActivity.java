package com.example.joe.myrestaurent;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;

public class MainActivity extends AppCompatActivity
        implements HomeFragment.OnFragmentInteractionListener, MenuFragment.OnFragmentInteractionListener{



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_home:
                    HomeFragment homeFragment = HomeFragment.newInstance("A", "B");
                    getSupportFragmentManager().beginTransaction().add(R.id.content, homeFragment).commit();
                    return true;

                case R.id.navigation_menu:
                    MenuFragment menuFragment = MenuFragment.newInstance("A", "B");
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, menuFragment).commit();
                    return true;

                case R.id.navigation_cart:

                    return true;

                case R.id.navigation_notifications:

                    return true;

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            HomeFragment homeFragment = HomeFragment.newInstance("A", "B");
            getSupportFragmentManager().beginTransaction().add(R.id.content, homeFragment).commit();
        }


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
