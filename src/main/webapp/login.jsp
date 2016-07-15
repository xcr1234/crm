<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
   <script language="JavaScript" src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
   <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/MD5.js"></script>
   <script src="${pageContext.servletContext.contextPath}/js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
    
    $("input[name=login]").click(function(){
       var username=$("input[name=username]").val();
       var password=$.md5($("input[name=password]").val());
       var validate=$("input[name=validate]").val();
      /* alert(username+password+validate); */
      window.location.href="${pageContext.servletContext.contextPath}/loginAction.do?method=login&username="+username+"&password="+password+"&validate="+validate;
    })
    
    $("img").click(function(){
    console.log(this);
    $(this).attr("src","${pageContext.servletContext.contextPath}/validateCode.do?randow="+new Date);
    })
});  
</script> 

</head>

<body style="background-color:#df7611; background-image:url(${pageContext.servletContext.contextPath}/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox loginbox2">
    
    <ul>
    <li><input name="username" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
    <li><input name="password" type="text" class="loginpwd" value="admin" onclick="JavaScript:this.value=''"/></li>
    <li class="yzm">
    <span><input name="validate" type="text" value="" onclick="JavaScript:this.value=''"/></span><cite><img src="${pageContext.servletContext.contextPath}/validateCode.do" alt="" width="100%" height="100%"/></cite> 
    </li>
    <li><input name="login" type="button" class="loginbtn" value="登陆"  onclick="javascript:window.location='main.jsp'"  /><label>${info}</label></li>
    </ul>
    
    
    </div>
    
    </div>
    
    
    <div class="loginbm">版权所有  2014  <a href="http://www.uimaker.com">uimaker.com</a>  仅供学习交流，勿用于任何商业用途</div>
	
    
</body>

</html>