<%@page language="java" pageEncoding="utf-8" import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
  <head> 
    <title>guoke.jsp</title>
    <link rel="stylesheet" type="text/css" href="/form/style/guoke.css">
    <link rel="stylesheet" type="text/css" href="/form/style/top.css">
    <link rel="stylesheet" type="text/css" href="/form/style/sidebar.css">
    <link rel="stylesheet" type="text/css" href="/form/style/content.css">
    <link rel="stylesheet" type="text/css" href="/form/style/like_action.css">
    <script src="/form/script/jquery-2.1.3.js"></script>
    <script type="text/javascript">
    	$(function(){
    		//页面顶部登录部分的控制
    		$(".ul_about").mouseover(function(e){
    			$(".about_me_under").css("display","inline"); 		
    		}).mouseout(function(){
    			$(".about_me_under").css("display","none");
    		});
    		
    		//(1)先给.like_count绑定自定义的myclick函数,
    		$(".like_count").bind("myclick",function(){
    			var $this=$(this);   
    			var $question_id=$this.next(); //.like_count的下一个同辈元素
    			var questionId=$question_id.text();

    			$.get("/form/servlet/Like_count",
    				 {useage:"get", type: "question",questionId: questionId}, 
    				 function(data,textStatus){		$this.text(data);  }
    			);
    		});
    		//(2)然后用trigger触发,即在浏览器加载完就触发,完成每个点赞数字的初始化操作
    		$(".like_count").trigger("myclick");
    		
    		
    		//这个是在用户点击了才触发的
    		$(".like_count").click(function(){
    			
    			var personal=$("#personal").attr("title");//获取#personal里的title属性的值
    			if(personal=="ok"){  //js里判断字符串相等是==,不同于java里的equals()
    				//这里是一个论坛上说stack overflow上给出的解决方案https://ruby-china.org/topics/13427
    				var $this=$(this);  
    				var $question_id=$this.next(); 
    				var questionId=$question_id.text();

    				$.get("/form/servlet/Like_count",
    				 	{useage:"insert", type: "question",questionId: questionId}, 
    				 	function(data,textStatus){		$this.text(data);  }
    				);	
    			}
    			else{
    				alert("请登录");
    				window.location.href="/form/login.jsp";
    			}		
    		}); 
    		//点击评论展开
    		$(".addReplay").bind("click",function(){
    			
    			var personal=$("#personal").attr("title");//获取#personal里的title属性的值
    			if(personal=="ok"){  //js里判断字符串相等是==,不同于java里的equals()
    				var $this=$(this);
    				var $addReplay=$this.parent().parent().parent().next();
    				if($addReplay.is(":visible")){
    					$addReplay.css("display","none");
    				}else{
    					$addReplay.css("display","block");
    				}
    				
    				//$this.parent().parent().parent().css("height","300px");
    				//$this.parent().parent().append($new);
    				//$this.parent().parent().toggle(function(){
    				//	$this.parent().parent().append($new);
    				//},function(){
    				//	$this.parent().parent().remove($new);
    				//});
    			}
    			else{
    				alert("请登录");
    				window.location.href="/form/login.jsp";
    			}		
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
    <!--最上面的横栏,基本每个页面都是相同的-->
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
						<li class="about_me"><a id="personal" href="/form/servlet/guoke" title="ok">Me</a></li>
						<li class="about_me_under" ><a href="/form/servlet/personalPage" id="personal_under">主页</a></li>
						<li class="about_me_under" ><a href="" id="personal_under">设置</a></li>
						<li class="about_me_under" ><a href="/form/servlet/logout" id="personal_under">退出</a></li>   
			<%}		else{ 
			%>
						<li class="about_me"><a id="personal" href="/form/login.jsp" title="no">登录</a></li>
			<%		} 
			%>
						
				</ul>
			</div>
		</div>
	</div>
	<!-- 正文和右部导航栏部分(side bar) -->
	<div class="wrap">
		<div id="content" ><!-- 在content下,  一个newest && 循环输出feed   -->
			<div id="newest">最新动态</div>
			<c:forEach  var="question"  items="${questionList}"  >
			<div class="feed">
				<div class="left_feed"><!-- 用户头像和点赞次数 -->
					<div><img class="img" src="/form/img/photo.jpg"></div>
					<div><a class="like_count" >1</a>
						<p class="question_id" style="display:none">${question.questionId }</p>
					</div>
				</div>
				<div class="right_feed"><!-- 正文 -->
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
								${answer.content }
							</c:if>
						</c:forEach> 
					</div>
					<div class="action">
						<a class="addReplay" >评论</a>
						<a class="addReplay" >关注</a>
						<a class="addReplay" >举报</a>
					</div>
				</div>
			</div>
			<div class="newReplay"> <!-- 点击显示添加评论框的div,默认隐藏 -->
				<form action="/form/servlet/addAnswer" method="post" >
					<div class="replay">
						<textarea name="answer_content" placeholder="添加评论"></textarea>
					</div>
					<div class="submit">
						<input type="hidden" name="questionId" value="${questionId }" />
						<input type="submit" id="question_addOfButton" value="提交" />
					</div>
				</form>
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
