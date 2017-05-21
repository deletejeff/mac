
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head lang="zh-CN">
    <meta charset="UTF-8">
    <title>微信连Wi-Fi</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <!-- 唤起微信的js  必须的 -->
    <script type="text/javascript" src="https://wifi.weixin.qq.com/resources/js/wechatticket/wechatutil.js" ></script>
    <script type="text/javascript" src="resources/jquery/jquery-1.9.1.min.js" ></script>
    <script type="text/javascript" src="resources/jquery/jquery.md5.js" ></script>
    <script type="text/javascript">
        /* 微信连Wi-Fi协议3.1供运营商portal呼起微信浏览器使用
         ----开发认证流程所需参数----
         门店名称 : 为派轰趴聚会吧
         ssid : ssid
         shopId : 3292030
         appId : wxbbadea64310d6c45
         secretKey : secretKey
         ----复用demo代码说明----
         若认证Portal页直接使用此Demo源代码，请注意填写代码中的以下参数（由您的网络环境动态获取）：
         extend
         timestamp
         authUrl
         mac
         bssid
         sign
         其中sign签名请在后台完成，例如：
         var toSign = appId + extend + timestamp + shopId + authUrl + mac + ssid + bssid + secretKey;
         var sign= md5(toSign);
         ----参考文档----
         http://mp.weixin.qq.com/wiki/10/0ef643c7147fdf689e0a780d8c08ab96.html
         */
        var loadIframe = null;
        var noResponse = null;
        var callUpTimestamp = 0;

        function putNoResponse(ev){
            clearTimeout(noResponse);
        }

        function errorJump()
        {
            var now = new Date().getTime();
            if((now - callUpTimestamp) > 4*1000){
                return;
            }
            alert('该浏览器不支持自动跳转微信请手动打开微信\n如果已跳转请忽略此提示');
        }

        myHandler = function(error) {
            errorJump();
        };

        function createIframe(){
            var iframe = document.createElement("iframe");
            iframe.style.cssText = "display:none;width:0px;height:0px;";
            document.body.appendChild(iframe);
            loadIframe = iframe;
        }
        //注册回调函数
        function jsonpCallback(result){
            if(result && result.success){
                alert('WeChat will call up : ' + result.success + '  data:' + result.data);
                var ua=navigator.userAgent;
                if (ua.indexOf("iPhone") != -1 ||ua.indexOf("iPod")!=-1||ua.indexOf("iPad") != -1) {   //iPhone
                    document.location = result.data;
                }else{
                    createIframe();
                    callUpTimestamp = new Date().getTime();
                    loadIframe.src=result.data;
                    noResponse = setTimeout(function(){
                        errorJump();
                    },3000);
                }
            }else if(result && !result.success){
                alert(result.data);
            }
        }
        function Wechat_GotoRedirect(appId, extend, timestamp, sign, shopId, authUrl, mac, ssid, bssid){
            //将回调函数名称带到服务器端
            var url = "https://wifi.weixin.qq.com/operator/callWechatBrowser.xhtml?appId=" + appId
                + "&extend=" + extend
                + "&timestamp=" + timestamp
                + "&sign=" + sign;
console.log(url);
            //如果sign后面的参数有值，则是新3.1发起的流程
            if(authUrl && shopId){
                url = "https://wifi.weixin.qq.com/operator/callWechat.xhtml?appId=" + appId
                    + "&extend=" + extend
                    + "&timestamp=" + timestamp
                    + "&sign=" + sign
                    + "&shopId=" + shopId
                    + "&authUrl=" + encodeURIComponent(authUrl)
                    + "&mac=" + mac
                    + "&ssid=" + ssid
                    + "&bssid=" + bssid;

            }

            //通过dom操作创建script节点实现异步请求
            var script = document.createElement('script');
            script.setAttribute('src', url);
            document.getElementsByTagName('head')[0].appendChild(script);
        }
    </script>


    <link rel="stylesheet" href="https://wifi.weixin.qq.com/resources/css/style-simple-follow.css"/>
</head>
<body class="mod-simple-follow">
<div class="mod-simple-follow-page">
    <div class="mod-simple-follow-page__banner">
        <img class="mod-simple-follow-page__banner-bg" src="https://wifi.weixin.qq.com/resources/images/background.jpg" alt=""/>
        <div class="mod-simple-follow-page__img-shadow"></div>
        <div class="mod-simple-follow-page__logo">
            <img class="mod-simple-follow-page__logo-img" src="https://wifi.weixin.qq.com/resources/images/t.weixin.logo.png" alt=""/>
            <p class="mod-simple-follow-page__logo-name"></p>
            <p class="mod-simple-follow-page__logo-welcome">欢迎您</p>
        </div>
    </div>
    <div class="mod-simple-follow-page__attention">
        <p class="mod-simple-follow-page__attention-txt">欢迎使用微信连Wi-Fi</p>
        <a class="mod-simple-follow-page__attention-btn" onclick="callWechatBrowser()">一键打开微信连Wi-Fi</a>
    </div>
</div>
</body>


<script type="text/javascript">
    var appId = "wxbbadea64310d6c45";
    var extend = "extend";
    var timestamp = new Date().getTime();
    var secretkey = "1413412bcad37fd7fa26a4e0cc664be2";
    var shopId = "3292030";
    var authUrl = "http://wifi.weixin.qq.com/assistant/wifigw/auth.xhtml?httpCode=200";
    var mac = "aa:aa:aa:aa:aa:aa";
    var ssid = "WX_weparty";
    var bssid = "ff:ff:ff:ff:ff:ff";
    var sign = $.md5(appId + extend + timestamp + shopId + authUrl + mac + ssid + secretkey);
    console.log("appId:"+appId);
    console.log("extend:"+extend);
    console.log("timestamp:"+timestamp);
    console.log("secretkey:"+secretkey);
    console.log("shopId:"+shopId);
    console.log("authUrl:"+authUrl);
    console.log("mac:"+mac);
    console.log("ssid:"+ssid);
    console.log("bssid:"+bssid);
    console.log("sign:"+sign);
    function callWechatBrowser(){
        //Wechat_GotoRedirect(appId, extend, timestamp, sign, shopId, authUrl, mac, ssid, bssid)
        /**
         * appid:wxbbadea64310d6c45
         * ssid:WX_weparty
         * shopid:3292030
         * secretKey:1413412bcad37fd7fa26a4e0cc664be2
         * appId	是	商家微信公众平台账号
         * shopId	是	即shop_id，设备所在门店的ID（微信公众平台门店）
         * authUrl	是	认证服务端URL，微信客户端将把用户微信身份信息向此URL提交并获得认证放行。
*                       authUrl的值是经过Url编码的，如：http%3A%2F%2F192.168.1.1%2Fauth.html%3Ft%3Dabc%26s%3D123
         * extend	是	extend里面可以放开发者需要的相关参数集合，最终将透传给运营商认证URL。
         *              extend参数只支持英文和数字，且长度不得超过300个字符。
         * timestamp	是	时间戳使用毫秒
         * sign	是	请求参数签名，具体计算方法见下方说明
         */
        Wechat_GotoRedirect(appId, extend, timestamp, sign, shopId, authUrl, mac, ssid, bssid);
    }
</script>


<script type="text/javascript">
    document.addEventListener('visibilitychange', putNoResponse, false);
</script>


</html>
	
	