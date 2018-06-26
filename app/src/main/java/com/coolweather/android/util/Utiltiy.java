package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2018-6-26.
 */

public class Utiltiy {
    /**
     *解析和处理服务器返回的省级数据
     * */
    public static boolean handleProviceResponse(String response){

        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvicees = new JSONArray(response);
                for(int i = 0; i < allProvicees.length() ;i++){
                    JSONObject provinceObject = allProvicees.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }
    /**
     * 解析和处理服务器返回的市级数据
     * */
    public static boolean handleCityResponse(String response,int proviceId){

        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCities = new JSONArray(response);
                for(int i = 0; i < allCities.length() ;i++){
                    JSONObject  cityObjec = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObjec.getString("name"));
                    city.setCityCode(cityObjec.getInt("id"));
                    city.setProvinceCode(proviceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }
    /**
     * 解析和处理服务器返回的县级数据
     * */
    public static boolean handlCountyResponse(String response,int cityId){

        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCounty = new JSONArray(response);
                for(int i = 0; i < allCounty.length() ;i++){
                    JSONObject  countyObject = allCounty.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }
}
