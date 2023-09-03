package com.example.proyecto;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity6 extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    EditText txtlatitud, txtlongitud;
    GoogleMap mMap;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        txtlatitud = findViewById(R.id.txtLatitud);
        txtlongitud = findViewById(R.id.txtlongitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng bogota = new LatLng(4.6548433,-74.1493007);
        mMap.addMarker(new MarkerOptions().position(bogota).title("EMPRESA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bogota));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        txtlatitud.setText(""+latLng.latitude);
        txtlongitud.setText(""+latLng.longitude);

        mMap.clear();
        LatLng colombia = new LatLng(latLng.latitude,latLng.longitude);
        mMap.addMarker(new MarkerOptions().position(colombia).title(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(colombia));
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txtlatitud.setText(""+latLng.latitude);
        txtlongitud.setText(""+latLng.longitude);

        mMap.clear();
        LatLng colombia = new LatLng(latLng.latitude,latLng.longitude);
        mMap.addMarker(new MarkerOptions().position(colombia).title(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(colombia));
    }
}