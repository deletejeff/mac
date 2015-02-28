package com.mac.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContextEvent;


/**
 * 功能：继承 SpringContext 默认上下文监听器，启动后配置运行环境需要的共享资源
 * 作者： yangyan
 * 时间： 2014/8/29 .
 */
public class AppContextLoaderListener extends ContextLoaderListener {


    public AppContextLoaderListener() {
        super();
        System.setProperty("org.jboss.logging.provider", "slf4j");
        System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
    }

    public AppContextLoaderListener(WebApplicationContext context) {
        super(context);
    }

    Log log = LogFactory.getLog(AppContextLoaderListener.class);

    /**
     * 上下文初始化完毕后，执行本项目需要首先执行的业务逻辑
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        AppContextConfigInitializer.initAppContextConfig(getCurrentWebApplicationContext());
    }
}
