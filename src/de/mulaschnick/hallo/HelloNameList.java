package de.mulaschnick.hallo;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteCursor;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

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
    private static final String TAG = HelloNameList.class.getSimpleName();
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        dbHelper = new DatabaseHelper(this);

//      objects.add(extras.getCharSequence("message").toString());

        Cursor dbResult = dbHelper.getAll();
        startManagingCursor(dbResult);
//        if (dbResult.moveToFirst())
//        {
//            for (Integer i=0; i < dbResult.getCount(); i++)
//            {
//                objects.add(dbResult.getString(1));
//                dbResult.moveToNext();
//            }
//        }

//        if (savedInstanceState != null)
//        {
//            objects = savedInstanceState.getStringArrayList("objects");
//        }

        super.onCreate(savedInstanceState);

        ListAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.list_element,
                dbResult,
                new String[] {DatabaseHelper.COLUMN_NAME},
                new int[] {R.id.list_name}
        );
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);    //To change body of overridden methods use File | Settings | File Templates.

        Object o = getListAdapter().getItem(position);
        SQLiteCursor cursor = (SQLiteCursor) o;
        Integer columnIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME);

        Intent i = new Intent(v.getContext(), InstanceStateDemo.class);
        i.putExtra("message", (CharSequence) cursor.getString(columnIndex));
        startActivity(i);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);    //To change body of overridden methods use File | Settings | File Templates.
//        outState.putStringArrayList("objects", objects);
    }
}
