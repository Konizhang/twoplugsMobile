package fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.twoplugs.mobile.R;


/**

 */
public class ServicematchFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_servicematch, container, false);

        return v;
    }

    public static ServicematchFragment newInstance(Context context, String text) {

        ServicematchFragment f = new ServicematchFragment();
        Bundle b = new Bundle();
        b.putString("notification_fragment", text);

        f.setArguments(b);

        return f;
    }
}
