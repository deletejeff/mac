<%@ page language="java" pageEncoding="UTF-8" %>
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

    <link rel="icon" type="image/png" href="resources/assets/i/favicon.png">

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="resources/assets/i/app-icon72x72@2x.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="apple-touch-icon-precomposed" href="resources/assets/i/app-icon72x72@2x.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="assets/i/app-icon72x72@2x.png">
    <meta name="msapplication-TileColor" content="#0e90d2">

    <link rel="stylesheet" href="resources/assets/css/amazeui.min.css">
    <link rel="stylesheet" href="resources/assets/css/app.css">
    <script type="application/javascript" src="static/js/app.js"></script>
    <script type="application/javascript" src="resources/assets/js/jquery.min.js"></script>
    <script type="application/javascript" src="resources/assets/js/amazeui.min.js"></script>
    <style>
        body{color: #2f2f2f;background: #f5f5f5;/*font-size: 1em;*/}

        .choose-time{background: #fff;padding: 1em 0;border-bottom: 0px solid #d8d8d8;margin-bottom: 0;}
        .choose-time .wraper{width:24em;margin: 0 auto; }
        .choose-time .btn{position:relative;float: left;line-height: 2.7em;width:9.35em;color: #ff3535;border: 1px solid #ff3535;text-align: center;border-radius: 0.2em;}
        .choose-time .m{float: left;margin:0 0.5em;line-height: 1.2em;font-size: 2em;color: #ff3535; font-weight:bold;text-align: center;}

        .persons{margin:0.5em 0; background: #fff; border-bottom: 1px solid #d8d8d8;border-top: 1px solid #d8d8d8;  }
        .persons .members{position:relative; padding: 0.9em 0.8em; }
        .persons .l{float: left;}

        /*通用样式*/
        .clear_fix:after{ content:".";height:0;visibility:hidden;display:block;clear:both; list-style-type:none;}
        .clear_fix{zoom:1;}
        .clear{clear:both;}

        body{font:normal 12px/1.5 'microsoft yahei','simsun';}
        a,input,button,span{-webkit-tap-highlight-color: rgba(0,0,0,0); -webkit-tap-highlight-color: transparent; /* For some Androids */}

    </style>
</head>
<body>
<div class="am-warning">
    <button class="am-header am-btn-secondary am-btn-xl" data-am-collapse="{target: '#collapse-nav'}">包场消费说明 <i class="am-icon-angle-down"></i></button>
    <nav>
        <ul id="collapse-nav" class="am-nav am-collapse">
            <label>............</label>
            <%--<li><a href="">开始使用</a></li>--%>
            <%--<li><a href="">CSS 介绍</a></li>--%>
            <%--<li class="am-active"><a href="">JS 介绍</a></li>--%>
            <%--<li><a href="">功能定制</a></li>--%>
        </ul>
    </nav>
</div>

<form data-am-validator>
    <div class="am-form-group">
        <div class="am-input-group am-datepicker-date">
            <input type="text" class="am-form-field" placeholder="预定日期" data-am-datepicker="{format: 'yyyy-mm-dd', viewMode: 'years'}" readonly/>
            <span class="am-input-group-btn am-datepicker-add-on">
                <button class="am-btn am-btn-default" type="button">
                    <span class="am-icon-calendar"></span>
                </button>
            </span>
        </div>
    </div>
    <div class="choose-time am-form-group">
        <div class="wraper clear_fix">
            <span class="btn">
                <select id="selectStartTime" data-am-selected="{maxHeight: 300, btnWidth: 110}"></select>
            </span>
            <span class="m">至</span>
            <span class="btn">
                <select id="selectEndTime" data-am-selected="{maxHeight: 300, btnWidth: 110}"></select>
            </span>
        </div>
    </div>
    <div class="persons">
        <div class="members clear_fix am-form-group">
            <label class="l peopleNum" for="doc-vld-age">聚会人数</label>
            <input type="number" class="am-form-field am-radius" id="doc-vld-age" placeholder="输入人数  1-50" min="1" max="50" required />
        </div>
    </div>
    <div class="am-form-group">
        <label class="l peopleNum" for="doc-vld-name">联系人</label>
        <input type="text" class="am-form-field am-radius" id="doc-vld-name" placeholder="贵姓" required/>
    </div>
    <div class="am-form-group">
        <label class="am-radio-inline">
            <input type="radio"  value="" name="docInlineRadio">先生
        </label>
        <label class="am-radio-inline">
            <input type="radio" name="docInlineRadio">女士
        </label>
    </div>
    <div class="am-form-group">
        <label class="l peopleNum" for="doc-vld-phone">联系电话</label>
        <input type="number" class="am-form-field am-radius" id="doc-vld-phone" placeholder="输入联系人手机" required />
    </div>
    <div class="am-form-group">
        <label class="l peopleNum" for="doc-vld-text">留言</label>
        <textarea class="am-form-field am-radius" rows="2" id="doc-vld-text" placeholder="如有特殊要求，请留言，老友记全体员工为你竭诚服务~"></textarea>
    </div>
    <p><button type="submit" class="am-btn am-btn-lg am-center">确认</button></p>
</form>







    <!--在这里编写你的代码-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="resources/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="resources/jquery/jquery-1.9.1.min.js"></script>
<![endif]-->
<script type="application/javascript">
    var selectTime = [{name:"10点",value:10},{name:"10点30分",value:10.5},{name:"11点",value:11},{name:"11点30分",value:11.5},{name:"12点",value:11},{name:"12点30分",value:12.5},{name:"13点",value:13},{name:"13点30分",value:13.5},{name:"14点",value:14},{name:"14点30分",value:14.5},{name:"15点",value:15},{name:"15点30分",value:15.5},{name:"16点",value:16},{name:"16点30分",value:16.5},{name:"17点",value:17},{name:"17点30分",value:17.5},{name:"18点",value:18},{name:"18点30分",value:18.5},{name:"19点",value:19},{name:"19点30分",value:19.5},{name:"20点",value:20},{name:"20点30分",value:20.5},{name:"21点",value:21},{name:"21点30分",value:21.5},{name:"22点",value:22},{name:"22点30分",value:22.5},{name:"23点",value:23}];
    for(var i=0;i<selectTime.length;i++){
        $('#selectStartTime').append('<option value="'+ selectTime[i].value +'">' + selectTime[i].name + '</option>');
        $('#selectEndTime').append('<option value="'+ selectTime[i].value +'">' + selectTime[i].name + '</option>');
    }
</script>
</body>
</html>