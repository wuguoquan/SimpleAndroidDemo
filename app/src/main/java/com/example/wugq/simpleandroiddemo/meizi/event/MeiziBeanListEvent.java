package com.example.wugq.simpleandroiddemo.meizi.event;

import com.example.wugq.simpleandroiddemo.meizi.bean.MeiziBean;

import java.util.List;

/**
 * 列举妹子信息的 Event
 *
 * Created by wugq on 2017/8/27.
 */
public class MeiziBeanListEvent {

    private List<MeiziBean> mMeiziBeanList;

    public MeiziBeanListEvent(List<MeiziBean> meiziBeanList) {
        mMeiziBeanList = meiziBeanList;
    }
    public List<MeiziBean> getMeiziBeanList() {
        return mMeiziBeanList;
    }
}
