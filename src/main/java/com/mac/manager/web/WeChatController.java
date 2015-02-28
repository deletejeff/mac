package com.mac.manager.web;

import com.mac.common.AppContext;
import com.sdyc.utils.ip.RequestIP;
import com.sdyc.wx.WeChatApp;
import com.sdyc.wx.api.WeChat;
import com.sdyc.wx.api.bean.UserAccessToken;
import com.sdyc.wx.api.util.Tools;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信公众号消息和事件通知
 */
@Controller
@RequestMapping("/wechat")
public class WeChatController {

    @Autowired
    private WeChatApp weChatApp;
    @Autowired
    private WeChat weChat;

    Log log = LogFactory.getLog(WeChatController.class);


    /**
     * 修改接口验证
     *
     * @param request
     * @param response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/api")
    public void get(HttpServletRequest request, HttpServletResponse response) {

        String path = request.getServletPath();
        String pathInfo = path.substring(path.lastIndexOf("/"));
        String outPut = "";
        if (pathInfo != null) {
            String echostr = request.getParameter("echostr");//
            // 验证
            if (echostr != null
                    && Tools.checkSignature(weChatApp.getToken(), request
                    .getParameter("signature"), request
                    .getParameter("timestamp"), request
                    .getParameter("nonce"))) {
                outPut = echostr;
            }
        }
        try {
            response.getWriter().write(outPut);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 接收和处理消息和事件信息
     *
     * @param request
     * @param response
     */
    @RequestMapping(method = RequestMethod.POST, value = "/api")
    public void post(HttpServletRequest request, HttpServletResponse response) {
        if (!Tools.checkSignature(weChatApp.getToken(), request.getParameter("signature"), request
                .getParameter("timestamp"), request.getParameter("nonce"))) {
            try {
                response.getWriter().print("");
                response.getWriter().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/xml");
            String xml = weChat
                    .processing(request);
            response.getWriter().write(xml == null ? "" : xml);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 网页授权回调地址
     *
     * @param request
     * @param state
     * @param code
     * @return
     */
//    @RequestMapping("/auth")
//    public ModelAndView auth(HttpServletRequest request,
//                             String state, String code) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        if (StringUtils.isNotBlank(code)) {
//            try {
//                UserAccessToken accessToken = weChat.getUserApi()
//                        .getAccessToken(code);
//                request.getSession().setAttribute(
//                        AppContext.getWxTokenKey(), accessToken);
//
//                if (accessToken != null && accessToken.getOpenid() != null) {
//                    //判断当前openId 是否是后台管理用户的openId，如果是的话，将自动登录
//                    Integer userIdByOpenId = adminUserService.getUserIdByOpenId(accessToken.getOpenid());
//                    Subject subject = SecurityUtils.getSubject();
//                    try {
//                        if (userIdByOpenId != null) {
//                            subject.login(new UsernamePasswordToken(WechatRealm.LOGIN_NAME_PREFIX + userIdByOpenId, ""));
//                            AdminUserVo user = this.adminUserService.getAdminUserById(userIdByOpenId);
//                            CurrentUser currentUser = new CurrentUser();
//                            currentUser.setDisplayName(user.getNickname());
//                            currentUser.setLoginIp(RequestIP.getIpAddr(request));
//                            currentUser.setRealName(user.getRealName());
//                            currentUser.setUserId(user.getUserId());
//                            currentUser.setUserType(user.getUserType());
//                            subject.getSession().setAttribute(AppContext.getAdminSessionKey(), currentUser);
//                        }
//                    } catch (AuthenticationException e) {
////                        不是本系统管理员的openId，无所谓，但是要拦截到这个异常，不能影响其他用户浏览
//                    }
//                }
//
//            } catch (Exception e) {
//                log.error("微信授权回调错误:" + e.getMessage() + " \n ，code:" + code, e);
//                e.printStackTrace();
//            }
//        }
//        if (StringUtils.isNotEmpty(state)) {
//            if ("v".equals(state)) {
//                Object v = request.getSession().getAttribute("v");
//                if (v != null) {
//                    request.getSession().removeAttribute("v");
//                    return new ModelAndView(new RedirectView((String) v, true), map);
//                }
//            } else if (state.startsWith("http")) { //如果跳转回来state是一个链接则跳转到此链接
//                try {
//                    state = URLDecoder.decode(state, "utf-8");
//                    return new ModelAndView(new RedirectView(state, true), map);
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//            } else if("benefitAddr".equals(state)){
//                Object benefitAddr = request.getSession().getAttribute("benefitAddr");
//                if (benefitAddr != null) {
//                    request.getSession().removeAttribute("benefitAddr");
//                    return new ModelAndView(new RedirectView((String) benefitAddr, true), map);
//                }
//            }
//        }
//        return new ModelAndView(new RedirectView("/", true), map);
//    }


    @RequestMapping("/wxConfig.do")
    @ResponseBody
    public Map<String,Object> getWxConfig(String urlStr){
        Map<String, Object> map = new HashMap<String, Object>();
        String accessToken = weChat.getServerApi().getAccessToken().getAccess_token();
        String jsapi_ticket = weChat.getJsApi().getJsapi_ticket(accessToken).getTicket();
        if(StringUtils.isNotBlank(jsapi_ticket)){
            map = weChat.getJsApi().sign(jsapi_ticket,urlStr);
            map.put("appId", this.weChatApp.getAppId());
        }
        return map;
    }
}
