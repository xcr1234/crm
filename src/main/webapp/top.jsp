<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
	
})	
</script>


</head>

<body style="background:url(${pageContext.servletContext.contextPath}/images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="${pageContext.servletContext.contextPath}/images/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    <li><a href="#" target="rightFrame" class="selected"><img src="${pageContext.servletContext.contextPath}/images/icon01.png" title="CRM管理" /><h2>CRM管理</h2></a></li>
    <li><a href="${pageContext.servletContext.contextPath}/error/jqqd.jsp" target="rightFrame"><img src="${pageContext.servletContext.contextPath}/images/icon02.png" title="进销存" /><h2>进销存</h2></a></li>
    <li><a href="${pageContext.servletContext.contextPath}/error/jqqd.jsp"  target="rightFrame"><img src="${pageContext.servletContext.contextPath}/images/icon03.png" title="生产管理" /><h2>生产管理</h2></a></li>
    <li><a href="${pageContext.servletContext.contextPath}/error/jqqd.jsp"  target="rightFrame"><img src="images/icon04.png" title="财务管理" /><h2>财务管理</h2></a></li>
    <li><a href="${pageContext.servletContext.contextPath}/error/jqqd.jsp" target="rightFrame"><img src="images/icon05.png" title="图表分析" /><h2>图表分析</h2></a></li>
    <li><a href="${pageContext.servletContext.contextPath}/error/jqqd.jsp"  target="rightFrame"><img src="images/icon06.png" title="人事管理" /><h2>人事管理</h2></a></li>
	<li><a href="${pageContext.servletContext.contextPath}/error/jqqd.jsp"  target="rightFrame"><img src="images/icon06.png" title="办公管理" /><h2>办公管理</h2></a></li>
    <li><a href="${pageContext.servletContext.contextPath}/error/jqqd.jsp"  target="rightFrame"><img src="images/icon06.png" title="信息中心" /><h2>信息中心</h2></a></li>
	<li><a href="${pageContext.servletContext.contextPath}/error/jqqd.jsp"  target="rightFrame"><img src="images/icon06.png" title="流程管理" /><h2>流程管理</h2></a></li>
	<li><a href="${pageContext.servletContext.contextPath}/error/jqqd.jsp"  target="rightFrame"><img src="images/icon06.png" title="人事管理" /><h2>人事管理</h2></a></li>
	<li><a href="${pageContext.servletContext.contextPath}/error/jqqd.jsp"  target="rightFrame"><img src="images/icon06.png" title="通讯管理" /><h2>通讯管理</h2></a></li>
    <li><a href="${pageContext.servletContext.contextPath}/error/jqqd.jsp"  target="rightFrame"><img src="images/icon06.png" title="综合事务" /><h2>综合事务</h2></a></li>
	</ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="${pageContext.servletContext.contextPath}/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="login.html" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>admin</span>
    <i>消息</i>
    <b>5</b>
    </div>    
    
    </div>

</body>
</html>
