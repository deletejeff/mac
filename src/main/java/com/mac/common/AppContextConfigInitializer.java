package com.mac.common;

import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Properties;

/**
 * 功能：项目环境配置处理
 * 作者： yangyan
 * 时间： 2014/10/30 .
 */
public class AppContextConfigInitializer {

    public static void initAppContextConfig(org.springframework.context.ApplicationContext context) {
        Properties config = (Properties) context.getBean("config");
        //网站ROOT URL
        AppContext.siteBaseUrl = config.getProperty("site_baseUrl");
        //如果配置的ROOT URL 最后没有写/，则加一个/
        if (!AppContext.siteBaseUrl.endsWith("/")) {
            AppContext.siteBaseUrl += "/";
        }
        //管理员登录状态sessionKey
        AppContext.adminSessionKey = config.getProperty("session_key_admin");
        //微信用户授权TOKEN sessionKey
        AppContext.wxTokenKey = config.getProperty("session_key_wx_token");
        //开发模式吗？
        AppContext.devMode = Boolean.parseBoolean(config.getProperty("devMode"));


        if (context instanceof WebApplicationContext) {
            WebApplicationContext webApplicationContext = (WebApplicationContext) context;
            //项目绝对路径
            AppContext.appRealPath = webApplicationContext.getServletContext().getRealPath("/");
            //放入到servletContext全局变量中，方便页面使用
            webApplicationContext.getServletContext().setAttribute("basePath", AppContext.siteBaseUrl);
        }
    }
}
