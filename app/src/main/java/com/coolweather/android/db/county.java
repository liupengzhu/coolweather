package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/6/7.
 */

public class County extends DataSupport {
    private int id;
    private String countyName;
    private String weatherId;
    private int cityid;

    public void setId(int id) {
        this.id = id;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getId() {
        return id;
    }

    public int getCityid() {
        return cityid;
    }

    public String getCountyName() {
        return countyName;
    }

    public String getWeatherId() {
        return weatherId;
    }
}
