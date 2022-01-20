package com.example.helloapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_maps);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {

                LatLng latLng = new LatLng(43.9509, -34.4618);
                //where is map loaded

         googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
             @Override
             public void onMapClick(@NonNull LatLng latLng) {

                 MarkerOptions markOptions=new MarkerOptions();
                 //position of marker
                 markOptions.position(latLng);
                 //title of marker
                 markOptions.title(latLng.latitude+" : "+latLng.longitude);

                 googleMap.clear();

                 googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                         latLng, 10
                 ));

                 googleMap.addMarker(markOptions);
             }
         });


            }
        });



        return rootView;
    }
}