package com.twoplugs.mobile;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import adapter.NavAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


        @BindView(R.id.tab)
        TabLayout tab;

        @BindView(R.id.pager)
        ViewPager pager;

        @BindView(R.id.toolbar)
        Toolbar toolbar;

        @BindView(R.id.drawer)
        DrawerLayout drawer;

        @BindView(R.id.navigation)
        NavigationView navigation;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);


            //set action bar and toogle button
            setSupportActionBar(toolbar);
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,0,0);
            drawer.addDrawerListener(toggle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toggle.syncState();


            List<String> list = new ArrayList<>();

            list.add("Plugs");
            list.add("Trans");
            list.add("Messages");
            list.add("Profile");

            pager.setAdapter(new NavAdapter(getSupportFragmentManager(),list));
            tab.setupWithViewPager(pager);

            tab.getTabAt(0).setIcon(R.drawable.plugs);
            tab.getTabAt(1).setIcon(R.drawable.trans);
            tab.getTabAt(2).setIcon(R.drawable.message);
            tab.getTabAt(3).setIcon(R.drawable.user);

            navigation.setNavigationItemSelectedListener(this);



    }

    public void onBackPressed() {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setTitle("Notice");
        builder.setMessage("Are you sure you want to exit?");
        builder.setNegativeButton("cancel", null);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // App.getInstance().exitApp();
                finish();
            }
        });
        builder.show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item4:
                finish();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return false;
    }
}
