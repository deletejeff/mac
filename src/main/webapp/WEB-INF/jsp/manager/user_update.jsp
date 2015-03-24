<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String path = request.getContextPath();
%>
<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Hello</title>

    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">

    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="icon" type="image/png" href="<%=path%>/resources/assets/i/favicon.png">

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="<%=path%>/resources/assets/i/app-icon72x72@2x.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="apple-touch-icon-precomposed" href="<%=path%>/resources/assets/i/app-icon72x72@2x.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="<%=path%>/resources/assets/i/app-icon72x72@2x.png">
    <meta name="msapplication-TileColor" content="#0e90d2">

    <link rel="stylesheet" href="<%=path%>/resources/assets/css/amazeui.min.css">
    <link rel="stylesheet" href="<%=path%>/resources/assets/css/app.css">
    <script type="application/javascript" src="<%=path%>/static/js/app.js"></script>
    <script type="application/javascript" src="<%=path%>/resources/assets/js/jquery.min.js"></script>
    <script type="application/javascript" src="<%=path%>/resources/assets/js/amazeui.min.js"></script>
</head>
<body>
<a href="javascript:history.go(-1)" target="_self">
    <button type="button" class="am-btn am-btn-sm">返回</button>
</a>
<form class="am-form" action="<%=path%>/user/update.do" method="post" enctype="multipart/form-data" data-am-validator>
    <input type="hidden" id="userPassword" name="userPassword" value="${userVo.userPassword}">
    <input type="hidden" id="openId" name="openId" value="${userVo.openId}">
    <input type="hidden" id="status" name="status" value="${userVo.status}">
    <input type="hidden" id="lastLoginIp" name="lastLoginIp" value="${userVo.lastLoginIp}">
    <input type="hidden" id="superman" name="superman" value="${userVo.superman}">
    <input type="hidden" id="createdAt" name="createdAt" value="${userVo.createdAt}">
    <input type="hidden" id="createdByUserId" name="createdByUserId" value="${userVo.createdByUserId}">
    <input type="hidden" id="headImgUrl" name="headImgUrl" value="${userVo.headImgUrl}">
    <fieldset>
        <legend>编辑用户</legend>
    </fieldset>
    <div class="am-form-group">
        <input type="text" id="uid" name="uid" value="${userVo.uid}" readonly>
    </div>
    <div class="am-form-group">
        <label for="userName">用户名<sup class="am-text-danger">*</sup></label>
        <input type="text" id="userName" name="userName" value="${userVo.userName}" readonly>
    </div>
    <div class="am-form-group">
        <label for="userEmail">邮箱</label>
        <input type="email" id="userEmail" name="userEmail" value="${userVo.userEmail}">
    </div>
    <div class="am-form-group">
        <label for="nickname">昵称</label>
        <input type="text" id="nickname" name="nickname" value="${userVo.nickname}" maxlength="16">
    </div>
    <div class="am-form-group">
        <label for="realName">真实姓名</label>
        <input type="text" id="realName" name="realName" value="${userVo.realName}" pattern="^[\u4e00-\u9fa5]{2,4}$" maxlength="20">
    </div>
    <div class="am-form-group">
        <label for="phone">电话</label>
        <input type="text" id="phone" name="phone" value="${userVo.phone}" pattern="^1((3|5|8){1}\d{1}|70)\d{8}$">
    </div>
    <div class="am-form-group">
        <label for="gender">性别<sup class="am-text-danger">*</sup></label>
        <input type="hidden" id="gender" name="gender" value="${userVo.gender}">
        <div class="am-btn-group">
            <button type="button" id="btn1" class="am-btn am-btn-primary am-round" onclick="changeGender('男');">男 ♂</button>
            <button type="button" id="btn2" class="am-btn am-btn-primary am-round" onclick="changeGender('女');">女 ♀</button>
        </div>
    </div>
    <p><button type="submit" id="add_user" class="am-btn am-btn-lg am-center">确认</button></p>
</form>
<!--[if (gte IE 9)|!(IE)]><!-->
<script src="<%=path%>/resources/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="<%=path%>/resources/jquery/jquery-1.9.1.min.js"></script>
<![endif]-->
<script type="application/javascript">
    $(function(){
        $('#multipartFile').change(function(){
            var file = this.files[0]; //选择上传的文件
            if(typeof(file) == "undefined"){
                $('#img_div').empty();
            }else{
                var r = new FileReader();
                r.readAsDataURL(file); //Base64
                $(r).load(function(){
                    $('#img_div').html('<img src="'+ this.result +'" alt="" />');
                });
            }
        });
    });
    function changeGender(gender){
        $('#btn1').removeClass("am-active");
        $('#btn2').removeClass("am-active");
        $('#gender').val(gender);
    }
    var gender = $('#gender').val();
    if(gender == '男'){
        $('#btn1').addClass("am-active");
    }else if (gender == '女') {
        $('#btn2').addClass("am-active");
    }else{

    }
//    $(function(){
//        function t(){
//            var t=n.hasClass("am-active")?"未激活":"激活";
//            $("#doc-single-toggle-status").text(t)
//        }
//        var n=$("#bt1");
</script>
</body>
</html>
