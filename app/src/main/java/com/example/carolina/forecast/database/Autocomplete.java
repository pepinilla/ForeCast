package com.example.carolina.forecast.database;

import com.example.carolina.forecast.entities.Data;
import com.example.carolina.forecast.entities.Locations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by carolina on 31/05/17.
 */

public class Autocomplete {

    HashMap<String, Object > hashMap = new HashMap<String, Object>();



    private static volatile Autocomplete INSTANCE;

    public Autocomplete() {
        Data city1 = new Data("Bogota", "Cundinamarca", "Colombia");
        Data city2 = new Data("San Francisco", "CA", "USA");
        Data city3 = new Data("Edmonton", "AB", "Canada");
        Data city4 = new Data("Vancouver", "BC", "Canada");

        add(city1);
        add(city2);
        add(city3);
        add(city4);
    }

    public static Autocomplete getInstance() {
        Autocomplete localInstance = INSTANCE;
        if (localInstance == null) { //1st check (no lock)
            synchronized (Autocomplete.class){
                localInstance = INSTANCE;
                if (localInstance == null) { //2nd check (lock)
                    localInstance = INSTANCE = new Autocomplete();
                }
            }
        }
        return localInstance;
    }



    public void add(Data data) {
        hashMap.put(data.getCity(), data);
    }


    public Map<String, Object> getHashMap() {
        return hashMap;
    }

    public List<String> getKeyList() {
        return Arrays.asList(hashMap.keySet().toArray(new String[0]));
    }

}
