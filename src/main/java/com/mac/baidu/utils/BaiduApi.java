package com.mac.baidu.utils;

public class BaiduApi {
    public static String ak = "potZ5GHg4GxYSURETthQvAdz";
    public static String url = "http://api.map.baidu.com/place/v2/search?ak="+ak+
            "&output=json&query=%E9%A4%90%E9%A5%AE$%E7%BE%8E%E9%A3%9F" +
            "&filter=industry_type:cater|sort_name:overall_rating|sort_rule:0|groupon:1" +
            "&page_size=10&page_num=0&scope=2" +
            "&radius=2000&location=";

    //baidu API 参数文档地址 http://developer.baidu.com/map/webservice-placeapi.htm
}
