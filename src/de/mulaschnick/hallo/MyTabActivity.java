package de.mulaschnick.hallo;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created with IntelliJ IDEA.
 * User: iluvatar
 * Date: 28.10.12
 * Time: 23:49
 * To change this template use File | Settings | File Templates.
 */
public class MyTabActivity extends TabActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.

        TabHost tabHost = getTabHost();
        TabHost.TabSpec ts1 = tabHost.newTabSpec("tab-1");
        ts1.setIndicator(getString(R.string.tabForm));
        Intent i1 = new Intent(this, HalloAndroidActivity.class);
        ts1.setContent(i1);

        TabHost.TabSpec ts2 = tabHost.newTabSpec("tab-2");
        ts2.setIndicator(getString(R.string.tabList));
        Intent i2 = new Intent(this, HelloNameList.class);
        ts2.setContent(i2);

        tabHost.addTab(ts1);
        tabHost.addTab(ts2);
    }
}
