package com.twoplugs.mobile;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;



import java.util.ArrayList;
import java.util.List;


import adapter.NavAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import fragment.NotificationFragment;
import utils.Constants;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = GuideActivity.class.getSimpleName();

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

            pager.setAdapter(new NavAdapter(this,getSupportFragmentManager(),list));
            tab.setupWithViewPager(pager);

            tab.getTabAt(0).setIcon(R.drawable.plugs);
            tab.getTabAt(1).setIcon(R.drawable.trans);
            tab.getTabAt(2).setIcon(R.drawable.message);
            tab.getTabAt(3).setIcon(R.drawable.user);

            navigation.setNavigationItemSelectedListener(this);

            pager.addOnPageChangeListener(new MyOnPageChangeListener());



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
            case R.id.sidebar_logout:
                finish();
                break;
            case R.id.sidebar_favourite:

                break;
            case R.id.sidebar_servicematch:

                break;
            case R.id.sidebar_Settings:

                break;
            case R.id.sidebar_notification:


                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return false;
    }


    class MyOnPageChangeListener implements OnPageChangeListener
    {
        /**
         * 当页面回调了会回调这个方法
         * @param position 当前滑动页面的位置
         * @param positionOffset 页面滑动的百分比
         * @param positionOffsetPixels 滑动的像数
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            NavigationView nv =(NavigationView)findViewById(R.id.navigation);
            nv.getMenu().clear();
            if(position== Constants.PLUGS_PAGE_INDEX){
                nv.inflateMenu(R.menu.searchmenu);
            }else{
                nv.inflateMenu(R.menu.navigation);
            }


           // switch (position)
            //    case  Constants.PROFILE_PAGE_INDEX




        }

        /**
         * 当页面被选中的时候，回调这个方法
         * @param position 被选中页面的对应的位置
         */
        @Override
        public void onPageSelected(int position) {

            Log.e(TAG,"onPageSelectedposition=="+position);
        }

        /**
         * 当ViewPager页面滑动状态发生变化的时候
         * @param state
         */
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
