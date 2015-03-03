package com.dahrous.android.sunshine.service.Interfaces;

/**
 * Created by Esteban on 22/02/2015.
 */
public interface IForecastService {

    String GetForecastData(String postcode);
    String[] GetWeatherDataFromJson(String postcode,int numDays);

}
