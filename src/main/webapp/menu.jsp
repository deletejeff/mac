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
        .am-header-fixed {
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            width: 100%;
            z-index: 1010;
        }
    </style>
</head>
<body>
<!-- 顶部导航条 -->
<header data-am-widget="header" class="am-header am-header-default am-header-fixed">
    <h1 class="am-header-title">菜单</h1>
    <!-- 侧边栏内容 -->
    <div id="demo-view" data-backend-compiled>
        <nav data-am-widget="menu" class="am-menu am-menu-offcanvas1" data-am-menu-offcanvas>
            <a href="javascript: void(0)" class="am-menu-toggle">
                <i class="am-menu-toggle-icon am-icon-bars"></i>
            </a>
            <div class="am-offcanvas">
                <div class="am-offcanvas-bar">
                    <ul class="am-menu-nav am-avg-sm-1">
                        <li class=""><a href="##" class="">欧巴张靖峰</a></li>
                        <li class=""><a href="##" class="">奶爸姚振中</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</header>
<!-- 底部导航条 -->
<header class="am-topbar am-topbar-fixed-bottom">
    <div class="am-topbar-brand am-topbar-toggle">
        <%--<button class="am-btn am-btn-primary am-topbar-btn am-btn-sm">登录</button>--%>
        <label class="am-text-success">合计:<label id="totalPrice">0</label>元</label>&nbsp;&nbsp;&nbsp;&nbsp;
        <button class="am-btn am-btn-primary am-btn-lg" data-am-modal="{target: '#my-order'}" id="pre-my-order">预定</button>
        <%--<span class="am-icon-btn" onclick="myorder()">预定</span>--%>
    </div>
</header>
<!-- 收缩面板内容 -->
<div class="am-panel-group" id="accordion"></div>

<!-- 弹出层 -->
<div class="am-modal am-modal-alert" tabindex="-1" id="my-order">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">您的菜单</div>
        <div id="myOrderContent" class="am-scrollable-vertical">
        </div>
        <%--<div class="am-modal-bd">点击确定下单</div>--%>
        <div class="am-modal-footer">
            <span class="am-modal-btn">我要修改</span>
            <span class="am-modal-btn">我要下单</span>
        </div>
    </div>
</div>


