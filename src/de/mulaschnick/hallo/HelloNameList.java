package de.mulaschnick.hallo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: iluvatar
 * Date: 13.10.12
 * Time: 22:20
 * To change this template use File | Settings | File Templates.
 */
public class HelloNameList extends ListActivity
{
    private ArrayList<String> objects = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Intent i = getIntent();
        Bundle extras = i.getExtras();

        if (savedInstanceState != null)
        {
            objects = savedInstanceState.getStringArrayList("objects");
        }

        if (!extras.isEmpty())
        {
            objects.add(extras.getCharSequence("message").toString());
        }

        super.onCreate(savedInstanceState);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.fragment_layout, objects);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);    //To change body of overridden methods use File | Settings | File Templates.
        Intent i = new Intent(v.getContext(), InstanceStateDemo.class);
        i.putExtra("message", (CharSequence) objects.get(position));
        startActivity(i);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);    //To change body of overridden methods use File | Settings | File Templates.
        outState.putStringArrayList("objects", objects);
    }
}
