package com.example.carolina.forecast.API;

import com.example.carolina.forecast.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by carolina on 09/06/17.
 */

public interface WeatherInterface {
    @GET("{api_key}/conditions/q/CA/San_Francisco.json")
    Call<WeatherResponse> getWeatherFromSanFrancisco(
            @Path("api_key") String apiKey
//            @Path("state") String state,
//            @Path("city") String city
    );
}
