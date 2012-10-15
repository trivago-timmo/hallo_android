package de.mulaschnick.hallo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: iluvatar
 * Date: 14.10.12
 * Time: 22:43
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String TAG = DatabaseHelper.class.getSimpleName();

    private static final String DB_NAME = "mulaschnick.db";
    private static final Integer DB_VERSION = 1;

    private static final String TABLE_NAME = "HelloName";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";

    private static final String TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
                                            + TABLE_NAME
                                            + "( "
                                            +   COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                            +   COLUMN_NAME + " VARCHAR(100)"
                                            + ");";

    private static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL(TABLE_DROP);
        onCreate(sqLiteDatabase);
    }

    public void insert(String value)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = null;
        try
        {
            values = new ContentValues();
            values.put(COLUMN_NAME, value);
            db.insert(TABLE_NAME, null, values);
        }
        catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        finally
        {
            Log.d(TAG, "Tolle Wurst");
        }
    }

    public Cursor getAll()
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor dbResult = db.query(TABLE_NAME, null, null, null, null, null, null);

        return dbResult;
    }
}
