package fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twoplugs.mobile.R;

public class NavContentFragment extends Fragment {


    public NavContentFragment() {
       
    }

    public static NavContentFragment newInstance(String text) {

        Bundle args = new Bundle();
        args.putString("text",text);
        NavContentFragment fragment = new NavContentFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nav_content,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView text = (TextView)view.findViewById(R.id.pagerContent);
        String str = getArguments().getString("text");
        text.setText(str);
    }
}
