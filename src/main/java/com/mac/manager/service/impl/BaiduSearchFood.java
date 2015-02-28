package com.mac.manager.service.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.mac.baidu.bean.BaiduFoodResult;
import com.mac.baidu.utils.BaiduApi;

public class BaiduSearchFood {
    /**
     * 发起http get请求获取网页源代码 
     *
     * @param requestUrl
     * @return
     */
    private static String httpRequest(String requestUrl) {
        StringBuffer buffer = null;

        try {
            // 建立连接  
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");

            // 获取输入流  
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // 读取返回结果  
            buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // 释放资源  
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            httpUrlConn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
    /**
     * 封装查询方法，供外部调用
     *
     * @return
     */
    public static BaiduFoodResult getFoodAroundLocation(String x,String y) {
        BaiduFoodResult baiduFoodResult = null;
        // 获取网页源代码  
        String json = httpRequest(BaiduApi.url+x+","+y);
//        System.out.println(BaiduApi.url+x+","+y);
//        System.out.println(json);
        // 查询并解析结果  
        try {
            // 通过Gson工具将json转换成BaiduFoodResult对象  
            baiduFoodResult = new Gson().fromJson(json, BaiduFoodResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 从网页中抽取信息  
        //String result = extract(html);  

        return baiduFoodResult;
    }
}
