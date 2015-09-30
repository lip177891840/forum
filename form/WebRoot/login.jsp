<%@page language="java" pageEncoding="utf-8" import="java.util.List"%>
<%@page import="bean1.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
  <head> 
    <title>index.jsp</title>
    <style type="text/css">
    	body{
			background-image:url(/form/img/bg.jpg)
    	}
    	#title{
    		margin:0 auto;
    		width:450px;
    		margin-top:130px;
    		font-size:29px;
    		color:#bbffaa;
    	}
    	#form{
    		margin: 0 auto;
    		width: 450px;
    		margin-top: 120px;
    	}
    	#name{
    		height:50px;
    	}
    	#password{
    		height:50px;
    		
    	}
    	#submit{
    		width:130px;
    		
    	}
    	input{
    		background:none repeat scroll 0 0 #e7f1f8;
    		border:1px solid #1672b9;
    		border-radius:5px;
    		color:#555;
    		font-size:15px;
    		line-height:17px;
    		margin:0;
    		padding:8px 10px;
    		width:180px;
    		box-shadow: 0 1px 2px rgba(15, 82, 135, 0.25) 
    				inset, 0 1px 0 rgba(255, 255, 255, 0.15);
    	}
    	#button{
    		margin:0 0 0 10px;	
    		padding:8px 10px;
    		width:60px;
    	}
    	a{
    		text-decoration: none;
    		color:#555;
    	}
    </style>
  </head>

  <body>
  <div id="title">Welcome &nbsp&nbsp  to  &nbsp&nbsp  果壳</div>
  <div id="form">
  	<form method="post" action="/form/servlet/login">
  		<div id="name">
  			<input type="text" name="name" placeholder="用户名"/>
  		</div>
  		<div id="password">
  			<input type="password" name="password" placeholder="密码"/> 
  		</div>
  		<div>
  			<input id="submit" type="submit" value="登入"/>
  			<input id="button" type="button" value="注册" onclick="window.location.href='/form/register.jsp'">
  		</div> 	
  	</form>
  
  </div>
  </body>
</html>
