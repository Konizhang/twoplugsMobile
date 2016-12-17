package fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twoplugs.mobile.R;

/**
 * Created by Administrator on 2016/11/29.
 */

public class PlugsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.plugs_page_layout, container, false);

        TextView tv = (TextView) v.findViewById(R.id.plugs_text);
        tv.setText(getArguments().getString("plugs_text"));

        return v;
    }

    public static PlugsFragment newInstance(Context context, String text) {

       // ((AppCompatActivity)context).getSupportActionBar().setTitle("plugs_text");
        PlugsFragment f = new PlugsFragment();
        Bundle b = new Bundle();
        b.putString("plugs_text", text);

        f.setArguments(b);

        return f;
    }
}
