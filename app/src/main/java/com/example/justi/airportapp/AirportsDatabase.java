//package com.example.justi.airportapp;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//
//public class AirportsDatabase extends SQLiteAssetHelper {
//
//    private static final String DATABASE_NAME = "airports.sqlite";
//    private static final int DATABASE_VERSION = 1;
//
//    public AirportsDatabase(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//
//    // Hier de CRUD methoden
//    public Cursor getAirports() {
//        SQLiteDatabase db = getReadableDatabase();
//
//        String query = "SELECT icao, name FROM airports";
//        Cursor c = db.rawQuery(query, null);
//        c.moveToFirst();
//        db.close();
//        return c;
//    }
//
//    public Cursor getNLAirports(){
//        SQLiteDatabase db = getReadableDatabase();
//
//        String query = "SELECT icao, name FROM airports WHERE iso_country = \"NL\"";
//        Cursor c = db.rawQuery(query, null);
//        c.moveToFirst();
//        db.close();
//        return c;
//    }
//
//    public Cursor getAirportByIcao(String icao){
//        SQLiteDatabase db = getReadableDatabase();
//
//        String query = "SELECT * FROM airports WHERE icao = ?";
//        Cursor c = db.rawQuery(query, new String[]{icao});
//        c.moveToFirst();
//        db.close();
//        return c;
//    }
//
//    public Cursor getSchiphol(){
//        return getAirportByIcao("EHAM");
//    }
//
//
//}
