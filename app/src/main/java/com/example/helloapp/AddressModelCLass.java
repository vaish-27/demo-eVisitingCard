package com.example.helloapp;

public class AddressModelCLass {

    String street;
    String suite;
    String city;
    String zipcode;
    private GeoModelClass geo;

    public AddressModelCLass(String street, String suite, String city, String zipcode,GeoModelClass geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo=geo;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public GeoModelClass getGeo() {
        return geo;
    }

    public void setGeo(GeoModelClass geo) {
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }
}
