package com.example.justi.airportapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        Intent intent = getIntent();
        String icao = intent.getStringExtra(Constants.ICAO);
        String schipholIcao = Constants.SCHIPHOL;

        ArrayList<Airport> airports = AirportDatabaseFactory.getInstance(this).getAirports(false);

        LatLng destination = null;
        LatLng schiphol = null;

        for(Airport airport : airports){
            if(airport.getIcao().equals(icao)){
                destination = new LatLng(airport.getLatitude(), airport.getLongitude());
                mMap.addMarker(new MarkerOptions().position(destination).title("Marker in " + airport.getName()));
            }else if(airport.getIcao().equals(schipholIcao)){
                schiphol = new LatLng(airport.getLatitude(), airport.getLongitude());
                mMap.addMarker(new MarkerOptions().position(schiphol).title("Marker in " + airport.getName()));
            }
        }

        if(destination != null){
            mMap.moveCamera(CameraUpdateFactory.newLatLng(destination));

            PolylineOptions line=
                    new PolylineOptions().add(destination, schiphol)
                            .width(5).color(Color.BLUE);

            PolylineOptions geodesicLine =
                    new PolylineOptions().add(destination, schiphol)
                            .width(5).color(Color.RED).geodesic(true);

            mMap.addPolyline(line);
            mMap.addPolyline(geodesicLine);
        }
    }
}
