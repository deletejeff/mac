package com.mac.baidu.bean;

/**
 * Created by machao on 2015/2/14.
 */
public class BaiduApi {
    public static String ak = "potZ5GHg4GxYSURETthQvAdz";
    public static String url_good_food = "http://api.map.baidu.com/place/v2/search?ak=" + ak +
            "&output=json&query=%E9%A4%90%E9%A5%AE$%E7%BE%8E%E9%A3%9F" +
            "&filter=industry_type:cater|sort_name:overall_rating|sort_rule:0|groupon:1" +
            "&page_size=10&page_num=0&scope=2" +
            "&radius=2000&location=";
    public static String url_ziqilaoyouji = "http://api.map.baidu.com/place/v2/search?ak=" + ak +
            "&output=json&query=%E6%BB%8B%E5%A5%87%E8%80%81%E5%8F%8B%E8%AE%B0&scope=2&region=%E8%A5%BF%E5%AE%89";
}
