package com.example.wugq.simpleandroiddemo.meizi.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 妹子的实体类
 *
 * Created by wugq on 2017/8/27.
 */
public class MeiziBean {

    /**
     * _id : 56cc6d23421aa95caa707b7c
     * createdAt : 2015-06-08T01:03:29.806Z
     * desc : 6.8——（2）
     * publishedAt : 2015-06-09T03:30:26.527Z
     * type : 福利
     * url : http://ww3.sinaimg.cn/large/7a8aed7bgw1eswencfur6j20hq0qodhs.jpg
     * used : true
     * who : 张涵宇
     *
     * {"id":5,"total":15,"url":"http://116.196.83.52:8080/SpringDemo/images/2017-07-02_104208.png"},
     */

    @SerializedName("id")
    private int id;
    @SerializedName("url")
    private String imageUrl;
    @SerializedName("total")
    private int total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public MeiziBean(String imageUrl){
        this.imageUrl = imageUrl;
    }
}
