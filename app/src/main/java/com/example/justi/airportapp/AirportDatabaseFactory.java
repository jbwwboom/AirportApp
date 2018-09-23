package com.example.justi.airportapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class AirportDatabaseFactory extends SQLiteAssetHelper {


    private ArrayList<Airport> airports;

    private static final String DATABASE_NAME = "airports.sqlite";
    private static final int DATABASE_VERSION = 1;

    private static AirportDatabaseFactory instance = null;


    private AirportDatabaseFactory(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        update();
    }

    private void update() {

        airports = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        //String query = "SELECT * FROM airports WHERE iso_country=\"NL\"";
        String query = "SELECT * FROM airports";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        try {
            while (cursor.moveToNext()) {

                String icao = cursor.getString(cursor.getColumnIndex("icao"));;
                String name = cursor.getString(cursor.getColumnIndex("name"));

                double longitude = 0.0;
                try {
                    longitude = Double.valueOf(cursor.getString(cursor.getColumnIndex("longitude")));
                } catch (Exception ex) {
                    Log.e("", ex.toString());
                }


                double latitude = 0.0;
                try {
                    latitude = Double.valueOf(cursor.getString(cursor.getColumnIndex("latitude")));
                } catch( Exception ex) {
                    Log.e("", ex.toString());
                }

                double elevation = 0.0;
                try {
                    elevation = Double.valueOf(cursor.getString(cursor.getColumnIndex("elevation")));
                } catch (Exception ex) {
                    Log.e("", ex.toString());
                }

                String iso_country = cursor.getString(cursor.getColumnIndex("iso_country"));
                String municipality = cursor.getString(cursor.getColumnIndex("municipality"));

                Airport airport = new Airport(icao, name, longitude, latitude, elevation, iso_country, municipality);
                airports.add(airport);
            }
        } catch( Exception ex) {
            Log.e("", ex.toString());
        }

        cursor.close();
    }

    // Singleton
    public static AirportDatabaseFactory getInstance(Context context) {
        if( instance == null ) {
            instance = new AirportDatabaseFactory(context);
        }
        return instance;
    }

    public ArrayList<Airport> getAirports(boolean forceUpdate) {
        if( forceUpdate ) {
            update();
        }
        return airports;
    }
}
