package com.dahrous.android.sunshine.service;

import android.net.Uri;
import android.text.format.Time;

import com.dahorus.android.sunshine.common.Utils;
import com.dahorus.android.sunshine.models.DayForecast;
import com.dahorus.android.sunshine.models.Forecast;
import com.dahorus.android.sunshine.models.Weather;
import com.dahrous.android.sunshine.service.Interfaces.IForecastService;



/**
 * Created by Esteban on 12/10/2014.
 */
public class ForecastService extends BaseService implements IForecastService {

    public String GetForecastData(String postcode){

        Uri.Builder uri = new Uri.Builder();

        uri.scheme("http")
        .authority("api.openweathermap.org")
        .appendPath("data")
        .appendPath("2.5")
        .appendPath("forecast")
        .appendPath("daily")
        .appendQueryParameter(PARAM_QUERY, postcode)
        .appendQueryParameter(PARAM_FORMAT, "json")
        .appendQueryParameter(PARAM_UNITS, "metric")
        .appendQueryParameter(PARAM_DAYS,"7");

        return CallService(uri.build().toString());

    }

    public String[] GetWeatherDataFromJson(String postcode,int numDays){

        String json = GetForecastData(postcode);

        if(json == "") return  null;

        Forecast forecast = new Forecast();

        forecast = forecast.FromJson(json);

        if(forecast == null) return null;

        Time dayTime = new Time();
        dayTime.setToNow();

        // we start at the day returned by local time. Otherwise this is a mess.
        int julianStartDay = Time.getJulianDay(System.currentTimeMillis(), dayTime.gmtoff);

        // now we work exclusively in UTC
        dayTime = new Time();

        String[] resultStrs = new String[numDays];

        for(int i = 0; i < forecast.getList().length; i++){

            resultStrs[i] = GetFormatedWheater(forecast.getList()[i],julianStartDay,i,dayTime);

        }

        return resultStrs;

    }

    private String GetFormatedWheater(DayForecast forecastDay, int julianStartDay, int index, Time dayTime ){

        if(forecastDay == null) return null;

        String day;
        String description;
        String highAndLow;

        // The date/time is returned as a long.  We need to convert that
        // into something human-readable, since most people won't read "1400356800" as
        // "this saturday".
        long dateTime;
        // Cheating to convert this to UTC time, which is what we want anyhow
        dateTime = dayTime.setJulianDay(julianStartDay+index);

        day = Utils.GetReadableDateString(dateTime);

        Weather weather = forecastDay.getWeather()[0];

        description = weather.getMain();


        double high = forecastDay.getTemp().getMax();
        double low = forecastDay.getTemp().getMin();

        highAndLow = FormatHighLows(high, low);

        return day + " - " + description + " - " + highAndLow;

    }

    private String FormatHighLows(double high, double low) {
        // For presentation, assume the user doesn't care about tenths of a degree.
        long roundedHigh = Math.round(high);
        long roundedLow = Math.round(low);

        String highLowStr = roundedHigh + "/" + roundedLow;
        return highLowStr;
    }

    private final String FORECAST_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7";

    private final String PARAM_QUERY = "q";
    private final String PARAM_FORMAT = "model";
    private final String PARAM_UNITS = "units";
    private final String PARAM_DAYS = "cnt";

}
