<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="application/javascript" src="<%=path%>/resources/assets/js/jquery.min.js"></script>
    <script type="application/javascript" src="<%=path%>/resources/assets/js/amazeui.min.js"></script>
</head>
<body>
<div class="am-cf">
    <a href="<%=path%>/main.jsp" target="_self">
        <button type="button" class="am-btn am-btn-sm">主页</button>
    </a>
    <a href="<%=path%>/time_range/add.do" target="_self">
        <button type="button" class="am-btn am-btn-sm">添加包场时段</button>
    </a>
    <label class="am-fr">${msg}</label>
</div>
<table class="am-table am-table-bordered am-table-striped am-table-hover">
    <thead>
        <tr>
            <th>开始时间</th>
            <th>结束时间</th>
        </tr>
    </thead>
    <c:forEach items="${pageList.list}" var="vo" varStatus="status">
        <tr>
            <td>${vo.startTime}</td>
            <td>${vo.endTime}</td>
            <td>
                <div class="am-btn-group">
                    <a href="<%=path%>/time_range/delete.do?timeRangeId=${vo.timeRangeId}" onClick="return confirm('确定删除吗？')" target="_self">
                        <button id="deleteBtn" type="button" class="am-btn am-btn-sm">删除</button>
                    </a>
                </div>
                <div class="am-btn-group">
                    <a href="<%=path%>/time_range/update.do?timeRangeId=${vo.timeRangeId}" target="_self">
                        <button type="button" class="am-btn am-btn-sm">编辑</button>
                    </a>
            </div>
            </td>
        </tr>
    </c:forEach>
</table>
<!--[if (gte IE 9)|!(IE)]><!-->
<script src="<%=path%>/resources/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="<%=path%>/resources/jquery/jquery-1.9.1.min.js"></script>
<![endif]-->
<script type="application/javascript">
</script>
</body>
</html>
