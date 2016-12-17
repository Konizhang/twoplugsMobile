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

public class TransFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.trans_page_layout, container, false);

        TextView tv = (TextView) v.findViewById(R.id.trans_text);
        tv.setText(getArguments().getString("trans_text"));

        return v;
    }

    public static TransFragment newInstance(Context context, String text) {
     //   ((AppCompatActivity)context).getSupportActionBar().setTitle("trans_page_layout");
        TransFragment f = new TransFragment();
        Bundle b = new Bundle();
        b.putString("trans_text", text);

        f.setArguments(b);

        return f;
    }
}
