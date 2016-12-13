package adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import fragment.MessageFragment;
import fragment.NavContentFragment;
import fragment.PlugsFragment;
import fragment.ProfileFragment;
import fragment.TransFragment;

/**
 * Created by Administrator on 2016/11/26.
 */

public class NavAdapter extends FragmentPagerAdapter{

    private List<String> list;
    private Context context;

    public NavAdapter(Context context , FragmentManager fm, List<String> list) {
        super(fm);
        this.list = list;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch(position) {
            case 0:
               // ((AppCompatActivity)context).getSupportActionBar().setTitle("PlugsFragment");
                return PlugsFragment.newInstance(context,"PlugsFragment");
            case 1:
               // ((AppCompatActivity)context).getSupportActionBar().setTitle("TransFragment");
                return TransFragment.newInstance(context,"TransFragment");
            case 2:
               // ((AppCompatActivity)context).getSupportActionBar().setTitle("MessageFragment");
                return MessageFragment.newInstance(context,"MessageFragment");
            case 3:
               // ((AppCompatActivity)context).getSupportActionBar().setTitle("ProfileFragment");
                return ProfileFragment.newInstance(context,"ProfileFragment");
            default:
              //  ((AppCompatActivity)context).getSupportActionBar().setTitle("PlugsFragment");
                return PlugsFragment.newInstance(context,"PlugsFragment, Default");
        }
        //return NavContentFragment.newInstance(list.get(position));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
