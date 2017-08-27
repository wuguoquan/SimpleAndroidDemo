package com.example.wugq.simpleandroiddemo.common.utils;

/**
 * 获取随机数的工具类
 *
 * Created by wugq on 2017/8/27.
 */
public class GetRandom {

    /**
     * 获取一个 0 到 30 之间的随机整数
     *
     * @return 一个 随机整数
     */
    public static int getRandom(){
        double random = Math.random();
        int result = (int)(random * 50 - 20);
        return Math.abs(result);
    }
}
