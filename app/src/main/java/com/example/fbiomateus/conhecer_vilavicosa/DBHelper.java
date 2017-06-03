package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

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
                "OPENHOUR TEXT, CLOSEHOUR TEXT, CONTACT TEXT, IMGURL TEXT, LATITUDE TEXT, LONGITUDE TEXT);";
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertPlace(String type, String name, String description, String openHour, String closeHour, String contact, String imgUrl, String latitude, String longitude){
        mSqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("TYPE", type);
        values.put("NAME", name);
        values.put("DESCRIPTION", description);
        values.put("OPENHOUR", openHour);
        values.put("CLOSEHOUR", closeHour);
        values.put("CONTACT", contact);
        values.put("IMGURL", imgUrl);
        values.put("LATITUDE", longitude);
        values.put("LONGITUDE", latitude);

        mSqLiteDatabase.insert(TABLE_NAME, null, values);
        mSqLiteDatabase.close();
    }

    public void updatePlace(int id, String type, String name, String description, String openHour, String closeHour, String contact, String imgUrl, String latitude, String longitude){
        mSqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("TYPE", type);
        values.put("NAME", name);
        values.put("DESCRIPTION", description);
        values.put("OPENHOUR", openHour);
        values.put("CLOSEHOUR", closeHour);
        values.put("CONTACT", contact);
        values.put("IMGURL", imgUrl);
        values.put("LATITUDE", latitude);
        values.put("LONGITUDE", longitude);

        mSqLiteDatabase.update(TABLE_NAME, values, "id = " + id, null);
        mSqLiteDatabase.close();
    }

    public void deletePlace(int id){
        mSqLiteDatabase = this.getWritableDatabase();

        mSqLiteDatabase.delete(TABLE_NAME,"id = " + id, null);
        mSqLiteDatabase.close();
    }

    public ArrayList<Place> getAllPlaces(){
        ArrayList<Place> places = new ArrayList<>();

        mSqLiteDatabase = this.getReadableDatabase();

        String select_all = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = mSqLiteDatabase.rawQuery(select_all, null);

        if(cursor.moveToFirst()){
            do {
                Place place = new Place(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                        cursor.getString(7), cursor.getString(8), cursor.getString(9));
                places.add(place);
            } while(cursor.moveToNext());
        }
        mSqLiteDatabase.close();
        return places;
    }

    public ArrayList<Place> getPlacesbyType(String type){
        ArrayList<Place> places = new ArrayList<>();

        mSqLiteDatabase = this.getReadableDatabase();

        String select_all = "SELECT * FROM " + TABLE_NAME + " WHERE type = '" + type + "'";
        Cursor cursor = mSqLiteDatabase.rawQuery(select_all, null);

        if(cursor.moveToFirst()){
            do {
                Place place = new Place(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                        cursor.getString(7), cursor.getString(8), cursor.getString(9));
                places.add(place);
            } while(cursor.moveToNext());
        }
        mSqLiteDatabase.close();
        return places;
    }

    public ArrayList<Place> getPlacebyName(String name){
        ArrayList<Place> places = new ArrayList<>();

        mSqLiteDatabase = this.getReadableDatabase();

        String selectPlacebyName = "SELECT * FROM " + TABLE_NAME + " WHERE name = '" + name + "'";
        Cursor cursor = mSqLiteDatabase.rawQuery(selectPlacebyName, null);

        if(cursor.moveToFirst()){
            do {
                Place place = new Place(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                        cursor.getString(7), cursor.getString(8), cursor.getString(9));
                places.add(place);
            } while(cursor.moveToNext());
        }
        mSqLiteDatabase.close();
        return places;
    }

}