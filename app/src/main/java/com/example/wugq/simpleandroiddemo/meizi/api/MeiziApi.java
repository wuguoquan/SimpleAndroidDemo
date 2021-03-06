package com.example.wugq.simpleandroiddemo.meizi.api;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.wugq.simpleandroiddemo.common.DemoApp;
import com.example.wugq.simpleandroiddemo.common.utils.GetRandom;
import com.orhanobut.logger.Logger;

/**
 * 获取妹子图的 Api
 *
 * Created by wugq on 2017/8/27.
 */
public class MeiziApi {

    private static String meiziData = "";

    public static String getMeiziApi(){
        StringBuilder meiziApi = new StringBuilder();
        meiziApi.append("http://116.196.83.52:8080/SpringDemo/getimage");
        return String.valueOf(meiziApi);
    }

    public static String getMeiziData(Context context){
        String url = getMeiziApi();
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                meiziData = s;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Logger.d(error);
            }
        });

        DemoApp demoApp = new DemoApp();
        requestQueue.add(stringRequest);
        return meiziData;
    }
}
