package com.example.carolina.forecast.entities;

/**
 * Created by carolina on 31/05/17.
 */

public class Data {

    private String city;
    private String state;
    private String country;

    public Data() {

    }

    public Data(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return country + ", " +  state + ", " + city;
    }
}
