<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <script type="application/javascript" src="<%=path%>/static/js/app.js"></script>
    <script type="application/javascript" src="<%=path%>/resources/assets/js/jquery.min.js"></script>
    <script type="application/javascript" src="<%=path%>/resources/assets/js/amazeui.min.js"></script>
</head>
<body>
<a href="javascript:history.go(-1)" target="_self">
    <button type="button" class="am-btn am-btn-sm">返回</button>
</a>
<form class="am-form" action="<%=path%>/menu/update.do" method="post" enctype="multipart/form-data" data-am-validator>
    <fieldset>
        <legend>编辑菜品</legend>
    </fieldset>
    <div class="am-form-group">
        <input type="text" id="dishId" name="dishId" value="${menuVo.dishId}" readonly>
    </div>
    <div class="am-form-group">
        <label for="dishName">名称</label>
        <input type="text" id="dishName" name="dishName" value="${menuVo.dishName}" required>
    </div>
    <div class="am-form-group">
        <label for="dishEnglishName">英文名</label>
        <input type="text" id="dishEnglishName" name="dishEnglishName" value="${menuVo.dishEnglishName}">
    </div>
    <div class="am-form-group">
        <label for="categoryId">分类</label>
        <select id="categoryId" name="categoryId">
            
        </select>
    </div>
    <div class="am-form-group">
        <label for="dishPrice">价格</label>
        <input type="number" id="dishPrice" name="dishPrice" value="${menuVo.dishPrice}" required>
    </div>
    <div class="am-form-group">
        <label for="dishDescription">描述</label>
        <input type="text" id="dishDescription" name="dishDescription" value="${menuVo.dishDescription}">
    </div>
    <div class="am-form-group">
        <label for="spicyLevel">麻辣等级</label>
        <select id="spicyLevel" name="spicyLevel">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
        </select>
    </div>
    <div class="am-form-group">
        <label for="hotLevel">火爆程度</label>
        <select id="hotLevel" name="hotLevel">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
        </select>
    </div>
    <div class="am-form-group">
        <label for="dishPrice2">大份价格</label>
        <input type="number" id="dishPrice2" name="dishPrice2" value="${menuVo.dishPrice2}">
    </div>
    <div class="am-form-group">
        <label for="dishOrigin">产地</label>
        <input type="text" id="dishOrigin" name="dishOrigin" value="${menuVo.dishOrigin}">
    </div>
    <div class="am-form-group">
        <div id="viewImg_div" hidden="hidden">
            <img src="<%=path%>/${menuVo.dishImgurl}"/>
            <input id="dishImgurl" name="dishImgurl" type="hidden" value="${menuVo.dishImgurl}"/>
            <button id="delete_img" type="button" class="am-btn am-btn-sm">删除图片</button>
        </div>
        <div id="uploadImg_div" hidden="hidden">
            <label for="multipartFile">图片</label>
            <input type="file" id="multipartFile" name="multipartFile">
            <p class="am-form-help">请选择要上传的文件...</p>
            <div id="img_div"></div>
        </div>
    </div>
    <div class="am-form-group">
        <label for="dishCapacity">容量</label>
        <input type="number" id="dishCapacity" name="dishCapacity" value="${menuVo.dishCapacity}">
    </div>
    <div class="am-form-group">
        <label for="dishUnit">计量单位</label>
        <input type="text" id="dishUnit" name="dishUnit" value="${menuVo.dishUnit}" required>
    </div>
    <div class="am-form-group">
        <label for="dishGroup">菜品系列分组</label>
        <select id="dishGroup" name="dishGroup"><option value="1">1</option></select>
    </div>
    <div class="am-form-group">
        <label for="dishOrder">菜品排列顺序</label>
        <input type="number" id="dishOrder" name="dishOrder" value="${menuVo.dishOrder}">
    </div>
    <p><button type="submit" id="add_dish" class="am-btn am-btn-lg am-center">确认</button></p>
</form>
<!--[if (gte IE 9)|!(IE)]><!-->
<script src="<%=path%>/resources/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="<%=path%>/resources/jquery/jquery-1.9.1.min.js"></script>
<![endif]-->
<script type="application/javascript">
    $.ajax({
        url: BASE_URL + '/category/list.do',
        type: 'post',
        success:function (data) {
            data = $.parseJSON(data);
            $('#categoryId').empty();
            $.each(data.list, function(i, item) {
                if(item.categoryId == '${menuVo.categoryId}'){
                    $('#categoryId').append('<option value="' + item.categoryId +'" selected>' + item.categoryName + '</option>');
                }else{
                    $('#categoryId').append('<option value="' + item.categoryId +'">' + item.categoryName + '</option>');
                }
            });
        }
    });
    $('#spicyLevel').val('${menuVo.spicyLevel}');
    $('#hotLevel').val('${menuVo.hotLevel}');
    if('${menuVo.dishImgurl}' != ""){
        $('#viewImg_div').show();
    }else{
        $('#viewImg_div').hide();
        $('#uploadImg_div').show();
    }
    $('#delete_img').on('click', function(){
        if(confirm('删除后无法恢复，确定删除吗？')){
            $.ajax({
                url: BASE_URL + '/menu/delete_img.do',
                type: 'post',
                data: {
                    dishId : '${menuVo.dishId}'
                },
                success:function (data) {
                    data = $.parseJSON(data);
                    if(data.success){
                        $('#dishImgurl').val('');
                        $('#viewImg_div').hide();
                        $('#uploadImg_div').show();
                    }
                }
            });
        }
    });
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
</script>
</body>
</html>
