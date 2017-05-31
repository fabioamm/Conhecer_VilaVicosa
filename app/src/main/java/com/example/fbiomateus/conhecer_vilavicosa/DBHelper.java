package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "CVV_DB";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "PLACE";
    SQLiteDatabase mSqLiteDatabase;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE PLACE(ID INTEGER PRIMARY KEY, TYPE TEXT, NAME TEXT, DESCRIPTION TEXT, " +
                "OPENHOUR TEXT, CLOSEHOUR TEXT, CONTACT TEXT, IMGURL TEXT);";
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertPlace(String type, String name, String description, String openHour, String closeHour, String contact, String imgUrl){
        mSqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("TYPE", type);
        values.put("NAME", name);
        values.put("DESCRIPTION", description);
        values.put("OPENHOUR", openHour);
        values.put("CLOSEHOUR", closeHour);
        values.put("CONTACT", contact);
        values.put("IMGURL", imgUrl);

        mSqLiteDatabase.insert(TABLE_NAME, null, values);
        mSqLiteDatabase.close();
    }


}