<!--[if (gte IE 9)|!(IE)]><!-->
<script src="resources/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="resources/jquery/jquery-1.9.1.min.js"></script>
<![endif]-->
<script type="application/javascript">
    var totalPrice = parseInt($('#totalPrice').text());
    var orderList = new Array();
    function plus(dishId, dishName, dishUnit, dishPrice){
        var quantity = parseInt($('#quantity_'+dishId).text())+1;
        if(quantity > 10){
            alert("好东西只有这么多了~");
            return;
        }
        totalPrice = totalPrice + dishPrice;
        $('#quantity_'+dishId).text(quantity);
        $('#totalPrice').text(totalPrice);
        if(quantity > 0){
            $('#quantity_span_'+dishId).removeClass('am-hide');
            $('#minus_span_'+dishId).removeClass('am-hide');
        }
        var obj = new Object();
        obj.dishId = dishId;
        obj.dishName = dishName;
        obj.quantity = quantity;
        obj.price = dishPrice;
        obj.unit = dishUnit;
        orderPlus(obj);
    }
    function minus(dishId, dishName, dishUnit, dishPrice){
        var quantity = parseInt($('#quantity_'+dishId).text())-1;
        totalPrice = totalPrice - dishPrice;
        $('#quantity_'+dishId).text(quantity);
        $('#totalPrice').text(totalPrice);
        if(quantity == 0) {
            $('#quantity_span_'+dishId).addClass('am-hide');
            $('#minus_span_'+dishId).addClass('am-hide');
        }
        var obj = new Object();
        obj.dishId = dishId;
        obj.dishName = dishName;
        obj.quantity = quantity;
        obj.price = dishPrice;
        obj.unit = dishUnit;
        orderMinus(obj);
    }
    function orderPlus(obj){
        var result = false;
        for(var i=0;i<orderList.length;i++){
            var temp = orderList[i];
            if(temp.dishName == obj.dishName){
                result = true;
                temp.quantity += 1;
            }
        }
        if(!result){
            orderList.push(obj);
        }
    }
    function orderMinus(obj){
        for(var i=0;i<orderList.length;i++){
            var temp = orderList[i];
            if(temp.dishName == obj.dishName){
                temp.quantity -= 1;
                if(temp.quantity == 0){
                    orderList.splice(i,1);
                }
            }
        }
    }
    $(function() {
        $.ajax({
            url : BASE_URL + '/category/list.do',
            cache : false,
            async : false,
            type : "POST",
            success : function (data){
                data = $.parseJSON(data);
                $('#accordion').empty();
                var ul_id = '';
                $.each(data.list, function(i, item){
                    if(i==0)ul_id += item.categoryId;
                    $('#accordion').append(
                    '<div class="am-panel am-panel-default">' +
                        '<div class="am-panel-hd">' +
                            '<h4 class="am-panel-title" data-am-collapse="{parent: \'#accordion\', target: \'#panel-' + i + '\'}">' + item.categoryName + '</h4>' +
                        '</div>' +
                        '<div id="panel-' + i + '" class="am-panel-collapse am-collapse">' +
                            '<div class="am-panel-bd">' +
                                '<ul id="list_' + item.categoryId + '" class="am-list am-list-static am-list-border"></ul>' +
                            '</div>' +
                        '</div>' +
                    '</div>');
                });
                initData(ul_id);
            }
        });
        $('#pre-my-order').on('click', function() {
            $('#myOrderContent').empty();
            var myOrderInnerHTML = '<table style="align-content: center;width: 100%">';
            for(var i=0;i<orderList.length;i++){
                var obj = orderList[i];
                myOrderInnerHTML += '<tr>';
                myOrderInnerHTML += '<td>' + obj.dishName + '</td>';
                myOrderInnerHTML += '<td>' + obj.quantity + '&nbsp;' + obj.unit + '</td>';
                myOrderInnerHTML += '<td>' + obj.quantity*obj.price + '&nbsp;元</td>';
                myOrderInnerHTML += '</tr>';
            }
            myOrderInnerHTML += '</table>';
            myOrderInnerHTML += '<br/>合计:' + totalPrice + '&nbsp;元';
            $('#myOrderContent').append(myOrderInnerHTML);
        });
    });
    function initData(ul_id){
        $.ajax({
            url: BASE_URL + '/menu/list.do',
            type: 'post',
            data: {
                categoryId : ul_id
            },
            success:function (data) {
                data = $.parseJSON(data);
                $.each(data.pageList.list, function(i, item){
                    $('#list_' + ul_id + '').append('<li>' +
                    '<label class="am-hide" id="dishPrice_' + item.dishId + '">' + item.dishPrice + '</label>' +
                    '<label class="am-hide" id="dishName_' + item.dishId + '">' + item.dishName + '</label>' +
                    '<span class=" am-badge am-badge-success am-circle">' +
                    '<span class="am-icon-btn-sm am-icon-plus" onclick="plus(\'' + item.dishId + '\',\'' + item.dishName + '\',\'' + item.dishUnit + '\',' + item.dishPrice + ');"></span>' +
                    '</span>' +
                    '<span id="quantity_span_' + item.dishId + '" class="am-badge am-badge-secondary am-circle am-hide">' +
                    '<span class="am-icon-btn-sm" id="quantity_' + item.dishId + '">0</span>' +
                    '</span>' +
                    '<span id="minus_span_' + item.dishId + '" class="am-badge am-badge-danger am-circle am-hide">' +
                    '<span class="am-icon-btn-sm am-icon-minus" onclick="minus(\'' + item.dishId + '\',\'' + item.dishName + '\',\'' + item.dishUnit + '\',' + item.dishPrice + ');"></span>' +
                    '</span>' +
                    '<span class="am-badge am-round">' +
                    '<span class="am-text-sm">' + item.dishPrice + '元/' + item.dishUnit + '</span>' +
                    '</span>' +
                    '<label class="am-kai">' + item.dishName + '</label>' +
                    '</br>' +
                    '<img class="am-img-loaded" src="' + item.dishImgurl + '">' +
                    '</br>' + item.dishDescription + '</li>');
                });
                $('#minus_div').hide();
            }
        });
    }
</script>
</body>
</html>