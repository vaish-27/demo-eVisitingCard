package com.example.helloapp;

import com.google.gson.annotations.SerializedName;

public class GeoModelClass {

    @SerializedName("lat")
    private String lat;

    @SerializedName("lng")
    private String lng;

    public GeoModelClass(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}
