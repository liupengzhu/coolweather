package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;
import com.coolweather.android.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/6/7.
 */

public class Utility {
    public static boolean handleProvinceResponse(String response)
    {
        if(!TextUtils.isEmpty(response))
        {
            try
            {
                JSONArray allProvince = new JSONArray(response);
                for(int i=0;i<allProvince.length();i++)
                {
                    JSONObject provinceObject = allProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;

            }catch (Exception e)
            {
                e.printStackTrace();
            }


        }
        return false;

    }
    public static boolean handleCityResponse(String response ,int provinceId)
    {
        if(!TextUtils.isEmpty(response))
        {
            try{
                JSONArray allcities = new JSONArray(response);
                for(int i = 0;i<allcities.length();i++)
                {
                    JSONObject cityObject = allcities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();

                }

                return true;

            }catch (Exception e )
            {
                e.printStackTrace();
            }

        }
        return false;
    }
    public static boolean handleCountyResponse(String response ,int cityId)
    {
        if(!TextUtils.isEmpty(response))
        {
            try{
                JSONArray allcounties = new JSONArray(response);
                for(int i = 0;i<allcounties.length();i++)
                {
                    JSONObject countyObject = allcounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityid(cityId);
                    county.save();

                }

                return true;

            }catch (Exception e )
            {
                e.printStackTrace();
            }

        }
        return false;
    }

    public static Weather handleWeatherResponse(String response)
    {
        try
        {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);


        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;


    }

}
