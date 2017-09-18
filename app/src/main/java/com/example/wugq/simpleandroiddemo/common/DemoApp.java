package com.example.wugq.simpleandroiddemo.common;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * 自定义的 Application
 *
 * Created by wugq on 2017/8/27.
 */
public class DemoApp extends Application{

    private static DemoApp mContext;
    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        requestQueue = Volley.newRequestQueue(mContext);
//        if(LeakCanary.isInAnalyzerProcess(this)){
//            return;
//        }
//        LeakCanary.install(this);
    }

    public static Context getContext(){
        return mContext;
    }

    public  RequestQueue getRequestQueue(){
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }
}
