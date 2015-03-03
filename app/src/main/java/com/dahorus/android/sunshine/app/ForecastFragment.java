package com.dahorus.android.sunshine.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dahorus.android.sunshine.interfaces.ICallback;
import com.dahrous.android.sunshine.service.FetchWeatherTask;
import com.dahrous.android.sunshine.service.ForecastService;
import com.dahrous.android.sunshine.service.Interfaces.IForecastService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Esteban on 22/02/2015.
 */
public class ForecastFragment extends Fragment {

    private ArrayAdapter<String> mForecastAdapter;
    private ListView mListViewForecast;
    private View rootView;
    private ICallback<String[]> onTaskCompleted;


    public ForecastFragment() {

        onTaskCompleted = new ForecastServiceCallback();
        _forecastService = new ForecastService();


    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

    }


    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.forecastfragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){

            case R.id.action_refresh:

                Refresh();

                break;

        }

        return super.onOptionsItemSelected(item);
    }


    private void Refresh(){

        _fetchWeatherTask = new FetchWeatherTask(_forecastService,onTaskCompleted);
        _fetchWeatherTask.execute("94043");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

       /* String[] forecastArray = {

                "Today - Sunny - 88/63",
                "Tomorrow - Foggy - 70/40",
                "Weds - Cloudy - 72/63",
                "Thrus - Asteroids - 75/65",
                "Fri - Heavy Rain - 65/56",
                "Sat - Help TRAPPED IN WHEATERSTATION - 60/51",
                "Sun . Sunny - 80/68"

        };*/

        Refresh();

       // AsyncTask<Void, Void, String> task = _fetchWeatherTask.execute();

        return rootView;
    }


    private IForecastService _forecastService;
    private FetchWeatherTask _fetchWeatherTask;


    public class ForecastServiceCallback implements ICallback<String[]> {

        public void OnCallback(String[] param) {

            if(param == null) return;

            List<String> weekForecast = new ArrayList<String>(Arrays.asList(param));

            mForecastAdapter = new ArrayAdapter<String>(
                    //The current context(this fragment's parent activity)
                    getActivity(),
                    //ID of list item layout
                    R.layout.list_item_forecast,
                    //ID of the textview to populate
                    R.id.list_item_forecast_textview,
                    //Forecast data
                    weekForecast
            );

            mListViewForecast = (ListView)rootView.findViewById(R.id.listview_forecast);

            mListViewForecast.setAdapter(mForecastAdapter);
        }
    }

}
