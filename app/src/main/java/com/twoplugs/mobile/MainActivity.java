package com.twoplugs.mobile;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
import android.view.View;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;


import adapter.NavAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

import fragment.MessageFragment;
import fragment.NotificationFragment;
import fragment.ProfileFragment;
import fragment.ServicematchFragment;
import fragment.SettingsFragment;
import fragment.TransFragment;
import utils.Constants;


public class MainActivity extends AppCompatActivity  {

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


    // toolbar titles respected to selected nav menu item
        private String[] activityTitles;

        // flag to load home fragment when user presses back key
        private boolean shouldLoadHomeFragOnBackPress = true;
        private Handler mHandler;

        // index to identify current nav menu item
        public static int navItemIndex = 0;

        // tags used to attach the fragments
        private static final String TAG_NOTIFICATION = "notification";
        private static final String TAG_FAVORITE = "favorite";
        private static final String TAG_SETTINGS = "settings";
        private static final String TAG_SERVICEMATCH = "servicematch";
        private static final String TAG_HELP = "help";
        public static String CURRENT_TAG = TAG_NOTIFICATION;




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);

            mHandler = new Handler();

            //set action bar and toogle button
            setSupportActionBar(toolbar);
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,0,0);
            drawer.addDrawerListener(toggle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toggle.syncState();
            activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

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

           // navigation.setNavigationItemSelectedListener(this);

            pager.addOnPageChangeListener(new MyOnPageChangeListener());

            // load nav menu header data
            loadNavHeader();

            // initializing navigation menu
            setUpNavigationView();

            if (savedInstanceState == null) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_NOTIFICATION;
                loadHomeFragment();
            }

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

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.sidebar_logout:
//                finish();
//                break;
//            case R.id.sidebar_favourite:
//
//                break;
//            case R.id.sidebar_servicematch:
//
//                break;
//            case R.id.sidebar_Settings:
//                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.pager, new SettingsFragment());
//                ft.commit();
//                break;
//            case R.id.sidebar_notification:
//
//
//                break;
//        }
//
//        drawer.closeDrawer(GravityCompat.START);
//        return false;
//    }


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

            String title = "";
            switch (position) {
                case 0:
                    title = "Plugs";
                    break;
                case 1:
                    title = "Transaction";
                    break;
                case 2:
                    title = "Message";
                    break;
                case 3:
                    title = "Profile";
                    break;
            }
            getSupportActionBar().setTitle(title);

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

    private void loadNavHeader() {
        // name, website
//        txtName.setText("Ravi Tamada");
//        txtWebsite.setText("www.androidhive.info");
//
//        // loading header background image
//        Glide.with(this).load(urlNavHeaderBg)
//                .crossFade()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(imgNavHeaderBg);
//
//        // Loading profile image
//        Glide.with(this).load(urlProfileImg)
//                .crossFade()
//                .thumbnail(0.5f)
//                .bitmapTransform(new CircleTransform(this))
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(imgProfile);

        // showing dot next to notifications label
       // navigationView.getMenu().getItem(3).setActionView(R.layout.menu_dot);
    }
    private void loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();

            // show or hide the fab button

            return;
        }

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.pager, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        // show or hide the fab button


        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:

                NotificationFragment notificationFragment = new NotificationFragment();
                return notificationFragment;
            case 1:

                ServicematchFragment servicematchFragment = new ServicematchFragment();
                return servicematchFragment;
            case 2:
                TransFragment transFragment = new TransFragment();
                return transFragment;
            case 3:
                // settings fragment
                SettingsFragment settingsFragment = new SettingsFragment();
                return settingsFragment;
            case 4:
                MessageFragment messageFragment = new MessageFragment();
                return messageFragment;
            default:
                return new NotificationFragment();
        }
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }

    private void selectNavMenu() {
        navigation.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.sidebar_notification:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_NOTIFICATION;
                        break;
                    case R.id.sidebar_servicematch:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_SERVICEMATCH;
                        break;
                    case R.id.sidebar_favourite:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_FAVORITE;
                        break;
                    case R.id.sidebar_Settings:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_SETTINGS;
                        break;
                    case R.id.sidebar_Help:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_HELP;
                        break;
                    case R.id.sidebar_logout:
                      finish();
                       break;
                    default:
                        navItemIndex = 0;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }


}
