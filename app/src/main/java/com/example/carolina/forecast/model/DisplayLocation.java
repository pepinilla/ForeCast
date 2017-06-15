package com.example.carolina.forecast.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by carolina on 09/06/17.
 */

public class DisplayLocation {
    @SerializedName("city")
    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
