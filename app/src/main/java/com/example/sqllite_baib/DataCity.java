package com.example.sqllite_baib;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataCity extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "citydb";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "city";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    public DataCity(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_city_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT)", TABLE_NAME, KEY_ID, KEY_NAME);
        db.execSQL(create_city_table);

    }
    //dataCity
    public void addCity(City city){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, city.getName());


        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public City getCity(int cityId) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, KEY_ID + " = ?", new String[] { String.valueOf(cityId) },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        City city = new City(cursor.getInt(0), cursor.getString(1));
        return city;
    }

    public List<City> getAllCity() {
        List<City>  cityList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            City city = new City(cursor.getInt(0), cursor.getString(1));
            cityList.add(city);
            cursor.moveToNext();
        }
        return cityList;
    }
    public int getId(int s) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, KEY_ID + " = ?", new String[] { String.valueOf(s) },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        City city = new City(cursor.getInt(0), cursor.getString(1));
        return city.getId();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_city_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_city_table);

        onCreate(db);
    }
    public void updateCity(City city) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, city.getName());


        db.update(TABLE_NAME, values, KEY_ID + " = ?", new String[] { String.valueOf(city.getId()) });
        db.close();
    }

    public void deleteCity(int cityId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("city", "ID =?", new String[] { String.valueOf(cityId) });
        db.close();
    }
}
