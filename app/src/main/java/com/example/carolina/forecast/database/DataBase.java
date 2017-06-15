package com.example.carolina.forecast.database;

import com.example.carolina.forecast.entities.Locations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carolina on 31/05/17.
 */

public class DataBase {

    List<Locations> list = new ArrayList<Locations>();

    private static volatile DataBase INSTANCE;

    public static DataBase getInstance() {
        DataBase localInstance = INSTANCE;
        if (localInstance == null) { //1st check (no lock)
            synchronized (DataBase.class){
                localInstance = INSTANCE;
                if (localInstance == null) { //2nd check (lock)
                    localInstance = INSTANCE = new DataBase();
                }
            }
        }
        return localInstance;
    }



    public void add(Locations location) {
        list.add(location);
    }

    public List<Locations> getList() {
        return list;
    }
}
