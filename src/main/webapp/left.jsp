<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>left</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson .header").click(function(){
		var $parent = $(this).parent();
		$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
		
		$parent.addClass("active");
		if(!!$(this).next('.sub-menus').size()){
			if($parent.hasClass("open")){
				$parent.removeClass("open").find('.sub-menus').hide();
			}else{
				$parent.addClass("open").find('.sub-menus').show();	
			}
			
			
		}
	});
	
	// 三级菜单点击
	$('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active")
		$(this).addClass("active");
    });
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('.menuson').slideUp();
		if($ul.is(':visible')){
			$(this).next('.menuson').slideUp();
		}else{
			$(this).next('.menuson').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#fff3e1;">
	
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>客户管理
    </div>
    	<ul class="menuson">
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="page/crm/ggkhc.jsp" target="rightFrame">公共客户池</a>
            <i></i>
            </div>
            
        </li>
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="right_khxxgl.html" target="rightFrame">客户信息管理</a>
            <i></i>
            </div>                      
        </li>       
        <li class="active"><cite></cite><a href="right.html" target="rightFrame">交往记录管理</a><i></i></li>
        <li><cite></cite><a href="imgtable.html" target="rightFrame">客户漏斗图</a><i></i></li>
        <li><cite></cite><a href="form.html" target="rightFrame">超期客户预警</a><i></i></li>
        <li><cite></cite><a href="${pageContext.servletContext.contextPath}/page/crm/khsrcx.jsp" target="rightFrame">客户生日查询</a><i></i></li>
        <li><cite></cite><a href="imglist1.html" target="rightFrame">客户关怀</a><i></i></li>
        <li><cite></cite><a href="tools.html" target="rightFrame">客户转移</a><i></i></li>    
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>销售计划管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="flow.html" target="rightFrame">项目机会</a><i></i></li>
        <li><cite></cite><a href="project.html" target="rightFrame">机会漏斗图</a><i></i></li>
        <li><cite></cite><a href="search.html" target="rightFrame">销售标价表</a><i></i></li>
        <li><cite></cite><a href="tech.html" target="rightFrame">解决方案</a><i></i></li>
        </ul>     
    </dd>    
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>产品管理</div>
      <ul class="menuson">
        <li><cite></cite><a href="flow.html" target="rightFrame">哈哈哈。没有啦</a><i></i></li>
       
        </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>供应商管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="flow.html" target="rightFrame">点不开就是点不开</a><i></i></li>
       
        </ul>
    
    </dd>   
    
    </dl>
    
</body>
</html>
