package com.example.justi.airportapp;

import android.database.Cursor;

public class Airport{

    private String icao;
    private String name;
    private double longitude;
    private double latitude;
    private double elevation;
    private String iso_country;
    private String muncipality;

    public Airport(String icao, String name, double longitude, double latitude, double elevation, String iso_country, String muncipality) {
        this.icao = icao;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.elevation = elevation;
        this.iso_country = iso_country;
        this.muncipality = muncipality;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public String getIso_country() {
        return iso_country;
    }

    public void setIso_country(String iso_country) {
        this.iso_country = iso_country;
    }

    public String getMuncipality() {
        return muncipality;
    }

    public void setMuncipality(String muncipality) {
        this.muncipality = muncipality;
    }

    public void setIcao(String icao){
        this.icao = icao;
    }

    public String getIcao(){
        return icao;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "icao='" + icao + '\'' +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", elevation=" + elevation +
                ", iso_country='" + iso_country + '\'' +
                ", muncipality='" + muncipality + '\'' +
                '}';
    }

    /*public static Airport fromCursor(Cursor cursor) {
        Airport listItem = new Airport();
        listItem.setIcao(cursor.getString(cursor.getColumnIndex("icao")));
        listItem.setName(cursor.getString(cursor.getColumnIndex("name")));
        return listItem;
    }*/
}