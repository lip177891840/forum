<%@page language="java" pageEncoding="utf-8" import="java.util.List"%>

<%@page import="bean1.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
  <head> 
    <title>index.jsp</title>
    <link rel="stylesheet" type="text/css" href="/form/style/all1.css">
    <link rel="stylesheet" type="text/css" href="/form/style/guoke.css">
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
		<div id="content" >
			<div class="top_all_topic">${topic.topicName }</div>
			<c:forEach var="question" items="${questionList_OneTopic }">
			<div class="feed">
				<div class="left_feed">
					<div class="img_left_feed"><img class="img_feed"src="/form/img/photo.jpg"></div>
					<div class="like_left_feed">
						<a class="like_count">1</a>
					</div>
				</div>
				<div class="right_feed">
					<div class="topic_right_feed">
						<c:forEach  items="${topicList }" var="topic">
							<c:if test="${topic.topicId == question.topicId }">
							来自 <a href="/form/servlet/showTopic?topicType=one&&topicId=${topic.topicId }" >${topic.topicName }</a>
							</c:if>
						</c:forEach>
					</div>
					<div class="question_right_feed"><a href="/form/servlet/showQuestion?questionId=${question.questionId }">
					${question.questionName }</a></div>
					<div class="zuozhe_right_feed">
						<c:forEach var="user" items="${userList }" >
							<c:if test="${user.userId == question.userId }">
								<a href="">${user.userName }</a>
							</c:if>
						</c:forEach>
					</div>
					<div class="content_right_feed">
						<c:forEach var="answer" items="${answerList }">
							<c:if test="${answer.questionId == question.questionId }">
								${answer.answerId }
							</c:if>
						</c:forEach> 
						在一个普通学生的一天里，早八点到晚十点，理论上的有效时间是十四小时，中午晚饭两餐饭休息要花掉两小时，
						零散聊天一小时，漫不经心逛淘宝一小时，几次厕所半小时，刷微博花掉一小时，时不时发点呆半小时……这些时间加起来，
						当然还有没计算在内的意外时间点，到最后，你的有效时间也没剩下多少个小时了，直到我发现，每个人最终用到的时间，
						就是这无与伦比的几个小时。
					</div>
					<div class="action_right_feed">
						<a href="">评论</a>
						<a href="">关注</a>
						<a href="">举报</a>
					</div>
				</div>
			</div>
			</c:forEach>
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
