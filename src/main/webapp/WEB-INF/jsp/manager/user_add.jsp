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
<form class="am-form" action="<%=path%>/user/add.do" method="post" enctype="multipart/form-data" data-am-validator>
    <fieldset>
        <legend>添加用户</legend>
    </fieldset>
    <div class="am-hide">
        <input type="text" id="uid" name="uid">
    </div>
    <div class="am-form-group">
        <label for="userName">用户名<sup class="am-text-danger">*</sup></label>
        <input type="text" id="userName" name="userName" placeholder="填写用户名" pattern="^[a-zA-z][a-zA-Z0-9]{2,16}$" maxlength="16" required>
    </div>
    <div class="am-form-group">
        <label for="userPassword1">密码<sup class="am-text-danger">*</sup></label>
        <input type="password" id="userPassword1" name="userPassword1" placeholder="填写用户密码" maxlength="32" required>
    </div>
    <div class="am-form-group">
        <label for="userPassword">确认密码<sup class="am-text-danger">*</sup></label>
        <input type="password" id="userPassword" name="userPassword" placeholder="请与上面输入的值一致" data-equal-to="#userPassword1" maxlength="32" required>
    </div>
    <div class="am-form-group">
        <label for="userEmail">邮箱</label>
        <input type="email" id="userEmail" name="userEmail" placeholder="填写常用邮箱">
    </div>
    <div class="am-form-group">
        <label for="nickname">昵称</label>
        <input type="text" id="nickname" name="nickname" placeholder="填写昵称" maxlength="16">
    </div>
    <div class="am-form-group">
        <label for="realName">真实姓名</label>
        <input type="text" id="realName" name="realName" value="" pattern="^[\u4e00-\u9fa5]{2,4}$" maxlength="20">
    </div>
    <div class="am-form-group">
        <label for="phone">电话</label>
        <input type="text" id="phone" name="phone" value="" placeholder="填写手机号码" pattern="^1((3|5|8){1}\d{1}|70)\d{8}$">
    </div>
    <div class="am-form-group">
        <label for="gender">性别<sup class="am-text-danger">*</sup></label>
        <input type="hidden" id="gender" name="gender" value="">
        <div class="am-btn-group">
            <button type="button" class="am-btn am-btn-primary am-round" onclick="changeGender('男');">男 ♂</button>
            <button type="button" class="am-btn am-btn-primary am-round" onclick="changeGender('女');">女 ♀</button>
        </div>
    </div>
    <div class="am-hide">
        <label for="multipartFile">上传头像</label>
        <input type="file" id="multipartFile" name="multipartFile">
        <p class="am-form-help">请选择要上传的文件...</p>
        <div id="img_div"></div>
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
        $('#gender').val(gender);
    }
</script>
</body>
</html>
