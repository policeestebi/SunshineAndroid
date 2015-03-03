package com.dahorus.android.sunshine.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.


        /*String json = "{\"cod\":\"200\",\"message\":0.3568,\"city\":{\"id\":\"5375480\",\"name\":\"Mountain View\",\"coord\":{\"lon\":-122.077,\"lat\":37.4123},\"country\":\"United States of America\",\"population\":0},\"cnt\":7,\"list\":[{\"dt\":1425240000,\"temp\":{\"day\":23.3,\"min\":8.11,\"max\":23.3,\"night\":8.11,\"eve\":15.94,\"morn\":9.64},\"pressure\":988.29,\"humidity\":64,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"speed\":1.22,\"deg\":298,\"clouds\":0,\"rain\":6.5},{\"dt\":1425326400,\"temp\":{\"day\":16.32,\"min\":3.28,\"max\":16.32,\"night\":3.28,\"eve\":11.08,\"morn\":8.54},\"pressure\":984.89,\"humidity\":78,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":1.41,\"deg\":194,\"clouds\":92,\"rain\":0.5},{\"dt\":1425412800,\"temp\":{\"day\":15.65,\"min\":1.62,\"max\":15.65,\"night\":1.79,\"eve\":9.05,\"morn\":1.62},\"pressure\":988.77,\"humidity\":68,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"02d\"}],\"speed\":1.31,\"deg\":299,\"clouds\":8},{\"dt\":1425499200,\"temp\":{\"day\":13.12,\"min\":7.1,\"max\":14.74,\"night\":7.1,\"eve\":14.74,\"morn\":7.12},\"pressure\":1010.42,\"humidity\":0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":4.44,\"deg\":9,\"clouds\":0},{\"dt\":1425585600,\"temp\":{\"day\":13.75,\"min\":5.4,\"max\":15.96,\"night\":8.54,\"eve\":15.96,\"morn\":5.4},\"pressure\":1016.57,\"humidity\":0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":2.17,\"deg\":140,\"clouds\":0},{\"dt\":1425672000,\"temp\":{\"day\":13.57,\"min\":6.81,\"max\":15.43,\"night\":9.04,\"eve\":15.43,\"morn\":6.81},\"pressure\":1017.59,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":1.48,\"deg\":144,\"clouds\":20},{\"dt\":1425758400,\"temp\":{\"day\":13.64,\"min\":7.56,\"max\":15.9,\"night\":10.07,\"eve\":15.9,\"morn\":7.56},\"pressure\":1014.74,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":1.96,\"deg\":109,\"clouds\":45,\"rain\":0.22}]}";

        Forecast forecast = new Forecast();

        forecast = forecast.FromJson(json);*/


        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){

            case R.id.action_settings:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */

}
