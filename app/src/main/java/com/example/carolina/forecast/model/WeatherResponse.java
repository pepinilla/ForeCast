package com.example.carolina.forecast.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by carolina on 09/06/17.
 */

public class WeatherResponse {
    @SerializedName("current_observation")
    private WeatherData weatherData;

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

}
