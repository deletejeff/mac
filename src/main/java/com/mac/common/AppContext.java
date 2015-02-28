package com.mac.common;

/**
 * 功能：项目运行时环境或全局设置
 * 作者： yangyan
 * 时间： 2014/7/28 .
 */
public class AppContext
{
    /**
     * 项目文件夹所在磁盘的路径
     */
    protected static String appRealPath = "";
    /**
     * 项目根路径完整URL
     */
    protected static String siteBaseUrl = "";

    /**
     * 系统是否处于开发模式
     */
    protected static boolean devMode = false;
    /**
     * 管理员登录状态在session中的key
     */
    protected static String adminSessionKey;
    /**
     * 微信授权TOKEN保存在session中的key
     */
    protected static String wxTokenKey;

    /**
     * 返回项目所在目录的路径
     *
     * @return
     */
    public static String getAppRealPath()
    {
        return appRealPath;
    }

    /**
     * 返回项目的根URL
     *
     * @return
     */
    public static String getSiteBaseUrl()
    {
        return siteBaseUrl;
    }

    /**
     * 返回AdminUser信息在session中的key
     *
     * @return
     */
    public static String getAdminSessionKey()
    {
        return adminSessionKey;
    }

    /**
     * 系统是否处于开发模式
     *
     * @return
     */
    public static boolean isDevMode()
    {
        return devMode;
    }

    public static String getWxTokenKey()
    {
        return wxTokenKey;
    }
}
