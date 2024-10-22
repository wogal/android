package com.example.javafragmentsgooglemaps_new;


import android.content.pm.PackageManager;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int Default_INTERVAL_MILLIS = 1000 * 30;
    public static final int Default_FastestInterval = 1000 * 5;
    private static final int PERMISSIONS_FINE_LOCATION = 69;
    TextView tv_labellat, tv_lat, tv_labellon, tv_lon, tv_labelaltitude, tv_altitude, tv_labelaccuracy, tv_accuracy, tv_labelspeed, tv_speed, tv_labelsensor, tv_sensor, tv_labelupdates, tv_updates, tv_address, tv_lbladdress;
    Switch sw_locationsupdates, sw_gps;

    // Googles API for locations services
    FusedLocationProviderClient fusedLocationProviderClient;
    LocationRequest locationRequest;

    // wogal test start
    String test = "drtryhdu";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        test = "new value uu7";

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // label allocations
        tv_labellat = findViewById(R.id.tv_labellat);
        tv_lat = findViewById(R.id.tv_lat);
        tv_labellon = findViewById(R.id.tv_labellon);
        tv_lon = findViewById(R.id.tv_lon);
        tv_labelaltitude = findViewById(R.id.tv_labelaltitude);
        tv_altitude = findViewById(R.id.tv_altitude);
        tv_labelaccuracy = findViewById(R.id.tv_labelaccuracy);
        tv_accuracy = findViewById(R.id.tv_accuracy);
        tv_labelspeed = findViewById(R.id.tv_labelspeed);
        tv_speed = findViewById(R.id.tv_speed);
        tv_labelsensor = findViewById(R.id.tv_labelsensor);
        tv_sensor = findViewById(R.id.tv_sensor);
        tv_labelupdates = findViewById(R.id.tv_labelupdates);
        tv_updates = findViewById(R.id.tv_updates);
        tv_address = findViewById(R.id.tv_address);
        tv_lbladdress = findViewById(R.id.tv_lbladdress);
        // switch allocations
        sw_locationsupdates = findViewById(R.id.sw_locationsupdates);
        sw_gps = findViewById(R.id.sw_gps);


        // set al properties of LocationRequest
        locationRequest = new LocationRequest();
        locationRequest.setInterval(Default_INTERVAL_MILLIS);
        locationRequest.setFastestInterval(Default_FastestInterval);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);



        // set onclick listerners
        sw_gps.setOnClickListener(this);
        sw_locationsupdates.setOnClickListener(this);
        tv_labellat = findViewById(R.id.tv_labellat);
        tv_lat = findViewById(R.id.tv_lat);
        tv_labellon = findViewById(R.id.tv_labellon);
        tv_lon = findViewById(R.id.tv_lon);
        tv_labelaltitude = findViewById(R.id.tv_labelaltitude);
        tv_altitude = findViewById(R.id.tv_altitude);
        tv_labelaccuracy = findViewById(R.id.tv_labelaccuracy);
        tv_accuracy = findViewById(R.id.tv_accuracy);
        tv_labelspeed = findViewById(R.id.tv_labelspeed);
        tv_speed = findViewById(R.id.tv_speed);
        tv_labelsensor = findViewById(R.id.tv_labelsensor);
        tv_sensor = findViewById(R.id.tv_sensor);
        tv_labelupdates = findViewById(R.id.tv_labelupdates);
        tv_updates = findViewById(R.id.tv_updates);
        tv_address = findViewById(R.id.tv_address);
        tv_lbladdress = findViewById(R.id.tv_lbladdress);


    } // end of onCreate method

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSIONS_FINE_LOCATION: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    updateGPS();
                } else {
                    Toast.makeText(this, "Hi Wogal No Permission Granted", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

        }
    }

    // *** GLOBAL onClick Listener ***
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sw_gps) {
            if (sw_gps.isChecked()) {
                // most accurate
                locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                tv_sensor.setText("Using GPS sensors");
            } else {
                locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                tv_sensor.setText("Using Towers + Wifi");
            }
        }
        //else if (v.getId() == R.id.sw_locationsupdates) {}

    } // end of onClick method

    private void updateGPS() {
        // get permissions from user to track GPS
        // get current location from the fused client
        // update the UI - ie: set all properties in there associated text view items.
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MainActivity.this);
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            // we have user permission
//            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
//                @Override
//                public void onSuccess(Location location) {
//                    // we got permission , put the values of location XXX into the UI components
//                    updateUIValues(location);
//                }
//            });
//
//        } else {
//            // permission NOT granted yet
//            if (Build.VERSION.SDK_INT >= VERSION_CODES.M) {
//                requestPermissions(new String[]{Manifest.permission.    .ACCESS_FINE_LOCATION}, PERMISSIONS_FINE_LOCATION);
//            }
    }


//private void updateUIValues(Location location) {
//    // we got permission , put the values of location XXX into the UI components
//    // so update text view with new location
//    tv_lat.setText(String.valueOf(location.getLatitude()));
//    tv_lon.setText(String.valueOf(location.getLongitude()));
//    tv_accuracy.setText(String.valueOf(location.getAccuracy()));
//    if (location.hasAltitude()) {
//        tv_altitude.setText(String.valueOf(location.getAltitude()));
//    } else {
//        tv_altitude.setText(R.string.not_available);
//    }
//    if (location.hasSpeed()) {
//        tv_speed.setText(String.valueOf(location.getSpeed()));
//    } else {
//        tv_speed.setText(R.string.not_available);
//    }
//
//
//}

} // end of MainActivity



















