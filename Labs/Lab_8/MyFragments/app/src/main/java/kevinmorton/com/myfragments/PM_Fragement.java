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
 * {@link PM_Fragement.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PM_Fragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PM_Fragement extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.pm_fragement, container, false);
    }
}