<%@page language="java" pageEncoding="utf-8" import="java.util.List"%>
<%@page import="bean1.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
  <head> 
    <title>index.jsp</title>
    <script src="/form/script/jquery-2.1.3.js"></script>
    <script type="text/javascript">
    	function createXMLHttp(){
    		var name=document.userform.name.value;
    		var xmlHttp=new XMLHttpRequest();
    		xmlHttp.onreadystatechange = function(){ 
				if(xmlHttp.readyState == 4){		//响应已经完全接受
	        		var ajax =document.getElementById("ajax");
	        		ajax.innerHTML=xmlHttp.responseText;
	        	}
	      	};
	      	if(name.length==0){
	      		
			}else if(name.length<3){
				document.getElementById("ajax").innerHTML="用户名需要大于3";
			}else{
				xmlHttp.open("GET","/form/servlet/userNameCheck?name=" + name,true);
				xmlHttp.send(null);
			}
    	}
    </script>
    <style type="text/css">
    	body{
    		background-image:url(/form/img/bg.jpg)
    	}
    	#title{
    		margin:0 auto;
    		width:450px;
    		margin-top:70px;
    		font-size:29px;
    		color:#bbffaa;
    	}
    	#form{
    		margin: 0 auto;
    		width: 450px;
    		margin-top: 50px;
    	}
    	.div{
    		height:50px;
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
    	.radio{
    		width:30px;
    		margin:0 20px 10px 0;
    	}
    	textarea{
    		background:none repeat scroll 0 0 #e7f1f8;
    		border:1px solid #1672b9;
    		border-radius:5px;
    		color:#555;
    		font-size:15px;
    		line-height:17px;
    		margin:0 0 10px 0;
    		padding:8px 10px;
    	}
    	#ajax{
    		margin-left:10px;
    		font-size:16px;
    		color:#555;
    	}
    </style>
  </head>

  <body>
  <div id="title">Welcome &nbsp&nbsp  to  &nbsp&nbsp  果壳</div>
  <div id="form">
  	<form method="post" action="/form/servlet/register" name="userform" >
  		<div class="div">
  			<input type="text" name="name" placeholder="用户名" min="3" onblur="createXMLHttp();" /><label id="ajax"></label>
  		</div>
  		<div class="div">
  			<input type="email" name="email" placeholder="邮箱"/>
  		</div>
  		<div class="div">
  			<input type="password" name="password"  placeholder="密码" min="3"/> 
  		</div>
  		<div>
  			男<input class="radio" type="radio" name="sex" value="male" checked="checked"/>
  			女<input class="radio" type="radio" name="sex" value="female"/>
  		</div>
  		
  		<div id="textarea">
  			<textarea rows="2" cols="40" name="signature" placeholder="签名"></textarea>
  		</div>
  		<div id="textarea">
  			<textarea rows="1" cols="40" name="home" placeholder="住址"></textarea>
  		</div>
  		<div id="textarea">
  			<textarea rows="1" cols="40" name="education" placeholder="教育经历"></textarea>
  		</div>
  		<div class="div">
  			<input type="submit" value="注册"/>
  		</div> 	
  	</form>
  
  </div>
  </body>
</html>
