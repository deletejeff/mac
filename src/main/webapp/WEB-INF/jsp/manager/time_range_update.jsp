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
    <link rel="stylesheet" href="<%=path%>/resources/assets/css/amazeui.datetimepicker.css">
    <script type="application/javascript" src="<%=path%>/static/js/app.js"></script>
    <script type="application/javascript" src="<%=path%>/resources/assets/js/jquery.min.js"></script>
    <script type="application/javascript" src="<%=path%>/resources/assets/js/amazeui.min.js"></script>
    <script type="application/javascript" src="<%=path%>/resources/assets/js/amazeui.datetimepicker.min.js"></script>
</head>
<body>
<a href="javascript:history.go(-1)" target="_self">
    <button type="button" class="am-btn am-btn-sm">返回</button>
</a>
<form class="am-form" action="<%=path%>/time_range/update.do" method="post" data-am-validator>
    <fieldset>
        <legend>编辑包场时段</legend>
    </fieldset>
    <div class="am-hide">
        <input type="text" id="timeRangeId" name="timeRangeId" value="${timeRangeVo.timeRangeId}" readonly>
    </div>
    <div class="am-form-group">
        <button type="button" class="am-btn am-btn-default am-margin-right" id="start_time_btn">开始时间</button>
        <span id="my-startDate">${timeRangeVo.startTime}</span>
        <input type="hidden" id="startTime" name="startTime" value="${timeRangeVo.startTime}">
    </div>
    <div class="am-form-group">
        <button type="button" class="am-btn am-btn-default am-margin-right" id="end_time_btn">结束时间</button>
        <span id="my-endDate">${timeRangeVo.endTime}</span>
        <input type="hidden" id="endTime" name="endTime" value="${timeRangeVo.endTime}">
    </div>
    <p><button type="submit" id="add_time_range" class="am-btn am-btn-lg am-center">确认</button></p>
</form>
<script type="application/javascript">
    $(function() {
        $.fn.datetimepicker.dates['zh-CN'] = {
            days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
            daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
            daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
            months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            today: "今天",
            suffix: [],
            meridiem: ["上午", "下午"],
            rtl: false // 从右向左书写的语言你可以使用 rtl: true 来设置
        };
        $('#start_time_btn').datetimepicker({
            language:  'zh-CN',
            autoclose: true,
            startView: 1,
            maxView: 1,
            minuteStep: 30,
            startDate: GetDateStr(-1),
            format: 'hh:ii'
        }).on('changeDate', function(ev){
            var start_time = $('#start_time_btn').data('date');
            $('#my-startDate').text(start_time);
            $('#startTime').val(start_time);
        });
        $('#end_time_btn').datetimepicker({
            language:  'zh-CN',
            autoclose: true,
            startView: 1,
            maxView: 1,
            minuteStep: 30,
            startDate: GetDateStr(-1),
            format: 'hh:ii'
        }).on('changeDate', function(ev){
            var end_time = $('#end_time_btn').data('date');
            $('#my-endDate').text(end_time);
            $('#endTime').val(end_time);
        });

        $('#add_time_range').on('click',function(){
            if($('#startTime').val() == '' || $('#endTime').val() == ''){
                alert('请填写开始时间与结束时间!');
                return false;
            }
        });
    });
    function GetDateStr(AddDayCount) {
        var dd = new Date();
        dd.setDate(dd.getDate()+AddDayCount);//获取AddDayCount天后的日期
        var y = dd.getFullYear();
        var m = dd.getMonth()+1;//获取当前月份的日期
        var d = dd.getDate();
        return y + "-" + m + "-" + d;
    }
</script>
</body>
</html>
