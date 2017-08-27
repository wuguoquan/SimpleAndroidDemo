package com.example.wugq.simpleandroiddemo.duanzi.utils;

import com.example.wugq.simpleandroiddemo.duanzi.bean.DuanziBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wugq on 2017/8/27.
 */
public class GsonHelper {

    public static List<DuanziBean> getDuanziBeanList(String response){

        List<DuanziBean> mDuanziBeanList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            String dataArrayStr = jsonObject.getJSONObject("data").getString("data");
            Type type = new TypeToken<List<DuanziBean>>(){}.getType();
            Gson gson = new Gson();
            mDuanziBeanList = gson.fromJson(dataArrayStr, type);
            return mDuanziBeanList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mDuanziBeanList;
    }
}
