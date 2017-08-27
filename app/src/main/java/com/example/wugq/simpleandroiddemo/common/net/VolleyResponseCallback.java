package com.example.wugq.simpleandroiddemo.common.net;

import com.android.volley.VolleyError;

/**
 * Created by wugq on 2017/8/27.
 */
public interface VolleyResponseCallback {
    void onSuccess(String response);
    void onError(VolleyError error);
}
