package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all places from the database.
     *
     * @return a List of places
     */
    public List<Place> getPlaces() {
        List<Place> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Place", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Place place = new Place();
            place.setId(cursor.getString(0));
            place.setType(cursor.getString(1));
            place.setName(cursor.getString(2));
            place.setDescription(cursor.getString(3));
            place.setOpenHour(cursor.getString(4));
            place.setCloseHour(cursor.getString(5));
            place.setContact(cursor.getString(6));
            place.setImgUrl(cursor.getString(7));
            list.add(place);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    /**
     * Insert a contact into the database.
     *
     * @param place the contact to be inserted
     */
    public void insertPlace(Place place) {
        ContentValues values = new ContentValues();
        values.put("id", place.getId());
        values.put("type", place.getType());
        values.put("name", place.getName());
        values.put("description", place.getDescription());
        values.put("openHour", place.getOpenHour());
        values.put("closeHour", place.getCloseHour());
        values.put("contact", place.getContact());
        values.put("imgUrl", place.getImgUrl());
        database.insert("Place", null, values);
    }


}