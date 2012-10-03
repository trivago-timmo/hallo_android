package de.mulaschnick.hallo;

import android.app.Activity;
import android.os.Bundle;

public class HalloAndroidActivity extends Activity
{
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
