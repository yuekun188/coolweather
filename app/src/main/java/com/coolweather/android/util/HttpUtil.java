package com.coolweather.android.util;

import okhttp3.*;

/**
 * Created by Administrator on 2018-6-26.
 */

public class HttpUtil {

    public static  void sendOkHttpRequest(String address, okhttp3.Callback callback){

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
