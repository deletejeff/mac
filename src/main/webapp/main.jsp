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
</head>
<body>
<h2>Welcome 老友记!</h2>
<a href="menu.jsp" class="am-btn am-btn-secondary am-round"><i class="am-icon-cutlery"></i> 餐单</a>
<a href="order.jsp" class="am-btn am-btn-secondary am-round"><i class="am-icon-cc-visa"></i> 订单</a>
<hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>
<a href="<%=path%>/menu/list_manager.do" id="menu_manager" class="am-btn am-btn-secondary am-round"><i class="am-icon-cog"></i> 菜单管理</a>
<a href="<%=path%>/category/list_manager.do" id="category_manager" class="am-btn am-btn-secondary am-round"><i class="am-icon-cog"></i> 类别管理</a>
<hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>
<a href="<%=path%>/user/list_manager.do" id="user_manager" class="am-btn am-btn-secondary am-round"><i class="am-icon-cog"></i> 用户管理</a>
<a href="<%=path%>/user/list_manager.do" id="order_manager" class="am-btn am-btn-secondary am-round"><i class="am-icon-cog"></i> 订单管理</a>
<hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>
<a href="<%=path%>/time_range/list_manager.do" id="time_range_manager" class="am-btn am-btn-secondary am-round"><i class="am-icon-cog"></i> 包场时段管理</a>
<script>
</script>
</body>
</html>
