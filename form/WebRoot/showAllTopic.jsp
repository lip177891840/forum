<%@page language="java" pageEncoding="utf-8" import="java.util.List"%>

<%@page import="bean1.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
  <head> 
    <title>index.jsp</title>
    <link rel="stylesheet" type="text/css" href="/form/style/all1.css">
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
			<a id="logo" href="/form/servlet/guoke" >知乎</a>
			
			<div id="search" >
				<form  id="form" method="GET">
					<input  id="input" type="text" >
					<button id="button" type="submit" >搜索</button>
				</form>
			</div>
			
			<div id="list_top" >
				<ul id="ul_top">
					<li class="li_top">
						<a class="a_top" href="/form/servlet/guoke">首页</a>
					</li>
					<li class="li_top">
						<a class="a_top" href="">话题</a>
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
		<% 		if(session.getAttribute("user")!=null){
		%>
						<a id="personal" href="/form/servlet/guoke" >Me</a>
		<%}		else{ 
		%>
						<a id="personal" href="/form/login.jsp" >登入</a>
		<%		} 
		%>
			</div>
		</div>
	</div>
	<div class="wrap">
		<div id="content" >
			<div class="top_all_topic">话题广场</div>
			<div class="all_topic">
				<ul>
				<c:forEach var="topic" items="${topicList }" >
					<li class="li_all_topic"><a href="/form/servlet/showTopic?topicType=one&&topicId=${topic.topicId }" >${topic.topicName }</a></li>
				</c:forEach>
				</ul>
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
					<li class="li_sidebar"><a class="a_right" href="">话题广场</a></li>
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
