package com.weather.yogurt.weathertest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Yogurt on 5/16/16.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper{
    public static final String CREATE_PROVINCE="create table Province ("
            +"id integer primary key autoincrement ,"
            +"province_name text,"
            +"province_code text)";
    /*
        city建表语句   .......市....
     */
    public static final String CREATE_CITY="create table City ("
            +"id integer primary key autoincrement ,"
            +"city_name text,"
            +"city_code text,"
            +"province_id integer,"
            +"city_postcode Text,"
            +"city_telAreaCode text)";
    /*
        Country建表语句//.......县/地区......
     */
    public static final String CREATE_TOWN="create table Town ("
            +"id integer primary key autoincrement ,"
            +"town_name_pinyin text,"
            +"town_name_chinese text,"
            +"town_code text,"
            +"city_id integer)";
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
