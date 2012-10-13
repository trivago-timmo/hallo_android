package de.mulaschnick.hallo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: iluvatar
 * Date: 12.10.12
 * Time: 23:18
 * To change this template use File | Settings | File Templates.
 */
public class TestFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onStart()
    {
        super.onStart();    //To change body of overridden methods use File | Settings | File Templates.
        TextView tv = (TextView) getView();
        tv.setText(getString(R.string.fragment1));
    }
}
