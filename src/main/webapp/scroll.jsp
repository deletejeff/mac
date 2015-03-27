<%@page language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="author" content="hahnzhu" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
    <title>Demo</title>
    <link rel="stylesheet" href="<%=path%>/resources/dist/css/parallax.css">
    <link rel="stylesheet" href="<%=path%>/resources/dist/css/parallax-animation.css">
    <style>
        /* custom */
        section[data-id="1"] {
            background-color: #3498db;
        }
        section[data-id="2"] {
            background-color: #40d47e;
        }
        section[data-id="3"] {
            background-color: #ff8c81;
        }
        section[data-id="4"] {
            background-color: #3498db;
        }
        .box1 {
            width: 100px;
            height: 200px;
            background-color: #ecf0f1;
            position: absolute;
            left: 160px; top: 126px;
        }
        .box2 {
            width: 200px;
            height: 100px;
            background-color: #8e44ad;
            position: absolute;
            left: 60px; top: 226px;
        }
        .box3 {
            width: 100px;
            height: 100px;
            background-color: #34495e;
            position: absolute;
            left: 160px; top: 226px;
        }
        .box4 {
            width: 50px;
            height: 50px;
            background-color: #e74c3c;
            position: absolute;
            left: 185px; top: 250px;
        }
        .music-btn{position:fixed;opacity:0;top:10px;right:10px;z-index:500;background-size:18px 18px;width:18px;height:18px;background-position:0 0;background-repeat:no-repeat}
        .music-btn.open{opacity:1;-webkit-animation:music 2s infinite linear;-moz-animation:loading-icon 2s infinite linear;animation:loading-icon .8s infinite linear;}
        @-webkit-keyframes music{0%{-webkit-transform:rotate(0deg)}
            100%{-webkit-transform:rotate(360deg)}
        }
        @-moz-keyframes music{0%{-moz-transform:rotate(0deg)}
            100%{-moz-transform:rotate(360deg)}
        }
        @keyframes music{0%{transform:rotate(0deg)}
            100%{transform:rotate(360deg)}
        }
        .music-btn.off{opacity:1;}
    </style>
</head>
<body>
<audio id="myAudioMatch" preload="auto" style="display: none" autoplay="autoplay" loop="loop">
    <source src="http://115.28.45.153/mac/home.mp3" type="audio/mpeg">
</audio>
<div class="wrapper">
    <div class="pages">
        <div class="music-btn" style="background-image: url('<%=path%>/resources/dist/img/music.png'); "></div>

        <!-- 第一屏 -->
        <section class="page">
            <div class="box1" data-animation="slideToBottom" data-timing-function="ease-in"></div>
            <div class="box2" data-animation="slideToTop" data-delay="300" data-timing-function="ease-out"></div>
            <div class="box3" data-animation="slideToRight" data-delay="600" data-timing-function="linear"></div>
            <div class="box4" data-animation="slideToLeft" data-delay="900" data-timing-function="cubic-bezier(.12,.73,.62,1.38)"></div>
        </section>

        <!-- 第二屏 -->
        <section class="page">
            <h2></h2>
            <div class="box1" data-animation="followSlide" data-duration="1000"></div>
            <div class="box2" data-animation="followSlide" data-delay="200" data-duration="1000"></div>
            <div class="box3" data-animation="followSlide" data-delay="400" data-duration="1000"></div>
            <div class="box4" data-animation="followSlide" data-delay="600" data-duration="1000"></div>
        </section>

        <!-- 第三屏 -->
        <section class="page">
            <div class="box1" data-animation="fadeInToBottom"></div>
            <div class="box2" data-animation="fadeInToTop" data-delay="200"></div>
            <div class="box3" data-animation="fadeInToLeft" data-delay="400"></div>
            <div class="box4" data-animation="fadeInToRight" data-delay="600"></div>
        </section>

        <!-- 第四屏 -->
        <section class="page">
            <div class="box1" data-animation="fadeIn"></div>
            <div class="box2" data-animation="fadeOut" data-delay="800"></div>
        </section>

    </div>
</div>
<script src="<%=path%>/resources/dist/js/zepto.min.js"></script>
<script src="<%=path%>/resources/dist/js/parallax.js"></script>
<script>

    $('.pages').parallax({
        direction: 'vertical', 	// horizontal (水平翻页)
        swipeAnim: 'cover', 	// cover (切换效果)
        drag:      true,		// 是否允许拖拽 (若 false 则只有在 touchend 之后才会翻页)
        loading:   false,		// 有无加载页
        indicator: false,		// 有无指示点
        arrow:     true,		// 有无指示箭头
        /*
         * 翻页后立即执行
         * {int} 		index: 第几页
         * {DOMElement} element: 当前页节点
         * {String}		directation: forward(前翻)、backward(后翻)、stay(保持原页)
         */
        onchange: function(index, element, direction) {
            // code here...
            // console.log(index, element, direction);
        },
        /*
         * 横竖屏检测
         * {String}		orientation: landscape、protrait
         */
        orientationchange: function(orientation) {
            // console.log(orientation);
        }
    });
    //音乐播放
    var myAudioMatch=document.getElementById("myAudioMatch");
    $(".music-btn").bind("touchend",function(event){
        event.stopPropagation();
        if(!$(this).hasClass("open")){
            $(this).removeClass("off").addClass("open");
            myAudioMatch.play();
        }else{
            $(this).removeClass("open").addClass("off");
            myAudioMatch.pause();
        }
    });
    myAudioMatch.loop = true;
    myAudioMatch.play();
    setTimeout(function() {
        $(".music-btn").addClass("open");
    }, 400);



</script>
</body>
</html>