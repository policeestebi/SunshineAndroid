package com.dahorus.android.sunshine.models;

import android.util.Log;

import com.google.gson.Gson;

/**
 * Created by Esteban on 01/03/2015.
 */
public class BaseModel<T> {

    public String ToJson(T object){

        Gson gson = new Gson();

        return gson.toJson(object);
    }

    public  T FromJson(String json){

        Gson gson = new Gson();
        T obj = null;

        try {

            obj = (T) gson.fromJson(json, this.getClass());

            return obj;
        }
        catch(Exception ex){

            Log.e("Error parsing json",ex.getMessage());

        }

        return obj;

    }

}
