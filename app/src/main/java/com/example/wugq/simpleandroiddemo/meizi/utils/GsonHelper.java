package com.example.wugq.simpleandroiddemo.meizi.utils;

import com.example.wugq.simpleandroiddemo.meizi.bean.MeiziBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.logger.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wugq on 2017/8/27.
 */
public class GsonHelper {

    /**
     * 将一个 String 类型的数据解析成一个 List<MeiziBean>
     *
     * @param response 包含妹子信息的 String
     * @return List<MeiziBean>
     */
    public static List<MeiziBean> getMeiziBean(String response){
        List<MeiziBean> meiziBeanList = new ArrayList<>();
        Logger.d(response);
        Type meiziListType = new TypeToken<List<MeiziBean>>(){}.getType();
        Gson gson = new Gson();
        meiziBeanList = gson.fromJson(response, meiziListType);
        return meiziBeanList;
    }
}
