package com.dahorus.android.sunshine.models;

/**
 * Created by Esteban on 01/03/2015.
 */
public class Forecast extends BaseModel<Forecast>  {

    public Forecast(){

    }

    private String cod;
    private double message;
    private int cnt;
    private City city;
    private DayForecast[] list;


    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public DayForecast[] getList() {
        return list;
    }

    public void setList(DayForecast[] list) {
        this.list = list;
    }
}
