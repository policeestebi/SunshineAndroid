package com.dahrous.android.sunshine.service;

import android.os.AsyncTask;

import com.dahorus.android.sunshine.interfaces.ICallback;
import com.dahrous.android.sunshine.service.Interfaces.IForecastService;

/**
 * Created by Esteban on 22/02/2015.
 */

public class FetchWeatherTask extends AsyncTask<String, Void, String[]> {


    public FetchWeatherTask(IForecastService  forecastService, ICallback<String[]> callback ){

        _forecastService = forecastService;
        _callback = callback;
    }

    @Override
    protected String[] doInBackground(String... urls) {

        if(urls.length == 0) return null;

        String uri = urls[0];

        return _forecastService.GetWeatherDataFromJson(uri,7);
    }

    @Override
    protected void onPostExecute(String[] strings) {

        if(_callback != null){
            _callback.OnCallback(strings);
        }

    }

    private IForecastService _forecastService;
    private ICallback _callback;


}
