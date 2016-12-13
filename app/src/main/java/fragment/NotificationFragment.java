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

public class NotificationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.notification_fragment_layout, container, false);

        return v;
    }

    public static NotificationFragment newInstance(Context context, String text) {

        ((AppCompatActivity)context).getSupportActionBar().setTitle("notification_fragment");
        NotificationFragment f = new NotificationFragment();
        Bundle b = new Bundle();
        b.putString("notification_fragment", text);

        f.setArguments(b);

        return f;
    }
}
