package com.example.carolina.forecast;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.carolina.forecast.API.WeatherInterface;
import com.example.carolina.forecast.model.WeatherResponse;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by carolina on 03/06/17.
 */

public class DetailForeCast extends AppCompatActivity {

    private final static String BASE_URL = "http://api.wunderground.com/api/";
    private final static String API_KEY = "";

    @Bind(R.id.places_2ndactivity)
    TextView places2ndactivity;


    public final static String LOCATION = "location";
    @Bind(R.id.temperature)
    TextView temperature;
    @Bind(R.id.humidity)
    TextView humidity;
    @Bind(R.id.pressure)
    TextView pressure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_places);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra(LOCATION);
        places2ndactivity.setText(location);

        String[] data = location.split(",");
        String state = data[0];
        String city = data[2];
        state = state.substring(0, 3);

        new GetWeatherInformation().execute(state, city);

    }


    public class GetWeatherInformation extends AsyncTask<Object, Void, WeatherResponse> {

        @Override
        protected WeatherResponse doInBackground(Object... params) {

//                final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            //Now this code is working since it is executed on background
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            WeatherInterface weatherInterface = retrofit.create(WeatherInterface.class);
            Call<WeatherResponse> call = weatherInterface.getWeatherFromSanFrancisco(API_KEY);
            WeatherResponse weatherResponse = null;
            try {
                weatherResponse = call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return weatherResponse;
        }

        @Override
        protected void onPostExecute(WeatherResponse weatherResponse) {
            super.onPostExecute(weatherResponse);

            if (weatherResponse != null) {
                //Update textViews with server response
                try {
                    temperature.setText(weatherResponse.getWeatherData().getTemp());
                    pressure.setText(weatherResponse.getWeatherData().getPressure().toString());
                    humidity.setText(weatherResponse.getWeatherData().getHumidity());
                } catch (Exception e) {

                }

            }

        }
    }



    }
