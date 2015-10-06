package kevinmorton.com.myfragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LM_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LM_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LM_Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.fragment_lm_, container, false);
    }
}
