<%@ page language="java" pageEncoding="UTF-8" %>
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
<header class="am-topbar admin-header">
    <div class="am-topbar-brand">
        <strong>Amaze UI</strong> <small>ziqilaoyouji</small>
    </div>
</header>
<div class="am-cf admin-main">
    <div class="am-g">
        <h1>Welcome !</h1>
        <p>trkrkgtb grdkgldmbaew erditgvjgjygm<br/>Professional，Powerful，Here, find yourself</p>
    </div>
</div>
<div data-am-widget="slider" class="am-slider am-slider-a1 am-slider-c1" data-am-slider='{directionNav:false}'>
    <ul class="am-slides">
        <li>
            <img src="<%=path%>/static/images/pure-1.jpg" />
            <div class="am-slider-desc">远方 有一个地方 那里种有我们的梦想</div>
        </li>
        <li>
            <img src="<%=path%>/static/images/pure-2.jpg" />
            <div class="am-slider-desc">远方 有一个地方 那里种有我们的梦想</div>
        </li>
        <li>
            <img src="<%=path%>/static/images/pure-3.jpg" />
            <div class="am-slider-desc">远方 有一个地方 那里种有我们的梦想</div>
        </li>
        <li>
            <img src="<%=path%>/static/images/pure-4.jpg" />
            <div class="am-slider-desc">远方 有一个地方 那里种有我们的梦想</div>
        </li>
    </ul>
</div>
<footer>

</footer>
<script>
</script>
</body>
</html>
