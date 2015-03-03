package com.dahorus.android.sunshine.common;
import java.text.SimpleDateFormat;

/**
 * Created by Esteban on 01/03/2015.
 */
public class Utils {

    public static String GetReadableDateString(long time){

        // Because the API returns a unix timestamp (measured in seconds),
        // it must be converted to milliseconds in order to be converted to valid date.

        SimpleDateFormat shortenedDateFormat = new SimpleDateFormat("EEE MMM dd");
        return shortenedDateFormat.format(time);
    }

}
