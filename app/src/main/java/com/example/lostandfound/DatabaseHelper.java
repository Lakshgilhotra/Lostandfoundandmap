package com.example.lostandfound;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String MyDatabase="mydatabase.db";

    public static final int VERSION=1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, MyDatabase, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE MyTable (id INTEGER PRIMARY KEY, PostType TEXT, Name TEXT, Phone TEXT, Description TEXT, Date TEXT, Location TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MyTable");
    }
    public Cursor getdata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM MyTable",null);
        return cursor;
    }
}
