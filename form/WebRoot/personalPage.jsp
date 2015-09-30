<%@page language="java" pageEncoding="utf-8" import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
  <head> 
    <title>index.jsp</title>
    <link rel="stylesheet" type="text/css" href="/form/style/all1.css">
    <script src="/form/script/jquery-2.1.3.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$(".ul_about").mouseover(function(e){
    			$(".about_me_under").css("display","inline");
    		
    		}).mouseout(function(){
    			$(".about_me_under").css("display","none");
    		});
    	
    	
    	});
    </script>
    <style type="text/css">
    	.top{
    		background: -moz-linear-gradient(center top , #086ed5, #055db5) repeat-x scroll 0 0 #0767c8;
    		border-bottom: 1px solid #044e97;
    		box-shadow: 0 1px 2px rgba(0, 0, 0, 0.25), 0 1px 0 rgba(255, 255, 255, 0.15) inset;
    		height: 45px;
    		left: 0;
    		position: fixed;
    		top: 0;
    		width: 100%;
    		z-index: 20;
		}
    </style>
  </head>

  <body >
	<div class="top">
		<div class="center_top">
			<a id="logo" href="" >知乎</a>
			
			<div id="search" >
				<form  id="form" method="GET">
					<input  id="input" type="text" >
					<button id="button" type="submit" >搜索</button>
				</form>
			</div>
			
			<div id="list_top" >
				<ul id="ul_top">
					<li class="li_top">
						<a class="a_top" href="">首页</a>
					</li>
					<li class="li_top">
						<a class="a_top" href="/form/servlet/showTopic?topicType=all">话题</a>
					</li>
					<li class="li_top">
						<a class="a_top" href="">发现</a>
					</li>
					<li class="li_top">
						<a class="a_top" href="">消息</a>
					</li>
				</ul>
			</div>
			<div id="about" >
				<ul class="ul_about">
				
			<% 		if(session.getAttribute("user")!=null){
			%>
						<li class="about_me"><a id="personal" href="/form/servlet/guoke">Me</a></li>
						<li class="about_me_under" ><a href="/form/servlet/personalPage" id="personal_under">主页</a></li>
						<li class="about_me_under" ><a href="" id="personal_under">设置</a></li>
						<li class="about_me_under" ><a href="/form/servlet/logout" id="personal_under">退出</a></li>   
			<%}		else{ 
			%>
						<li class="about_me"><a id="personal" href="/form/login.jsp" >登入</a></li>
			<%		} 
			%>
						
				</ul>
			</div>
		</div>
	</div>
	<div class="wrap">
		<div id="content">
			<div id="newest">个人信息</div>
			<div class="img_left_feed"><img class="img_feed"src="/form/img/photo.jpg"></div>
			<div class="feed">
				${user.userName }  <br />
				${user_info.signature } <br />
				${user_info.sex }	   <br />
				${user_info.email }   <br />
				${user_info.home }    <br />
				${user_info.education }
			</div>
		</div>
		<div id="sidebar" >
			<div class="sidebar_top">
				<ul>
					<li class="li_sidebar"><a class="a_right" href="">我的草稿</a></li>
					<li class="li_sidebar"><a class="a_right" href="">我的回答</a></li>
					<li class="li_sidebar"><a class="a_right" href="">我的收藏</a></li>
				</ul>
			</div>
			<div class="sidebar_mid">
				<ul>
					<li class="li_sidebar"><a class="a_right" href="">所有问题</a></li>
					<li class="li_sidebar"><a class="a_right" href="/form/servlet/showTopic?topicType=all">话题广场</a></li>
					<li class="li_sidebar"><a class="a_right" href="">个人秀</a></li>
				</ul>
			</div>
			<div class="sidebar_bottom">
				<ul>
					<li class="li_sidebar"><a class="a_right" href="">使用指南</a></li>
					<li class="li_sidebar"><a class="a_right" href="">移动应用</a></li>
					<li class="li_sidebar"><a class="a_right" href="">使用协议</a></li>
					<li class="li_sidebar"><a class="a_right" href="">@2015果壳</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
