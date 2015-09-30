<%@page language="java" pageEncoding="utf-8" import="java.util.List"%>

<%@page import="bean1.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
  <head> 
    <title>index.jsp</title>
    <link rel="stylesheet" type="text/css" href="/form/style/showQuestion.css">
    <link rel="stylesheet" type="text/css" href="/form/style/top.css">
    <link rel="stylesheet" type="text/css" href="/form/style/content.css">
    <link rel="stylesheet" type="text/css" href="/form/style/like_action.css">
    <link rel="stylesheet" type="text/css" href="/form/style/sidebar.css">
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
		<div id="content" ><!-- 在content下,问题的 name && describe && 循环输出answer -->
			<div class="question_name">${question.questionName }</div>
			<div class="question_describe">
				问题描述: &nbsp&nbsp${question.describe }
			</div>
			
		<c:forEach  items="${answerList }" var="answer">
			<c:if test="${answer.questionId ==question.questionId }">
			<div class="answer">
				<div class="answer_left" >
					<div class="like_left_feed">
						<a class="like_count">1</a>
					</div>
					<div class="dislike_left_feed">
						<a class="like_count">1</a>
					</div>
				</div>
				<div class="answer_right">
					<div class="content_answer">${answer.content }</div>
					<div class="action">
						<a href="">评论</a>
						<a href="">关注</a>
						<a href="">举报</a>
					</div>
				</div>
			</div>
			</c:if>
		</c:forEach>
			<div class="question_addOfUser">
				
			<% 		if(session.getAttribute("user")!=null){
			%>
						<a  href="/form/servlet/guoke" >${user.userName }</a>
			<%      }else{ 
			%>
						<a  href="/form/login.jsp" >登入</a>
			<%		} 
			%> 
				
				
			</div>
			<form action="/form/servlet/addAnswer" method="post">
				<div class="question_addOfAnswer" >
					<textarea name="answer_content" placeholder="添加回答" ></textarea>
				</div>
				<div >
					<input type="hidden" name="questionId" value="${questionId }" />
					<input type="submit" id="question_addOfButton" value="发布答案" />
				</div>
			</form>
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
