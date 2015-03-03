<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <link rel="icon" type="image/png" href="../../../resources/assets/i/favicon.png">

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="../../../resources/assets/i/app-icon72x72@2x.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="apple-touch-icon-precomposed" href="../../../resources/assets/i/app-icon72x72@2x.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="assets/i/app-icon72x72@2x.png">
    <meta name="msapplication-TileColor" content="#0e90d2">

    <link rel="stylesheet" href="../../../resources/assets/css/amazeui.min.css">
    <link rel="stylesheet" href="../../../resources/assets/css/app.css">
    <script type="application/javascript" src="../../../resources/assets/js/jquery.min.js"></script>
    <script type="application/javascript" src="../../../resources/assets/js/amazeui.min.js"></script>
</head>
<body>
<form class="am-form" action="/category/add.do" method="post" enctype="multipart/form-data" data-am-validator>
    <fieldset>
        <legend>添加类别</legend>
    </fieldset>
    <div class="am-hide">
        <input type="text" id="categoryId" name="categoryId">
    </div>
    <div class="am-form-group">
        <label for="categoryName">名称</label>
        <input type="text" id="categoryName" name="categoryName" placeholder="填写名称" required>
    </div>
    <div class="am-form-group">
        <label for="categoryOrder">排列顺序</label>
        <input type="number" id="categoryOrder" name="categoryOrder" placeholder="请填写排列顺序">
    </div>
    <p><button type="submit" id="add_category" class="am-btn am-btn-lg am-center">确认</button></p>
</form>
<!--[if (gte IE 9)|!(IE)]><!-->
<script src="../../../resources/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="../../../resources/jquery/jquery-1.9.1.min.js"></script>
<![endif]-->
<script type="application/javascript">
</script>
</body>
</html>
