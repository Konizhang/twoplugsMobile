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

public class MessageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.message_page_layout, container, false);

        TextView tv = (TextView) v.findViewById(R.id.message_text);
        tv.setText(getArguments().getString("message_text"));

        return v;
    }

    public static MessageFragment newInstance(Context context, String text) {

        ((AppCompatActivity)context).getSupportActionBar().setTitle("MessageFragment");

        MessageFragment f = new MessageFragment();
        Bundle b = new Bundle();
        b.putString("message_text", text);

        f.setArguments(b);

        return f;
    }
}
